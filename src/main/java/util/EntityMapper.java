package util;

import dtos.EmployeeDto;
import entityes.*;

public class EntityMapper {
    public static Employee toEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setTitleName(employeeDto.getTitleName());
        employee.setFirstName(employeeDto.getFirstName());
        employee.setSurName(employeeDto.getSurName());
        employee.setAge(employeeDto.getAge());

        return employee;
    }

    public static Address toAddress(EmployeeDto.Address addressRequestDto) {
        Address address = new Address();
        address.setAddress(addressRequestDto.getAddress());
        address.setCity(addressRequestDto.getCity());
        address.setCountry(addressRequestDto.getCountry());
        address.setPostcode(addressRequestDto.getPostcode());

        return address;
    }

    public static Company toCompany(EmployeeDto.Company companyRequestDto) {
        Company company = new Company();
        company.setCompanyConst(companyRequestDto.getCompanyConst());

        return company;
    }

    public static Office toOffice(EmployeeDto.Office officeRequestDto) {
        Office office = new Office();
        office.setOfficeName(officeRequestDto.getOfficeName());

        return office;
    }

    public static Department toDepartment(EmployeeDto.Department departmentRequestDto) {
        Department department = new Department();
        department.setDepartmentName(departmentRequestDto.getDepartmentName());

        return department;
    }
}
