package util;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
 
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
/**
 * extract sys-config.xml文件
 * @author Amber
 *
 */
public class XmlConfigReader {
 
	
	private static XmlConfigReader instance = null;
	
	private JdbcConfig jdbcConfig = new JdbcConfig();;
	
	private XmlConfigReader() {
		SAXReader reader = new SAXReader();
		System.out.println("in is null");
		//通过当前线程的类加载器，获得文件的相对路径，将xml文件读入到输入流
		
		InputStream in = XmlConfigReader.class.getResourceAsStream("sys-config.xml");
				  //Thread.currentThread().getContextClassLoader().getResourceAsStream("sys-config.xml");
		if (in == null) {
			System.out.println("in is null");
		}else {
			System.out.println(in.toString());
		}
		
		try {
			 // read xml and convert it to document type
			Document doc = reader.read(in);
			
			//get jdbc config info
			Element driverNameElt = (Element)doc.selectObject("/config/db-info/driver-name");	
			Element urlElt = (Element)doc.selectObject("/config/db-info/url");
			Element userNameElt = (Element)doc.selectObject("/config/db-info/user-name");
			Element passwordElt = (Element)doc.selectObject("/config/db-info/password");
			
			//setup jdbc settings
			jdbcConfig.setDriverName(driverNameElt.getStringValue());
			jdbcConfig.setUrl(urlElt.getStringValue());
			jdbcConfig.setUserName(userNameElt.getStringValue());
			jdbcConfig.setPassword(passwordElt.getStringValue());
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
 
	/**
	 * 加锁，实现多线程的同步机制，防止多线程的访问冲突
	 * @return
	 * @throws FileNotFoundException 
	 */
	public static synchronized XmlConfigReader getInstance() {
		if(instance == null){			
			instance = new XmlConfigReader();
		}
		return instance;
	}
	/**
	 * return jdbcConfig instance
	 * @return
	 */
	public JdbcConfig getJdbcConfig(){
		return jdbcConfig;
	}
}
