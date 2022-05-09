package com.anchtun.java7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class JDBCImprovements {

	public static void main(String[] args) throws Exception {
		getResults();
		createJdbcRowSet();
	}

	/**
	 * try with resources
	 * the resources will be closed automatically
	 */
	private static void getResults() throws Exception {
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "user", "password");
				Statement sta = con.createStatement();
				ResultSet res = sta.executeQuery("select * from product");) {
			while (res.next()) {
				System.out.println("Department name=" + res.getString("name"));
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	private static void createJdbcRowSet() throws Exception {
		try (JdbcRowSet jrs = RowSetProvider.newFactory().createJdbcRowSet();) {
			jrs.setUrl("jdbc:mysql://localhost:3306/test");
			jrs.setUsername("user");
			jrs.setPassword("password");
			jrs.setCommand("select * from product");
			jrs.execute();
			while (jrs.next()) {
				System.out.println("Department name=" + jrs.getString("name"));
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
}
