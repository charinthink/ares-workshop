package entityes;

import consts.CompanyConst;

public class Company {
    private Long id;
    private Employee employee;
    private CompanyConst companyConst;
    /* Child */
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
