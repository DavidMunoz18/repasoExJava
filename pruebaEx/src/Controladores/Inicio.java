package Controladores;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import Dtos.CitasDto;
import Servicios.FicheroImplementacion;
import Servicios.FicherosInterfaz;
import Servicios.MenuImplementacion;
import Servicios.MenuInterfaz;
import Servicios.OperativaImplementacion;
import Servicios.OperativaInterfaz;

public class Inicio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		List<CitasDto> listaCitas = new ArrayList<CitasDto>();
		MenuInterfaz mi = new MenuImplementacion();
		OperativaInterfaz oi = new OperativaImplementacion();
		FicherosInterfaz fi = new FicheroImplementacion();
		LocalDate fechaHoy = LocalDate.now();
		
		
		
		String ruta = "C:\\Users\\Julio\\eclipse-workspace\\pruebaEx\\citasConAsistencia- " + fechaHoy.format(dateTimeFormatter).replace("-", "") ;
		String rutaCarga = "C:\\Users\\Julio\\eclipse-workspace\\pruebaEx\\fichero- " + fechaHoy.format(dateTimeFormatter).replace("-", "");
		try {
			
		
		oi.cargaDatos(listaCitas, ruta);
		
		
		boolean cerrarMenu = false;
		int opcion;
		while(!cerrarMenu) {
			opcion = mi.mostrarMenuYSeleccionPrincipal();
			switch (opcion) {
			case 0:
				FileWriter fileWriter;
				try {
					fileWriter = new FileWriter(rutaCarga);
					PrintWriter printWriter = new PrintWriter(fileWriter);
					
					for (CitasDto citasDto : listaCitas) {
						printWriter.write(citasDto.getId() +";"+ citasDto.getDni() + ";"+ citasDto.getNombre() +";"+ citasDto.getApellidos() +";"+ citasDto.getEspecialida()+";" + citasDto.getFchaCita() + ";" );
						
						printWriter.close();
					}
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				cerrarMenu = true;
				break;
			case 1:
				oi.darAltaCitas(listaCitas);
				break;
			case 2:
				oi.registroLlegada(listaCitas);
				break;
			case 3:
				int opcionMostrar = mi.mostrarConsultas();
				switch (opcionMostrar) {
				case 1:
					int opcionEspecialidades1 = mi.mostrarOpciones();
					switch (opcionEspecialidades1) {
					case 1:
						oi.mostrarConsultasPsicologia(listaCitas);
						break;
					case 2:
						oi.mostrarConsultasTraumatologia(listaCitas);
						break;
					case 3:
						oi.mostrarConsultasFisioterapia(listaCitas);
						break;

					default:
						break;
					}
					
					break;
				case 2:
					int opcionEspecialidades2 = mi.mostrarOpciones();
					switch (opcionEspecialidades2) {
					case 1:
						fi.escribirConsultasPsicologia(listaCitas, ruta);
						break;
					case 2:
						fi.escribirConsultasTraumatologia(listaCitas, ruta);
						break;
					case 3:
						fi.escribirConsultasTraumatologia(listaCitas, ruta);
						break;

					default:
						break;
					}
					break;

				default:
					break;
				}
				break;
				
			default:
				System.out.println("La opcion seleccionada no existe");
				break;
			}
			
		}
		
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}
