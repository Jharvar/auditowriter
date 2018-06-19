package paquete_principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import clases.Comando;
import comunicaciones.Constantes;

public class Main {
	//atributo tipo buffer para leer por teclado
	public static BufferedReader br;
	public static Comando cmd;
	public static ArrayList<String>historial_comandos = new ArrayList<>();
	public static void main(String[] args) {
		consola();
	}
	/**
	 * metodo principal que va ejecutando comandos a través de la consola
	 */
	public static void consola() {
		try {//bloque try - catch para capturar las Excepciones IOException
			//instanciamos el objeto buffer
			br = new BufferedReader(new InputStreamReader(System.in));
			//declaramos una cadena vacia
			String comando ="";
			//variable booleana para salir del do-while
			boolean salir = true;
			cmd = new Comando();
			menu();
			do {//leemos el comando
				comando =br.readLine();
				
				switch (comando) { // insertamos el comando
				case Constantes.COMANDOS_DISPONIBLES: // comando ? para ver todos los comandos del sistema
					cmd.comandos_disponibles(); // muestra los comandos disponibles
					historial_comandos.add(Constantes.COMANDOS_DISPONIBLES);
					break;
				case Constantes.MANUAL: // muestra el manual
					cmd.man();
					historial_comandos.add(Constantes.MANUAL);
					break;
				case Constantes.MENU: // muestra el menu del programa
					menu();
					historial_comandos.add(Constantes.MENU);
					break;
				case Constantes.PWD:
					cmd.pwd();
					historial_comandos.add(Constantes.PWD);
					break;
				case Constantes.LS:
					String ruta = br.readLine();
					cmd.ls(ruta);
					historial_comandos.add(Constantes.LS+" "+ruta);
					break;
				case Constantes.CREATE_DIRS:
					cmd.create_dirs();
					historial_comandos.add(Constantes.CREATE_DIRS);
					break;	
				case Constantes.REMOVE_DIRS:
					cmd.remove_dirs();
					historial_comandos.add(Constantes.REMOVE_DIRS);
					break;
				case Constantes.RMDIR:
					cmd.rmdir();
					historial_comandos.add(Constantes.RMDIR);
					break;
				case Constantes.RMF:
					cmd.rmf();
					historial_comandos.add(Constantes.RMF);
					break;
				case Constantes.CREATEDIR:
					cmd.createdir();
					historial_comandos.add(Constantes.CREATEDIR);
					break;
				case Constantes.CREATEFILE:
					cmd.crfile();
					historial_comandos.add(Constantes.CREATEFILE);
					break;
				case Constantes.HISTORIAL:
					historial();
					break;
				case Constantes.EDITOR:
					cmd.lanzarBloc();
					historial_comandos.add(Constantes.EDITOR);
					break;
				case Constantes.CLEAN:
					cmd.clean();
					historial_comandos.add(Constantes.CLEAN);
					break;
				
				case Constantes.EXIT: // sale del programa
					salir =false;
					break;
				
				}
			} while (salir); // salimos del programa
			
			
			
		}catch (IOException ioe) {
			System.out.println("Error En Lectura");
		}catch (NumberFormatException nfe) {
			System.out.println("La linea no se corresponde a ningun comando conocido");
		}
	}
	
	public static void menu() {
		System.out.println("+----------------------------------+");
		System.out.println("|             AUDITOWRITER         |");
		System.out.println("+----------------------------------+");
		System.out.println("| Para ver los comandos escribe: ? |");
		System.out.println("+----------------------------------+");
		System.out.println("|         Escribe un Comando.      |");
		System.out.println("+----------------------------------+");
		
	}
	public static void historial() {
		if(historial_comandos.isEmpty()) {
			System.out.println("Todavia no se han utilizado comandos");
		}else {
			for(int i =0; i < historial_comandos.size();i++) {
				System.out.println((i+1)+" "+historial_comandos.get(i));
			}
		}
	}
	
}
