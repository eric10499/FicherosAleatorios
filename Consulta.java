/*
 * Consulta.java
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
 * CONSULTA. Crea un programa Java que consulte los datos de un empleado del fichero aleatorio. El programa se ejecutará desde la línea de comandos y debe recibir un identificador de empleado. Si el empleado existe se visualizarán sus datos, si no existe se visualizará un mensaje indicándolo.
 * 
 * Fet per Eric Visier Sánchez
 * 
 */

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

