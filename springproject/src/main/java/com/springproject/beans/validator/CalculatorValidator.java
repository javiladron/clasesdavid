package com.springproject.beans.validator;

import org.apache.commons.lang.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.springproject.beans.form.CalculatorObject;

public class CalculatorValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object obj, Errors errors) {
		CalculatorObject co=(CalculatorObject) obj;
		if(StringUtils.isNotBlank(co.getPrimerop()) && StringUtils.isNotBlank(co.getSegundoop()) && !"-1".equals(co.getOperacion())){
			boolean isDataInteger=true;
			int poN=-1;
			int soN=-1;
			int opN=-1;
			try{
				poN=Integer.parseInt(co.getPrimerop());
				soN=Integer.valueOf(co.getSegundoop()).intValue();//otra forma de pasar string a int (tipo primitivo)
				opN=new Integer(co.getOperacion()).intValue();
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
