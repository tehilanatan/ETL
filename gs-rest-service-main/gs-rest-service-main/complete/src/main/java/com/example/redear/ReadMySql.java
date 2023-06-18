package com.example.redear;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;

import com.example.restservice.Person;

public class ReadMySql implements Reader {

	
	static final String DB_URL = "jdbc:mysql://localhost/students";
	@Value("${spring.datasource.username}") String USER;
	@Value("${spring.datasource.password}") String PASS;
	
	
	public ReadMySql() {
	
		
	}
	
	@Override
	public void read() {

	}

	
	public List<Map<String, Object>> readFromDB(String QUERY) {
		
		List<Map<String, Object>> hashTable = new ArrayList<Map<String, Object>>();
		// Open a connection
		try (Connection conn = DriverManager.getConnection(DB_URL, "root", "123456");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(QUERY);) {
			// Extract data from result set
			while (rs.next()) {
				ResultSetMetaData metaData = rs.getMetaData();
				HashMap<String, Object> hashItem = new HashMap<String, Object>();
				for (int i = 1; i <= metaData.getColumnCount(); i++) {
					hashItem.putIfAbsent(metaData.getColumnName(i), rs.getObject(i));
				}
				hashTable.add(hashItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return hashTable;
	}

}
