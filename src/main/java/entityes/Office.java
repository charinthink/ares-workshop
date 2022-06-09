package entityes;

import consts.OfficeConst;

public class Office {
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
