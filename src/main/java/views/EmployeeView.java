package views;

import dtos.EmployeeRequestDto;
import dtos.EmployeeResponseDto;

import java.util.List;

public class EmployeeView implements EmployeeViewImpl {
    @Override
    public EmployeeResponseDto createEmployee(EmployeeRequestDto employeeRequestDto) {
        return null;
    }

    @Override
    public EmployeeResponseDto updateEmployee(Long id, EmployeeRequestDto employeeRequestDto) {
        return null;
    }

    @Override
    public List<EmployeeResponseDto> findAll() {
        return null;
    }

    @Override
    public EmployeeResponseDto findById(Long id) {
        return null;
    }

    @Override
    public EmployeeResponseDto updateById(Long id, EmployeeRequestDto employeeRequestDto) {
        return null;
    }

    @Override
    public List<EmployeeResponseDto> findByDepartmentId(Long id) {
        return null;
    }

    @Override
    public List<EmployeeResponseDto> findByOfficeId(Long id) {
        return null;
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void deleteByDepartmentId(Long id) {

    }

    @Override
    public void deleteByOfficeId(Long id) {

    }
}
