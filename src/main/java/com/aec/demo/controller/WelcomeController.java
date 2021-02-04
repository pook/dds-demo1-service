package com.aec.demo.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aec.demo.dds.pub.UserPublisher;
import com.aec.demo.domain.User;

@Controller
public class WelcomeController {

	@Autowired
	private UserPublisher userPublisher;
	private static final Logger logger = LogManager.getLogger(WelcomeController.class);
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index(Model model) {
		 model.addAttribute("user", new User());
		
		return "index";
	}
	
	@RequestMapping(value="/welcome", method=RequestMethod.POST)
	public String  welcome(ModelMap model, @ModelAttribute("user")User user) {
//		logger.info(fname);
		logger.info("cccc"+user.getUserFname());
		userPublisher.write(user);
		return "welcome";
	}
}
