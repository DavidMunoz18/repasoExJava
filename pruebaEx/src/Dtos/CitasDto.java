package Dtos;

import java.time.LocalDate;

public class CitasDto {

	
	long id;
	String dni = "aaaaa";
	String nombre = "aaaaa";
	String apellidos = "aaaaa";
	String especialida = "aaaaa";
	LocalDate fchaCita = LocalDate.now();
	boolean asistenciaCita = false;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getEspecialida() {
		return especialida;
	}
	public void setEspecialida(String especialida) {
		this.especialida = especialida;
	}
	public LocalDate getFchaCita() {
		return fchaCita;
	}
	public void setFchaCita(LocalDate fchaCita) {
		this.fchaCita = fchaCita;
	}
	public boolean isAsistenciaCita() {
		return asistenciaCita;
	}
	public void setAsistenciaCita(boolean asistenciaCita) {
		this.asistenciaCita = asistenciaCita;
	}
	public CitasDto() {
		super();
	}
	public CitasDto(String dni, String nombre, String apellidos, String especialida, LocalDate fchaCita,
			boolean asistenciaCita) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.especialida = especialida;
		this.fchaCita = fchaCita;
		this.asistenciaCita = asistenciaCita;
	}
	
	
}
