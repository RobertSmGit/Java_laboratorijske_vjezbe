package hr.java.vjezbe.entitet;

import java.math.BigDecimal;

public class TvrdiDisk {

	private String nazivProizvodaca;
	private String tip;
	private BigDecimal kapacitet;

	public TvrdiDisk(String naziv, String tip, BigDecimal kapacitet) {
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

	public BigDecimal getKapacitet() {
		return kapacitet;
	}

	public void setKapacitet(BigDecimal kapacitet) {
		this.kapacitet = kapacitet;
	}

}
