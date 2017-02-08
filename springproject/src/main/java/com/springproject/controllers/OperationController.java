package com.springproject.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springproject.beans.form.CalculatorObject;
import com.springproject.manager.IManagerOperation;

@Controller
public class OperationController {
	
	@Autowired
	IManagerOperation manager;

	@RequestMapping(value="/operation/",method = RequestMethod.GET)
	public String showDefaultIndex(Model model){
		CalculatorObject co= new CalculatorObject();
		model.addAttribute("calculatorObject",co);
		return "index";
	}
	
	@RequestMapping(value="/operation/calcular/",method = RequestMethod.POST)
	public String calculate(HttpServletRequest request,@Validated CalculatorObject co,BindingResult br,Model model){
		//recoger parametros del formulario
		/*String primerop=request.getParameter("primerop");
		String segundoop=request.getParameter("segundoop");
		String operacion=request.getParameter("operacion");*/
		
		List<ObjectError> errors=br.getAllErrors();
		/*if(errors!=null && errors.size()>0){
			
		}*/
		System.out.println("Llego al controller con "+errors.size()+" errores");
		if(CollectionUtils.isEmpty(errors)){
			System.out.println("por aqui no debes entrar ahora");
			//llamar a metodo calcular del manager
			//String res=manager.calcular(primerop, segundoop, operacion);
			String res=manager.calcular(co.getPrimerop(),co.getSegundoop(),co.getOperacion());
			//incrustar resultado en el modelo
			/**
			 * metemos el resultado calculado en la variable model que se pasa a la vista.
			 * En este caso la vista es result (result.jsp)
			 */
			//model.addAttribute("resultado", StringUtils.isNotBlank(res) ? res : "error");
			model.addAttribute("resultado", res);
		}
		else{
			model.addAttribute("resultado", null);
			System.out.println("eoeoe: "+errors.get(0).getDefaultMessage());
			model.addAttribute("err", errors.get(0).getDefaultMessage());//paso a la vista el unico error que tengo
		}
		
		
		return "result";
	}
	
	
	
}
