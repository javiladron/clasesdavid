package com.springproject.controllers;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springproject.beans.bbdd.DescOperationBean;
import com.springproject.beans.form.CalculatorObject;
import com.springproject.beans.validator.CalculatorValidator;
import com.springproject.manager.IManagerOperation;
import com.springproject.manager.IManagerOperationJPA;

@Controller
public class OperationController {
	
	@Autowired
	IManagerOperation manager;
	
	@Autowired
	IManagerOperationJPA managerJPA;
	
	@Autowired
	CalculatorValidator validator;

	@RequestMapping(value="/operation/",method = RequestMethod.GET)
	public String showDefaultIndex(Model model){
		CalculatorObject co= new CalculatorObject();
		model.addAttribute("calculatorObject",co);
		model.addAttribute("modologs","jpa");
		return "index";
	}
	
	@RequestMapping(value="/operation/calcular/",method = RequestMethod.POST)
	public String calculate(HttpServletRequest request,@ModelAttribute("calculatorObject") CalculatorObject co,BindingResult br,Model model){
		//recoger parametros del formulario
		/*String primerop=request.getParameter("primerop");
		String segundoop=request.getParameter("segundoop");
		String operacion=request.getParameter("operacion");*/
		validator.validate(co, br);
		if(!br.hasErrors()){//si no tiene errores llamo al manager para que me haga la operacion
			//llamar a metodo calcular del manager
			//String res=manager.calcular(primerop, segundoop, operacion);
			String res=null;
			if("jdbc".equals(co.getTipoBBDD())){
				res=manager.calcular(co.getPrimerop(),co.getSegundoop(),co.getOperacion());
				model.addAttribute("modologs","jdbc");
			}
			else{
				res=managerJPA.calcular(co.getPrimerop(),co.getSegundoop(),co.getOperacion());
				model.addAttribute("modologs","jpa");
			}
			
					
			//incrustar resultado en el modelo
			/**
			 * metemos el resultado calculado en la variable model que se pasa a la vista.
			 * En este caso la vista es result (result.jsp)
			 */
			//model.addAttribute("resultado", StringUtils.isNotBlank(res) ? res : "error");
			model.addAttribute("resultado", res);
		}
		else{//si tiene errores cojo la lista de ellos y estraigo únicamente el primero porque se que solo va a haber uno
			model.addAttribute("resultado", null);
			model.addAttribute("modologs","jpa");
//			List<ObjectError> listaErrores=br.getAllErrors();
//			for(int i=0;i<listaErrores.size();i++){
//				listaErrores.get(i);
//			}
//			
//			for(ObjectError error : listaErrores){
//				System.out.println(error);
//			}
			model.addAttribute("err", br.getAllErrors().get(0).getDefaultMessage());//paso a la vista el unico error que tengo
		}
		
		
		return "result";
	}
	
	@RequestMapping(value="/operation/logs/",method = RequestMethod.GET)
	public String showlogo(HttpServletRequest request,Model model){
		String mode=request.getParameter("mode");
		String op=request.getParameter("op");
		if("jdbc".equals(mode)){
			model.addAttribute("lista", manager.dameListadoLogs(op));
		}
		else{
			model.addAttribute("lista", managerJPA.dameListadoLogsJPA(op));
		}
		model.addAttribute("modologs",mode);
		return "logs";
	
	}
	
}
