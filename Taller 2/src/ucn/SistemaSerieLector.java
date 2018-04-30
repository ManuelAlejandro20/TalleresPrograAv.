package ucn;

public interface SistemaSerieLector {
	
	public Serie crearserie_arreglo(int isbn, String nombre, String autor, String fecha, int contador);
	public Lector crearlector_arreglo(String id, String nombre, int contador1);
	public void creararreglos_sus(Lector arreglo, String[] suscripciones, int contador);
	public boolean agregarserie(int isbn_escrito, String nombre_escrito, String autor_escrito, String fecha_escrita);
	public boolean agregarlector(String id, String nombre, int numero);
}
