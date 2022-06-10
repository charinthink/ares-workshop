package util;

import dtos.EmployeeDto;
import entityes.*;

public class DtoMapper {
    public static EmployeeDto toEmployeeDto(Employee employee) {
        EmployeeDto employeeResponseDto = new EmployeeDto();
        employeeResponseDto.setId(employee.getId());
        employeeResponseDto.setTitleName(employee.getTitleName());
        employeeResponseDto.setFirstName(employee.getFirstName());
        employeeResponseDto.setSurName(employee.getSurName());
        employeeResponseDto.setOld(employee.getOld());

        return employeeResponseDto;
    }

    public static EmployeeDto.Address toAddressDto(Address address) {
        EmployeeDto.Address addressDto = new EmployeeDto.Address();
        addressDto.setId(address.getId());
        addressDto.setAddress(address.getAddress());
        addressDto.setCity(address.getCity());
        addressDto.setCountry(address.getCountry());
        addressDto.setPostcode(address.getPostcode());

        return addressDto;
    }

    public static EmployeeDto.Company toCompanyDto(Company company) {
        EmployeeDto.Company companyDto = new EmployeeDto.Company();
        companyDto.setId(company.getId());
        companyDto.setCompanyConst(company.getCompanyConst());

        return companyDto;
    }

    public static EmployeeDto.Department toDepartmentDto(Department department) {
        EmployeeDto.Department departmentDto = new EmployeeDto.Department();
        departmentDto.setId(department.getId());
        departmentDto.setDepartmentName(departmentDto.getDepartmentName());

        return departmentDto;
    }

    public static EmployeeDto.Office toOfficeDto(Office office) {
        EmployeeDto.Office officeDto = new EmployeeDto.Office();
        officeDto.setId(office.getId());
        officeDto.setOfficeName(office.getOfficeName());

        return officeDto;
    }
}
