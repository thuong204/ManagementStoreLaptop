package Helper;

public class CheckPasswordTrue {
	public boolean checkPass(char[] pass1, char[] pass2) {
		for(int i=0;i<pass1.length;i++) {
			if(pass1[i] != pass2[i]) {
				return false;
			}
		}
		return true;
		
	}

}
