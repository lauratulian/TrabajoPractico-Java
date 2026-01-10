package data;

import java.sql.*;
import java.util.Properties;
import java.io.InputStream;


public class DbConnector {

	private static DbConnector instancia;
	
	private String driver;
    private String host;
    private String port;
    private String user;
    private String password;
    private String db;
	
	private int conectados=0;
	private Connection conn=null;
	
	 private void loadConfig() {
	        try (InputStream is = getClass()
	                .getClassLoader()
	                .getResourceAsStream("db.properties")) {

	            Properties props = new Properties();
	            props.load(is);

	            driver = props.getProperty("db.driver");
	            host = props.getProperty("db.host");
	            port = props.getProperty("db.port");
	            db = props.getProperty("db.name");
	            user = props.getProperty("db.user");
	            password = props.getProperty("db.password");

	        } catch (Exception e) {
	            throw new RuntimeException("No se pudo cargar db.properties", e);
	        }
	    }

	
	
	public DbConnector() {
		loadConfig();
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static DbConnector getInstancia() {
		if (instancia == null) {
			instancia = new DbConnector();
		}
		return instancia;
	}
	
	public Connection getConn() {
		try {
			if(conn==null || conn.isClosed()) {
				conn=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+db, user, password);
				conectados=0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conectados++;
		return conn;
	}
	
	public void releaseConn() {
		conectados--;
		try {
			if (conectados <= 0 && conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}

	
