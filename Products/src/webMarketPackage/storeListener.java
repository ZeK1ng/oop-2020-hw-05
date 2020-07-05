package webMarketPackage;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.Console;
import java.sql.*;
import java.util.*;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class storeListener
 *
 */
public class storeListener implements ServletContextListener {
	private static final String dbUname = DBINFO.dbUname;
	private static final String dbpass = DBINFO.dbpass;
	private static final String server = DBINFO.server;
	private static final String database = DBINFO.database;
	private static final String tableName = DBINFO.tableName;
	private Connection con;
    /**
     * Default constructor. 
     */
    public storeListener() {
        // TODO Auto-generated constructor stub
    	con = null;
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
    	ProductCatalog prod_cat = new ProductCatalog();
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		con = DriverManager.getConnection("jdbc:mysql://" + server, dbUname ,dbpass);
    		Statement stmt = con.createStatement();
    		stmt.executeQuery("USE " + database);
    		ResultSet rs = stmt.executeQuery("SELECT * FROM " +tableName);
    		while(rs.next()) {
    			String prod_id = rs.getString("productid");
    			String name = rs.getString("name");
    			String imageFile= rs.getString("imagefile");
    			double price = rs.getDouble("price");
    			prod_cat.add(new Product(prod_id,name,imageFile,price));
    		}
    		arg0.getServletContext().setAttribute("productCatalog", prod_cat);
    		con.close();
    	}catch(SQLException | ClassNotFoundException e ) {
    		e.printStackTrace();
    	}
         
    }
	
}
