package util;

import dtos.EmployeeResponseDto;
import entityes.*;

public class DtoMapper {
    public static EmployeeResponseDto toEmployeeDto(Employee employee) {
        EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();
        employeeResponseDto.setId(employee.getId());
        employeeResponseDto.setTitleName(employee.getTitleName());
        employeeResponseDto.setFirstName(employee.getFirstName());
        employeeResponseDto.setSurName(employee.getSurName());
        employeeResponseDto.setOld(employee.getOld());

        return employeeResponseDto;
    }

    public static EmployeeResponseDto.Address toAddressDto(Address address) {
        EmployeeResponseDto.Address addressDto = new EmployeeResponseDto.Address();
        addressDto.setId(address.getId());
        addressDto.setAddress(address.getAddress());
        addressDto.setCity(address.getCity());
        addressDto.setCountry(address.getCountry());
        addressDto.setPostcode(address.getPostcode());

        return addressDto;
    }

    public static EmployeeResponseDto.Company toCompanyDto(Company company) {
        EmployeeResponseDto.Company companyDto = new EmployeeResponseDto.Company();
        companyDto.setId(company.getId());
        companyDto.setCompanyConst(company.getCompanyConst());

        return companyDto;
    }

    public static EmployeeResponseDto.Department toDepartmentDto(Department department) {
        EmployeeResponseDto.Department departmentDto = new EmployeeResponseDto.Department();
        departmentDto.setId(department.getId());
        departmentDto.setDepartmentName(departmentDto.getDepartmentName());

        return departmentDto;
    }

    public static EmployeeResponseDto.Office toOfficeDto(Office office) {
        EmployeeResponseDto.Office officeDto = new EmployeeResponseDto.Office();
        officeDto.setId(office.getId());
        officeDto.setOfficeName(office.getOfficeName());

        return officeDto;
    }
}
