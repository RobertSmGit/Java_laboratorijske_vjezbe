package hr.java.vjezbe.entitet;

public class Racunalo {

	private MaticnaPloca maticnaPloca;
	private Procesor procesor;
	private RadnaMemorija radnaMemorija;
	private TvrdiDisk tvrdiDisk;

	public Racunalo(MaticnaPloca maticnaPloca, Procesor procesor, RadnaMemorija radnaMemorija, TvrdiDisk tvrdiDisk) {
		this.maticnaPloca = maticnaPloca;
		this.procesor = procesor;
		this.radnaMemorija = radnaMemorija;
		this.tvrdiDisk = tvrdiDisk;
	}

	public MaticnaPloca getMaticnaPloca() {
		return maticnaPloca;
	}

	public void setMaticnaPloca(MaticnaPloca maticnaPloca) {
		this.maticnaPloca = maticnaPloca;
	}

	public Procesor getProcesor() {
		return procesor;
	}

	public void setProcesor(Procesor procesor) {
		this.procesor = procesor;
	}

	public RadnaMemorija getRadnaMemorija() {
		return radnaMemorija;
	}

	public void setRadnaMemorija(RadnaMemorija radnaMemorija) {
		this.radnaMemorija = radnaMemorija;
	}

	public TvrdiDisk getTvrdiDisk() {
		return tvrdiDisk;
	}

	public void setTvrdiDisk(TvrdiDisk tvrdiDisk) {
		this.tvrdiDisk = tvrdiDisk;
	}

}
