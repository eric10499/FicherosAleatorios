package FicherosAleatorios;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Modificacion {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		File fichero = new File ("C:\\\\Users\\\\ERIC\\\\Desktop\\\\AleatorioEmpleado.dat");
		RandomAccessFile file = new RandomAccessFile (fichero, "rw"); 
		int id, dep ,posicion;
		Double salario, nuevoSalario;
		char apellido[]= new char[10], aux;
		posicion = 0;
		long puntero = 0;
		StringBuffer buffer = null; 
		System.out.println("Introduzca el id del empleado :");
		int idModifcacion = scanner.nextInt();
		System.out.println("Introduzca el importe del empleado :");
		double importeModifcacion = scanner.nextDouble();
		for ( ; ; ){
			try {
				file.seek (posicion); // Nos posicionamos en posicion 
				id = file.readInt();     // Obtengo identificar de Empleado 
				if(id == idModifcacion) {
					for ( int i =0; i<apellido.length; i++) { 
						aux = file.readChar(); // Voy leyendo carácter a carácter el apellido y lo guardo 
						apellido[i]=aux;            // en el array apellido 
					} String apellidos = new String (apellido);

					file.skipBytes(4);
					salario = file.readDouble();
					puntero = file.getFilePointer() -8;
					file.seek(puntero);
					nuevoSalario = salario + importeModifcacion;
					file.writeDouble(nuevoSalario);



					System.out.printf("ID: %s, Apellido: %s, Salario: %.2f, Nuevo Salario: %.2f %n", id, apellidos.trim(), salario, nuevoSalario);
					//TODO Falta implementar el hecho de insertar canviando el antiguo salario por el nuevo.
				}
				if (id >0) {
					//Nos situamos al principio del fichero
					posicion = posicion + 36;
				}


				if (file.getFilePointer() ==file.length()) {
					System.out.println("Este id no existe en base de datos");
					break;  // Si he recorrido todo el fichero, salgo }                                                                                    // del for 
				}

			} catch (EOFException e) {

				break;

			}

		}
		file.close(); 
	}
}
