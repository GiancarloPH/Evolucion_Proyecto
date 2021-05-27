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