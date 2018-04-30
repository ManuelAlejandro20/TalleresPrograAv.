package ucn;

public class ListaLector {
	private Lector[] lista;
	private static int maxlector;
	
	public ListaLector(int max) {
		lista = new Lector[max];
	}
	
	public void agregar_lector(Lector objetolector, int contador) {
		lista[contador] = objetolector;
		maxlector = contador;
	}
	
	public boolean verificar_lector(String id_escrita) {
		for (int i=0; i<maxlector; i++) {
			if(lista[i].getid().equals(id_escrita)) {
				return true;
			}
		}
		return false;
	}
	
	public Lector[] getlistalector() {
		return lista;
	}
	
	public int get_maxlector() {
		return maxlector;
	}
	
	public void setnuevolector(Lector lectornuevo) {
		maxlector++;
		this.lista[maxlector] = lectornuevo;

	}
	
}
