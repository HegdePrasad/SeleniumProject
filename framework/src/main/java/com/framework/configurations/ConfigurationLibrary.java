package com.framework.configurations;

import java.io.File;

public interface ConfigurationLibrary {
	
	public static final String firefoxDriverPath = "E:/Eclipse Projects/New folder/framework/src/main/resources/Project/Drivers/geckodriver.exe";
	
	public static final String chromeDriverPath = "E:/Eclipse Projects/New folder/framework/src/main/resources/Project/Drivers/chromedriver.exe";
	
	public static final String propertiesFilePath = "E:/Eclipse Projects/New folder/framework/src/main/java/com/framework/configurations/Properties";
	
	// Returns home directory
	public static String folder = System.getProperty("user.dir");
	
	// Returns path of src folder
	public static File filePath = new File(folder, "src");

}
