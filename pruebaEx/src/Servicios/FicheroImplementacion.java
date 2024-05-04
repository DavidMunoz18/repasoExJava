package Servicios;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import Dtos.CitasDto;

public class FicheroImplementacion implements FicherosInterfaz {

	DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	Scanner sc = new Scanner(System.in);
	
public void escribirConsultasPsicologia(List<CitasDto> listaCitas, String ruta) {
		
		System.out.println("Introduzca la fecha deseada (yyyy/MM/dd)");
		String fecha = sc.next();
		
		try {
			FileWriter fileWriter = new FileWriter(ruta);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			
			for (CitasDto citas : listaCitas) {
				
				if(citas.getFchaCita().format(dateTimeFormatter).equals(fecha) && citas.getEspecialida().equals("Psicologia")) {
					
					printWriter.write("Nombre completo: " + citas.getNombre() + " " + citas.getApellidos() + "," + "Hora: " + citas.getFchaCita());
					fileWriter.close();
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
public void escribirConsultasTraumatologia(List<CitasDto> listaCitas, String ruta) {
		
	
	
		System.out.println("Introduzca la fecha deseada (yyyy/MM/dd)");
		String fecha = sc.next();
	
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(ruta);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			
			for (CitasDto citas : listaCitas) {
				
				if(citas.getFchaCita().format(dateTimeFormatter).equals(fecha) && citas.getEspecialida().equals("Traumatologia")) {
					
					printWriter.write("Nombre completo: " + citas.getNombre() + " " + citas.getApellidos() + "," + "Hora: " + citas.getFchaCita());
					
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void escribirConsultasFisioterapia(List<CitasDto> listaCitas, String ruta) {
		
		System.out.println("Introduzca la fecha deseada (yyyy/MM/dd)");
		String fecha = sc.next();
		
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(ruta);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			
			for (CitasDto citas : listaCitas) {
				
				if(citas.getFchaCita().format(dateTimeFormatter).equals(fecha) && citas.getEspecialida().equals("Fisioterapia")) {
					
					printWriter.write("Nombre completo: " + citas.getNombre() + " " + citas.getApellidos() + "," + "Hora: " + citas.getFchaCita());
					
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
