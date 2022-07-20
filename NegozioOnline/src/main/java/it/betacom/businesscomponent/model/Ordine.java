package com.gio.businesscomponent.model;

import java.util.Date;

public class Ordine {
	private long id_ordine;
	private double totale;
	private Date data;
	private String username;
	
	public long getId_ordine() {
		return id_ordine;
	}

	public void setId_ordine(long id_ordine) {
		this.id_ordine = id_ordine;
	}

	public double getTotale() {
		return totale;
	}

	public void setTotale(double totale) {
		this.totale = totale;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Ordine [id_ordine=" + id_ordine + ", totale=" + totale + ", data=" + data + ", username=" + username
				+ "]";
	}

}
