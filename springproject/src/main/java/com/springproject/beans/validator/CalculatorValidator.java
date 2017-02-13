package com.springproject.beans.validator;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.springproject.beans.form.CalculatorObject;

/**
 * Definimos validador como un bean de spring. para ello usamos la anotacion component (tb podriamos haber usado la anotacion service)
 * @author david
 *
 */
@Component
public class CalculatorValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		return false;
	}

	@Override
	public void validate(Object obj, Errors errors) {
		CalculatorObject co=(CalculatorObject) obj;
		if(StringUtils.isNotBlank(co.getPrimerop()) && StringUtils.isNotBlank(co.getSegundoop()) && !"-1".equals(co.getOperacion())){
			boolean isDataInteger=true;
			try{
				Integer.parseInt(co.getPrimerop());
				Integer.valueOf(co.getSegundoop()).intValue();//otra forma de pasar string a int (tipo primitivo)
				new Integer(co.getOperacion()).intValue();
			}catch(NumberFormatException nfe){
				isDataInteger=false;
			}
			if(!isDataInteger){
				errors.reject("error", "Los valores de los campos del formulario no son validos");
			}
		}
		else{
			errors.reject("error", "Todos los atributos del formulario son obligatorios");
		}
		

	}

}
