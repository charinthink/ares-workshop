package util;

import dtos.EmployeeRequestDto;
import entityes.*;

public class EntityMapper {
    public static Employee toEmployee(EmployeeRequestDto employeeRequestDto) {
        Employee employee = new Employee();
        employee.setTitleName(employeeRequestDto.getTitleName());
        employee.setFirstName(employeeRequestDto.getFirstName());
        employee.setSurName(employeeRequestDto.getSurName());
        employee.setOld(employeeRequestDto.getOld());

        return employee;
    }

    public static Address toAddress(EmployeeRequestDto.Address addressRequestDto) {
        Address address = new Address();
        address.setAddress(addressRequestDto.getAddress());
        address.setCity(addressRequestDto.getCity());
        address.setCountry(addressRequestDto.getCountry());
        address.setPostcode(addressRequestDto.getPostcode());

        return address;
    }

    public static Company toCompany(EmployeeRequestDto.Company companyRequestDto) {
        Company company = new Company();
        company.setCompanyConst(companyRequestDto.getCompanyConst());

        return company;
    }

    public static Office toOffice(EmployeeRequestDto.Office officeRequestDto) {
        Office office = new Office();
        office.setOfficeName(officeRequestDto.getOfficeName());

        return office;
    }

    public static Department toDepartment(EmployeeRequestDto.Department departmentRequestDto) {
        Department department = new Department();
        department.setDepartmentName(departmentRequestDto.getDepartmentName());

        return department;
    }
}
