package dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import consts.CompanyConst;
import consts.DepartmentConst;
import consts.OfficeConst;
import entityes.Address;
import entityes.Office;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompanyDto {
    private Long id;
    private CompanyConst companyName;
    private List<EmployeeDto> employeesDto;
    private List<OfficeDto> offices;

    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class EmployeeDto {
        private Long id;
        private String titleName;
        private String firstName;
        private String surName;
        private Integer age;
        private OfficeDto office;
        private CompanyDto company;
        private DepartmentDto department;
        private List<AddressDto> addresses;
    }

    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class AddressDto {
        private Long id;
        private String address;
        private String city;
        private String country;
        private String postcode;
    }

    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class OfficeDto {
        private Long id;
        private OfficeConst officeName;
        private List<DepartmentDto> departmentDtos;
    }

    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class DepartmentDto {
        private Long id;
        private DepartmentConst departmentName;
    }
}
