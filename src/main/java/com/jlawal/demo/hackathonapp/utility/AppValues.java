package com.jlawal.demo.hackathonapp.utility;

public enum AppValues {
    HOME_PAGE("home/index"), VIEW_PRODUCTS_PAGE("products/list"), NEW_PRODUCT_PAGE("products/new"),
    SITE_ROOT("home"), PRODUCT_SORT_BY("productNumber"),
    SUPPLIER_SORT_BY("supplierName"), ENTRIES_PER_PAGE(5), SITE_NAME("hackathonapp"),
    REDIRECT("redirect:");

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
