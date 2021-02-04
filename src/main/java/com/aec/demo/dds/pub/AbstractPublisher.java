package com.aec.demo.dds.pub;

import com.aec.demo.domain.kafka.sqlserver.Field;

public interface AbstractPublisher<T> {
	public void write(T publish, Field[] fields);
}
