package mx.unam.dgtic.admglp.dao;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "t_usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Integer idUsuario; // Identificador de usuario
	
//	, referencedColumnName = "id"
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_contra")
	private Contra contra;
	
	@Column(name = "usuario_vc_apodo")
	private String apodo; // Seudonimo del usuario en la aplicacion
	
	@Column(name = "usuario_vc_correo1")
	private String correo1; // Correo electronico
	
	@Column(name = "usuario_vc_correo2")
	private String correo2; // Correo electronico
	
	@Column(name = "usuario_vc_nombre")
	private String nombre; // Nombre de la persona 100
	
	@Column(name = "usuario_vc_apellido1")
	private String apellido1; // Primer apellido 100
	
	@Column(name = "usuario_vc_apellido2")
	private String apellido2; // Segundo apellido 100
	
	@Column(name = "usuario_ti_edad")
	private Integer edad;// Edad de la persona
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "usuario_d_fec_nacimiento")
	private Date fechaNacimiento; // Fecha de nacimiento
	
	@Column(name = "usuario_vc_telefono1")
	private String telefono1; // Telefono del usuario
	
	@Column(name = "usuario_vc_telefono2")
	private String telefono2; // Segundo telefono de contacto
	
	@Column(name = "usuario_dt_fecha_registro")
	private Date fecRegistro; // Fecha de Inicio de acceso a la aplicacion
	
	@Column(name = "usuario_dt_fecha_actualizacion")
	private Date fecActualizacion; // Fecha de fin de acceso a la aplicacion
	
	@Column(name = "usuario_si_estatus")
	private Integer estatus; // Estado del usuario
	
	public Usuario(Integer idUsuario, String apodo, String correo1, String correo2, String nombre, String apellido1,
			String apellido2, Integer edad, Date fechaNacimiento, String telefono1, String telefono2, Date fecRegistro,
			Date fecActualizacion, Integer estatus) {
		this.idUsuario = idUsuario;
		this.apodo = apodo;
		this.correo1 = correo1;
		this.correo2 = correo2;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.edad = edad;
		this.fechaNacimiento = fechaNacimiento;
		this.telefono1 = telefono1;
		this.telefono2 = telefono2;
		this.fecRegistro = fecRegistro;
		this.fecActualizacion = fecActualizacion;
		this.estatus = estatus;
	}

	public Usuario(Contra contra, String apodo, String correo1, String correo2,
			String nombre, String apellido1, String apellido2, Integer edad, Date fechaNacimiento, String telefono1,
			String telefono2, Date fecRegistro, Date fecActualizacion, Integer estatus) {
		this.contra = contra;
		this.apodo = apodo;
		this.correo1 = correo1;
		this.correo2 = correo2;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.edad = edad;
		this.fechaNacimiento = fechaNacimiento;
		this.telefono1 = telefono1;
		this.telefono2 = telefono2;
		this.fecRegistro = fecRegistro;
		this.fecActualizacion = fecActualizacion;
		this.estatus = estatus;
	}

	public Usuario(Integer idUsuario, String apodo, String correo1, String correo2, String nombre, String apellido1,
			String apellido2, Integer edad, Date fechaNacimiento, String telefono1, String telefono2) {
		this.idUsuario = idUsuario;
		this.apodo = apodo;
		this.correo1 = correo1;
		this.correo2 = correo2;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.edad = edad;
		this.fechaNacimiento = fechaNacimiento;
		this.telefono1 = telefono1;
		this.telefono2 = telefono2;
	}

	public Usuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Usuario() {
		super();
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Contra getContra() {
		return contra;
	}

	public void setContraDTO(Contra contra) {
		this.contra = contra;
	}

	public String getApodo() {
		return apodo;
	}

	public void setApodo(String apodo) {
		this.apodo = apodo;
	}

	public String getCorreo1() {
		return correo1;
	}

	public void setCorreo1(String correo1) {
		this.correo1 = correo1;
	}

	public String getCorreo2() {
		return correo2;
	}

	public void setCorreo2(String correo2) {
		this.correo2 = correo2;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getTelefono1() {
		return telefono1;
	}

	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}

	public String getTelefono2() {
		return telefono2;
	}

	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
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
		return "UsuarioDTO [idUsuario=" + idUsuario + ", apodo=" + apodo + ", correo1=" + correo1 + ", correo2="
				+ correo2 + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", edad="
				+ edad + ", fechaNacimiento=" + fechaNacimiento + ", telefono1=" + telefono1 + ", telefono2="
				+ telefono2 + ", fecRegistro=" + fecRegistro + ", fecActualizacion=" + fecActualizacion + ", estatus="
				+ estatus + "]";
	}
	
}
