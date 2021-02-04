package com.aec.demo.domain.kafka.sqlserver;

public class Kafka<T>{	

	private TriggerEntry<T> payload;
	private Schema schema;
	
	private char op;
	private long ts_ms;
	private long transaction;
	
	public char getOp() {
		return op;
	}
	public void setOp(char op) {
		this.op = op;
	}
	public long getTs_ms() {
		return ts_ms;
	}
	public void setTs_ms(long ts_ms) {
		this.ts_ms = ts_ms;
	}
	public long getTransaction() {
		return transaction;
	}
	public void setTransaction(long transaction) {
		this.transaction = transaction;
	}
	public TriggerEntry<T> getPayload() {
		return payload;
	}
	public void setPayload(TriggerEntry<T> payload) {
		this.payload = payload;
	}
	public Schema getSchema() {
		return schema;
	}
	public void setSchema(Schema schema) {
		this.schema = schema;
	}
		
}
