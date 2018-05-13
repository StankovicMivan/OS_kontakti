package Model;

public class Uplata {

	private Ucenik ucenik;
	private Kurs kurs;
	public Uplata() {
		super();
	}
	public Uplata(Ucenik ucenik, Kurs kurs) {
		super();
		this.ucenik = ucenik;
		this.kurs = kurs;
	}
	@Override
	public String toString() {
		return "Uplata [ucenik=" + ucenik + ", kurs=" + kurs + "]";
	}
	public Ucenik getUcenik() {
		return ucenik;
	}
	public void setUcenik(Ucenik ucenik) {
		this.ucenik = ucenik;
	}
	public Kurs getKurs() {
		return kurs;
	}
	public void setKurs(Kurs kurs) {
		this.kurs = kurs;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((kurs == null) ? 0 : kurs.hashCode());
		result = prime * result + ((ucenik == null) ? 0 : ucenik.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Uplata other = (Uplata) obj;
		if (kurs == null) {
			if (other.kurs != null)
				return false;
		} else if (!kurs.equals(other.kurs))
			return false;
		if (ucenik == null) {
			if (other.ucenik != null)
				return false;
		} else if (!ucenik.equals(other.ucenik))
			return false;
		return true;
	}
	
	
	
}
