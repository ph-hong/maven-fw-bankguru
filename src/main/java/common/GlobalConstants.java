package common;

import java.io.File;

public class GlobalConstants {
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String OS_NAME = System.getProperty("os.name");
	public static final String FILE_SEPARATOR = File.separator;

	public static final String LOGIN_URL = "https://demo.guru99.com/v4/";

	public static final String DATA_PATH = PROJECT_PATH + FILE_SEPARATOR + "testdata" + FILE_SEPARATOR + "bankguru"
			+ FILE_SEPARATOR;

}
