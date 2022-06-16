package services;

import dtos.CompanyDto;

import java.rmi.NoSuchObjectException;
import java.util.List;

public interface CompanyServiceImpl {
    CompanyDto createCompany(CompanyDto companyDto);

    CompanyDto.EmployeeDto createEmployee(CompanyDto.EmployeeDto employeeDto) throws NoSuchObjectException;

    CompanyDto findAllEmployee();

    CompanyDto.EmployeeDto findById(Long id);

    CompanyDto.EmployeeDto updateEmployee(Long id, CompanyDto.EmployeeDto employeeDto);

    CompanyDto.EmployeeDto findByDepartmentId(Long id);

    CompanyDto.EmployeeDto findByOfficeId(Long id);

    void deleteAllEmployee();

    void deleteByEmployeeId(Long id);

    List<CompanyDto.EmployeeDto> findByCompanyId(Long id);

    List<CompanyDto.DepartmentDto> findAllDepartmentByOfficeId(Long id);
}
