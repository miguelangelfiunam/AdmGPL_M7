package mx.unam.dgtic.admglp.dao;

import java.util.Date;

public class Municipio {
	protected Integer id;
	protected String clave;
	protected String nombre;
	protected Date fecRegistro; // Fecha de Inicio de acceso a la aplicacion
	protected Date fecActualizacion; // Fecha de fin de acceso a la aplicacion
	protected Integer estatus;

	public Municipio(Integer id, String clave, String nombre, Date fecRegistro, Date fecActualizacion,
			Integer estatus) {
		this.id = id;
		this.clave = clave;
		this.nombre = nombre;
		this.fecRegistro = fecRegistro;
		this.fecActualizacion = fecActualizacion;
		this.estatus = estatus;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecRegistro() {
		return fecRegistro;
	}

	public void setFecRegistro(Date fecRegistro) {
		this.fecRegistro = fecRegistro;
	}

	public Date getFecActualizacion() {
		return fecActualizacion;
	}

	public void setFecActualizacion(Date fecActualizacion) {
		this.fecActualizacion = fecActualizacion;
	}

	public Integer getEstatus() {
		return estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	@Override
	public String toString() {
		return "MunicipioDTO [id=" + id + ", clave=" + clave + ", nombre=" + nombre + ", fecRegistro=" + fecRegistro
				+ ", fecActualizacion=" + fecActualizacion + ", estatus=" + estatus + "]";
	}
}
