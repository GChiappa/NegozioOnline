package  it.betacom.businesscomponent.model;

public class Ordine_Articolo {
	private long id_ordine;
	private long id_articolo;
	private int quantita;

	public long getId_ordine() {
		return id_ordine;
	}

	public void setId_ordine(long id_ordine) {
		this.id_ordine = id_ordine;
	}

	public long getId_articolo() {
		return id_articolo;
	}

	public void setId_articolo(long id_articolo) {
		this.id_articolo = id_articolo;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	@Override
	public String toString() {
		return "Ordine_Articolo [id_ordine=" + id_ordine + ", id_articolo=" + id_articolo + ", quantita=" + quantita
				+ "]";
	}

}
