/*
 * Insercion.java
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
 * INSERCION. Crea un programa Java que inserte datos en el fichero aleatorio. El programa ejecutará desde la línea de comandos y debe recibir 4 parámetros: identificador de empleado, apellido, departamento y salario. Antes de insertar se comprobará si el identificador existe, en ese caso se debe visualizar un mensaje indicándolo; si no existe se deberá insertar.
 * 
 * Fet per Eric Visier Sánchez
 * 
 */

package FicherosAleatorios;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;



public class Insercion {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		File fichero = new File ("C:\\\\Users\\\\ERIC\\\\Desktop\\\\AleatorioEmpleado.dat");
		RandomAccessFile file = new RandomAccessFile (fichero, "rw"); 
		int id, dep ,posicion;
		Double salario;
		char apellido[]= new char[10], aux;
		posicion =0;
		StringBuffer buffer = null; 
		System.out.println("Introduzca el id del empleado :");
		int idInsercion = scanner.nextInt();
		System.out.println("Introduzca el apellido del empleado :");
		String apellidoInsercion = scanner.next();
		System.out.println("Introduzca el departamento del empleado :");
		int depInsercion = scanner.nextInt();
		System.out.println("Introduzca el salario del empleado :");
		double salarioInsercion = scanner.nextDouble();
		for ( ; ; ){
			file.seek (posicion); // Nos posicionamos en posicion 
			id = file.readInt();     // Obtengo identificar de Empleado 
			for ( int i =0; i<apellido.length; i++) { 
				aux = file.readChar(); // Voy leyendo carácter a carácter el apellido y lo guardo 
				apellido[i]=aux;            // en el array apellido 
			} String apellidos = new String (apellido);
			dep = file.readInt();              //Lectura de departamento y salario 
			salario = file.readDouble();
			if (id >0) {
				//System.out.printf("ID: %s, Apellido: %s, Departamento: %d, Salario: %.2f %n", id, apellidos.trim(), dep, salario);
				//Nos situamos al principio del fichero
				posicion = posicion + 36;
			}
			if(id == idInsercion) {
				System.out.println("Este id ya existe en base de datos.");
				break;
			}	
			if (file.getFilePointer() ==file.length()) {
				file.writeInt (idInsercion); 
				buffer = new StringBuffer (apellidoInsercion); 
				buffer.setLength(10); // Fijo en 10 caracteres la longitud del apellido 
				file.writeChars (buffer.toString()); 
				file.writeInt(depInsercion); 
				file.writeDouble (salarioInsercion);
				System.out.printf("ID: %s, Apellido: %s, Departamento: %d, Salario: %.2f %n", idInsercion, apellidoInsercion.trim(), depInsercion, salarioInsercion);
				break;  // Si he recorrido todo el fichero, salgo }                                                                                    // del for 
			}	
		}
		file.close(); 
	}
}
