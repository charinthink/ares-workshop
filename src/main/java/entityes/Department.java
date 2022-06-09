package entityes;

import consts.DepartmentConst;

public class Department {
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
