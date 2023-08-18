package com.mysql.demo.api.common.utils;

import java.util.regex.Pattern;

public class Utils {
    public static boolean isMatchAEmail(String email) {
        String regexPattern = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return Pattern.matches(regexPattern, email);
    }
}
