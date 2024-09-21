package Helper;

import java.awt.Color;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Datavalidator {
	public static void validateEmpty(JTextField field, StringBuilder sb, String errorMessage) {
		if(field.getText().equals("")){
			sb.append(errorMessage).append("\n");
			field.requestFocus();
			field.setBackground(Color.red);
		}
		else {
			field.setBackground(Color.white);
		}
			
		}
	public static void validateEmpty(JPasswordField field, StringBuilder sb, String errorMessage) {
		String password = new String(field.getPassword());
		if(password.equals("")){
			sb.append(errorMessage).append("\n");
			field.requestFocus();
			field.setBackground(Color.red);
		}
		else {
			field.setBackground(Color.white);
		}	
		}
}
