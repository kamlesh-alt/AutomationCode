package Utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class Property_data {
	private Properties prop;
	private final String propertyFilePath= "./src/test/resources/prop.properties";
	
    public  void read_Data_from_propertyfile() throws IOException{
		      prop= new Properties();
		      BufferedReader reader;
		     // String propertyFilePath = System.getProperty("user.dir") + File.separator +FilePath;
		      File destination = new File(propertyFilePath);
		      //FileInputStream input = new FileInputStream(destination);
		      
			  try {
					reader = new BufferedReader(new FileReader(propertyFilePath));
				 // reader = new BufferedReader(new InputStreamReader(input));
					prop = new Properties();
					try {
						prop.load(reader);
						//prop.load(input);
						reader.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
					throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
				}		
			}
    
    public String getApplicationUrl() {
		String url = prop.getProperty("url");
		if(url != null) return url;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
    
    public String getApplicationUrl1() {
		String url = prop.getProperty("url-build");
		if(url != null) return url;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
    
    public String getDriverPath(){
		String driverPath = prop.getProperty("Chromepath");
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");		
	}
    
    public String getInvalidEmpId(){
    	String inv_emp_id=prop.getProperty("invalid_user");
    	if(inv_emp_id!=null) return inv_emp_id;
    	else throw new RuntimeException("Invalid user Id is not specifiied in the Configuration.properties file");
    }
    
    public String getDriverPath_firefox(){
		String driverPath = prop.getProperty("Firefoxpath");
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");		
	}
    
    public String getDriverPath_ie(){
		String driverPath = prop.getProperty("IEpath");
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");		
	}
    
    public String getoptionalmessage(){
    	System.out.println("optional messageS");
    	String msg =  prop.getProperty("optional_msg");
    	System.out.println(msg);
    	if(msg!= null) return msg;
    	else throw new RuntimeException("optional message not specified in the Configuration.properties file.");
    	 	
    }
    public String getusername1_prop(){
    	String usernam = prop.getProperty("user");
    	System.out.println(usernam); 
    	if(usernam!= null) 
    	return usernam;
    	else throw new RuntimeException("username not specified in the Configuration.properties file.");
    }
    
    public String getusername_prop(){
		String usernam = prop.getProperty("username");
		if(usernam!= null) return usernam;
		else throw new RuntimeException("username not specified in the Configuration.properties file.");		
	}
    
    
    public String getusername_prop_prejoiner(){
		String usernam = prop.getProperty("username_pre");
		if(usernam!= null) return usernam;
		else throw new RuntimeException("username not specified in the Configuration.properties file.");		
	}
    
    public String getpassword_prop(){
		String pass = prop.getProperty("password");
		if(pass!= null) return pass;
		else throw new RuntimeException("password not specified in the Configuration.properties file.");		
	}
    
    
    public String getpassword_prop_prejoiner(){
		String pass = prop.getProperty("password_pre");
		if(pass!= null) return pass;
		else throw new RuntimeException("password not specified in the Configuration.properties file.");		
	}
    
    
    public String getbrowser(){
		String browser = prop.getProperty("browser");
		if(browser!= null) return browser;
		else throw new RuntimeException("browser not specified in the Configuration.properties file.");		
	}
    
    public String getfilepath(){
		String browser = prop.getProperty("filepath");
		if(browser!= null) return browser;
		else throw new RuntimeException("filepath not specified in the Configuration.properties file.");		
	}
    
    public String getfilepath1(){
		String browser = prop.getProperty("filepath1");
		if(browser!= null) return browser;
		else throw new RuntimeException("Error Image filepath not specified in the Configuration.properties file.");		
	}
    public String getfilepath2(){
		String browser = prop.getProperty("filepath2");
		if(browser!= null) return browser;
		else throw new RuntimeException("Error Image filepath not specified in the Configuration.properties file.");		
	}
    public String getenvironment(){
		String browser = prop.getProperty("Environment");
		if(browser!= null) return browser;
		else throw new RuntimeException("Environment not specified in the Configuration.properties file.");		
	}
}