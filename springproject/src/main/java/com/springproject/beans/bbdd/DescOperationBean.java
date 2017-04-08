package com.springproject.beans.bbdd;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Esta entity tiene una relacion N:1 con las entity LogBean
 * @author david
 *
 */
@Entity
@Table(name="descoperation")
public class DescOperationBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	private String nombreop;
	private String color;
	@OneToMany(fetch=FetchType.LAZY,mappedBy="descOperation")
	private List<LogBean> lista;
	
	public Integer getId() {
		return id;
	}
	public String getNombreop() {
		return nombreop;
	}
	public String getColor() {
		return color;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setNombreop(String nombreop) {
		this.nombreop = nombreop;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public List<LogBean> getLista() {
		return lista;
	}
	public void setLista(List<LogBean> lista) {
		this.lista = lista;
	}
	
	

}
