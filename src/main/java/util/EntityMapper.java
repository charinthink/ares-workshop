package util;

import dtos.CompanyDto;
import entityes.*;

import java.util.Objects;

public class EntityMapper {
    public static Employee toEmployee(CompanyDto.EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setId(employeeDto.getId());
        employee.setTitleName(employeeDto.getTitleName());
        employee.setFirstName(employeeDto.getFirstName());
        employee.setSurName(employeeDto.getSurName());
        employee.setAge(employeeDto.getAge());

        return employee;
    }

    public static Address toAddress(CompanyDto.AddressDto addressDto) {
        Address address = new Address();
        address.setId(addressDto.getId());
        address.setAddress(addressDto.getAddress());
        address.setCity(addressDto.getCity());
        address.setCountry(addressDto.getCountry());
        address.setPostcode(addressDto.getPostcode());

        return address;
    }

    public static Company toCompany(CompanyDto companyDto) {
        Company company = new Company();
        company.setId(companyDto.getId());
        company.setCompanyName(companyDto.getCompanyName());

        return company;
    }

    public static Office toOffice(CompanyDto.OfficeDto officeDto) {
        Office office = new Office();
        office.setId(officeDto.getId());
        office.setOfficeName(officeDto.getOfficeName());

        return office;
    }

    public static Department toDepartment(CompanyDto.DepartmentDto departmentDto) {
        Department department = new Department();
        department.setId(departmentDto.getId());
        department.setDepartmentName(departmentDto.getDepartmentName());

        return department;
    }
}
