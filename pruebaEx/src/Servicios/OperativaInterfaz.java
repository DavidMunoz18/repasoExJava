package Servicios;

import java.util.List;

import Dtos.CitasDto;

public interface OperativaInterfaz {

	public void darAltaCitas(List<CitasDto> listaCitas);
	
	public void registroLlegada(List<CitasDto> listaCitas);
	
	public void mostrarConsultasPsicologia(List<CitasDto> listaCitas);
	public void mostrarConsultasTraumatologia(List<CitasDto> listaCitas);
	public void mostrarConsultasFisioterapia(List<CitasDto> listaCitas);
	
	public void cargaDatos(List<CitasDto> listaCitas, String ruta);
}
