package Servicios;

import java.util.List;

import Dtos.CitasDto;

public interface FicherosInterfaz {

	public void escribirConsultasPsicologia(List<CitasDto> listaCitas, String ruta);
	public void escribirConsultasTraumatologia(List<CitasDto> listaCitas, String ruta);
	public void escribirConsultasFisioterapia(List<CitasDto> listaCitas, String ruta);
}
