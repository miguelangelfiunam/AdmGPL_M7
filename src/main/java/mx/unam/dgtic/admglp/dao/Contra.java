package mx.unam.dgtic.admglp.dao;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_contra")
public class Contra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_contra")
	private Integer id;

	@Column(name = "contra_vc_contra_cifrado")
	private String contraCifrado;

	@Column(name = "contra_dt_fecha_registro")
	private Date fecRegistro; // Fecha de registro

	@Column(name = "contra_dt_fecha_actualizacion")
	private Date fecActualizacion; // Fecha de actualizacion

	@Column(name = "contra_si_estatus")
	private Integer estatus; // Estatus del registro en la base

	@OneToOne(mappedBy = "contra", cascade = CascadeType.ALL)
	private Usuario usuario;

	public Contra(Integer id, String contraCifrado, Date fecRegistro, Date fecActualizacion, Integer estatus) {
		this.id = id;
		this.contraCifrado = contraCifrado;
		this.fecRegistro = fecRegistro;
		this.fecActualizacion = fecActualizacion;
		this.estatus = estatus;
	}

	public Contra(String contraCifrado, Date fecRegistro, Date fecActualizacion, Integer estatus) {
		this.contraCifrado = contraCifrado;
		this.fecRegistro = fecRegistro;
		this.fecActualizacion = fecActualizacion;
		this.estatus = estatus;
	}

	public Contra(String contraCifrado, Integer estatus) {
		this.contraCifrado = contraCifrado;
		this.estatus = estatus;
	}

	public Contra() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContraCifrado() {
		return contraCifrado;
	}

	public void setContraCifrado(String contraCifrado) {
		this.contraCifrado = contraCifrado;
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
