package rs.ac.uns.ftn.informatika.dosk.java.vezbe06.primer02;

public class IzuzetakNeispravanSlog extends Exception {

	String slog;
	String token;
	
	public IzuzetakNeispravanSlog(String slog) {
		this.slog = slog;
	}

	public IzuzetakNeispravanSlog(String slog, String token) {
		this.slog = slog;
		this.token = token;
	}
	
	public void ispisIzuzetak() {
		if (token != null) {
			System.out.println("Neispravan slog " + slog + " kod tokena " 
		+ token);
			return;
		}

		System.out.println("Neispravan slog " + slog);
	}

}
