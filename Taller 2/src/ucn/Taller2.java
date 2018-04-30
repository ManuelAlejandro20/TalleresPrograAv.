package ucn;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import ucn.Registro;
import ucn.ArchivoEntrada;

public class Taller2 {
	public static void main(String args[]) throws IOException{
		ArchivoEntrada arch_series = new ArchivoEntrada("C:\\Users\\aleja\\eclipse-workspace\\Taller 2\\archivos txt\\series.txt");
		ArchivoEntrada arch_lectores = new ArchivoEntrada("C:\\Users\\aleja\\eclipse-workspace\\Taller 2\\archivos txt\\lectores.txt");
		Scanner scanner = new Scanner(System.in);
		int contador, contador2; contador = contador2 = 0;
		boolean salir = false;
		Lector arreglo = null;
		SistemaSerieLectorImpl sistema = new SistemaSerieLectorImpl();
		while(!arch_series.isEndFile()) {
			Registro reg = arch_series.getRegistro();
			int isbn_leido = reg.getInt();
			String nombre_leido = reg.getString();
			String autor_leido = reg.getString();
			String fecha_leida = reg.getString();
			sistema.crearserie_arreglo(isbn_leido, nombre_leido, autor_leido, fecha_leida, contador);
			contador++;
		}
		while(!arch_lectores.isEndFile()) {
			Registro reg = arch_lectores.getRegistro();
			String id_leida = reg.getString();
			String usuario_leido = reg.getString();
			String sus_leida = "";
			String suscripciones[] = new String[100];
			while (sus_leida != null) {
				sus_leida = reg.getString();
				if(sus_leida==null) {
					continue;
				}
				else{
					suscripciones[contador2] = sus_leida;
					contador2++;
				}
			}
			arreglo = sistema.crearlector_arreglo(id_leida, usuario_leido, contador);
			sistema.creararreglos_sus(arreglo, suscripciones,contador);
			contador++;
			contador2 = 0;
		}
		
		while (!salir) {
			try {
				menu();
				System.out.println("\n Selecciona una opción porfavor (-1 para salir)");
				int dec = scanner.nextInt();
			
				switch (dec) {
		
				case 1:
					agregarserie(sistema);
					continue;
				case 2:
					agregarlector(sistema);			
					continue;
				case 3:
					
				case -1:
					salir = true;
					break;
				default:
					System.out.println("\n XXXX ESCRIBE UNA DE LAS OPCIONES PORFAVOR XXXX");
				}
			}catch (InputMismatchException e) {
			System.out.println("\n XXXX ESCRIBE UNA OPCIÓN VALIDA PORFAVOR XXXX");
			scanner.next();
		}
		
	}
	scanner.close();
	
		
}
	
	
	public static void agregarserie(SistemaSerieLectorImpl sistema) {
		Scanner scanner = new Scanner(System.in);
		boolean salirserie = false;
		while (!salirserie){
			try {
				System.out.println("\nIngresa el ISBN de la serie que quieres agregar");
				int isbn_escrito = scanner.nextInt();
				System.out.println("\nIngresa el título de la serie que quieres agregar");
				String titulo_escrito = StdIn.readString();
				System.out.println("\nIngresa el autor de la serie que quieres agregar");
				String autor_escrito = StdIn.readString();
				System.out.println("\nIngresa la fecha de registro de la serie que quieres agregar");
				String fecha_escrita = StdIn.readString();	
	
				
				if (sistema.agregarserie(isbn_escrito, titulo_escrito, autor_escrito, fecha_escrita)) {
					System.out.println("\nXXXXX Se realizaron los cambios XXXXX");
					salirserie = true;
				}
			

				else {
					if(sistema.verificarrespuesta(isbn_escrito)){
						StdOut.print("xd");
						continue;
					}
					else {
						StdOut.println("\n XXXXX Se ha agregado una nueva serie XXXXX ");
						salirserie = true;
						}
					}	
			}catch (InputMismatchException e) {
			System.out.println("\n XXXX ESCRIBE UNA OPCIÓN VALIDA PORFAVOR XXXX");
			scanner.next();
			}		
		}
		scanner.close();
	}
	public static void agregarlector(SistemaSerieLectorImpl sistema) {
		Scanner scanner = new Scanner(System.in);
		boolean salirlector = false;
		while(!salirlector) {
			System.out.println("\n Ingresa el nombre del usuario porfavor");
			String usuario_escrito = StdIn.readString();
			System.out.println("\n Ingresa el ID del usuario porfavor");
			String id_escrito = StdIn.readString();
			System.out.println("\n ¿Cuántas series va a suscribir?");
			int numero = scanner.nextInt();
			try {
				if(sistema.agregarlector(id_escrito, usuario_escrito, numero)) {
					continue;
				}
				else {
					salirlector=true;
				}
			}catch (InputMismatchException e) {
				StdOut.println("\n XXXX ESCRIBE UN NUMERO PORFAVOR (PRESIONE CUALQUIER TECLA PARA CONTINUAR) XXXX");
				scanner.next();
			}
		}
		scanner.close();
	}
	
	public static void menu() {
		System.out.println("\n 1. Agregar una serie");
		System.out.println(" 2. Agregar un nuevo lector");
		System.out.println(" 3. Suscribir una nueva serie");
	}
}
