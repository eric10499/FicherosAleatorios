/*
 * Borrado.java
 * 
 * Copyright 2018 ERIC <ERIC@DESKTOP-5T1N085>
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 * 
 * BORRADO. Crea un programa Java que al ejecutarlo desde la línea de comandos reciba un identificador de empleado y lo borre. Se hará un borrado lógico marcando el registro con la siguiente información: el identificador será igual a -1, el apellido será igual al identificador que se borra, y el departamento y salario serán 0.
 * 
 * Fet per Eric Visier Sánchez
 * 
 */

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
