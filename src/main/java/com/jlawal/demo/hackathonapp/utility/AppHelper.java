package com.jlawal.demo.hackathonapp.utility;

import java.util.HashMap;
import java.util.Map;

public class AppHelper {
   public static final Map<String, String> pageLinks = new HashMap<String, String>() {
        {
            put("siteRoot", '/' + AppValues.SITE_NAME.val(AppValues.SITE_ROOT.val()));
            put("viewCustomers", '/' + AppValues.SITE_NAME.val(AppValues.VIEW_CUSTOMERS_PAGE.val()));
            put("registerCustomer", '/' + AppValues.SITE_NAME.val(AppValues.NEW_CUSTOMER_PAGE.val()));
            put("viewAccounts", '/' + AppValues.SITE_NAME.val(AppValues.VIEW_ACCOUNTS_PAGE.val()));
            put("createAccount", '/' + AppValues.SITE_NAME.val(AppValues.NEW_ACCOUNT_PAGE.val()));
            put("createAccountType", '/' + AppValues.SITE_NAME.val(AppValues.NEW_ACCOUNT_TYPE_PAGE.val()));
        }
    };

}
