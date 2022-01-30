package mx.unam.dgtic.admglp.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "c_municipio")
public class Municipio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_municipio")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "id_estado")
	private Estado estado;
	
	@Column(name = "municipio_c_clave")
	private String clave;
	
	@Column(name = "municipio_vc_nombre")
	private String nombre;
	
	@Column(name = "municipio_dt_fecha_registro")
	private Date fecRegistro; // Fecha de Inicio de acceso a la aplicacion
	
	@Column(name = "municipio_dt_fecha_actualizacion")
	private Date fecActualizacion; // Fecha de fin de acceso a la aplicacion
	
	@Column(name = "municipio_si_estado")
	private Integer estatus;
	
	@OneToMany(mappedBy = "municipio")
	private List<Asentamiento> asentamientos = new ArrayList<Asentamiento>();
	

	public Municipio(Integer id, String clave, String nombre, Date fecRegistro, Date fecActualizacion,
			Integer estatus) {
		this.id = id;
		this.clave = clave;
		this.nombre = nombre;
		this.fecRegistro = fecRegistro;
		this.fecActualizacion = fecActualizacion;
		this.estatus = estatus;
	}

	public Municipio(String clave) {
		super();
		this.clave = clave;
	}

	public Municipio() {
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
		Municipio other = (Municipio) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MunicipioDTO [id=" + id + ", clave=" + clave + ", nombre=" + nombre + ", fecRegistro=" + fecRegistro
				+ ", fecActualizacion=" + fecActualizacion + ", estatus=" + estatus + "]";
	}
}
