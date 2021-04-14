package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckInfo {
    public static final String CHECKPHONE = "^\\(?([0-9]{3})\\)?[-]?([0-9]{3})[-]?([0-9]{4})$";
    public static final Pattern CHECKMAIL = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    private static Pattern pattern;
    private static Matcher matcher;

    public static boolean checkPhone(String phone) {
        pattern = Pattern.compile(CHECKPHONE);
        matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    public static boolean checkMail(String mail) {
        Matcher matcher = CHECKMAIL.matcher(mail);
        return matcher.find();
    }
}
