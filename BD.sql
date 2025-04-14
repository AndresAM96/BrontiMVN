DROP DATABASE IF EXISTS inventario;
CREATE DATABASE inventario;
USE inventario;

-- Usuarios
CREATE TABLE usuarios (
  cedula_usuario INT PRIMARY KEY,
  nombre VARCHAR(255) NOT NULL,
  contrasena VARCHAR(255) NOT NULL,
  rol VARCHAR(255) NOT NULL
);

-- Productos
CREATE TABLE productos (
  id_producto INT PRIMARY KEY AUTO_INCREMENT,
  nombre_producto VARCHAR(255) NOT NULL,
  descripcion VARCHAR(255) NOT NULL,
  precio_venta INT NOT NULL,
  precio_compra INT NOT NULL,
  stock INT NOT NULL,
  stock_minimo INT NOT NULL,
  tipo_despacho VARCHAR(255) NOT NULL
);

-- Proveedores
CREATE TABLE proveedores (
  id_proveedor INT PRIMARY KEY AUTO_INCREMENT,
  nombre_proveedor VARCHAR(255) NOT NULL,
  direccion VARCHAR(255) NOT NULL,
  telefono VARCHAR(255) NOT NULL,
  correo VARCHAR(255) NOT NULL
);

-- Clientes
CREATE TABLE clientes (
  id_cliente INT PRIMARY KEY AUTO_INCREMENT,
  nombre_cliente VARCHAR(255) NOT NULL,
  cedula_cliente INT NOT NULL,
  direccion VARCHAR(255) NOT NULL,
  telefono VARCHAR(255) NOT NULL
);

-- Ventas
CREATE TABLE ventas (
  id_venta INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(255),
  tipo_factura VARCHAR(255) NOT NULL,
  forma_pago VARCHAR(255) NOT NULL,
  fecha DATETIME NOT NULL,
  descripcion VARCHAR(255) NOT NULL,
  descuento VARCHAR(255) NOT NULL,
  cedula_usuario INT,
  CONSTRAINT FK_usuario FOREIGN KEY (cedula_usuario) REFERENCES usuarios (cedula_usuario) ON DELETE SET NULL
);

-- Detalle de Venta
CREATE TABLE detalle_venta (
  id_detalle INT PRIMARY KEY AUTO_INCREMENT,
  cantidad INT NOT NULL,
  precio_unitario DOUBLE NOT NULL,
  id_producto INT NOT NULL,
  id_venta INT NOT NULL,
  CONSTRAINT FK_producto FOREIGN KEY (id_producto) REFERENCES productos (id_producto),
  CONSTRAINT FK_venta FOREIGN KEY (id_venta) REFERENCES ventas (id_venta) ON DELETE CASCADE
);

-- Insertar superadministrador
INSERT INTO usuarios (cedula_usuario, nombre, contrasena, rol) VALUES
(1000000000, 'SuperAdmin', 'admin123', 'SuperAdmin');