
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