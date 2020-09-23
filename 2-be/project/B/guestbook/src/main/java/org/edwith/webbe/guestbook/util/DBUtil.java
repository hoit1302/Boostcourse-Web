package org.edwith.webbe.guestbook.util;

import java.sql.*;

public class DBUtil {
	private static String dbUrl = "jdbc:mysql://localhost/carddb?serverTimezone=Asia/Seoul&useSSL=false"
			+ "&allowPublicKeyRetrieval=true&useUnicode=true&characterEncoding=UTF8";
	private static String dbId = "carduser";
	private static String dbPassword = "card123!@#";
	
    public static Connection getConnection(){
    	return getConnection(dbUrl, dbId, dbPassword);
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
