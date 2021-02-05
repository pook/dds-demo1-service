package com.aec.demo.dds.pub.impl;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.aec.demo.dds.pub.UserPublisher;
import com.aec.demo.domain.User;
import com.aec.demo.domain.kafka.sqlserver.Field;
import com.aec.demo.type.DDSUser;
import com.aec.demo.type.DDSUserDataWriter;
import com.rti.dds.infrastructure.InstanceHandle_t;
import com.rti.dds.infrastructure.RETCODE_ERROR;
import com.rti.dds.infrastructure.RETCODE_NO_DATA;
import com.rti.dds.publication.DataWriter;


@Service
public class UserPublisherImpl implements UserPublisher{

	private static final Logger logger = LogManager.getLogger(UserPublisherImpl.class);
	@Autowired
	@Qualifier("userDataWriter")
	private DataWriter dataWriter;
	
	@Override
	public void write(User publish, Field[] fields){
		logger.info("User ID: " + publish.getUserId());
		DDSUser dds = DDSUser.createInstance(publish, fields);
		try {
			((DDSUserDataWriter) dataWriter).write(dds, InstanceHandle_t.HANDLE_NIL);
		} catch (RETCODE_NO_DATA ex) {
			logger.error(ex.getMessage());
		} catch (RETCODE_ERROR err) {
			StringWriter sw = new StringWriter();
			err.printStackTrace(new PrintWriter(sw));
			logger.error("Write User error ID:"+publish.getUserId()+" " + sw.toString());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
	}

	@Override
	public void write(User publish) {
		logger.info("Write User ID: " + publish.getUserId()+" User Name: ");
		DDSUser dds = DDSUser.createInstance(publish);
		try {
			((DDSUserDataWriter) dataWriter).write(dds, InstanceHandle_t.HANDLE_NIL);
		} catch (RETCODE_NO_DATA ex) {
			logger.error(ex.getMessage());
		} catch (RETCODE_ERROR err) {
			StringWriter sw = new StringWriter();
			err.printStackTrace(new PrintWriter(sw));
			logger.error("Write User error ID:"+publish.getUserId()+" " + sw.toString());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
	}
}
