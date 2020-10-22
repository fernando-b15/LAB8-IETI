package com.eci.cosw.springbootsecureapi.model;

import java.util.Date;

public class Task {
	
	private String id;
	private String descripcion;
	private Date dueDate;
	private String estado;
	private User responsable;
	
	public Task() {
		
		
	}

	public Task(String id, String descripcion, Date dueDate, String estado, User responsable) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.dueDate = dueDate;
		this.estado = estado;
		this.responsable = responsable;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String esatado) {
		this.estado = esatado;
	}

	public User getResponsable() {
		return responsable;
	}

	public void setResponsable(User responsable) {
		this.responsable = responsable;
	}
	

}
