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



CREATE OR REPLACE TRIGGER NOELIMINARCLIENTE 
BEFORE DELETE ON CLIENTES FOR EACH ROW
BEGIN
    RAISE_APPLICATION_ERROR(-20100, 'NO SE PUEDEN ELIMINAR COMPLETAMENTE REGISTROS DE CLIENTES');
END;




CREATE OR REPLACE TRIGGER ESTADOADMINISTRADOR
AFTER UPDATE OF ESTADO ON EMPLEADOS FOR EACH ROW
BEGIN
   
   IF :OLD.IDCARGO = 1 THEN
   raise_application_error(-20343, 'NO SE PUEDE ELIMINAR AL ADMINISTRADOR');
         UPDATE EMPLEADOS SET ESTADO = 'ACTIVO' WHERE IDEMPLEADO= :OLD.IDEMPLEADO;
    END IF;
 END;
 