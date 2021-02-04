package com.aec.demo.domain.kafka.sqlserver;

public class Schema {

	private String type;

	private OuterField[] fields;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public OuterField[] getFields() {
		return fields;
	}
	public void setFields(OuterField[] fields) {
		this.fields = fields;
	}	
}