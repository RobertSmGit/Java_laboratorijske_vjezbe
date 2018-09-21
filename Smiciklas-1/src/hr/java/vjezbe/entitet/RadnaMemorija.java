package hr.java.vjezbe.entitet;

public class RadnaMemorija {

	private String nazivProizvodaca;
	private String tip;
	private Integer kapacitet;

	public RadnaMemorija(String naziv, String tip, Integer kapacitet) {
		nazivProizvodaca = naziv;
		this.tip = tip;
		this.kapacitet = kapacitet;
	}

	public String getNazivProizvodaca() {
		return nazivProizvodaca;
	}

	public void setNazivProizvodaca(String nazivProizvodaca) {
		this.nazivProizvodaca = nazivProizvodaca;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public Integer getKapacitet() {
		return kapacitet;
	}

	public void setKapacitet(Integer kapacitet) {
		this.kapacitet = kapacitet;
	}

}
