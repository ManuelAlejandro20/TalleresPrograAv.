package ucn;

public class ListaSuscripcion {
	private String[] listasuscripcion;
	private static int maxlista;
	
	public ListaSuscripcion (int max) {
		listasuscripcion = new String[max];
	}
	
	public void suscripciones_existentes(String sus, int contador) {
		listasuscripcion[contador] = sus;
		maxlista = contador;
	}
	
	public String[] getlista_sus(){
		return listasuscripcion;
	}
	
	public int getmaxlista() {
		return maxlista;
	}
	
	public void setlista_sus(String sus) {
		maxlista++;
		listasuscripcion[maxlista] = sus;
	}
	
	public void setlista_nueva(String sus, int numero) {
		maxlista = numero;
		listasuscripcion[numero] = sus;
	}

}
