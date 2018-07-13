package com.example.javawebtutor.untills;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class JDBCConnection {
	public static Connection get_JDBCConnection() {
		final  String url = "jdbc:sqlserver://localhost;databaseName=user";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				return DriverManager.getConnection(url, "trongphu", "Trong107621");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException s) {
			s.printStackTrace();
		}
		return null;
		
	}
	public static void main(String[] args) {
        System.out.println(get_JDBCConnection());
    }

}
