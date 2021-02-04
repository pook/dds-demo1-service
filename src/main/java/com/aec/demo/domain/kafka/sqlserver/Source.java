package com.aec.demo.domain.kafka.sqlserver;

public class Source {
	
	private String version;
	private String connector;
	private String name;
	private String ts_ms;
	private boolean snapshot;
	private String db;
	private String schema;
	private String table;
	private int txId;
	private int lsn;
	private int xmin;
	
	private String change_lsn;
	private String commit_lsn;
	
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getConnector() {
		return connector;
	}
	public void setConnector(String connector) {
		this.connector = connector;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTs_ms() {
		return ts_ms;
	}
	public void setTs_ms(String ts_ms) {
		this.ts_ms = ts_ms;
	}
	public boolean isSnapshot() {
		return snapshot;
	}
	public void setSnapshot(boolean snapshot) {
		this.snapshot = snapshot;
	}
	public String getDb() {
		return db;
	}
	public void setDb(String db) {
		this.db = db;
	}
	public String getSchema() {
		return schema;
	}
	public void setSchema(String schema) {
		this.schema = schema;
	}
	public String getTable() {
		return table;
	}
	public void setTable(String table) {
		this.table = table;
	}
	public int getTxId() {
		return txId;
	}
	public void setTxId(int txId) {
		this.txId = txId;
	}
	public int getLsn() {
		return lsn;
	}
	public void setLsn(int lsn) {
		this.lsn = lsn;
	}
	public int getXmin() {
		return xmin;
	}
	public void setXmin(int xmin) {
		this.xmin = xmin;
	}
	public String getChange_lsn() {
		return change_lsn;
	}
	public void setChange_lsn(String change_lsn) {
		this.change_lsn = change_lsn;
	}
	public String getCommit_lsn() {
		return commit_lsn;
	}
	public void setCommit_lsn(String commit_lsn) {
		this.commit_lsn = commit_lsn;
	}


}
