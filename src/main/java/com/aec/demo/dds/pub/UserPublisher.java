package com.aec.demo.dds.pub;

import com.aec.demo.domain.User;

public interface UserPublisher extends AbstractPublisher<User>{
	public void write(User publish);
}
