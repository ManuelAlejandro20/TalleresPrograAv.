package ucn;


public class SistemaSerieLectorImpl implements SistemaSerieLector{
	private ListaLector listalector;
	private ListaSerie listaserie;
	
	public SistemaSerieLectorImpl() {
		listalector = new ListaLector(1000);
		listaserie = new ListaSerie(1000);
		
	}
	
	public Serie crearserie_arreglo(int isbn, String nombre, String autor, String fecha, int contador) {
		Serie arreglo = new Serie(isbn, nombre, autor, fecha);
		listaserie.agregarserie(arreglo, contador);;
		return arreglo;
		
	}
	
	public Lector crearlector_arreglo(String id, String nombre, int contador1) {
		Lector arreglolector = new Lector(id, nombre);
		listalector.agregar_lector(arreglolector, contador1);
		return arreglolector;
	}
	
	public void creararreglos_sus(Lector arreglo, String[] suscripciones, int contador) {
		Lector lector = listalector.getlistalector()[contador];
		ListaSuscripcion listasus = lector.getlistasuscripcion();
		for (int j=0; j<100; j++) {
			if (suscripciones[j] == null) {
				break;
			}
			else {
				listasus.suscripciones_existentes(suscripciones[j], j);
				}
			}
		}
	
	public ListaSerie getlistasss() {
		return listaserie;
	}
	
 	public boolean agregarserie(int isbn_escrito, String nombre_escrito, String autor_escrito, String fecha_escrita) {	
		boolean salirserie2 = false;
		if(listaserie.verficar_isbn(isbn_escrito) != -1) {
			while(!salirserie2) {
				int numrepetido = listaserie.verficar_isbn(isbn_escrito);
				System.out.println("\nXXXX Este ISBN ya pertenece a una serie, ¿Quieres modificar los datos de la serie '"+ listaserie.get_listaserie()[numrepetido].getnombre() +"'? (Sí/No) XXXXX");
				String decision = StdIn.readString();
				decision = decision.toLowerCase();
				if (decision.equals("sí")) {
					decision = "si";
				}
				switch (decision){
				case "si" :
					listaserie.get_listaserie()[numrepetido].set_nombre(nombre_escrito);
					listaserie.get_listaserie()[numrepetido].set_autor(autor_escrito);
					listaserie.get_listaserie()[numrepetido].set_fecha(fecha_escrita);
					return true;
					
				case "no":
					System.out.println("\nXXXXX No se hicieron cambios XXXXX");
					salirserie2 = true;
					break;
					
					
				default:
					System.out.println("\nXXXXX Escribe una opciòn valida XXXXX");
					continue;
					}
				}
			}
		else {
			Serie serienueva = new Serie(isbn_escrito, nombre_escrito,autor_escrito,fecha_escrita);
			listaserie.setlistas_series(serienueva);
			return false;
			}
		return false;
	}
 
 	public boolean verificarrespuesta(int isbn_escrito) {
 		for (int i=0; i<listaserie.get_maxseries()-1; i++) {
 			if(listaserie.get_listaserie()[i].getisbn() == 0) {
 				continue;
 			}
 			
 			else if(listaserie.get_listaserie()[i].getisbn() == isbn_escrito) {
 				return true;
 			}
 		}
 		return false;
 	}
	
 	public boolean agregarlector(String id, String nombre, int numero) { 		
 		if(listalector.verificar_lector(id)) {
 			System.out.println("\n XXXXX ESE ID YA PERETENECE A UN USUARIO, INGRESE OTRO PORFAVOR XXXXX");
 			return true;
 		}
 		
 		else {
 			Lector lectornuevo = new Lector(id, nombre);
 			listalector.setnuevolector(lectornuevo);
 			for(int i=0; i<numero; i++) {
 				System.out.println("\n Ingresa el ISBN de la serie que quieres agregar porfavor");
 				String sus_nueva = StdIn.readString();
 				listalector.getlistalector()[listalector.get_maxlector()].getlistasuscripcion().getlista_sus()[i] = sus_nueva;
 			}
 			return false;
 		}
 	}
}
	
	
	
