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

        return null;
    }

    @Override
    public CompanyDto.EmployeeDto createEmployee(CompanyDto.EmployeeDto employeeDto) {
        Employee employee = EntityMapper.toEmployee(employeeDto);
        Company companyDb = companyQuery();

        Long officeDtoId = employeeDto.getOffice().getId();
        Long departmentDtoId = employeeDto.getDepartment().getId();
        Office office = companyDb.getOffices()
                .stream()
                .filter(off -> off.getId().equals(officeDtoId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("id"));
        Department department = office.getDepartments()
                .stream()
                .filter(deprt -> deprt.getId().equals(departmentDtoId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("id"));
        List<Address> addresses = employeeDto.getAddresses()
                .stream()
                .peek(addr -> addr.setId((long) (Math.random() * 100) + 100))
                .map(EntityMapper::toAddress)
                .collect(Collectors.toList());

        employee.setId((long) (Math.random() * 100) + 100);
        employee.setOffice(office);
        employee.setDepartment(department);
        employee.setCompany(companyDb);
        employee.setAddresses(addresses);

        List<Employee> employees = Objects.isNull(companyDb.getEmployees()) ? new ArrayList<>() : companyDb.getEmployees();
        employees.add(employee);

        companyDb.setEmployees(employees);

        companyDb.getOffices()
                .stream()
                .filter(off -> off.getId().equals(officeDtoId))
                .forEach(off -> {
                    off.setEmployees(employees);
                    off.getDepartments()
                            .stream().filter(dp -> dp.getId().equals(departmentDtoId))
                            .forEach(dp -> dp.setEmployees(employees));
                });

        companySave(companyDb);

        return employeeResponseDto(employee);
    }

    @Override
    public List<CompanyDto.EmployeeDto> findAllEmployee() {
        return null;
    }

    @Override
    public CompanyDto.EmployeeDto findEmployeeById(Long id) {
        return null;
    }

    @Override
    public CompanyDto.EmployeeDto updateEmployee(Long id, CompanyDto.EmployeeDto employeeDto) {
        return null;
    }

    @Override
    public List<CompanyDto.EmployeeDto> findByDepartmentId(Long id) {
        return null;
    }

    @Override
    public List<CompanyDto.EmployeeDto> findByOfficeId(Long id) {
        return null;
    }

    @Override
    public void deleteAllEmployee() {

    }

    @Override
    public void deleteByEmployeeId(Long id) {

    }

    @Override
    public List<CompanyDto.DepartmentDto> findAllDepartmentByOfficeId(Long id) {
        return null;
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
