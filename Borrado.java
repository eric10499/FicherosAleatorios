package FicherosAleatorios;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Borrado {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		File fichero = new File ("C:\\\\Users\\\\ERIC\\\\Desktop\\\\AleatorioEmpleado.dat");
		RandomAccessFile file = new RandomAccessFile (fichero, "rw"); 
		int id, posicion;
		posicion =0;
		long puntero;
		System.out.println("Introduzca el id del empleado :");
		int idBorrado = scanner.nextInt();
		for ( ; ; ){
			try {
				file.seek (posicion); // Nos posicionamos en posicion 
				id = file.readInt();     // Obtengo identificar de Empleado 
				if(id == idBorrado) {
					puntero = file.getFilePointer()-4;

					file.seek(puntero);

					file.writeInt(-1);

					file.writeInt(idBorrado);

					file.skipBytes(16);

					file.writeInt(0);

					file.writeDouble(0);
				}

				if (id >0) {
					//System.out.printf("ID: %s, Apellido: %s, Departamento: %d, Salario: %.2f %n", id, apellidos.trim(), dep, salario);
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
