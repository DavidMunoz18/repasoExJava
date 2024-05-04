package Servicios;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import Dtos.CitasDto;

public class OperativaImplementacion implements OperativaInterfaz {

	DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	Scanner sc = new Scanner(System.in);
	@Override
	public void darAltaCitas(List<CitasDto> listaCitas) {
		
		CitasDto citas = crearNuevaCita(listaCitas);
		
		listaCitas.add(citas);
		
	}
	private CitasDto crearNuevaCita(List<CitasDto> listaCitas) {
	
		
		
		CitasDto citas = new CitasDto();
		
		citas.setId(idAutoGenerado(listaCitas));
		
		
		
		System.out.println("ID: " + citas.getId());
		
		System.out.println("Introduce el dni");
		citas.setDni(sc.next());
		
		System.out.println("Introduce el nombre");
		citas.setNombre(sc.next());;
		
		System.out.println("Introduce el apellido");
		citas.setApellidos(sc.next());
		
		System.out.println("Introduce la especialidad");
		citas.setEspecialida(sc.next());
		
		System.out.println("Introduce la fecha de la cita (yyyy-MM-dd)");
		citas.setFchaCita(LocalDate.parse(sc.next(), dateTimeFormatter));
		
		System.out.println(citas.getFchaCita());
		
		return citas;
		
	}
	
	private long idAutoGenerado(List<CitasDto> listaCitas) {
		
		int tamanioLista = listaCitas.size();
		
		long id;
		
		if(tamanioLista == 0) {
			id = 1;
		}
		else {
			id = listaCitas.get(tamanioLista -1).getId() + 1;
		}
		return id;
		
	}
	@Override
	public void registroLlegada(List<CitasDto> listaCitas) {
		
		
		
		char[] letrasDni = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E' };
		
		System.out.println("Introduzca su dni (numero)");
		int numeroDni = sc.nextInt();
		
		System.out.println("Introduce su dni (letra)");
		char letraDni = sc.next().charAt(0);
		
		int resto = numeroDni %23;
		
		String dniJunto = numeroDni + String.valueOf(letraDni) ;
		
		LocalDate fechaHoy = LocalDate.now();
		
		System.out.println(fechaHoy);
		
		
		for (CitasDto citas : listaCitas) {
			
			if(citas.getDni().equals(dniJunto) && letrasDni[resto] == letraDni && citas.getFchaCita().equals(fechaHoy)) {
				System.out.println("Espere su turno para la consulta de Psicología en la sala de espera. Su especialista le avisará.");
			}
			else {
				System.out.println("No dispone de cita previa para ese dia");
			}
		}
		
		
	}
	@Override
	public void mostrarConsultasPsicologia(List<CitasDto> listaCitas) {
		
		System.out.println("Introduzca la fecha deseada (yyyy/MM/dd)");
		String fecha = sc.next();
		
		for (CitasDto citas : listaCitas) {
			
			if(citas.getFchaCita().format(dateTimeFormatter).equals(fecha) && citas.getEspecialida().equals("Psicologia")) {
				
				System.out.println("Nombre completo: " + citas.getNombre() + " " + citas.getApellidos() + "," + "Hora: " + citas.getFchaCita());
				
			}
		}
		
	}
	public void mostrarConsultasTraumatologia(List<CitasDto> listaCitas) {
			
			System.out.println("Introduzca la fecha deseada (yyyy/MM/dd)");
			String fecha = sc.next();
			
			for (CitasDto citas : listaCitas) {
				
				if(citas.getFchaCita().format(dateTimeFormatter).equals(fecha) && citas.getEspecialida().equals("Traumatologia")) {
					
					System.out.println("Nombre completo: " + citas.getNombre() + " " + citas.getApellidos() + "," + "Hora: " + citas.getFchaCita());
					
				}
			}
			
		}
	public void mostrarConsultasFisioterapia(List<CitasDto> listaCitas) {
		
		System.out.println("Introduzca la fecha deseada (yyyy/MM/dd)");
		String fecha = sc.next();
		
		for (CitasDto citas : listaCitas) {
			
			if(citas.getFchaCita().format(dateTimeFormatter).equals(fecha) && citas.getEspecialida().equals("Fisioterapia")) {
				
				System.out.println("Nombre completo: " + citas.getNombre() + " " + citas.getApellidos() + "," + "Hora: " + citas.getFchaCita());
				
			}
		}
		
	}
@Override
	public void cargaDatos(List<CitasDto> listaCitas) {
		
	
		
	}
	
}
