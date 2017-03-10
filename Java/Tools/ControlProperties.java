package Tools;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class ControlProperties {

	//用bundle有一个坏就是只能读，因为用他来读不能修改，修改了以后再次读额时候还是原来bundle里的值
	/*public int readProperties() {
		ResourceBundle rBundle = ResourceBundle.getBundle("config");
		int i = Integer.parseInt(rBundle.getString("i"));
		return i;
	}*/
	
	public int readProperties(String key) {  
        //获取绝对路径  
        String filePath = ControlProperties.class.getResource("/").toString();  
        //截掉路径的”file:“前缀  
         
       filePath = filePath.substring(6, filePath.length()-4)+"config.properties";
         //"F:\\programmeSoftware\\netBeans\\MyProjects\\face\\config.properties";  
        Properties props = new Properties();  
        try {  
            InputStream in = new BufferedInputStream(new FileInputStream(filePath));  
            props.load(in);  
            in.close();  
            String value = props.getProperty(key);  
            return Integer.parseInt(value);  
        } catch (Exception e) {  
            e.printStackTrace();  
            return -1;  
        }  
    }  

	public void writeData(String key, String value) {
		// 获取绝对路径
		String filePath = ControlProperties.class.getResource("/").toString();
		// 截掉路径的”file:/“前缀
		filePath = filePath.substring(6, filePath.length()-4)+"config.properties";
		//filePath = filePath +"src/config.properties";
		//"F:\\programmeSoftware\\netBeans\\MyProjects\\face\\config.properties";  
		Properties prop = new Properties();
		try {
			File file = new File(filePath);
			if (!file.exists())
				file.createNewFile();
			/*InputStream fis = new FileInputStream(file);
			prop.load(fis);
			// 一定要在修改值之前关闭fis
			fis.close();*/
			OutputStream fos = new FileOutputStream(filePath);
			prop.setProperty(key, value);
			// 保存，并加入注释
			prop.store(fos, "Update '" + key + "' value");
			fos.close();
		} catch (IOException e) {
			System.err.println("Visit " + filePath + " for updating " + value + " value error");
		}
	}

}
