package ucn;

public class Lector {
	private String id;
	private String nombre;
	private ListaSuscripcion listasuscripcion;
	
	public Lector(String id, String nombre) {
		this.id = id;
		this.nombre = nombre;
		listasuscripcion = new ListaSuscripcion(100);
	}

	
	public String getnombre() {
		return nombre;
	}
	
	public String getid() {
		return id;
	}
	
	public ListaSuscripcion getlistasuscripcion() {
		return listasuscripcion;
	}
	
}
