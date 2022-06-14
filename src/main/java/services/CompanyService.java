package services;

import dtos.CompanyDto;
import entityes.*;
import util.DtoMapper;
import util.EntityMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static db_on_memory.DB.*;

public class CompanyService implements CompanyServiceImpl {

    @Override
    public CompanyDto createEmployee(CompanyDto companyDto) {
        Company company = EntityMapper.toCompany(companyDto);
        Employee employee = EntityMapper.toEmployee(companyDto.getEmployee());
        Office office = EntityMapper.toOffice(companyDto.getEmployee().getOffice());
        Department department = EntityMapper.toDepartment(companyDto.getEmployee().getOffice().getDepartment());
        List<Address> addresses = companyDto.getEmployee()
                .getAddresses()
                .stream()
                .map(EntityMapper::toAddress)
                .peek(ar -> {
                    ar.setId((long) (Math.random() * 10));
                    ar.setEmployee(employee);
                })
                .collect(Collectors.toList());

        employee.setId((long) (Math.random() * 10));

        List<Employee> employees = new ArrayList<>();
        employee.setCompany(company);
        employee.setOffice(office);
        employee.setDepartment(department);

        employee.setAddresses(addresses);
        employees.add(employee);

        List<Office> offices = new ArrayList<>();
        office.setCompany(company);
        office.setEmployees(employees);

        List<Department> departments = new ArrayList<>();
        department.setOffice(office);
        department.setEmployees(employees);
        departments.add(department);


        office.setDepartments(departments);
        offices.add(office);

        company.setOffices(offices);
        company.setEmployees(employees);

        DB.add(company);

        return responseDto(employee);
    }

    @Override
    public CompanyDto findAllEmployee() {
        return null;
    }

    @Override
    public CompanyDto.EmployeeDto findById(Long id) {
        return null;
    }

    @Override
    public CompanyDto.EmployeeDto updateEmployee(Long id, CompanyDto.EmployeeDto employeeDto) {
        return null;
    }

    @Override
    public CompanyDto.EmployeeDto findByDepartmentId(Long id) {
        return null;
    }

    @Override
    public CompanyDto.EmployeeDto findByOfficeId(Long id) {
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

    private CompanyDto responseDto(Employee employee) {
        Company company = employee.getCompany();
        Office office = employee.getOffice();
        Department department = employee.getDepartment();


        CompanyDto companyDto = DtoMapper.toCompanyDto(company);
        CompanyDto.EmployeeDto employeeDto = DtoMapper.toEmployeeDto(employee);
        CompanyDto.OfficeDto officeDto = DtoMapper.toOfficeDto(office);
        CompanyDto.DepartmentDto departmentDto = DtoMapper.toDepartmentDto(department);
        List<CompanyDto.AddressDto> addresses = employee.getAddresses()
                .stream()
                .map(DtoMapper::toAddressDto)
                .collect(Collectors.toList());
        employeeDto.setAddresses(addresses);

        officeDto.setDepartment(departmentDto);
        employeeDto.setOffice(officeDto);
        companyDto.setEmployee(employeeDto);

        return companyDto;
    }
}
