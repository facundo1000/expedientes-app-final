-- personas
insert into personas (nombre, apellido, dni, telefono, email,tipo_persona,asistencia) values ('maximiliano','lopez','78987654','2954265696','some_mail@hotmail.com','INVOLUCRADO',false);

-- expedientes
insert into expedientes (texto_nota,fecha_ingreso_facultad,iniciante_id,estado_expediente) values ('algo descriptivo','2023-06-25',1,'ABIERTO');

-- acciones_realizadas
insert into acciones_realizadas (accion_realizada,fecha_accion,expediente_id) values ('aprobacion del expediente N°01123', '2023-06-12',1);


