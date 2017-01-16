package com.springproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OperationController {

	@RequestMapping(value="/operation/",method = RequestMethod.GET)
	public String showDefaultIndex(Model model){
		return "index";
	}
	
}
