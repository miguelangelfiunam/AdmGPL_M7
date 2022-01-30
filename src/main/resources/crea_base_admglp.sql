#-----------------------------------------------------------------#
#			2. Script de creación de la base de datos						#
#					MARTINEZ RIVERA MIGUEL ANGEL								#
#-----------------------------------------------------------------#

#-----------------------------------------------------------------#
#				Tabla de articulos en este caso 								#
#			tanques de gas en difernetes presentaciones					#
#-----------------------------------------------------------------#
CREATE TABLE c_articulo (
id_articulo INT(11) NOT NULL AUTO_INCREMENT, 
articulo_vc_nombre VARCHAR(70) NOT NULL, 
articulo_d_precio_articulo DECIMAL(19, 0) NOT NULL, 
articulo_dt_fecha_registro DATETIME NOT NULL, 
articulo_dt_fecha_actualizacion DATETIME NULL, 
articulo_si_estatus SMALLINT(6) NOT NULL, 
PRIMARY KEY (id_articulo)
)ENGINE=INNODB;

#-----------------------------------------------------------------#
#				Tabla de asentamientos o localidades						#
#		un ejemplo podría ser una colonia dentro de un municipio		#
#-----------------------------------------------------------------#
CREATE TABLE c_asentamiento (
id_asentamiento INT(11) NOT NULL AUTO_INCREMENT, 
id_municipio INT(11) NOT NULL, 
asenta_c_clave CHAR(4) NOT NULL, 
asenta_c_codigo_postal CHAR(5) NOT NULL,  
asenta_vc_tipo VARCHAR(70) NOT NULL, 
asenta_vc_nombre VARCHAR(150) NOT NULL, 
asenta_dt_fecha_registro DATETIME NOT NULL, 
asenta_dt_fecha_actualizacion DATETIME NULL, 
asenta_si_estatus SMALLINT(6) NOT NULL, 
PRIMARY KEY (id_asentamiento)
)ENGINE=INNODB;

#-----------------------------------------------------------------#
#			Tabla de clientes que podrán realizar un pedido de gas	#
#-----------------------------------------------------------------#
CREATE TABLE c_cliente (
id_cliente INT(11) NOT NULL AUTO_INCREMENT, 
id_usuario INT(11) NOT NULL UNIQUE, 
cliente_i_numero INT(11) NOT NULL, 
cliente_dt_fecha_registro DATETIME NULL, 
cliente_dt_fecha_actualizacion DATETIME NULL, 
cliente_si_estatus SMALLINT(6) NOT NULL, 
PRIMARY KEY (id_cliente)
)ENGINE=INNODB; 

#-----------------------------------------------------------------#
#			Tabla de empleados que podrán entregar un pedido de gas	#
#-----------------------------------------------------------------#
CREATE TABLE c_empleado (
id_empleado INT(11) NOT NULL AUTO_INCREMENT, 
id_usuario INT(11) NOT NULL UNIQUE, 
empleado_i_num_trab INT(11) NOT NULL UNIQUE, 
empleado_i_numero_ss CHAR(15) NOT NULL UNIQUE, 
empleado_c_rfc_trab char(13) NOT NULL UNIQUE, 
empleado_dt_fecha_registro DATETIME NOT NULL, 
empleado_dt_fecha_actualizacion DATETIME NULL, 
empleado_si_estatus SMALLINT(6) NOT NULL, 
PRIMARY KEY (id_empleado)
)ENGINE=INNODB;

#-----------------------------------------------------------------#
#			Tabla de estados donde se reparten pedidos de gas			#
#-----------------------------------------------------------------#
CREATE TABLE c_estado (
id_estado INT(11) NOT NULL AUTO_INCREMENT, 
estado_c_clave char(2) NOT NULL UNIQUE,
estado_vc_nombre VARCHAR(100) NOT NULL,
estado_dt_fecha_registro DATETIME NOT NULL, 
estado_dt_fecha_actualizacion DATETIME NULL,  
estado_si_estatus SMALLINT(6) NOT NULL, 
PRIMARY KEY (id_estado)
)ENGINE=INNODB;

#-----------------------------------------------------------------#
#				Tabla de estados para las tablas								#
#-----------------------------------------------------------------#
CREATE TABLE c_estatus (
id_estatus INT(11) NOT NULL AUTO_INCREMENT, 
estatus_si_num_estatus SMALLINT(6) NOT NULL, 
estatus_vc_nom_tabla VARCHAR(50) NOT NULL, 
estatus_vc_nombre_estatus VARCHAR(50) NOT NULL, 
estatus_vc_descripcion VARCHAR(200), 
estatus_dt_fecha_registro DATETIME NOT NULL, 
estatus_dt_fecha_actualizacion DATETIME NULL,  
estatus_c_activo char(1) NOT NULL, 
PRIMARY KEY (id_estatus)
)ENGINE=INNODB;

#-----------------------------------------------------------------#
#				Tabla de municipios donde se reparten pedidos			#
#-----------------------------------------------------------------#
CREATE TABLE c_municipio (
id_municipio INT(11) NOT NULL AUTO_INCREMENT, 
id_estado INT(11) NOT NULL, 
municipio_c_clave char(3) NOT NULL, 
municipio_vc_nombre VARCHAR(100) NOT NULL, 
municipio_dt_fecha_registro DATETIME NOT NULL, 
municipio_dt_fecha_actualizacion DATETIME NULL, 
municipio_si_estado SMALLINT(6) NOT NULL, 
PRIMARY KEY (id_municipio)
)ENGINE=INNODB;

#-----------------------------------------------------------------#
#				Tabla de roles que puede tener un usuario 				#
#						dentro de la aplicacion									#
#-----------------------------------------------------------------#
CREATE TABLE c_rol (
id_rol INT(11) NOT NULL AUTO_INCREMENT, 
rol_vc_nombre VARCHAR(50) NOT NULL, 
rol_c_tipo_rol char(1) NOT NULL, 
rol_dt_fecha_registro DATETIME NOT NULL, 
rol_dt_fecha_actualizacion DATETIME NULL, 
rol_si_estatus SMALLINT(6) NOT NULL, 
PRIMARY KEY (id_rol))ENGINE=INNODB;

#-----------------------------------------------------------------#
#				Tabla de articulos en este caso 								#
#			tanques de gas en diferentes presentaciones					#
#-----------------------------------------------------------------#
CREATE TABLE c_transporte (
id_transporte INT(11) NOT NULL AUTO_INCREMENT, 
trans_i_numero_unidad INT(11) NOT NULL, 
trans_i_modelo INT(11) NOT NULL, 
trans_vc_placas VARCHAR(20) NOT NULL, 
trans_vc_marca VARCHAR(30) NOT NULL, 
trans_dt_fecha_registro DATETIME NOT NULL, 
trans_dt_fecha_actualizacion DATETIME NULL, 
trans_si_estatus SMALLINT(6) NOT NULL, 
PRIMARY KEY (id_transporte)
)ENGINE=INNODB;

#-----------------------------------------------------------------#
#				Tabla de accesos de los usuarios para llevar 			#
#				una bitacora de quien accede y cuando accede				#
#-----------------------------------------------------------------#
CREATE TABLE t_acceso (
id_acceso INT(11) NOT NULL AUTO_INCREMENT, 
id_usuario INT(11) NOT NULL, 
acceso_dt_fecha_Inicio_acceso DATETIME NULL, 
acceso_dt_fecha_fin_acceso DATETIME NULL, 
acceso_descripcion VARCHAR(150) NOT NULL, 
acceso_dt_fecha_registro DATETIME NOT NULL, 
acceso_dt_fecha_actualizacion DATETIME NULL, 
acceso_si_estatus SMALLINT(6) NOT NULL, 
PRIMARY KEY (id_acceso)
)ENGINE=INNODB;

#-----------------------------------------------------------------#
#				Tabla de comentarios que se harán en el pedido			#
#						para comunicar el avance del pedido					#
#-----------------------------------------------------------------#
CREATE TABLE t_comentario (
id_comentario INT(11) NOT NULL AUTO_INCREMENT, 
id_pedido INT(11) NOT NULL, 
comentario_i_numero INT(11) NOT NULL, 
comentario_vc_comentario VARCHAR(500) NOT NULL, 
comentario_c_tipo char(1) NOT NULL, 
comentario_dt_fecha_registro DATETIME NOT NULL, 
comentario_dt_fecha_actualizacion DATETIME NULL, 
comentario_si_estatus SMALLINT(6) NOT NULL, 
PRIMARY KEY (id_comentario)
)ENGINE=INNODB;

#-----------------------------------------------------------------#
#				Tabla de contraseñas para los usuarios						#
#-----------------------------------------------------------------#
CREATE TABLE t_contra (
id_contra INT(11) NOT NULL AUTO_INCREMENT,  
contra_vc_contra_cifrado VARCHAR(500) NOT NULL, 
contra_dt_fecha_registro DATETIME NOT NULL, 
contra_dt_fecha_actualizacion DATETIME NULL, 
contra_si_estatus SMALLINT(6) NOT NULL, 
PRIMARY KEY (id_contra)
)ENGINE=INNODB;

#-----------------------------------------------------------------#
#			Tabla de direcciones relacionadas con el usuario			#
#-----------------------------------------------------------------#
CREATE TABLE t_direccion (
id_direccion INT(11) NOT NULL AUTO_INCREMENT, 
id_asentamiento INT(11) NOT NULL, 
direccion_vc_nombre VARCHAR(300) NOT NULL, 
direccion_vc_referencias VARCHAR(300), 
direccion_dt_fecha_registro DATETIME NOT NULL, 
direccion_dt_fecha_actualizacion DATETIME NULL, 
direccion_si_estatus SMALLINT(6) NOT NULL, 
PRIMARY KEY (id_direccion)
)ENGINE=INNODB;

#-----------------------------------------------------------------#
#				Tabla de pedidos generados por el usuario					#
#-----------------------------------------------------------------#
CREATE TABLE t_pedido (
id_pedido INT(11) NOT NULL AUTO_INCREMENT, 
id_cliente INT(11) NOT NULL, 
id_direccion int(11) NOT NULL, 
pedido_d_total DECIMAL(19, 0) NOT NULL, 
pedido_dt_fecha_pedido DATETIME NOT NULL, 
pedido_dt_fecha_entrega DATETIME NULL, 
pedido_i_tipo_pago INT(11), 
pedido_dt_fecha_registro DATETIME NOT NULL, 
pedido_dt_fecha_actualizacion DATETIME NULL, 
pedido_vc_observacion VARCHAR(250), 
pedido_si_estatus SMALLINT(6) NOT NULL, 
PRIMARY KEY (id_pedido)
)ENGINE=INNODB;

#-----------------------------------------------------------------#
#				Tabla de turnos generados para los empleados 			#
#				Servirá para llevar un seguimiento de días laborados	#
#-----------------------------------------------------------------#
CREATE TABLE t_turno (
id_turno INT(11) NOT NULL AUTO_INCREMENT, 
turno_dt_fecha_inicio_turno DATETIME NOT NULL, 
turno_dt_fecha_fin_turno DATETIME NULL, 
turno_dt_fecha_registro DATETIME NOT NULL, 
turno_dt_fecha_actualizacion DATETIME NULL, 
turno_si_estatus SMALLINT(6) NOT NULL, 
PRIMARY KEY (id_turno)
)ENGINE=INNODB;

#-----------------------------------------------------------------#
#			Tabla de usuarios que podrán acceder al sistema				#
#-----------------------------------------------------------------#
CREATE TABLE t_usuario (
id_usuario INT(11) NOT NULL AUTO_INCREMENT, 
id_contra INT(11) NOT NULL UNIQUE, 
usuario_vc_apodo VARCHAR(40) NOT NULL UNIQUE, 
usuario_vc_correo1 VARCHAR(80) NOT NULL, 
usuario_vc_correo2 VARCHAR(80), 
usuario_vc_nombre VARCHAR(50) NOT NULL, 
usuario_vc_apellido1 VARCHAR(50) NOT NULL, 
usuario_vc_apellido2 VARCHAR(50) NOT NULL, 
usuario_ti_edad TINYINT NOT NULL, 
usuario_d_fec_nacimiento DATE NOT NULL, 
usuario_vc_telefono1 VARCHAR(10) NOT NULL, 
usuario_vc_telefono2 VARCHAR(10), 
usuario_dt_fecha_registro DATETIME NOT NULL, 
usuario_dt_fecha_actualizacion DATETIME NULL, 
usuario_si_estatus SMALLINT(6) NOT NULL, 
PRIMARY KEY (id_usuario)
)ENGINE=INNODB;

#-----------------------------------------------------------------#
#		Tabla de relación entre el cliente y las direcciones			#
#-----------------------------------------------------------------#
CREATE TABLE tr_cliente_direccion (
id_cliente_direccion INT(11) NOT NULL AUTO_INCREMENT, 
id_cliente INT(11) NOT NULL, 
id_direccion INT(11) NOT NULL, 
cli_dir_dt_fecha_registro DATETIME NOT NULL, 
cli_dir_dt_fecha_actualizacion DATETIME NULL, 
cli_dir_si_estatus SMALLINT(6) NOT NULL, 
PRIMARY KEY (id_cliente_direccion)
)ENGINE=INNODB;

#-----------------------------------------------------------------#
#			Tabla de relación entre el empleado y el pedido				#
#-----------------------------------------------------------------#
CREATE TABLE tr_empleado_pedido (
id_empleado_pedido INT(11) NOT NULL AUTO_INCREMENT, 
idEmpleado INT(11) NOT NULL, 
iIdPedido INT(11) NOT NULL, 
emp_ped_dt_fecha_registro DATETIME NOT NULL, 
emp_ped_dt_fecha_actualizacion DATETIME NULL, 
emp_ped_si_estatus SMALLINT(6) NOT NULL, 
PRIMARY KEY (id_empleado_pedido)
)ENGINE=INNODB;

#-----------------------------------------------------------------#
#				Tabla de articulos en este caso 								#
#			tanques de gas en difernetes presentaciones					#
#-----------------------------------------------------------------#
CREATE TABLE tr_pedido_articulo (
id_ped_art INT(11) NOT NULL AUTO_INCREMENT, 
id_pedido INT(11) NOT NULL, 
id_articulo INT(11) NOT NULL, 
ped_art_ti_cantidad tinyint NOT NULL, 
ped_art_d_subtotal decimal(19, 0) NOT NULL,
ped_art_dt_fecha_registro DATETIME NOT NULL, 
ped_art_dt_fecha_actualizacion DATETIME NULL, 
ped_art_si_estatus SMALLINT(6) NOT NULL, 
PRIMARY KEY (id_ped_art)
)ENGINE=INNODB;

#-----------------------------------------------------------------#
#			Tabla de relación entre el turno creado, 						#
#	el empleado que labora y el trasnporte asignado en ese turno	#
#-----------------------------------------------------------------#
CREATE TABLE tr_turno_empleado_transporte (
id_turno_empleado_transporte INT(11) NOT NULL AUTO_INCREMENT, 
id_turno INT(11) NOT NULL, 
id_empleado INT(11) NOT NULL, 
id_transporte INT(11) NOT NULL, 
turno_emp_trans_dt_fecha_entrada DATETIME NOT NULL, 
turno_emp_trans_dt_fecha_salida DATETIME NULL, 
turno_emp_trans_si_estatus SMALLINT(6) NOT NULL, 
PRIMARY KEY (id_turno_empleado_transporte)
)ENGINE=INNODB;

#-----------------------------------------------------------------#
#		Tabla de relación entre el usuario y el rol asignado 			#
#						para entrar en el sistema								#
#-----------------------------------------------------------------#
CREATE TABLE tr_usuario_rol (
id_usuario_rol INT(11) NOT NULL AUTO_INCREMENT, 
id_rol INT(11) NOT NULL, 
id_usuario INT(11) NOT NULL, 
usu_rol_dt_fecha_registro DATETIME NOT NULL, 
usu_rol_dt_fecha_actualizacion DATETIME NULL, 
usu_rol_si_estatus SMALLINT(6) NOT NULL, 
PRIMARY KEY (id_usuario_rol)
)ENGINE=INNODB;

#-----------------------------------------------------------------#
# 						Creación de un índice en la 							#
# 				tabla estatus para asignar un solo estado 				#
# 						por numero de estado y nombre 						#
# 					de la tabla asociada a ese estado						#
#-----------------------------------------------------------------#
CREATE UNIQUE INDEX c_estatus ON c_estatus (estatus_si_num_estatus, estatus_vc_nom_tabla);

#-----------------------------------------------------------------#
# 					Creación de un índice en la 								#
# 					tabla de relación entre cliente y dirección			#
#					para asignar una sola dirección 							#
# 					por cliente logrando así que una dirección			#
# 					no este repetida en un usuario							#
#-----------------------------------------------------------------#
CREATE UNIQUE INDEX tr_cliente_direccion ON tr_cliente_direccion (id_cliente, id_direccion);

#-----------------------------------------------------------------#
# 					Creación de un índice en la 								#
# 					tabla de relación entre empleado y pedido				#
#					para asignar un empleado		 							#
# 					a un pedido logrando así que un empleado				#
# 					no este repetida en un pedido								#
#-----------------------------------------------------------------#
CREATE INDEX tr_empleado_pedido ON tr_empleado_pedido (idEmpleado, iIdPedido);

#-----------------------------------------------------------------#
# 					Creación de un índice en la 								#
# 					tabla de relación entre pedido y artículo				#
#					para asignar un artículo 									#
# 					a un pedido logrando así que un artículo				#
# 					no este repetida en un pedido								#
#-----------------------------------------------------------------#
CREATE UNIQUE INDEX tr_pedido_articulo ON tr_pedido_articulo (id_pedido, id_articulo);

#-----------------------------------------------------------------#
# 					Creación de un índice en la 								#
# 					tabla de relación entre turno y empleado				#
#					para asignar un empleado		 							#
# 					por turno logrando así que un empleado					#
# 					no este repetida en un turno								#
#-----------------------------------------------------------------#
CREATE UNIQUE INDEX tr_turno_empleado_transporte ON tr_turno_empleado_transporte (id_turno, id_empleado);

#-----------------------------------------------------------------#
# 					Creación de un índice en la 								#
# 					tabla de relación entre rol y usuario					#
#					para asignar un rol			 								#
# 					a un usuario logrando así que un usuario				#
# 					no tenga repetido un rol									#
#-----------------------------------------------------------------#
CREATE UNIQUE INDEX tr_usuario_rol ON tr_usuario_rol (id_rol, id_usuario);

#-----------------------------------------------------------------#
# 					Creación de una llave foranea								#
#					para la tabla t_contra										#
#					donde el id de usuario funje como FK					#
#-----------------------------------------------------------------#
ALTER TABLE t_usuario ADD CONSTRAINT FKt_contra311966 
FOREIGN KEY (id_contra) REFERENCES t_contra (id_contra);

#-----------------------------------------------------------------#
# 					Creación de una llave foranea								#
#					para la tabla tr_usuario_rol								#
#					donde el id de rol funje como FK							#
#-----------------------------------------------------------------#
ALTER TABLE tr_usuario_rol ADD CONSTRAINT FKtr_usuario338231 
FOREIGN KEY (id_rol) REFERENCES c_rol (id_rol);

#-----------------------------------------------------------------#
# 					Creación de una llave foranea								#
#					para la tabla de tr_usuario_rol							#
#					donde el id de usuario funje como FK					#
#-----------------------------------------------------------------#
ALTER TABLE tr_usuario_rol ADD CONSTRAINT FKtr_usuario699017 
FOREIGN KEY (id_usuario) REFERENCES t_usuario (id_usuario);

#-----------------------------------------------------------------#
# 					Creación de una llave foranea								#
#					para la tabla t_acceso										#
#					donde el id de usuario funje como FK					#
#-----------------------------------------------------------------#
ALTER TABLE t_acceso ADD CONSTRAINT FKt_acceso629272 
FOREIGN KEY (id_usuario) REFERENCES t_usuario (id_usuario);

#-----------------------------------------------------------------#
# 					Creación de una llave foranea								#
#					para la tabla c_empleado									#
#					donde el id de usuario funje como FK					#
#-----------------------------------------------------------------#
ALTER TABLE c_empleado ADD CONSTRAINT FKc_empleado220638 
FOREIGN KEY (id_usuario) REFERENCES t_usuario (id_usuario);

#-----------------------------------------------------------------#
# 					Creación de una llave foranea								#
#					para la tabla c_cliente										#
#					donde el id de usuario funje como FK					#
#-----------------------------------------------------------------#
ALTER TABLE c_cliente ADD CONSTRAINT FKc_cliente561454 
FOREIGN KEY (id_usuario) REFERENCES t_usuario (id_usuario);

#-----------------------------------------------------------------#
# 					Creación de una llave foranea								#
#					para la tabla tr_cliente_direccion						#
#					donde el id de cliente funje como FK					#
#-----------------------------------------------------------------#
ALTER TABLE tr_cliente_direccion ADD CONSTRAINT FKtr_cliente187311 
FOREIGN KEY (id_cliente) REFERENCES c_cliente (id_cliente);

#-----------------------------------------------------------------#
# 					Creación de una llave foranea								#
#					para la tabla tr_cliente_direccion						#
#					donde el id de direccion funje como FK					#
#-----------------------------------------------------------------#
ALTER TABLE tr_cliente_direccion ADD CONSTRAINT FKtr_cliente971187 
FOREIGN KEY (id_direccion) REFERENCES t_direccion (id_direccion);

#-----------------------------------------------------------------#
# 					Creación de una llave foranea								#
#					para la tabla tr_empleado_pedido							#
#					donde el id de empleado funje como FK					#
#-----------------------------------------------------------------#
ALTER TABLE tr_empleado_pedido ADD CONSTRAINT FKtr_emplead705164 
FOREIGN KEY (idEmpleado) REFERENCES c_empleado (id_empleado);

#-----------------------------------------------------------------#
# 					Creación de una llave foranea								#
#					para la tabla tr_empleado_pedido							#
#					donde el id de pedido funje como FK						#
#-----------------------------------------------------------------#
ALTER TABLE tr_empleado_pedido ADD CONSTRAINT FKtr_emplead954267 
FOREIGN KEY (iIdPedido) REFERENCES t_pedido (id_pedido);

#-----------------------------------------------------------------#
# 					Creación de una llave foranea								#
#					para la tabla t_pedido										#
#					donde el id de cliente funje como FK					#
#-----------------------------------------------------------------#
ALTER TABLE t_pedido ADD CONSTRAINT FKt_pedido230835 
FOREIGN KEY (id_cliente) REFERENCES c_cliente (id_cliente);

#-----------------------------------------------------------------#
# 					Creación de una llave foranea								#
#					para la tabla t_pedido										#
#					donde el id de direccion funje como FK					#
#-----------------------------------------------------------------#
ALTER TABLE t_pedido ADD CONSTRAINT FKt_pedido582256 
FOREIGN KEY (id_direccion) REFERENCES t_direccion (id_direccion);

#-----------------------------------------------------------------#
# 					Creación de una llave foranea								#
#					para la tabla tr_turno_empleado_transporte			#
#					donde el id de turno funje como FK						#
#-----------------------------------------------------------------#
ALTER TABLE tr_turno_empleado_transporte ADD CONSTRAINT FKtr_turno_e936515 
FOREIGN KEY (id_turno) REFERENCES t_turno (id_turno);

#-----------------------------------------------------------------#
# 					Creación de una llave foranea								#
#					para la tabla tr_turno_empleado_transporte			#
#					donde el id de transporte funje como FK				#
#-----------------------------------------------------------------#
ALTER TABLE tr_turno_empleado_transporte ADD CONSTRAINT FKtr_turno_e390466 
FOREIGN KEY (id_transporte) REFERENCES c_transporte (id_transporte);

#-----------------------------------------------------------------#
# 					Creación de una llave foranea								#
#					para la tabla tr_turno_empleado_transporte			#
#					donde el id de empleado funje como FK					#
#-----------------------------------------------------------------#
ALTER TABLE tr_turno_empleado_transporte ADD CONSTRAINT FKtr_turno_e357918 
FOREIGN KEY (id_empleado) REFERENCES c_empleado (id_empleado);

#-----------------------------------------------------------------#
# 					Creación de una llave foranea								#
#					para la tabla tr_pedido_articulo							#
#					donde el id de pedido funje como FK						#
#-----------------------------------------------------------------#
ALTER TABLE tr_pedido_articulo ADD CONSTRAINT FKtr_pedido_549600 
FOREIGN KEY (id_pedido) REFERENCES t_pedido (id_pedido);

#-----------------------------------------------------------------#
# 					Creación de una llave foranea								#
#					para la tabla tr_pedido_articulo							#
#					donde el id de articulo funje como FK					#
#-----------------------------------------------------------------#
ALTER TABLE tr_pedido_articulo ADD CONSTRAINT FKtr_pedido_114924 
FOREIGN KEY (id_articulo) REFERENCES c_articulo (id_articulo);

#-----------------------------------------------------------------#
# 					Creación de una llave foranea								#
#					para la tabla c_municipio									#
#					donde el id de estado funje como FK						#
#-----------------------------------------------------------------#
ALTER TABLE c_municipio ADD CONSTRAINT FKc_municipi133071 
FOREIGN KEY (id_estado) REFERENCES c_estado (id_estado);

#-----------------------------------------------------------------#
# 					Creación de una llave foranea								#
#					para la tabla c_asentamiento								#
#					donde el id de municipio funje como FK					#
#-----------------------------------------------------------------#
ALTER TABLE c_asentamiento ADD CONSTRAINT FKc_asentami890224 
FOREIGN KEY (id_municipio) REFERENCES c_municipio (id_municipio);

#-----------------------------------------------------------------#
# 					Creación de una llave foranea								#
#					para la tabla c_asentamiento								#
#					donde el id de asentamiento funje como FK				#
#-----------------------------------------------------------------#
ALTER TABLE t_direccion ADD CONSTRAINT FKt_direccio716926 
FOREIGN KEY (id_asentamiento) REFERENCES c_asentamiento (id_asentamiento);

#-----------------------------------------------------------------#
# 					Creación de una llave foranea								#
#					para la tabla t_comentario									#
#					donde el id de pedido funje como FK						#
#-----------------------------------------------------------------#
ALTER TABLE t_comentario ADD CONSTRAINT FKt_comentar704229 
FOREIGN KEY (id_pedido) REFERENCES t_pedido (id_pedido);
