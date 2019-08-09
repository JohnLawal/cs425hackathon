package com.jlawal.demo.hackathonapp.utility;

import java.util.HashMap;
import java.util.Map;

public class AppHelper {
   public static final Map<String, String> pageLinks = new HashMap<String, String>() {
        {
            put("siteRoot", '/' + AppValues.SITE_NAME.val(AppValues.SITE_ROOT.val()));
            put("viewProducts", '/' + AppValues.SITE_NAME.val(AppValues.VIEW_PRODUCTS_PAGE.val()));
            put("createProduct", '/' + AppValues.SITE_NAME.val(AppValues.NEW_PRODUCT_PAGE.val()));
        }
    };

}
