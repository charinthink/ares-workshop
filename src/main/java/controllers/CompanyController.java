package controllers;

import dtos.CompanyDto;
import services.CompanyService;

import java.util.List;

public class CompanyController implements CompanyControllerImpl {
    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @Override
    public CompanyDto createCompany(CompanyDto companyDto) {
        CompanyDto response = companyService.createCompany(companyDto);
        return response;
    }

    @Override
    public CompanyDto.EmployeeDto createEmployee(CompanyDto.EmployeeDto employeeDto) {
        CompanyDto.EmployeeDto response = companyService.createEmployee(employeeDto);
        return response;
    }

    @Override
    public List<CompanyDto.EmployeeDto> findAllEmployee() {
        List<CompanyDto.EmployeeDto> response = companyService.findAllEmployee();
        return response;
    }

    @Override
    public CompanyDto.EmployeeDto findEmployeeById(Long id) {
        CompanyDto.EmployeeDto response = companyService.findEmployeeById(id);
        return response;
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
}
