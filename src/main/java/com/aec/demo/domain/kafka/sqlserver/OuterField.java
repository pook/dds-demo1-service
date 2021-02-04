package com.aec.demo.domain.kafka.sqlserver;

public class OuterField {

	private String struct;
	private Field[] fields;
	public String getStruct() {
		return struct;
	}
	public void setStruct(String struct) {
		this.struct = struct;
	}
	public Field[] getFields() {
		return fields;
	}
	public void setFields(Field[] fields) {
		this.fields = fields;
	}
	
}