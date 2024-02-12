-- personas
insert into personas (nombre, apellido, dni, telefono, email,asistencia,eliminado,fecha_nac,tipo_doc) values ('maximiliano','lopez','78987654','2954265696','some_mail@hotmail.com',false,false,'27-09-1992','DNI');

-- expedientes
insert into expedientes (texto_nota,fecha_ingreso_facultad,iniciante_id,estado_expediente) values ('algo descriptivo','2023-06-25',1,'ABIERTO');

-- acciones_realizadas
insert into acciones_realizadas (accion_realizada,fecha_accion,eliminado) values ('aprobacion del expediente N°01123', '2023-06-12',false);

insert into persona_tipodepersona (persona_id,tipo_persona) VALUES (1,'INVOLUCRADO');

