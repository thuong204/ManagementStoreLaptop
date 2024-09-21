package Helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountValidation {
	    public static boolean validate(String accountName) {
	        Pattern pattern = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d)[a-zA-Z\\d]{10,}$");
	        Matcher matcher = pattern.matcher(accountName);
	        return matcher.matches();
	    }

}
