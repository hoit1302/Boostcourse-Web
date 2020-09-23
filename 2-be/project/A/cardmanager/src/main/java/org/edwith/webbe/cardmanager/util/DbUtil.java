package org.edwith.webbe.cardmanager.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
	private static String dbUrl = "jdbc:mysql://localhost/carddb?serverTimezone=Asia/Seoul&useSSL=false"
			+ "&allowPublicKeyRetrieval=true&useUnicode=true&characterEncoding=UTF8";
	private static String dbUser = "carduser";
	private static String dbPasswd = "card123!@#";
	
	public static Connection getConnection(){
        return getConnection(dbUrl, dbUser, dbPasswd);
    }

    private static Connection getConnection(String dbURL, String dbId, String dbPassword){
        Connection conn = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, dbId, dbPassword);
            return conn;
        }catch(Exception ex){
            throw new RuntimeException("Connection Error");
        }
    }
}
