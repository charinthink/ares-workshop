package services;

import dtos.EmployeeDto;
import entityes.*;
import util.DtoMapper;
import util.EntityMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static db_on_memory.DB.*;

public class EmployeeService implements EmployeeServiceImpl {
    @Override
    public EmployeeDto createEmployee(EmployeeDto employee) {
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

        EmployeeDto employeeResponseDto = DtoMapper.toEmployeeDto(employeeNew);

        List<EmployeeDto.Address> addressesResponseDto = addressNew.stream()
                .map(DtoMapper::toAddressDto)
                .collect(Collectors.toList());
        employeeResponseDto.setAddresses(addressesResponseDto);

        EmployeeDto.Department departmentResponseDto = DtoMapper.toDepartmentDto(departmentNew);

        EmployeeDto.Office officeResponseDto = DtoMapper.toOfficeDto(officeNew);
        officeResponseDto.setDepartment(departmentResponseDto);

        EmployeeDto.Company companyResponseDto = DtoMapper.toCompanyDto(companyNew);
        companyResponseDto.setOffice(officeResponseDto);

        employeeResponseDto.setCompany(companyResponseDto);

        return employeeResponseDto;
    }

    @Override
    public List<EmployeeDto> findAll() {
        return null;
    }

    @Override
    public EmployeeDto findById(Long id) {
        return null;
    }

    @Override
    public EmployeeDto updateById(Long id, EmployeeDto employee) {
        return null;
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
