package mx.unam.dgtic.admglp.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "c_asentamiento")
public class Asentamiento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_asentamiento")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "id_municipio")
	private Municipio municipio;
	
	@Column(name = "asenta_c_clave")
	private String clave;
	
	@Column(name = "asenta_c_codigo_postal")
	private String codigoPostal;
	
	@Column(name = "asenta_vc_tipo")
	private String tipo;
	
	@Column(name = "asenta_vc_nombre")
	private String nombre;
	
	@Column(name = "asenta_dt_fecha_registro")
	private Date fecRegistro; // Fecha de Inicio de acceso a la aplicacion
	
	@Column(name = "asenta_dt_fecha_actualizacion")
	private Date fecActualizacion; // Fecha de fin de acceso a la aplicacion
	
	@Column(name = "asenta_si_estatus")
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

	public Asentamiento(Integer id) {
		super();
		this.id = id;
	}

	public Asentamiento() {
		super();
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Asentamiento other = (Asentamiento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Asentamiento [id=" + id + ", clave=" + clave + ", codigoPostal=" + codigoPostal + ", tipo=" + tipo
				+ ", nombre=" + nombre + ", fecRegistro=" + fecRegistro + ", fecActualizacion=" + fecActualizacion
				+ ", estatus=" + estatus + "]";
	}

}
