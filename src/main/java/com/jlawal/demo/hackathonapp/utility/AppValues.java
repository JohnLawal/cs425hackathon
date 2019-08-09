package com.jlawal.demo.hackathonapp.utility;

public enum AppValues {
    HOME_PAGE("home/index"), VIEW_ACCOUNTS_PAGE("accounts/list"), NEW_ACCOUNT_PAGE("accounts/new"),
    NEW_ACCOUNT_TYPE_PAGE("accounttypes/new"), VIEW_CUSTOMERS_PAGE("customers/list"), NEW_CUSTOMER_PAGE("customers/new"),
    SITE_ROOT("home"), ACCOUNT_SORT_BY("accountNumber"), ACCOUNT_TYPE_SORT_BY("accountTypeId"),
    CUSTOMER_SORT_BY("lastName"), ENTRIES_PER_PAGE(5), SITE_NAME("hackathonapp"),
    SAVINGS_ACCOUNT_TYPE_NAME("Savings"), CHECKING_ACCOUNT_TYPE_NAME("Checking"),
    LOAN_ACCOUNT_TYPE_NAME("Loan"), REDIRECT("redirect:");

    private String val;
    private int iVal;

    AppValues(String string) {
        this.val = string;
    }

    AppValues(int iVal) {
        this.iVal = iVal;
    }

    public String val(String... appendable) {
        StringBuilder value = new StringBuilder(this.val);
        for (String string : appendable) {
            value.append("/").append(string);
        }
        return value.toString();
    }

    public int iVal() {
        return this.iVal;
    }
}
