package com.example.restservice;

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
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.redear.ReadMySql;
import com.example.writer.WriteMongoDb;

@RestController
public class GreetingController {

	private ReadMySql readMySql;
	private WriteMongoDb writeMongoDb;
	static final String QUERY = "SELECT *  FROM person";
	static final String DB_URL = "jdbc:mysql://localhost/students";
	@Value("${spring.datasource.username}") String USER;
	@Value("${spring.datasource.password}") String PASS;


	@GetMapping("/TableSqlToMongo")
	public int TableSqlToMongo() {
		
		writeMongoDb = new WriteMongoDb();
		readMySql = new ReadMySql();
		writeMongoDb.write("sampleCollection", readMySql.readFromDB(QUERY));
		 return 222;
	}


}
