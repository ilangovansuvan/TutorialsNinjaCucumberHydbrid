package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfiqReader {
	
	public static Properties initProperties() {
		Properties prop =new Properties();
		File file = new File(System.getProperty("user.dir")+"\\src\\test\\resource\\confiq\\confiq.properties");
		try {
			FileInputStream fis = new FileInputStream(file);
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop;
	}

}
