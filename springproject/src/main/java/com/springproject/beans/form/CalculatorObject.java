package com.springproject.beans.form;

import java.io.Serializable;

public class CalculatorObject implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	
	private String primerop;
	private String segundoop;
	private String operacion;
	private String tipoBBDD;
	private String boton;
	public String getPrimerop() {
		return primerop;
	}
	public void setPrimerop(String primerop) {
		this.primerop = primerop;
	}
	public String getSegundoop() {
		return segundoop;
	}
	public void setSegundoop(String segundoop) {
		this.segundoop = segundoop;
	}
	public String getOperacion() {
		return operacion;
	}
	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}
	public String getBoton() {
		return boton;
	}
	public void setBoton(String boton) {
		this.boton = boton;
	}
	public String getTipoBBDD() {
		return tipoBBDD;
	}
	public void setTipoBBDD(String tipoBBDD) {
		this.tipoBBDD = tipoBBDD;
	}
	
	

}
