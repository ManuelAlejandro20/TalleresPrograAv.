package ucn;

public class Serie {
	private int isbn;
	private String nombre;
	private String autor;
	private String fecha;
	private ListaSerie listaserie;
					
	public Serie(int isbn, String nombre, String autor, String fecha) {
		this.isbn = isbn;
		this.nombre = nombre;
		this.autor = autor;
		this.fecha = fecha;
		
	}	
	
	
	public int getisbn() {
		return isbn;
	}
	
	public String getnombre() {
		return nombre;
	}
	
	public String getautor() {
		return autor;
	}
	
	public String getfecha() {
		return fecha;
	}
	
	public ListaSerie getlistaserie() {
		return listaserie;
	}
	
	public void set_nombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void set_autor(String autor) {
		this.autor = autor;
	}
	
	public void set_fecha(String fecha) {
		this.fecha = fecha;
	}
	
	

}