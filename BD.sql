CREATE DATABASE inventario;
Use inventario;
CREATE TABLE usuarios (
    cedula_usuario INT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    contrasena VARCHAR(45) NOT NULL,
    rol VARCHAR(10) NOT NULL
);

CREATE TABLE proveedores (
    cedula_proveedor INT PRIMARY KEY,
    nombre_proveedor VARCHAR(100) NOT NULL,
    direccion_proveedor VARCHAR(100),
    telefono_proveedor VARCHAR(20),
    email_proveedor VARCHAR(100)
);

CREATE TABLE productos (
    id_producto INT PRIMARY KEY AUTO_INCREMENT,
    nombre_producto VARCHAR(100) NOT NULL,
    descripcion VARCHAR(500) NOT NULL,
    precio_venta DECIMAL NOT NULL,
    precio_compra DECIMAL NOT NULL,
    stock INT NOT NULL,
	stock_minimo INT NOT NULL,
    tipo_despacho varchar(100) NOT NULL
);

CREATE TABLE clientes (
    cedula_cliente INT PRIMARY KEY,
    nombre_cliente VARCHAR(100) NOT NULL,
    direccion_cliente VARCHAR(100),
    telefono_cliente VARCHAR(20),
    email_cliente VARCHAR(100)
);


CREATE TABLE ventas (
    id_venta INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    tipo_factura VARCHAR (30) NOT NULL,
    forma_pago VARCHAR (30) NOT NULL,
    fecha DATETIME NOT NULL,
    cedula_vendedor INT NOT NULL,
    cedula_cliente INT NOT NULL,
    descripcion VARCHAR(500),
    descuento VARCHAR(100),
    FOREIGN KEY (cedula_cliente) REFERENCES clientes(cedula_cliente),
    FOREIGN KEY (cedula_vendedor) REFERENCES usuarios(cedula_usuario)
);