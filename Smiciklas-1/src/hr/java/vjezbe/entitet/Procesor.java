package hr.java.vjezbe.entitet;

import java.math.BigDecimal;

public class Procesor {

	private String nazivProizvodaca;
	private String tip;
	private String tipSucelja;
	private BigDecimal brzina;

	public Procesor(String naziv, String tip, String tipSucelja, BigDecimal brzina) {
		nazivProizvodaca = naziv;
		this.tip = tip;
		this.tipSucelja = tipSucelja;
		this.brzina = brzina;
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

	public String getTipSucelja() {
		return tipSucelja;
	}

	public void setTipSucelja(String tipSucelja) {
		this.tipSucelja = tipSucelja;
	}

	public BigDecimal getBrzina() {
		return brzina;
	}

	public void setBrzina(BigDecimal brzina) {
		this.brzina = brzina;
	}

}
