package clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Comando {

	private String linea="";
	private Scanner scanner;
	@SuppressWarnings("unused")
	private Process proceso;
	private ArrayList<String>rutas_dir = new ArrayList<>();
	/**
	 * 
	 * @param comando
	 * muestra un listado de los comandos disponibles
	 */
	
	public void comandos_disponibles(){
		try {
			File fichero = new File("."+File.separator+"ficheros"+File.separator+"comandos.txt");
			BufferedReader br = new BufferedReader(new FileReader(fichero));
			
			linea = br.readLine();
			while(linea!=null) {
				System.out.println(linea);
				linea = br.readLine();
			}
			br.close();
			
		}catch (IOException ioe) {
			System.out.println("Error en la lectura");
		}
	}
	public void man() {
		try {
			File fichero = new File("."+File.separator+"ficheros"+File.separator+"manual.txt");
			BufferedReader br = new BufferedReader(new FileReader(fichero));
			
			linea = br.readLine();
			while(linea!=null) {
				System.out.println(linea);
				linea = br.readLine();
			}
			br.close();
			
		}catch (IOException ioe) {
			System.out.println("Error en la lectura");
		}
		
	}
	public void pwd() {
		File ruta = new File(".");
		try {
			System.out.println(ruta.getCanonicalPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void ls(String ruta) {
		if(ruta !="") {
		File ruta_fichero= new File(ruta);
		String[]list = ruta_fichero.list();
		for (String archivos : list) {
			System.out.println(archivos);
		}
		}else {
			System.out.println("Escribe una ruta");
		}
	}
	public void create_dirs(){
		try {
		
		File directorios;
		String opcion="";
		int numeroDirs=0;
		//creamos los directorios.
		scanner = new Scanner(System.in);
		System.out.println("¿Quieres crear las rutas por defecto? [Y/N]");
		opcion = scanner.next();
		if(opcion.equalsIgnoreCase("Y")) {
		rutas_dir.add("."+File.separator+"auditowriter");
		rutas_dir.add("."+File.separator+"auditowriter"+File.separator+"writeups");
		rutas_dir.add("."+File.separator+"auditowriter"+File.separator+"herramientas");
		rutas_dir.add("."+File.separator+"auditowriter"+File.separator+"exploits");
		rutas_dir.add("."+File.separator+"auditowriter"+File.separator+"exploits"+File.separator+"metaesploit");
		rutas_dir.add("."+File.separator+"auditowriter"+File.separator+"git_hubs");
		rutas_dir.add("."+File.separator+"auditowriter"+File.separator+"programacion");
		rutas_dir.add("."+File.separator+"auditowriter"+File.separator+"programacion"+File.separator+"java");
		rutas_dir.add("."+File.separator+"auditowriter"+File.separator+"programacion"+File.separator+"python");
		rutas_dir.add("."+File.separator+"auditowriter"+File.separator+"programacion"+File.separator+"php");
		rutas_dir.add("."+File.separator+"auditowriter"+File.separator+"reversing");
		rutas_dir.add("."+File.separator+"auditowriter"+File.separator+"escaneo");
		rutas_dir.add("."+File.separator+"auditowriter"+File.separator+"escaneo"+File.separator+"nmap");
		rutas_dir.add("."+File.separator+"auditowriter"+File.separator+"escaneo"+File.separator+"zenmap");
		rutas_dir.add("."+File.separator+"auditowriter"+File.separator+"escaneo"+File.separator+"sparta");
		
		for(int i =0; i < rutas_dir.size();i++) {
			directorios = new File(rutas_dir.get(i).toString());
			directorios.mkdir();
			System.out.println("Creando ... "+directorios.getCanonicalPath());
		}
		
		}else {
			String directorioADefinir="";
			System.out.println("¿Cuantos directorios quieres crear? :");
			numeroDirs = scanner.nextInt();
			System.out.println("Define los directorios");
			rutas_dir.add("."+File.separator+"auditowriter");
			for(int i =0; i < numeroDirs; i++) {
				directorioADefinir = scanner.next();
				rutas_dir.add("."+File.separator+"auditowriter"+File.separator+directorioADefinir);
				directorios = new File(rutas_dir.get(i).toString());
				directorios.mkdir();
				System.out.println("Creando... "+ directorios.getCanonicalPath());
			}
		}
		}catch(IOException ioe) {
			System.out.println("Error De Lectura");
		}
	}
	public void remove_dirs() {
	try {	
			if(!rutas_dir.isEmpty()) {
				for(int i =0; i < rutas_dir.size();i++) {
					File borrar_ficheros = new File(rutas_dir.get(i).toString());
					borrar_ficheros.delete();
					System.out.println("Borrando... "+borrar_ficheros.getCanonicalPath());
				}
			}else {
				System.out.println("No se ha pdodido borrar la estructura");
			}
		}catch (IOException ioe) {
			System.out.println("Error de lectura");
		}
	}
	public void lanzarBloc() {
		try {
			proceso = Runtime.getRuntime().exec("notepad");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void clean() {
		for(int i =0; i < 20; i++) {
			System.out.println();
			System.out.flush();
			
		}
		
	}
	public void rmdir() {
		try {
			String dirAborrar="";
			scanner = new Scanner(System.in);
			System.out.println("Escribe el directorio a borrar.");
			dirAborrar = scanner.next();
			File ruta_actual = new File("."+File.separator+"auditowriter"+File.separator+dirAborrar);
			ruta_actual.delete();
			System.out.println("Se ha borrado el directorio: "+ ruta_actual.getCanonicalPath());
		}catch (IOException ioe) {
			System.out.println("Error de lectura");
		}
	}
	public void rmf() {
		try {
		scanner = new Scanner(System.in);
		String borrarFile="";
		System.out.println("Escribe la ruta ");
		borrarFile = scanner.next();
		File rmf = new File("."+File.separator+"auditowriter"+File.separator+borrarFile);
		rmf.delete();
		System.out.println("Se ha borrado el archivo "+ rmf.getCanonicalPath());
		}catch (IOException e) {
			System.out.println("Error en la lectura");
		}
	}
	public void createdir() {
		scanner = new Scanner(System.in);
		String createdir="";
		System.out.println("Crea el directorio en la ruta que quieras");
		createdir = scanner.next();
		File crdir = new File("."+File.separator+"auditowriter"+createdir);
		crdir.mkdir();
	}
	public void crfile() {
		try {
		scanner = new Scanner(System.in);
		String crf = "";
		System.out.println("Escribe el fichero a crear");
		crf = scanner.next();
		File crfile = new File("."+File.separator+"auditowriter"+crf);
		crfile.createNewFile();
		}catch (IOException ioe) {
			System.out.println("Error en la lectura");
		}
	}

}
