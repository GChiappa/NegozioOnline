package com.gio.businesscomponent.model;

public class Articolo {
	private long id_articolo;
	private String marca;
	private String modello;
	private double prezzo;

	public long getId_articolo() {
		return id_articolo;
	}

	public void setId_articolo(long id_articolo) {
		this.id_articolo = id_articolo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	@Override
	public String toString() {
		return "Articolo [id_articolo=" + id_articolo + ", marca=" + marca + ", modello=" + modello + ", prezzo="
				+ prezzo + "]";
	}

}
