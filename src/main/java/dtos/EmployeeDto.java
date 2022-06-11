package dtos;

import consts.CompanyConst;
import consts.DepartmentConst;
import consts.OfficeConst;

import java.util.List;

public class EmployeeDto {
    private Long id;
    private String titleName;
    private String firstName;
    private String surName;
    private Integer age;
    private List<Address> addresses;
    private Company company;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
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
        private Office office;

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

        public Office getOffice() {
            return office;
        }

        public void setOffice(Office office) {
            this.office = office;
        }
    }

    /* Class Office */
    public static class Office {
        private Long id;
        private OfficeConst officeName;
        private Department department;

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

        public Department getDepartment() {
            return department;
        }

        public void setDepartment(Department department) {
            this.department = department;
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
