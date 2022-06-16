package db_on_memory;

import entityes.Company;

public class DB {
    private static Company companyDb = new Company();

    public static void companySave(Company company) {
        companyDb = company;
    }

    public static Company companyQuery() {
        return companyDb;
    }
}
