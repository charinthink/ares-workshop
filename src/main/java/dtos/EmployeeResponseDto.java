package dtos;

import consts.CompanyConst;
import consts.DepartmentConst;
import consts.OfficeConst;

import java.util.List;

public class EmployeeResponseDto {
    private Long id;
    private String titleName;
    private String firstName;
    private String surName;
    private Integer old;
    private List<EmployeeRequestDto.Address> addresses;
    private EmployeeRequestDto.Company company;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public Integer getOld() {
        return old;
    }

    public void setOld(Integer old) {
        this.old = old;
    }

    public List<EmployeeRequestDto.Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<EmployeeRequestDto.Address> addresses) {
        this.addresses = addresses;
    }

    public EmployeeRequestDto.Company getCompany() {
        return company;
    }

    public void setCompany(EmployeeRequestDto.Company company) {
        this.company = company;
    }

    /* Class Address */
    public static class Address {
        private Long id;
        private String address;
        private String city;
        private String country;
        private String postcode;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getPostcode() {
            return postcode;
        }

        public void setPostcode(String postcode) {
            this.postcode = postcode;
        }
    }

    /* Class Company */
    public static class Company {
        private Long id;
        private CompanyConst companyConst;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public CompanyConst getCompanyConst() {
            return companyConst;
        }

        public void setCompanyConst(CompanyConst companyConst) {
            this.companyConst = companyConst;
        }
    }

    /* Class Office */
    public static class Office {
        private Long id;
        private OfficeConst officeName;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public OfficeConst getOfficeName() {
            return officeName;
        }

        public void setOfficeName(OfficeConst officeName) {
            this.officeName = officeName;
        }
    }

    /* Class Department */
    public static class Department {
        private Long id;
        private DepartmentConst departmentName;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public DepartmentConst getDepartmentName() {
            return departmentName;
        }

        public void setDepartmentName(DepartmentConst departmentName) {
            this.departmentName = departmentName;
        }
    }
}
