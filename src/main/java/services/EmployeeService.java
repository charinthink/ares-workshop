package services;

import dtos.EmployeeRequestDto;
import dtos.EmployeeResponseDto;
import entityes.*;
import util.DtoMapper;
import util.EntityMapper;

import java.util.List;
import java.util.stream.Collectors;

import static db_on_memory.DB.*;

public class EmployeeService implements EmployeeServiceImpl {
    @Override
    public EmployeeResponseDto createEmployee(EmployeeRequestDto employee) {
        Long id = (long) (Math.random() * 10);

        Employee employeeNew = EntityMapper.toEmployee(employee);
        employeeNew.setId(id);

        List<Address> addressNew = employee.getAddresses()
                .stream()
                .map(EntityMapper::toAddress)
                .collect(Collectors.toList());
        employeeNew.setAddress(addressNew);

        Department departmentNew = EntityMapper.toDepartment(employee.getCompany().getOffice().getDepartment());
        departmentNew.setId(id);

        Office officeNew = EntityMapper.toOffice(employee.getCompany().getOffice());
        officeNew.setId(id);
        officeNew.setDepartment(departmentNew);

        Company companyNew = EntityMapper.toCompany(employee.getCompany());
        companyNew.setId(id);
        companyNew.setOffice(officeNew);

        employeeNew.setCompany(companyNew);

        /* Save */
        DB.add(employeeNew);

        EmployeeResponseDto employeeResponseDto = DtoMapper.toEmployeeDto(employeeNew);

        List<EmployeeResponseDto.Address> addressesResponseDto = addressNew.stream()
                .map(DtoMapper::toAddressDto)
                .collect(Collectors.toList());
        employeeResponseDto.setAddresses(addressesResponseDto);

        EmployeeResponseDto.Department departmentResponseDto = DtoMapper.toDepartmentDto(departmentNew);

        EmployeeResponseDto.Office officeResponseDto = DtoMapper.toOfficeDto(officeNew);
        officeResponseDto.setDepartment(departmentResponseDto);

        EmployeeResponseDto.Company companyResponseDto = DtoMapper.toCompanyDto(companyNew);
        companyResponseDto.setOffice(officeResponseDto);

        employeeResponseDto.setCompany(companyResponseDto);

        return employeeResponseDto;
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
    public EmployeeResponseDto updateById(Long id, EmployeeRequestDto employee) {
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
