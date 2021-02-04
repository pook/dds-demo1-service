package com.aec.demo.domain.kafka.sqlserver;

public class Field {

	private String type;
	private boolean optional;
	private String field;
	private String name;
	private int version;
	private Parameter parameters;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isOptional() {
		return optional;
	}
	public void setOptional(boolean optional) {
		this.optional = optional;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public Parameter getParameters() {
		return parameters;
	}
	public void setParameters(Parameter parameters) {
		this.parameters = parameters;
	}	
		
}
