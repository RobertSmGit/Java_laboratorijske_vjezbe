package hr.java.vjezbe.entitet;

public class MaticnaPloca {

	private String nazivProizvodaca;
	private String tip;

	public MaticnaPloca(String naziv, String tip) {
		nazivProizvodaca = naziv;
		this.tip = tip;
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

}
