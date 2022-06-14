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
    public CompanyDto createEmployee(CompanyDto companyDto) {
        CompanyDto response = companyService.createEmployee(companyDto);
        return response;
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
}
