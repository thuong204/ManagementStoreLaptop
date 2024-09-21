package Test;

import Helper.Connect;

public class test {
	public static void main(String[] args) {
		Connect cn = new Connect();
		try {
			cn.openConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
