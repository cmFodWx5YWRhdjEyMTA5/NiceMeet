package com.crater.juanfran.nicemeet.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorsClass {
    private static final String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";

    private static Pattern pattern;
    private static Matcher matcher;

    public static boolean validateEmail(String email) {
        if(email==null)
            return false;
        pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static int validatePassword(String password) {
        if (password.isEmpty()) {
            return ErrorsClass.PASSWORDISEMPTY;
        }
        if (password.length()<6)
        {
            return ErrorsClass.PASSWORDTOOSHORT;
        }
        if(!password.matches(".*\\d+.*"))
        {
            return ErrorsClass.PASSWORDNOTCONTAINNUMBER;
        }
        return 0;

    }
}
