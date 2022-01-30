package mx.unam.dgtic.admglp.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "c_estado")
public class Estado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_estado")
	protected Integer id;
	
	@Column(name = "estado_c_clave")
	protected String clave;
	
	@Column(name = "estado_vc_nombre")
	protected String nombre;
	
	@Column(name = "estado_dt_fecha_registro")
	protected Date fecRegistro; // Fecha de Inicio de acceso a la aplicacion
	
	@Column(name = "estado_dt_fecha_actualizacion")
	protected Date fecActualizacion; // Fecha de fin de acceso a la aplicacion
	
	@Column(name = "estado_si_estatus")
	protected Integer estatus;
	
	@OneToMany(mappedBy = "estado")
	List<Municipio> municipios = new ArrayList<Municipio>();

	public Estado(Integer id, String clave, String nombre, Date fecRegistro, Date fecActualizacion, Integer estatus) {
		super();
		this.id = id;
		this.clave = clave;
		this.nombre = nombre;
		this.fecRegistro = fecRegistro;
		this.fecActualizacion = fecActualizacion;
		this.estatus = estatus;
	}

	public Estado(Integer id) {
		super();
		this.id = id;
	}

	public Estado(String clave) {
		super();
		this.clave = clave;
	}

	public Estado() {
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

	public List<Municipio> getMunicipios() {
		return municipios;
	}

	public void setMunicipios(List<Municipio> municipios) {
		this.municipios = municipios;
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
		Estado other = (Estado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EstadoDTO [id=" + id + ", clave=" + clave + ", nombre=" + nombre + ", fecRegistro=" + fecRegistro
				+ ", fecActualizacion=" + fecActualizacion + ", estatus=" + estatus + "]";
	}
}
