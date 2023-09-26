package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	static final String file = "./src/main/resources/Data/config.properties";
	Properties props;

	public ReadConfig() throws IOException {

		props = new Properties();
		File f = new File(file);
		FileInputStream fis = new FileInputStream(f);
		props.load(fis);
	}

	public String getUsername() {
		return props.getProperty("username");
	}

	public String getPassword() {
		return props.getProperty("password");
	}

	public String getFirstName() {
		return props.getProperty("firstname");
	}

	public String getLastName() {
		return props.getProperty("lastname");
	}

	public String getPostalCode() {

		return props.getProperty("postalcode");
	}

	public String getWrongUsername() {

		return props.getProperty("wrongUser");
	}

	public String getWrongPassword() {

		return props.getProperty("wrongPass");
	}

	public String[] getItemList() {

		String[] s = { props.getProperty("item1"), props.getProperty("item2"), props.getProperty("item3"),
				props.getProperty("item4"), props.getProperty("item5"), props.getProperty("item6") };

		return s;
	}

	public String[] getItemPriceList() {

		String[] s1 = { props.getProperty("item1p"), props.getProperty("item2p"), props.getProperty("item3p"),
				props.getProperty("item4p"), props.getProperty("item5p"), props.getProperty("item6p") };

		return s1;
	}
}
