package ucn;

public class ListaSerie {
	private Serie[] lista;
	private static int maxseries;
	
	public ListaSerie(int max) {
		lista = new Serie[max];
	}
	
	public void agregarserie(Serie serie, int contador) {
		lista[contador] = serie;
		maxseries = contador;
	}
	
	public Serie[] get_listaserie() {
		return lista;
	}
	
	public int get_maxseries() {
		return maxseries;
	}
	
	public int verficar_isbn(int isbn) {
		for (int i=0; i<maxseries+1; i++) {
			if(lista[i].getisbn() == isbn) {
				return i;
			}
		}
		return -1;
	}
	
	public void setlistas_series(Serie serienueva) {
		maxseries++;
		lista[maxseries] = serienueva;
	}
}
