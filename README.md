# bancoSiga
Software Design &amp; Architecture - Bank Simulation with Spring Boot.

David Corzo, Luis Bernal, Jorge Anaya.

El programa de Banco Siga se encarga de poder crear nuevos clientes para el uso del banco, a estos mismos podemos crearles cuentas bancarias, de tipo ahorro, credito y corriente, con dichas cuentas ellos podran hacer diferentes tipos de transacciones donde podran depositar dinero, y con ese dinero depositado podran transferirlo, pagar cuentas y mas. 

El programa tambien tiene pruebas unitarias y de integracion para verificar que todo este funcionando como debe ser.

Al mismo tiempo, con GitHubActions, tiene implementado Continous Integration.

Se le ha agregado Jaccoco para ver un reporte de las pruebas, al mismo tiempo tiene Swagger integrado para tener acceso a todos los metodos usados en Postman.

Y se le integro el PIT de Mutation Test para que el mismo pueda mutar nuestras pruebas y darnos un reporte del mismo.

El Swagger se puede consultar en el siguiente link una vez que se corra el programa y este activo: http://localhost:8085/swagger-ui/index.html#/

Se configuró Sonar para que reciba los porcentajes de jacoco modificando el archivo de configuracion para que Sonar lea el archivo .xml entregado por jacoco al hacer pull.

Contrasena basica de localhost es 
User: bancosiga
Pass: bancosiga

----------


## Escenario: 
Banco Siga, un banco de la Universidad de  Sabana, tiene una base de usuarios en rápido crecimiento para sus aplicaciones web. Con este crecimiento, la complejidad del código y la necesidad de una arquitectura escalable se hicieron evidentes y la necesidad de la misma se hizo clara. Los usuarios universitarios ahora exigen funciones avanzadas y los equipos de desarrollo necesitan una estructura que les permita integrar fácilmente nuevas funciones sin afectar la estabilidad del sistema. 

## Patrón de diseño seleccionado: 
Patrones de comportamiento – Observador. 

### Razón: 
Se eligió el patrón Observer  para permitir que la aplicación web del banco maneje eventos y notificaciones en tiempo real. Cuando los usuarios realizan transacciones, deben realizar acciones como actualizar saldos, generar recibos y recibir notificaciones de eventos relacionados. Los observadores permiten una comunicación eficiente entre  componentes sin tener que emparejar remitentes y receptores de  notificaciones dentro de su aplicación. 

## Requerimientos funcionales:
### Notificaciones en tiempo real: 
Descripción: La aplicación debe notificar e informar al usuario sobre transacciones exitosas, cambios de saldo y eventos importantes en tiempo real. 
Justificación: mejora la experiencia del usuario, mantiene a los clientes actualizados sobre la actividad en su cuenta, mejora la seguridad y permite una respuesta más rápida  en  caso de que una transacción no se complete. Se logra esto usando Observer

### Historial comercial: 
Descripción: Los usuarios deben tener acceso a un historial detallado de sus transacciones.  
Justificación: Facilita la auditoría y proporciona a los usuarios un registro completo de las actividades financieras en cualquier momento y  lugar. Se implemento un historial para cada usuario usando la base de datos donde puede ver todo de su cuenta.

## Requerimientos no funcionales 
### Escalabilidad: 
Descripción: La arquitectura debe ser escalable horizontalmente para adaptarse al crecimiento en el número de usuarios y transacciones en cualquier momento.  
Justificación: Garantiza que las aplicaciones puedan manejar una mayor carga sin sacrificar el rendimiento. 

### Corto tiempo de respuesta: 
Descripción: Tu aplicación debe tener tiempos de respuesta rápidos, especialmente al momento de realizar transacciones y consultar saldos. 
Justificación: Responder rápidamente a las solicitudes y acciones mejora la experiencia del usuario.


----------


## Privacidad y protección de datos: 

### Responsabilidad ética: 
Garantizar que nuestros sistemas procesen los datos personales de los clientes de forma segura y cumpliendo con las leyes de  protección de datos. 
Responsabilidades profesionales: implementar medidas de seguridad rigurosas y seguir las mejores prácticas de la industria para evitar filtraciones de datos y garantizar la confidencialidad de la información del cliente.  


### Seguridad economica: 
Responsabilidad ética: Garantizar la integridad del sistema para evitar fraudes y manipulación financiera. 
Responsabilidades laborales: mantener protocolos de seguridad actualizados, realizar auditorías periódicas y trabajar con los reguladores para garantizar la estabilidad y seguridad del sistema financiero.  


### Transparencia de la información: 
Responsabilidad ética: Proporcionar información clara y fácil de entender sobre productos financieros, tarifas,  términos y condiciones. 
Responsabilidades laborales: garantiza que la información proporcionada a los clientes sea precisa, actual y de fácil acceso. 


### Inclusión financiera: 
Responsabilidad ética: Garantizar que los sistemas sean accesibles para todos los sectores de la sociedad, evitar la discriminación y promover la inclusión financiera. 
Responsabilidades laborales: Desarrollar servicios y productos que estén disponibles y sean  beneficiosos para una amplia gama de clientes, incluidos aquellos con necesidades únicas. 


### Cumplimiento corporativo: 
Responsabilidades éticas: Cumplir con todas las leyes y regulaciones financieras y bancarias aplicables. 
Responsabilidades profesionales: mantenerse informado sobre los cambios regulatorios, cooperar con los reguladores y adoptar prácticas que promuevan la legalidad y la ética en todas las actividades bancarias.  
