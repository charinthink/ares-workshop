package services;

import dtos.CompanyDto;
import entityes.*;
import util.DtoMapper;
import util.EntityMapper;

import java.rmi.NoSuchObjectException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static db_on_memory.DB.*;

public class CompanyService implements CompanyServiceImpl {

    @Override
    public CompanyDto createCompany(CompanyDto companyDto) {
        Company company = EntityMapper.toCompany(companyDto);
        List<Office> offices = new ArrayList<>();

        companyDto.getOffices()
                .stream()
                .parallel()
                .forEach(off -> {
                    Office office = EntityMapper.toOffice(off);
                    List<Department> departments = off.getDepartmentDtos()
                            .stream()
                            .map(EntityMapper::toDepartment)
                            .collect(Collectors.toList());

                    office.setDepartments(departments);
                    offices.add(office);
                });

        company.setOffices(offices);
        companySave(company);

        return companyResponseDto(company);
    }

    @Override
    public CompanyDto.EmployeeDto createEmployee(CompanyDto.EmployeeDto employeeDto) {
        Employee employee = EntityMapper.toEmployee(employeeDto);
        Company companyDb = companyQuery();
        Office office = companyDb.getOffices()
                .stream()
                .filter(off -> off.getId().equals(employeeDto.getOffice().getId()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("id"));
        Department department = office.getDepartments()
                .stream()
                .filter(deprt -> deprt.getId().equals(employeeDto.getDepartment().getId()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("id"));
        List<Address> addresses = employeeDto.getAddresses()
                .stream()
                .peek(addr -> addr.setId((long) (Math.random() * 100)))
                .map(EntityMapper::toAddress)
                .collect(Collectors.toList());

        employee.setId((long) (Math.random() * 100));
        employee.setOffice(office);
        employee.setDepartment(department);
        employee.setCompany(companyDb);
        employee.setAddresses(addresses);

        List<Employee> employees = Objects.isNull(companyDb.getEmployees()) ? new ArrayList<>() : companyDb.getEmployees();
        employees.add(employee);

        companyDb.setEmployees(employees);
        office.setEmployees(employees);
        department.setEmployees(employees);

        companySave(companyDb);

        return employeeResponseDto(employee);
    }

    @Override
    public List<CompanyDto.EmployeeDto> findAllEmployee() {
        return companyQuery().getEmployees()
                .stream()
                .map(this::employeeResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public CompanyDto.EmployeeDto findEmployeeById(Long id) {
        List<Employee> employeesDb = companyQuery().getEmployees();
        Employee employeeDb = employeesDb.stream()
                .filter(em -> em.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("id"));

        return DtoMapper.toEmployeeDto(employeeDb);
    }

    @Override
    public CompanyDto.EmployeeDto updateEmployee(Long id, CompanyDto.EmployeeDto employeeDto) {
        Company companyDb = companyQuery();
        List<Employee> employeeDb = companyDb.getEmployees().stream()
                .filter(em -> em.getId().equals(id))
                .peek(em -> {
                    em.setFirstName(employeeDto.getFirstName());
                    em.setSurName(employeeDto.getSurName());
                    em.setAge(employeeDto.getAge());

                    employeeDto.getAddresses().stream().forEach(addr -> {
                        em.getAddresses()
                                .stream()
                                .filter(addrDb -> addrDb.getId().equals(addr.getId()))
                                .forEach(addrDb -> {
                                    addrDb.setAddress(addr.getAddress());
                                    addrDb.setCity(addr.getCity());
                                    addrDb.setCountry(addr.getCountry());
                                    addrDb.setPostcode(addr.getPostcode());
                                });
                    });

                }).collect(Collectors.toList());
        companyDb.setEmployees(employeeDb);

        Employee employee = companyDb.getEmployees()
                .stream()
                .filter(em -> em.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("id"));

        return employeeResponseDto(employee);
    }

    @Override
    public List<CompanyDto.EmployeeDto> findByDepartmentId(Long id) {
        List<Department> departmentsDb = companyQuery().getOffices()
                .stream()
                .map(Office::getDepartments)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        List<Employee> employeesDb = departmentsDb.stream()
                .filter(dp -> dp.getId().equals(id))
                .map(Department::getEmployees)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        return employeesDb.stream().map(this::employeeResponseDto).collect(Collectors.toList());
    }

    @Override
    public CompanyDto.EmployeeDto findByOfficeId(Long id) {
        Office officeDb = companyQuery().getOffices()
                .stream()
                .filter(dp -> dp.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("id"));

        List<Employee> employees = officeDb.getEmployees();
        return null;
    }

    @Override
    public void deleteAllEmployee() {

    }

    @Override
    public void deleteByEmployeeId(Long id) {

    }

    @Override
    public List<CompanyDto.EmployeeDto> findByCompanyId(Long id) {
        return null;
    }

    @Override
    public List<CompanyDto.DepartmentDto> findAllDepartmentByOfficeId(Long id) {
        return null;
    }

    private CompanyDto companyResponseDto(Company company) {
        CompanyDto companyDto = DtoMapper.toCompanyDto(company);
        List<CompanyDto.OfficeDto> officeDtos = new ArrayList<>();

        company.getOffices()
                .stream()
                .parallel()
                .forEach(off -> {
                    CompanyDto.OfficeDto officeDto = DtoMapper.toOfficeDto(off);
                    List<CompanyDto.DepartmentDto> departmentDtos = off.getDepartments()
                            .stream()
                            .map(DtoMapper::toDepartmentDto)
                            .collect(Collectors.toList());

                    officeDto.setDepartmentDtos(departmentDtos);
                    officeDtos.add(officeDto);
                });

        companyDto.setOffices(officeDtos);

        return companyDto;
    }

    private CompanyDto.EmployeeDto employeeResponseDto(Employee employee) {
        CompanyDto.EmployeeDto employeeDto = DtoMapper.toEmployeeDto(employee);
        CompanyDto.OfficeDto officeDto = DtoMapper.toOfficeDto(employee.getOffice());
        CompanyDto.DepartmentDto departmentDto = DtoMapper.toDepartmentDto(employee.getDepartment());
        CompanyDto companyDto = DtoMapper.toCompanyDto(employee.getCompany());
        List<CompanyDto.AddressDto> addressDtos = employee.getAddresses()
                .stream()
                .map(DtoMapper::toAddressDto)
                .collect(Collectors.toList());


        employeeDto.setOffice(officeDto);
        employeeDto.setDepartment(departmentDto);
        employeeDto.setCompany(companyDto);
        employeeDto.setAddresses(addressDtos);

        return employeeDto;
    }
}
