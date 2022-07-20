package it.betacom.businesscomponent.model;

public class Immagine {
	private long id_immagine;
	private String url;
	private String descrizione;

	public long getId_immagine() {
		return id_immagine;
	}

	public void setId_immagine(long id_immagine) {
		this.id_immagine = id_immagine;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	@Override
	public String toString() {
		return "Immagine [id_immagine=" + id_immagine + ", url=" + url + ", descrizione=" + descrizione + "]";
	}

}
