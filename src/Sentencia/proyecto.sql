create table cliente(
id_cliente int primary key,
primer_nombre varchar(20),
segundo_nombre varchar(20),
primer_apellido varchar(20),
segundo_apellido varchar(20),
telefono varchar(9) constraint regla_tel check(REGEXP_LIKE(telefono, '[1-9]{4}'||'-'||'[0-9]{4}')),
cudad varchar(50),
departamento varchar(50)
);

create table cuenta(
codigo_cuenta varchar(15) primary key,
saldo_total number(*,2) constraint regla_ingreso check(saldo_total >= 0),
id_tipo_cuenta int,
id_cliente int
);

create table transaccion(
id_transaccion int primary key,
saldo number(*,2) constraint regla_saldo check(saldo >= 0),
fecha date,
codigo_cuenta varchar(15),
id_tipo_transaccion int
);

create table tipo_transaccion(
id_tipo_transaccion int primary key,
tipo int
);

create table tipo_cuenta(
id_tipo_cuenta int primary key,
tipo_cuenta int
);



create sequence cliente_seq start with 1 increment by 1;
create sequence transac_seq start with 1 increment by 1;
create sequence tipoTransac_seq start with 1 increment by 1;
create sequence tipoCuenta_seq start with 1 increment by 1;



Alter table cuenta add constraint cuenta_fk foreign key (id_cliente) references cliente(id_cliente);
Alter table transaccion add constraint transac_fk foreign key (codigo_cuenta) references cuenta(codigo_cuenta);
Alter table cuenta add constraint tipoCuenta_Fk foreign key (id_tipo_cuenta) references tipo_cuenta(id_tipo_cuenta);
Alter table transaccion add constraint tipoTransac_fk foreign key (id_tipo_transaccion) references tipo_transaccion(id_tipo_transaccion);



--INSERT TABLE CLIENTE
INSERT INTO cliente(id_cliente, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, telefono, cudad, departamento)
VALUES(cliente_seq.NextVal, 'Anderson', 'Alberto', 'Carcamo', 'Rivera', '1212-4556', 'El Salvador', 'Santa Ana');
INSERT INTO cliente(id_cliente, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, telefono, cudad, departamento)
VALUES(cliente_seq.NextVal, 'Diego', 'Esau', 'Hernandez', 'Magaña', '7863-3223', 'El Salvador', 'Santa Ana');
INSERT INTO cliente(id_cliente, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, telefono, cudad, departamento)
VALUES(cliente_seq.NextVal, 'Luis', 'Enrique', 'Vasquez', 'Aquila', '6812-1212', 'El Salvador', 'Santa Ana');
INSERT INTO cliente(id_cliente, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, telefono, cudad, departamento)
VALUES(cliente_seq.NextVal, 'Jose', 'Martin', 'Sanabria', 'Flores', '3729-4343', 'El Salvador', 'Santa Ana');
INSERT INTO cliente(id_cliente, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, telefono, cudad, departamento)
VALUES(cliente_seq.NextVal, 'Juan', 'Jose', 'Gomes', 'Acuña', '7122-3239', 'El Salvador', 'Santa Ana');

--INSERT TABLE TIPO_CUENTA
INSERT INTO tipo_cuenta(id_tipo_cuenta, tipo_cuenta)
VALUES(tipoCuenta_seq.Nextval, 1)

--INSERT TABLE CUENTA
INSERT INTO cuenta(codigo_cuenta, saldo_total, id_tipo_cuenta, id_cliente)
VALUES('pdb-12', 500, 1, 1)

--INSERT TABLE TRANSACCION
INSERT INTO transaccion(id_transaccion, saldo, fecha, codigo_cuenta, id_tipo_transaccion)
VALUES(transac_seq.Nextval, 100, '12/2/17', 'pdb-12', 1)

--INSERT TABLE TIPO_TRANSACCION
INSERT INTO tipo_transaccion(id_tipo_transaccion, tipo)
VALUES (tipoTransac_seq.Nextval, 1)



