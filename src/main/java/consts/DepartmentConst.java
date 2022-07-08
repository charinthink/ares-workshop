package consts;

public enum DepartmentConst {
    ZEUS,
    POSEIDON,
    HERA,
    ATHENA;

    public String getName() {
        switch (this) {
            case ZEUS:
                return "ซูส";
            case POSEIDON:
                return "โพไซดอน";
            case HERA:
                return "เฮรา";
            case ATHENA:
                return "อะธีนา";
            default:
                return null;
        }
    }
}
