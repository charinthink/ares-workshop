package controllers;

import dtos.EmployeeDto;
import services.EmployeeService;

import java.util.List;

public class EmployeeController implements EmployeeControllerImpl {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        EmployeeDto response = employeeService.createEmployee(employeeDto);
        return response;
    }
    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
        return null;
    }

    @Override
    public List<EmployeeDto> findAll() {
        List<EmployeeDto> resposne = employeeService.findAll();
        return resposne;
    }

    @Override
    public EmployeeDto findById(Long id) {
        EmployeeDto response = employeeService.findById(id);
        return response;
    }

    @Override
    public EmployeeDto updateById(Long id, EmployeeDto employeeDto) {
        EmployeeDto response = employeeService.updateById(id, employeeDto);
        return response;
    }

    @Override
    public List<EmployeeDto> findByDepartmentId(Long id) {
        return null;
    }

    @Override
    public List<EmployeeDto> findByOfficeId(Long id) {
        return null;
    }

    @Override
    public void deleteAll() {
        employeeService.deleteAll();
    }

    @Override
    public void deleteById(Long id) {
        employeeService.deleteById(id);
    }

    @Override
    public void deleteByDepartmentId(Long id) {
        employeeService.deleteByDepartmentId(id);
    }

    @Override
    public void deleteByOfficeId(Long id) {
        employeeService.deleteByOfficeId(id);
    }
}