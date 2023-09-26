package experiment;

import java.util.Properties;

public class Demo {

	public static void main(String[] args) {
	
	Properties prop = 	System.getProperties();
	prop.list(System.out);
	System.out.println(System.getProperty("os.name"));
	System.out.println(System.getProperty("user.name"));
	System.out.println(System.getProperty("java.version"));

	}

}
