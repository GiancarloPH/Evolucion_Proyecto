/*
drop table cargos;
drop table categorias;
drop table clientes;
drop table compras;
drop table detallecompra;
drop table detalleventa;
drop table empleados;
drop table productos;
drop table proveedores;
drop table ventas;
*/

/*TABLAS*/

CREATE TABLE Cargos(
	idCargo int NOT NULL,
	Nombre varchar(50) 
 );

CREATE TABLE Categorias(
	idCategoria int  NOT NULL,
	nombre varchar(50),
	Estado INT 
);
    
CREATE TABLE Clientes(
	idCliente varchar(10) NOT NULL,
	Nombre varchar(50) NOT NULL,
	Apellido varchar(50) ,
	Nacimiento date ,
	DNI varchar (10) ,
	Estado INT
);

CREATE TABLE Compras(
	idCompra varchar(10) NOT NULL,
	IDproveedor varchar(10),
	fecha date,
	importetotal float
);

CREATE TABLE DetalleCompra(
	idCompra varchar(10) NOT NULL,
	idProducto varchar(10) NOT NULL,
	cantidad int ,
    PrecioUnit float,
	Importe float 
);

CREATE TABLE DetalleVenta(
	idVenta varchar(10) NOT NULL,
	idProducto varchar(10) NOT NULL,
	Cantidad int NOT NULL,
    PrecioUnit float NOT NULL,
	Importe float
    );
    
CREATE TABLE Empleados(
	idEmpleado varchar(10)  NOT NULL,
	DNI varchar(10) NOT NULL,
	Nombre varchar(50) ,
	Apellido varchar(50) ,
	Genero varchar(50) ,
	Nacimiento date NOT NULL,
	Telefono varchar(20) NOT NULL,
	Correo varchar(100) NOT NULL,
	Direccion varchar(100) NOT NULL,
	Usuario varchar(50) NOT NULL,
	Contraseña varchar(50) NOT NULL,
	idCargo int NOT NULL,
	Estado INT 

); 

CREATE TABLE Productos(
	idProducto varchar(10) NOT NULL,
	nombre varchar(50) NOT NULL,
	descripcion varchar(50) ,
	precioUnit float ,
	Stock int ,
	idCategoria int NOT NULL,
	Estado INT 
);

CREATE TABLE Proveedores(
	IDProveedor varchar(10) NOT NULL,
	RUC varchar(20) NOT NULL,
	NomEmpresa varchar(100) NOT NULL,
	nombreContacto varchar(50) NOT NULL,
	apellidoContacto varchar(50) NOT NULL,
	telefonoContacto varchar(20) NOT NULL,
    direccionEmpresa varchar(100) NOT NULL,
	Estado INT
);


CREATE TABLE Ventas(
	idVenta varchar(10) NOT NULL,
	Fecha date ,
	IdEmpleado varchar(10) ,
    ImportTotal float ,
	idCliente varchar(10)
    );

ALTER TABLE Cargos add CONSTRAINT PK_Cargo PRIMARY KEY (idCargo);
ALTER TABLE Categorias add CONSTRAINT PK_Categoria PRIMARY KEY (idCategoria);
ALTER TABLE Clientes add CONSTRAINT PK_Cliente PRIMARY KEY (idCliente);
ALTER TABLE Compras add CONSTRAINT PK_Compra PRIMARY KEY (idCompra);
ALTER TABLE Empleados add CONSTRAINT PK_Empleado PRIMARY KEY (idEmpleado);
ALTER TABLE Productos add CONSTRAINT PK_Producto PRIMARY KEY (idProducto);
ALTER TABLE Proveedores add CONSTRAINT PK_Proveedor PRIMARY KEY (IDProveedor);
ALTER TABLE Ventas add CONSTRAINT PK_Venta PRIMARY KEY (idVenta);

ALTER TABLE Compras ADD CONSTRAINT FK_Compra_Proveedor FOREIGN KEY(IDproveedor) REFERENCES Proveedores(IDProveedor);
ALTER TABLE DetalleCompra ADD CONSTRAINT FK_DetalleCompra_Compra FOREIGN KEY(idcompra) REFERENCES Compras(idcompra);
ALTER TABLE DetalleCompra ADD CONSTRAINT FK_DetalleCompra_Producto FOREIGN KEY(idProducto) REFERENCES Productos(idProducto);
ALTER TABLE DetalleVenta ADD CONSTRAINT FK_DetalleVenta_Venta FOREIGN KEY(idVenta) REFERENCES Ventas(idVenta);
ALTER TABLE DetalleVenta ADD CONSTRAINT FK_DetalleVenta_Produc FOREIGN KEY(idProducto) REFERENCES Productos(idProducto);
ALTER TABLE Empleados ADD CONSTRAINT FK_Empleado_Cargo FOREIGN KEY(idCargo) REFERENCES Cargos(idCargo);
ALTER TABLE Productos ADD CONSTRAINT FK_Producto_Categoria FOREIGN KEY(idCategoria) REFERENCES Categorias(idCategoria);

ALTER TABLE Ventas ADD CONSTRAINT FK_Venta_Cliente FOREIGN KEY(idCliente) REFERENCES Clientes(idCliente);
ALTER TABLE Ventas ADD CONSTRAINT FK_Venta_Empleado FOREIGN KEY(IdEmpleado) REFERENCES Empleados(idEmpleado);


ALTER TABLE EMPLEADOS ADD CONSTRAINT UN_EMPLEADOS UNIQUE (DNI);
ALTER TABLE EMPLEADOS ADD CONSTRAINT UN_EMPLEADOTE UNIQUE (Telefono);
ALTER TABLE EMPLEADOS ADD CONSTRAINT UN_EMPLEADOCO UNIQUE (Correo);
ALTER TABLE EMPLEADOS ADD CONSTRAINT UN_EMPLEADOUSU UNIQUE (Usuario);


ALTER TABLE PROVEEDORES ADD CONSTRAINT UN_PROVERUC UNIQUE (RUC);
ALTER TABLE PROVEEDORES ADD CONSTRAINT UN_PROVETELF UNIQUE (telefonoContacto);
ALTER TABLE PROVEEDORES ADD CONSTRAINT UN_PROVEEMPRE UNIQUE (NomEmpresa);

ALTER TABLE CLIENTES ADD CONSTRAINT UN_CLIENTEDNI UNIQUE (DNI);



/*----------------------------------------------*/
/*SECUENCIAS
drop SEQUENCE CGPROV
drop SEQUENCE CGEMP
drop SEQUENCE CGCAT
drop SEQUENCE CGCLI
DROP SEQUENCE CGPRO;
DROP SEQUENCE CGCOMP;
DROP SEQUENCE CGVENT;
drop trigger TRIG_COD_CLI
drop trigger TRIG_COD_PV
drop trigger TRIG_COD_EMP
drop trigger TRIG_COD_CAT
drop trigger TRIG_COD_PRO
drop trigger TRIG_COD_COMP
drop trigger TRIG_COD_VENT
drop trigger SUMARSTOCK
drop trigger RESTARSTOCK
drop trigger ImportDetComp
drop trigger control_stock
drop trigger stockIni
drop trigger control_precio
drop trigger NOELIMINARCLIENTE
drop trigger ESTADOADMINISTRADOR
drop trigger ImportDetVent
*/


/*----------------------------------------------*/
CREATE SEQUENCE CGCLI
START WITH 1
INCREMENT BY 1;

CREATE OR REPLACE TRIGGER TRIG_COD_CLI
    BEFORE INSERT ON clientes
    FOR EACH ROW
BEGIN
    SELECT 'CL' || LPAD(CGCLI.nextval,6,'0')
    INTO :new.idcliente
    FROM dual;
END;

/*----------------------------------------------*/
CREATE SEQUENCE CGPROV
START WITH 1
INCREMENT BY 1;

CREATE  or replace TRIGGER TRIG_COD_PV
BEFORE INSERT ON proveedores
FOR EACH ROW
BEGIN
 SELECT 'PV' || LPAD(CGPROV.nextval,6,'0')
    INTO :new.idproveedor
    FROM dual;
END;

/*-----------------------------------------------*/

CREATE SEQUENCE CGEMP
START WITH 1
INCREMENT BY 1;

CREATE TRIGGER TRIG_COD_EMP
BEFORE INSERT ON empleados
FOR EACH ROW
BEGIN
SELECT 'EM' || LPAD(CGEMP.nextval,6,'0')
    INTO :new.idempleado
    FROM dual;
END;

/*----------------------------------------------*/
  
CREATE SEQUENCE CGCAT
START WITH 1
INCREMENT BY 1;

CREATE TRIGGER TRIG_COD_CAT
BEFORE INSERT ON categorias
FOR EACH ROW
BEGIN
SELECT CGCAT.NEXTVAL INTO :NEW.IDCATEGORIA FROM DUAL;
END;

/*----------------------------------------------*/

CREATE SEQUENCE CGPRO
START WITH 1
INCREMENT BY 1;

CREATE OR REPLACE TRIGGER TRIG_COD_PRO
    BEFORE INSERT ON PRODUCTOS
    FOR EACH ROW
BEGIN
    SELECT 'PR' || LPAD(CGPRO.nextval,6,'0')
    INTO :new.idproducto
    FROM dual;
    
END;

/*----------------------------------------------*/

CREATE SEQUENCE CGCOMP
START WITH 1
INCREMENT BY 1;

CREATE OR REPLACE TRIGGER TRIG_COD_COMP
    BEFORE INSERT ON COMPRAS
    FOR EACH ROW
BEGIN
    SELECT 'C' || LPAD(CGCOMP.nextval,6,'0')
    INTO :new.idcompra
    FROM dual;
END;
/*----------------------------------------------*/


CREATE SEQUENCE CGVENT
START WITH 1
INCREMENT BY 1;

CREATE OR REPLACE TRIGGER TRIG_COD_VENT
    BEFORE INSERT ON VENTAS
    FOR EACH ROW
BEGIN
    SELECT 'V' || LPAD(CGVENT.nextval,6,'0')
    INTO :new.idventa
    FROM dual;
END;

/*----------------------------------------------*/
/*bladimir*/

CREATE OR REPLACE TRIGGER SUMARSTOCK
AFTER INSERT ON DETALLECOMPRA FOR EACH ROW
BEGIN
    UPDATE PRODUCTOS
    SET STOCK=STOCK+:NEW.CANTIDAD
    WHERE IDPRODUCTO= :NEW.IDPRODUCTO;
END;

/*----------------------------------------------*/
CREATE OR REPLACE TRIGGER RESTARSTOCK
AFTER INSERT ON DETALLEVENTA FOR EACH ROW
BEGIN
    UPDATE PRODUCTOS
    SET STOCK=STOCK-:NEW.CANTIDAD
    WHERE IDPRODUCTO= :NEW.IDPRODUCTO;
END;


/*----------------------------------------------*/

CREATE OR REPLACE TRIGGER  ImportDetComp
BEFORE INSERT ON DETALLECOMPRA FOR EACH ROW
BEGIN
:new.importe := :new.cantidad * :new.preciounit;
END;


/*----------------------------------------------*/

CREATE OR REPLACE TRIGGER  ImportDetVent
BEFORE INSERT ON DETALLEVENTA FOR EACH ROW
BEGIN
:new.importe := :new.cantidad * :new.preciounit;
END;
/*----------------------------------------------*/

CREATE OR REPLACE TRIGGER control_stock
BEFORE INSERT ON PRODUCTOS FOR EACH ROW
BEGIN
if :NEW.stock < 0
then :NEW.stock :=0;
end if;
END;

/*----------------------------------------------*/

CREATE OR REPLACE TRIGGER stockIni
BEFORE INSERT ON PRODUCTOS FOR EACH ROW
BEGIN
     :NEW.STOCK :=0;
END;


/*----------------------------------------------*/
CREATE OR REPLACE TRIGGER control_precio
BEFORE INSERT ON PRODUCTOS FOR EACH ROW
BEGIN
if :NEW.preciounit < 0
then :NEW.preciounit :=0;
end if;
END;

/*----------------------------------------------*/

/*bladimir*/

CREATE OR REPLACE TRIGGER NOELIMINARCLIENTE 
BEFORE DELETE ON CLIENTES FOR EACH ROW
BEGIN
    RAISE_APPLICATION_ERROR(-20100, 'NO SE PUEDEN ELIMINAR COMPLETAMENTE REGISTROS DE CLIENTES');
END;



  /*bladimir*/
CREATE OR REPLACE TRIGGER ESTADOADMINISTRADOR
AFTER UPDATE OF ESTADO ON EMPLEADOS FOR EACH ROW
BEGIN
   
   IF :OLD.IDCARGO = 1 THEN
   raise_application_error(-20343, 'NO SE PUEDE ELIMINAR AL ADMINISTRADOR');
         UPDATE EMPLEADOS SET ESTADO = 'ACTIVO' WHERE IDEMPLEADO= :OLD.IDEMPLEADO;
    END IF;
 END;
 
 
/*----------------------------------------------*/
 
INSERT  INTO Cargos VALUES (1, 'Administrador');
INSERT  INTO Cargos VALUES (2, 'Vendedor');
INSERT  INTO Cargos VALUES (3, 'Almacenero');

INSERT  INTO Categorias(nombre,estado) VALUES ( 'Abarrotes', 1);
INSERT  INTO Categorias(nombre,estado)  VALUES ( 'Enlatados', 1);
INSERT  INTO Categorias(nombre,estado)  VALUES ( 'Lacteos', 1);
INSERT  INTO Categorias(nombre,estado)  VALUES ( 'Botanas',1);
INSERT  INTO Categorias(nombre,estado)  VALUES ( 'Confiteria', 1);
INSERT  INTO Categorias(nombre,estado)  VALUES ( 'Harinas', 1);
INSERT  INTO Categorias(nombre,estado)  VALUES ( 'Frutas Y Verduras', 1);
INSERT  INTO Categorias(nombre,estado)  VALUES ( 'Bebidas', 1);
INSERT  INTO Categorias(nombre,estado)  VALUES ( 'Bebidas Alcoholicas', 1);
INSERT  INTO Categorias(nombre,estado)  VALUES ( 'Carnes y Embudos',1);
INSERT  INTO Categorias(nombre,estado)  VALUES ( 'Hiegene Personal', 1);
INSERT  INTO Categorias(nombre,estado)  VALUES ( 'Uso Domestico',1);

INSERT  INTO  Clientes(nombre,apellido,nacimiento,dni,estado) VALUES ( 'charles', 'dummar', '12/3/2000', '58475263', 1);
INSERT  INTO  Clientes(nombre,apellido,nacimiento,dni,estado) VALUES ( 'paulina', 'rubio', '09/6/2000', '12345678', 1);
INSERT  INTO  Clientes(nombre,apellido,nacimiento,dni,estado) VALUES ( 'mariana', 'contreras','03/2/2000', '12246357', 1);
INSERT  INTO  Clientes(nombre,apellido,nacimiento,dni,estado) VALUES ( 'jorge', 'templas','22/11/2000',  '27277728',1);
INSERT  INTO  Clientes(nombre,apellido,nacimiento,dni,estado) VALUES ( 'mario', 'carranza', '18/1/2000', '00177728', 1);

INSERT INTO Proveedores(ruc,nomempresa,nombrecontacto,apellidocontacto,telefonocontacto,direccionempresa,estado) VALUES ( '10779153474', 'Kamida', 'juaquina', 'Aliaga montero', '970271929', 'av.alcomar',1);
INSERT INTO Proveedores(ruc,nomempresa,nombrecontacto,apellidocontacto,telefonocontacto,direccionempresa,estado) VALUES ( '20376816100', 'Makro', 'Elizabeth', 'vance', '950315723', 'Av. Circunvalacion 708a', 1);

INSERT INTO Productos(nombre,descripcion,preciounit,stock,idcategoria,estado) VALUES   ( 'Azúcar', 'bolsa', 1, 134, 1,1);
INSERT INTO Productos(nombre,descripcion,preciounit,stock,idcategoria,estado)  VALUES   ('Cafés', 'sobre', 1.2, 100, 1, 1);
INSERT INTO Productos(nombre,descripcion,preciounit,stock,idcategoria,estado)  VALUES   ( 'Harina', 'paquete', 1.6, 430, 2, 1);
INSERT INTO Productos(nombre,descripcion,preciounit,stock,idcategoria,estado)  VALUES   ( 'pañal', 'suelto', 1.5, 70, 11, 1);

INSERT  INTO Compras(idproveedor,fecha,importetotal) VALUES( 'PV000001', '18/10/2020', 40);

INSERT INTO empleados(dni,nombre,apellido,genero,nacimiento,telefono,correo,direccion,usuario,contraseña,idcargo,estado) VALUES ( '70809248', 'yaneli Elvita', 'Carpio Arevalo', 'femenino', '9/7/2000', '999999999', 'yaneli.c.are@gmail.com', 'Comas-San felipe', 'yaneli', '12345', 1,1);
INSERT INTO empleados(dni,nombre,apellido,genero,nacimiento,telefono,correo,direccion,usuario,contraseña,idcargo,estado) VALUES ( '70855558', 'jenifer diana', 'Bustamante Gonzales', 'femenino', '12/1/2001', '997758999', 'jenifer@gmail.com', 'independencia', 'jeni', '12345', 1,1);

INSERT INTO Ventas(fecha,idempleado,importtotal,idcliente) VALUES   ( '18/9/2000','EM000001', 42.4, 'CL000001');

INSERT  INTO DETALLECOMPRA(idcompra,idproducto,cantidad,preciounit) VALUES ('C000001', 'PR000001', 40, 0.5);
INSERT  INTO DETALLECOMPRA(idcompra,idproducto,cantidad,preciounit) VALUES  ('C000001', 'PR000002', 20, 0.5);
INSERT  INTO DETALLECOMPRA(idcompra,idproducto,cantidad,preciounit) VALUES ('C000001', 'PR000003', 10, 1);

INSERT  INTO DetalleVenta(idventa,idproducto,cantidad,preciounit) VALUES  ('V000001', 'PR000002', 2,1.2);
INSERT  INTO DetalleVenta(idventa,idproducto,cantidad,preciounit)  VALUES ('V000001', 'PR000001',40,1);


alter table CLIENTES add constraint ck_c_dni check (regexp_like(DNI,'[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'));

select * from clientes
/*----------------------------------------------*/
 /*
 select * from compras;
 select * from detallecompra;
 select * from productos;
 */
/*----------------------------------------------*/


/*
drop view LOGINEMPLEADO;
drop view SEL_PRODUCTOS;
drop view listarEmpleado ;
drop view listarProductos;
drop view listarcliente;
drop view listarprov;
*/

CREATE OR REPLACE VIEW LOGINEMPLEADO as(
select e.idempleado,e.dni,e.nombre,e.apellido,e.genero,e.nacimiento
 ,e.telefono,e.correo,e.direccion,e.usuario,e.contraseña,e.idcargo,e.estado, c.nombre CARGONAME 
from empleados e
inner join cargos c on
e.idcargo = c.idcargo
);

/*----------------------------------------------*/

CREATE OR REPLACE  VIEW SEL_PRODUCTOS
AS(
SELECT p.idProducto as "Codigo",p.nombre as "Producto",p.descripcion "Descripcion",p.precioUnit "Precio",
	p.stock AS "Stock",c.nombre as "Categoria"
	FROM PRODUCTOS p 
	inner join Categorias c on p.idCategoria = c.idCategoria where p.Estado =1
	
);

/*----------------------------------------------*/
CREATE OR REPLACE VIEW listarEmpleado as(
    Select 
    E.IDEMPLEADO CODI,E.DNI DNI,E.NOMBRE NOMBRE,E.APELLIDO APELLIDOS,
    E.GENERO GEN, TO_CHAR(E.NACIMIENTO,'dd-MM-yyyy') na,E.TELEFONO TEL, E.CORREO CORREO, E.DIRECCION DIREC,
    E.USUARIO USUARIO,E.CONTRASEÑA CONT,
    C.NOMBRE CARGO,
    E.estado ESTADO 
    from empleados E
    inner join cargos c on c.idcargo=e.idcargo 
    where e.estado <> 0
    );
   
/*----------------------------------------------*/
CREATE OR REPLACE VIEW  listarProductos as (
    Select p.idproducto,p.nombre NOMBRE,p.descripcion Descripcion,p.preciounit preciounit,p.stock,c.nombre CATGEORIA ,p.estado ESTADO
    from productos p
    inner join categorias c on c.idcategoria=p.idcategoria 
    where p.estado <>0
    );
    
/*----------------------------------------------*/
create or replace view listarcliente as(
select IDCLIENTE id,NOMBRE nm,APELLIDO ap,TO_CHAR(NACIMIENTO,'dd-MM-yyyy') NAC ,DNI dn,ESTADO  from clientes
where estado <> 0
);

/*----------------------------------------------*/
create or replace view listarprov as(
select idproveedor, ruc ru,nomempresa ne,nombrecontacto nc,apellidocontacto ap,telefonocontacto tc,direccionempresa de
from proveedores
where estado <> 0
);

/*----------------------------------------------*/

Create or replace view RV as(
select v.idventa,e.nombre ||' '|| e.apellido NB_EMPLE,TO_CHAR(v.fecha,'dd-MM-yyyy') fecha,c.nombre ||' '|| c.apellido NB_CLIENTE,v.importtotal
from ventas v
inner join empleados e on e.idempleado= v.idempleado
inner join clientes c on c.idcliente = v.idcliente
);
/*----------------------------------------------------*/
Create or replace view RDV as(
select dv.idventa, p.nombre PRODUCTO,dv.cantidad,dv.preciounit,dv.importe
from detalleventa dv
inner join productos p on p.idproducto= dv.idproducto
);

/*----------------------------------------------*/
select * from compras;
Create or replace view RC as(
select c.idcompra,p.nombrecontacto || ' ' ||p.apellidocontacto NOMPROV,p.ruc,TO_CHAR(c.fecha,'dd-MM-yyyy') fecha,c.importetotal
from compras c
inner join proveedores p on p.idproveedor = c.idproveedor
);
/*----------------------------------------------------*/
Create or replace view RDC as(
select dc.idcompra, p.nombre PRODUCTO,dc.cantidad,dc.preciounit,dc.importe
from detallecompra dc
inner join productos p on p.idproducto= dc.idproducto
);

/*PROC
drop procedure DEL_Cliente;
drop procedure DEL_Proveedor;
drop procedure DEL_EMPLEADO;
drop procedure DEL_Producto;
drop procedure DEL_CateProductos;
drop procedure ins_empleados;
drop procedure ins_producto;
drop procedure ins_proveedores;
drop procedure ins_categoria;
drop procedure ins_compra;
drop procedure ins_detcompra;
drop procedure upd_EMPLEADO;
drop procedure upd_producto;
drop procedure upd_cliente;
drop procedure upd_proveedor;
*/
create or replace PROCEDURE DEL_Cliente(
    COD IN varchar2
)IS
BEGIN
    UPDATE CLIENTES SET ESTADO = 0 WHERE  IDCLIENTE=COD;
END;

/*----------------------------------------------*/
CREATE OR REPLACE PROCEDURE DEL_Proveedor(
    COD IN varchar2
)IS
BEGIN
    UPDATE PROVEEDORES SET ESTADO =0 WHERE IDPROVEEDOR=COD;
END;

/*----------------------------------------------*/

CREATE OR REPLACE PROCEDURE DEL_EMPLEADO(
    COD IN varchar2,
    LOGIN IN VARCHAR2
    )IS
    EXISTE NUMBER;
BEGIN
    SELECT COUNT(USUARIO) INTO EXISTE FROM EMPLEADOS WHERE LOGIN='admin';
    IF EXISTE>0 THEN
        RAISE_APPLICATION_ERROR(-20001,'No se puede eliminar el usuario "admin"');
    ELSE
        UPDATE EMPLEADOS SET ESTADO = 0 WHERE IDEMPLEADO=COD AND LOGIN<>'admin';
    END IF;
END;


/*----------------------------------------------*/
CREATE OR REPLACE PROCEDURE DEL_Producto(
    COD IN VARCHAR2
)IS
BEGIN
    UPDATE PRODUCTOS SET ESTADO = 0 WHERE IDPRODUCTO=COD;
END;

/*----------------------------------------------*/
CREATE OR REPLACE PROCEDURE DEL_CateProductos(
    NOM IN VARCHAR2
)IS
BEGIN
    UPDATE CATEGORIAS SET ESTADO = 0 WHERE NOMBRE=NOM;
END;

/*----------------------------------------------*/

CREATE OR REPLACE PROCEDURE ins_empleados(
doc IN empleados.dni%type,   
nom IN empleados.nombre%TYPE,
ape IN empleados.apellido%TYPE,
gen IN empleados.genero%TYPE,
nac IN  date,
tel IN  empleados.telefono%TYPE,
ema IN empleados.correo%TYPE,
di IN empleados.direccion%TYPE,
usu IN empleados.usuario%TYPE,
contra IN empleados.contraseña%TYPE,
car  IN empleados.idcargo%TYPE
) IS 
    usuarios empleados.usuario%TYPE;
    telefonos empleados.telefono%TYPE;
    CURSOR nombre2 IS SELECT usuario,telefono INTO usuarios,telefonos FROM empleados;
    datos_iguales EXCEPTION;
    BEGIN
    OPEN nombre2;
    LOOP
        FETCH nombre2 INTO usuarios,telefonos;
        IF usuarios = usu THEN 
        RAISE datos_iguales;
        ELSIF telefonos = tel THEN 
        RAISE datos_iguales;
        END IF;
        EXIT WHEN nombre2%notfound ;
    END LOOP;
    CLOSE nombre2;
      
    INSERT INTO empleados(DNI,NOMBRE,APELLIDO,GENERO,NACIMIENTO,TELEFONO,CORREO,DIRECCION,USUARIO,CONTRASEÑA,IDCARGO,ESTADO) VALUES (doc,nom,ape,gen,TO_CHAR(nac,'dd-MM-yyyy'),tel,ema,di,usu,contra,car,1);
        EXCEPTION 
        WHEN datos_iguales THEN 
        dbms_output.put_line('No Puede Insertar Datos Iguales');
        raise_application_error(-20343,'No Puede Insertar Datos Iguales, Error en: ' || usu ||' ' || tel );
  END ins_empleados;

/*----------------------------------------------*/
CREATE OR REPLACE PROCEDURE ins_producto(
    nom IN productos.nombre%TYPE, des IN productos.descripcion%TYPE,
    prec IN productos.preciounit%TYPE, idcat IN productos.idcategoria%TYPE
    ) IS 
    nombres productos.nombre%TYPE;
     CURSOR nombre2 
     IS SELECT nombre
    
    INTO nombres FROM productos;
    datos_iguales EXCEPTION;
    BEGIN
    OPEN nombre2;
    LOOP
        FETCH nombre2 INTO nombres;
        IF nombres = nom THEN 
        RAISE datos_iguales;
        END IF;
        EXIT WHEN nombre2%notfound ;
    END LOOP;
    CLOSE nombre2;
       INSERT INTO productos(nombre,descripcion,preciounit,idcategoria,estado) VALUES (nom,des,prec,idcat,1);
        EXCEPTION 
        WHEN datos_iguales THEN 
        dbms_output.put_line('No Puede Insertar Datos Iguales Al Registro');
         raise_application_error(-20343,'No Puede Insertar Datos Iguales Al Registro');
END ins_producto;

/*----------------------------------------------*/
CREATE OR REPLACE PROCEDURE ins_proveedores (
 rucs IN proveedores.ruc%TYPE, empre IN proveedores.nomempresa%TYPE,
 nomc IN proveedores.nombrecontacto%TYPE,apec IN proveedores.apellidocontacto%TYPE,
 tel IN proveedores.telefonocontacto%TYPE,dic  IN proveedores.direccionempresa%TYPE
) IS 
    rut proveedores.ruc%TYPE;
    est proveedores.estado%TYPE;
    CURSOR nombre2 IS SELECT ruc,estado INTO rut,est FROM proveedores;
    datos_iguales EXCEPTION;
    BEGIN
    OPEN nombre2;
    LOOP
        FETCH nombre2 INTO rut,est;
        IF rut = rucs AND est =1 THEN 
        RAISE datos_iguales;
        END IF;
        EXIT WHEN nombre2%notfound ;
    END LOOP;
    CLOSE nombre2;
    INSERT INTO proveedores(ruc,nomempresa,nombrecontacto,apellidocontacto,telefonocontacto,direccionempresa,estado)
    VALUES (rucs,empre,nomc,apec,tel,dic,1);
        EXCEPTION 
        WHEN datos_iguales THEN 
         dbms_output.put_line('No Puede Insertar Datos Iguales Al Registro');
         raise_application_error(-20343,'No Puede Insertar Datos Iguales Al Registro');
    END ins_proveedores;
    
/*----------------------------------------------*/

CREATE OR REPLACE PROCEDURE ins_cliente(
nom IN clientes.nombre%TYPE,
ape IN clientes.apellido%TYPE,
nac IN  date,
doc IN clientes.dni%type   
) IS 
   
    dnis clientes.dni%TYPE;
    CURSOR nombre2 IS SELECT dni INTO dnis FROM clientes;
    datos_iguales EXCEPTION;
    BEGIN
    OPEN nombre2;
    LOOP
        FETCH nombre2 INTO dnis;
        IF dnis = doc THEN 
        RAISE datos_iguales;
        END IF;
        EXIT WHEN nombre2%notfound ;
    END LOOP;
    CLOSE nombre2;
      
    INSERT INTO clientes(NOMBRE,APELLIDO,NACIMIENTO,DNI,ESTADO) VALUES (nom,ape,TO_CHAR(nac,'dd-MM-yyyy'),doc,1);
        EXCEPTION 
        WHEN datos_iguales THEN 
        dbms_output.put_line('No Puede Insertar Datos Iguales');
        raise_application_error(-20343,'No Puede Insertar Datos Iguales, Error en: ' || doc );
  END ins_cliente;
/*----------------------------------------------*/
create or replace PROCEDURE ins_categoria(
    des IN categorias.nombre%TYPE
    ) 
    IS 
    descrip categorias.nombre%TYPE;
    CURSOR nombre2 IS SELECT nombre INTO descrip FROM categorias;
    datos_iguales EXCEPTION;
    BEGIN
    OPEN nombre2;
    LOOP
        FETCH nombre2 INTO descrip;
           IF descrip = des THEN 
        RAISE datos_iguales;
        END IF;
        EXIT WHEN nombre2%notfound ;
    END LOOP;
    CLOSE nombre2;
    INSERT INTO categorias(NOMBRE,ESTADO) VALUES (des,1);
        EXCEPTION 
        WHEN datos_iguales THEN 
         dbms_output.put_line('No Puede Insertar Datos Iguales Al Registro');
        raise_application_error(-20343,'No Puede Insertar Datos Iguales Al Registro');
    END ins_categoria;

/*----------------------------------------------
select * from compras;
select * from detallecompra;
select * from proveedores;
select * from productos;
execute ins_compra('PV000001');
execute ins_detcompra('C000003','PR000003',2,3);*/


create or replace PROCEDURE ins_compra(
    cp IN compras.idproveedor%TYPE,
    it in compras.importetotal%TYPE
    ) 
    IS 
BEGIN
    INSERT INTO COMPRAS(idproveedor,fecha,importetotal) VALUES (CP,sysdate,it);
END ins_compra;

/*----------------------------------------------*/

create or replace PROCEDURE ins_detcompra(
    cc IN DETALLECOMPRA.idcompra%TYPE,
    cp IN DETALLECOMPRA.idproducto%TYPE,
    cant IN DETALLECOMPRA.cantidad%TYPE,
    pu IN DETALLECOMPRA.preciounit%TYPE
    ) 
    IS 
BEGIN
    INSERT INTO DETALLECOMPRA(idcompra,idproducto,cantidad,preciounit) VALUES (CC,CP,cant,pu);
END ins_detcompra;

/*----------------------------------------------
select * from ventas;
select * from detalleventa;
select * from proveedores;
select * from productos;*/
create or replace PROCEDURE ins_venta(
    ce IN ventas.idempleado%TYPE,
    it in ventas.importtotal%TYPE,
    cc in ventas.idcliente%TYPE
    ) 
    IS 
BEGIN
    INSERT INTO ventas(fecha,idempleado,importtotal,idcliente) VALUES (sysdate,ce,it,cc);
END ins_venta;

/*----------------------------------------------*/

create or replace PROCEDURE ins_detventa(
    cv IN detalleventa.idventa%TYPE,
    cp IN detalleventa.idproducto%TYPE,
    cant IN detalleventa.cantidad%TYPE,
    pr in detalleventa.preciounit%TYPE
    ) 
    IS 
BEGIN
    INSERT INTO detalleventa(idventa,idproducto,cantidad,preciounit) VALUES (CV,CP,cant,pr);
END ins_detventa;
/*----------------------------------------------*/

CREATE OR REPLACE PROCEDURE upd_EMPLEADO
(
  ide IN empleados.idempleado%TYPE,doc IN empleados.dni%TYPE,   
  nom IN empleados.nombre%TYPE, ape IN empleados.apellido%TYPE, gen IN empleados.genero%TYPE, nac IN  empleados.nacimiento%TYPE,
  tel IN  empleados.telefono%TYPE,ema IN empleados.correo%TYPE,di IN empleados.direccion%TYPE,
  usu IN empleados.usuario%TYPE,contra IN empleados.contraseña%TYPE,car  IN empleados.idcargo%TYPE
 )
 IS
   nombres empleados.nombre%TYPE:=nom  ;apellidos empleados.apellido%TYPE:=ape;
   generos empleados.genero%TYPE:=gen  ;nacimientos empleados.nacimiento%TYPE:=nac;
   telelefonos empleados.telefono%TYPE:=tel ; emails empleados.correo%TYPE:=ema;
   direccions empleados.direccion%TYPE:=di ;usuarios empleados.usuario%TYPE:=usu;
   contraseñas empleados.contraseña%TYPE:=contra ;cargos empleados.idcargo%TYPE:=car;

  CURSOR c_tra IS
  SELECT nombre,apellido,genero,nacimiento,telefono,correo,direccion,usuario,contraseña,idcargo
  INTO nombres,apellidos,generos,nacimientos,telelefonos,emails,direccions,usuarios,contraseñas,cargos 
  FROM  empleados 
  WHERE idempleado = ide;
  datos_no_actualizados EXCEPTION;
  BEGIN 

 update empleados SET nombre = nombres,apellido=apellidos,genero=generos
 ,nacimiento=nacimientos,telefono=telelefonos,correo=emails,direccion=direccions
 ,usuario=usuarios,contraseña=contraseñas,idcargo=cargos 
  WHERE idempleado = ide;
        IF SQL%notfound THEN
            RAISE datos_no_actualizados;
        END IF;     
  EXCEPTION 
  WHEN datos_no_actualizados THEN
   dbms_output.put_line('No se pudo actualizar');
END upd_EMPLEADO;

/*----------------------------------------------*/
CREATE OR REPLACE PROCEDURE upd_producto(
  idpro IN productos.idproducto%TYPE,
  nom IN productos.nombre%TYPE,
  des IN productos.descripcion%TYPE,
  prec IN productos.preciounit%TYPE,
  idcat IN  productos.idcategoria%TYPE
  )
  IS
  datos_no_actualizados EXCEPTION;
  BEGIN 
  UPDATE productos SET nombre = nom,preciounit = prec, descripcion = des, idcategoria = idcat
  WHERE idproducto = idpro;
  IF SQL%notfound THEN
  RAISE datos_no_actualizados;
  END IF;
  EXCEPTION 
  WHEN datos_no_actualizados THEN
   dbms_output.put_line('No se puedo actualizar');
  END upd_producto;


/*----------------------------------------------*/
CREATE OR REPLACE PROCEDURE upd_proveedor(
 cod IN proveedores.idproveedor%TYPE,
 rucs IN proveedores.ruc%TYPE, 
 empre IN proveedores.nomempresa%TYPE,
 nomc IN proveedores.nombrecontacto%TYPE,
 apec IN proveedores.apellidocontacto%TYPE,
 tel IN proveedores.telefonocontacto%TYPE,
 dic  IN proveedores.direccionempresa%TYPE)
IS 
 datos_no_actualizados EXCEPTION;
 BEGIN
 UPDATE proveedores SET nomempresa=empre,ruc=rucs,nombrecontacto=nomc,
 apellidocontacto=apec,telefonocontacto=tel,direccionempresa=dic WHERE idproveedor=cod;
 COMMIT;
 IF SQL%rowcount<0 THEN
            RAISE datos_no_actualizados;
        END IF;  
 EXCEPTION
 WHEN datos_no_actualizados THEN
     dbms_output.put_line('No se puedo actualizar');
END upd_proveedor;


/*----------------------------------------------*/

CREATE OR REPLACE PROCEDURE upd_cliente (
cod IN VARCHAR2,
nom IN VARCHAR2,
ape IN VARCHAR2,
nac date,
dn IN VARCHAR2)
IS 
datos_no_actualizados EXCEPTION;
BEGIN 
UPDATE clientes SET nombre=nom,apellido=ape,nacimiento=nac,dni=dn WHERE idcliente=cod;
COMMIT;
 IF SQL%notfound THEN
            RAISE datos_no_actualizados;
        END IF;  
EXCEPTION
WHEN datos_no_actualizados THEN
     dbms_output.put_line('No se puedo actualizar');
END upd_cliente; 
   

/*----------------------------------------------*/
select * from ventas;

create or replace procedure  BUSXFECHAVENTA(
 fecha1 date,
 fecha2 date
)is
 aa varchar(100);
 b varchar2(100);
 f1 date;
 f2 varchar2(100);
 ede float;
begin
select v.idventa idventa,e.nombre ||' '|| e.apellido NB_EMPLE,TO_CHAR(v.fecha,'dd-MM-yyyy') fecha,c.nombre ||' '|| c.apellido NB_CLIENTE,v.importtotal
 into aa,b,f1,f2,ede from ventas v
inner join empleados e on e.idempleado= v.idempleado
inner join clientes c on c.idcliente = v.idcliente
where fecha >= fecha1 and fecha <= fecha2;

 raise_application_error(-20343,'jeje ' ||f1 );
end BUSXFECHAVENTA;


drop procedure upd_EMPLEADO;


CREATE OR REPLACE PROCEDURE upd_EMPLEADO
(
  ide IN empleados.idempleado%TYPE,
  doc IN empleados.dni%TYPE,   
  nom IN empleados.nombre%TYPE, 
  ape IN empleados.apellido%TYPE, 
  gen IN empleados.genero%TYPE, 
  nac IN  empleados.nacimiento%TYPE,
  tel IN  empleados.telefono%TYPE,
  ema IN empleados.correo%TYPE,
  di IN empleados.direccion%TYPE,
  usu IN empleados.usuario%TYPE,
  contra IN empleados.contraseña%TYPE,
  car  IN empleados.idcargo%TYPE
 )
 IS
   dnis empleados.dni%TYPE:=doc;
   nombres empleados.nombre%TYPE:=nom  ;
   apellidos empleados.apellido%TYPE:=ape;
   generos empleados.genero%TYPE:=gen  ;
   nacimientos empleados.nacimiento%TYPE:=nac;
   telelefonos empleados.telefono%TYPE:=tel ; 
   emails empleados.correo%TYPE:=ema;
   direccions empleados.direccion%TYPE:=di ;
   usuarios empleados.usuario%TYPE:=usu;
   contraseñas empleados.contraseña%TYPE:=contra ;
   cargos empleados.idcargo%TYPE:=car;

  CURSOR c_tra IS
  SELECT dni,nombre,apellido,genero,nacimiento,telefono,correo,direccion,usuario,contraseña,idcargo
  INTO dnis,nombres,apellidos,generos,nacimientos,telelefonos,emails,direccions,usuarios,contraseñas,cargos 
  FROM  empleados 
  WHERE idempleado = ide;
  datos_no_actualizados EXCEPTION;
  BEGIN 

 update empleados SET dni=dnis,nombre = nombres,apellido=apellidos,genero=generos
 ,nacimiento=nacimientos,telefono=telelefonos,correo=emails,direccion=direccions
 ,usuario=usuarios,contraseña=contraseñas,idcargo=cargos 
  WHERE idempleado = ide;
        IF SQL%notfound THEN
            RAISE datos_no_actualizados;
        END IF;     
  EXCEPTION 
  WHEN datos_no_actualizados THEN
   dbms_output.put_line('No se pudo actualizar');
END upd_EMPLEADO;

/*----------------------------------------------*/
---
--- ACTUALIZACIÓN 18/06/2021
---
/*----------------------------------------------*/

ALTER TABLE VENTAS ADD SERIE VARCHAR(3);
ALTER TABLE VENTAS ADD NUMERACION VARCHAR(7);
/*----------------------------------------------*/
CREATE OR REPLACE VIEW  MAXSERIE as (
Select MAX((TO_NUMBER(SERIE))) as SERIE FROM VENTAS
);
CREATE OR REPLACE VIEW  MAXNUMERACION as (
Select MAX((TO_NUMBER(NUMERACION))) as NUMERACION FROM VENTAS WHERE SERIE = (SELECT MAX(SERIE) FROM VENTAS)
);
create or replace PROCEDURE ins_venta(
    ce IN ventas.idempleado%TYPE,
    it in ventas.importtotal%TYPE,
    cc in ventas.idcliente%TYPE,
    ns in ventas.serie%TYPE,
    nn in ventas.numeracion%TYPE
    ) 
    IS 
BEGIN
    INSERT INTO ventas(fecha,idempleado,importtotal,idcliente,serie,numeracion) VALUES (sysdate,ce,it,cc,ns,nn);
END ins_venta;


Create or replace view RV as(
select v.idventa,e.nombre ||' '|| e.apellido NB_EMPLE,TO_CHAR(v.fecha,'dd-MM-yyyy') fecha,c.nombre ||' '|| c.apellido NB_CLIENTE, v.serie||'-'||v.numeracion NB_FACTURA, v.importtotal
from ventas v
inner join empleados e on e.idempleado= v.idempleado
inner join clientes c on c.idcliente = v.idcliente
);


/*----------------------------------------------*/
---
--- ACTUALIZACIÓN 23/06/2021
---
/*----------------------------------------------*/

create or replace PROCEDURE ins_venta(
    ce IN ventas.idempleado%TYPE,
    it in ventas.importtotal%TYPE,
    cc in ventas.idcliente%TYPE,
    ns in ventas.serie%TYPE,
    nn in ventas.numeracion%TYPE
    ) 
    IS 
BEGIN
    INSERT INTO ventas(fecha,idempleado,importtotal,idcliente,serie,numeracion,estado) VALUES (sysdate,ce,it,cc,ns,nn,'PAGADO');
END ins_venta;


ALTER TABLE VENTAS ADD ESTADO VARCHAR(50);
--- PAGADO !
--- CANCELADO!

create or replace PROCEDURE actualizar_boleta(
    datas varchar2
    ) 
    IS 
BEGIN
   FOR producto_rec IN (
        SELECT idproducto,cantidad
          FROM detalleventa
         WHERE idventa=datas)
   LOOP
     --- DBMS_OUTPUT.put_line (employee_rec.idproducto);
     update productos set stock = stock+producto_rec.cantidad where idproducto=producto_rec.idproducto;
     DBMS_OUTPUT.put_line ('DATA: '|| producto_rec.idproducto || ' ' || producto_rec.cantidad);
   END LOOP;
   update ventas set estado = 'CANCELADO' where idventa=datas;
END actualizar_boleta;


Create or replace view RV as(
select v.idventa,e.nombre ||' '|| e.apellido NB_EMPLE,TO_CHAR(v.fecha,'dd-MM-yyyy') fecha,c.nombre ||' '|| c.apellido NB_CLIENTE, v.serie||'-'||v.numeracion NB_FACTURA, v.importtotal, v.estado
from ventas v
inner join empleados e on e.idempleado= v.idempleado
inner join clientes c on c.idcliente = v.idcliente
);

Create or replace view RVD as(
select v.idventa,e.nombre ||' '|| e.apellido NB_EMPLE,TO_CHAR(v.fecha,'dd-MM-yyyy') fecha,c.nombre ||' '|| c.apellido NB_CLIENTE, v.serie||'-'||v.numeracion NB_FACTURA, v.importtotal, v.estado
from ventas v
inner join empleados e on e.idempleado= v.idempleado
inner join clientes c on c.idcliente = v.idcliente
where v.estado <> 'CANCELADO'
);


ALTER VIEW RVD
COMPILE;





