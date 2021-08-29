CREATE DATABASE IBM;
USE IBM;
CREATE TABLE proveedores (
  id_proveedor INT(2) NOT NULL PRIMARY KEY,
  nombre VARCHAR(50) NOT NULL,
  fecha_alta DATE NOT NULL,
  id_cliente INT(2) NOT NULL);
  
INSERT INTO proveedores VALUES (1,'Coca-cola', '2012-06-07',5);
INSERT INTO proveedores VALUES (2,'Pepsi', '2013-10-12',5);
INSERT INTO proveedores VALUES (3,'Redbull', '2015-01-20',6);