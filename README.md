# Supermarket
> Mision TIC - Universidad de Caldas

> Ferney Vanegas Hérnández

> Un sencillo programa de conexioń a Bases de Datos con Java usando JDBD.

## Contexto
En un supermercado lo contratan para analizar las necesidades que allí se presentan y le solicitan que diseñe un modelo entidad relación para la base de datos que desarrollarán más adelante. A continuación se presentan los requerimientos técnicos que se han obtenido a través de una entrevista.

Se ha sabido que el supermercado necesita administrar los siguientes datos del proveedor: NIT, razón social, dirección, teléfono, correo electrónico, representante legal y sitio web. También se requiere administrar los datos de los clientes, solicitándole el documento de identidad, el nombre, los apellidos, la dirección de entrega y el correo electrónico, además se obtendrá el teléfono, pero puede tener varios teléfonos de contacto.La dirección del cliente y del proveedor se compone de calle/carrera, número, barrio y ciudad. 

Un producto tiene un id único, nombre, precio actual, existencia y el id del proveedor que lo ofrece. Cada producto pertenece a una categoría, la categoría tiene un id único, el nombre y una descripción general.

El contador del supermercado anotó que es necesario registrar la información de las venta, guardando un id único, la fecha de la venta, el id del cliente que realiza la compra, el valor del descuento (si aplica, en caso de que no se tendrá un valor predeterminado de 0), y ﬁnalmente se debe guardar el valor total. Cada venta puede tener un conjunto de productos asociados.

Además, el supermercado ha generado estrategias de pago, las cuales pueden ser a crédito generando un porcentaje de interés a cada uno de los clientes de forma individual. También se puede  hacer el pago mediante efectivo o si se considera mediante un datáfono con tarjeta débito o tarjeta crédito. Este tipo de pago debe almacenarse para un reporte de pagos por cada tipo. 

## Código
* El Software satisface todo lo requerido. 
* Se incluye una consulta sencilla de reportes, solamente para mostrar los productos adquiridos por un cliente. Pero las posibilidades de consultas son muchas más.

## Version Estable
* 1.0.1
