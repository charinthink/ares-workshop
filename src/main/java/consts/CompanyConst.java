package consts;

public enum CompanyConst {
    GREEK_TECHNOLOGY;

    public String getName() {
        switch (this) {
            case GREEK_TECHNOLOGY:
                return "Greek Technology";
            default:
                return null;
        }
    }
}
