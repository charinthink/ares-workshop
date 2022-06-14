package util;

import dtos.CompanyDto;
import entityes.*;

public class DtoMapper {
    public static CompanyDto toCompanyDto(Company company) {
        CompanyDto companyDto = new CompanyDto();
        companyDto.setId(company.getId());
        companyDto.setCompanyName(company.getCompanyName());

        return companyDto;
    }

    public static CompanyDto.EmployeeDto toEmployeeDto(Employee employee) {
        CompanyDto.EmployeeDto employeeDto = new CompanyDto.EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setTitleName(employee.getTitleName());
        employeeDto.setFirstName(employee.getFirstName());
        employeeDto.setSurName(employee.getSurName());
        employeeDto.setAge(employee.getAge());

        return employeeDto;
    }

    public static CompanyDto.OfficeDto toOfficeDto(Office office) {
        CompanyDto.OfficeDto officeDto = new CompanyDto.OfficeDto();
        officeDto.setId(office.getId());
        officeDto.setOfficeName(office.getOfficeName());

        return officeDto;
    }

    public static CompanyDto.DepartmentDto toDepartmentDto(Department department) {
        CompanyDto.DepartmentDto departmentDto = new CompanyDto.DepartmentDto();
        departmentDto.setId(department.getId());
        departmentDto.setDepartmentName(department.getDepartmentName());

        return departmentDto;
    }

    public static CompanyDto.AddressDto toAddressDto(Address address) {
        CompanyDto.AddressDto addressDto = new CompanyDto.AddressDto();
        addressDto.setAddress(address.getAddress());
        addressDto.setCity(address.getCity());
        addressDto.setCountry(address.getCountry());
        addressDto.setPostcode(address.getPostcode());
        addressDto.setId(address.getId());

        return addressDto;
    }
}
