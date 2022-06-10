package controllers;

import dtos.EmployeeRequestDto;
import dtos.EmployeeResponseDto;
import services.EmployeeService;

import java.util.List;

public class EmployeeController implements EmployeeControllerImpl {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public EmployeeResponseDto createEmployee(EmployeeRequestDto employeeRequestDto) {
        EmployeeResponseDto response = employeeService.createEmployee(employeeRequestDto);
        return response;
    }

    @Override
    public EmployeeResponseDto updateEmployee(Long id, EmployeeRequestDto employeeRequestDto) {
        EmployeeResponseDto response = employeeService.updateById(id, employeeRequestDto);
        return response;
    }

    @Override
    public List<EmployeeResponseDto> findAll() {
        List<EmployeeResponseDto> response = employeeService.findAll();
        return response;
    }

    @Override
    public EmployeeResponseDto findById(Long id) {
        EmployeeResponseDto response = employeeService.findById(id);
        return response;
    }

    @Override
    public List<EmployeeResponseDto> findByDepartmentId(Long id) {
        List<EmployeeResponseDto> response = employeeService.findByDepartmentId(id);
        return response;
    }

    @Override
    public List<EmployeeResponseDto> findByOfficeId(Long id) {
        List<EmployeeResponseDto> response = employeeService.findByOfficeId(id);
        return response;
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
