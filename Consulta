package FicherosAleatorios;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Consulta {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		File fichero = new File ("C:\\\\Users\\\\ERIC\\\\Desktop\\\\AleatorioEmpleado.dat");
		RandomAccessFile file = new RandomAccessFile (fichero, "r"); 
		int id, dep ,posicion;
		Double salario;
		char apellido[]= new char[10], aux;
		posicion =0;
		System.out.println("Introduzca el id del empleado que quiere consultar :");
		int idConsulta = scanner.nextInt();
		for ( ; ; ){

			file.seek (posicion); // Nos posicionamos en posicion 
			id = file.readInt();     // Obtengo identificar de Empleado 

			for ( int i =0; i<apellido.length; i++) { 
				aux = file.readChar(); // Voy leyendo carácter a carácter el apellido y lo guardo 
				apellido[i]=aux;            // en el array apellido 
			} String apellidos = new String (apellido);
			dep = file.readInt();              //Lectura de departamento y salario 
			salario = file.readDouble();

			if(id >0) {
				posicion = posicion + 36;
			}
			if(id == idConsulta) {
				System.out.printf("ID: %s, Apellido: %s, Departamento: %d, Salario: %.2f %n", id, apellidos.trim(), dep, salario);
				break;
			} 
			if (file.getFilePointer() ==file.length())
				if(id != idConsulta) {
					System.out.println("El usuario indicado no se encuentra en base de datos.");
					break;
				}// Si he recorrido todo el fichero, salgo 
		}   
		file.close();
	}

}

