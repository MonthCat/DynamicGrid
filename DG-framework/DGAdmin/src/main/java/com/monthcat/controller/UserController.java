package com.monthcat.controller;

import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.monthcat.model.User;
import com.monthcat.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	private static Logger logger = Logger.getLogger(UserController.class);
	@Autowired
	private UserService userService;

	@RequestMapping("/reg")
	public String register(User user, Model model) {
		return "index";
	}

	@RequestMapping("/update")
	public String updateUser(User user, Model model) {
		return "updateUser";
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ModelAndView addUser(User user) {
		ModelAndView mav = null;

		try {

			user.setId(UUID.randomUUID().toString().length());
			userService.addUser(user);
			logger.info("User " + user.getUsername() + " register success.");
			mav = new ModelAndView();
			mav.setViewName("success");
			mav.addObject("user", user);
			mav.addObject("msg", "register success!");
			return mav;
		} catch (Exception e) {
			logger.error("User register error.", e);
			mav = new ModelAndView();
			mav.setViewName("error");
			mav.addObject("user", null);
			mav.addObject("user", "register failed!");
			return mav;
		}

	}
}
