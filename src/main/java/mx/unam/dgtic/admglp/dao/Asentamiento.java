package mx.unam.dgtic.admglp.dao;

import java.util.Date;

public class Asentamiento {
	private Integer id;
	private String clave;
	private String codigoPostal;
	private String tipo;
	private String nombre;
	private Date fecRegistro; // Fecha de Inicio de acceso a la aplicacion
	private Date fecActualizacion; // Fecha de fin de acceso a la aplicacion
	private Integer estatus;

	public Asentamiento(Integer id, String clave, String codigoPostal, String tipo, String nombre, Date fecRegistro,
			Date fecActualizacion, Integer estatus) {
		this.id = id;
		this.clave = clave;
		this.codigoPostal = codigoPostal;
		this.tipo = tipo;
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

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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

}
