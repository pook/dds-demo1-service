package com.aec.demo.domain.kafka.sqlserver;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Parameter {
	
	private String scale;
	
	@JsonProperty("connect.decimal.precision")
	private String precision;

	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public String getPrecision() {
		return precision;
	}

	public void setPrecision(String precision) {
		this.precision = precision;
	}
}
