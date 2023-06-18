package com.example.writer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface Writer {

	void write(String tableName, List<Map<String, Object>> Table);

}
