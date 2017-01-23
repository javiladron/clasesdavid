package com.springproject.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springproject.manager.IManagerOperation;

@Controller
public class OperationController {
	
	@Autowired
	IManagerOperation manager;

	@RequestMapping(value="/operation/",method = RequestMethod.GET)
	public String showDefaultIndex(Model model){
		return "index";
	}
	
	@RequestMapping(value="/operation/calcular/",method = RequestMethod.POST)
	public String calculate(HttpServletRequest request,Model model){
		//recoger parametros del formulario
		String primerop=request.getParameter("primerop");
		String segundoop=request.getParameter("segundoop");
		String operacion=request.getParameter("operacion");
		//llamar a metodo calcular del manager
		String res=manager.calcular(primerop, segundoop, operacion);
		//incrustar resultado en el modelo
		model.addAttribute("resultado", res);
		return "result";
	}
	
	
	
}
