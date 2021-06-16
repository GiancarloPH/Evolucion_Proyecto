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