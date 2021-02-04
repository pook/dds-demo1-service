package com.aec.demo.domain.kafka.sqlserver;

public class TriggerEntry <T>{
	
	private T before;
	private T after;
	private Source source;
	private char op;
	private String ts_ms;
	//private transaction
	public T getBefore() {
		return before;
	}
	public void setBefore(T before) {
		this.before = before;
	}
	public T getAfter() {
		return after;
	}
	public void setAfter(T after) {
		this.after = after;
	}
	public Source getSource() {
		return source;
	}
	public void setSource(Source source) {
		this.source = source;
	}
	public char getOp() {
		return op;
	}
	public void setOp(char op) {
		this.op = op;
	}
	public String getTs_ms() {
		return ts_ms;
	}
	public void setTs_ms(String ts_ms) {
		this.ts_ms = ts_ms;
	}

}
