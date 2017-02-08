package com.springproject.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class JstlClaseController {
	
	@RequestMapping(value="/jstlclase/",method=RequestMethod.GET)
	public String getJsp(Model model){
		List<String> jugadores=new ArrayList<String>();
		jugadores.add("Messi");
		jugadores.add("Cristiano");
		jugadores.add("Neymar");
		jugadores.add("Suarez");
		
		model.addAttribute("lista", jugadores);
		return "jstlclase";
	}

}
