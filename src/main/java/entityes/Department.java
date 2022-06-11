package entityes;

import consts.DepartmentConst;

public class Department {
    private Long id;
    private DepartmentConst departmentName;
    /* Parent */
    private Office office;

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

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }
}
