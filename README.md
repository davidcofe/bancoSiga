# bancoSiga
Software Design &amp; Architecture - Bank Simulation with Spring Boot.

David Corzo, Luis Bernal, Jorge Anaya.

El programa de Banco Siga se encarga de poder crear nuevos clientes para el uso del banco, a estos mismos podemos crearles cuentas bancarias, de tipo ahorro, credito y corriente, con dichas cuentas ellos podran hacer diferentes tipos de transacciones donde podran depositar dinero, y con ese dinero depositado podran transferirlo, pagar cuentas y mas. 

El programa tambien tiene pruebas unitarias y de integracion para verificar que todo este funcionando como debe ser.

Al mismo tiempo, con GitHubActions, tiene implementado Continous Integration.

Se le ha agregado Jaccoco para ver un reporte de las pruebas, al mismo tiempo tiene Swagger integrado para tener acceso a todos los metodos usados en Postman.

Y se le integro el PIT de Mutation Test para que el mismo pueda mutar nuestras pruebas y darnos un reporte del mismo.

El Swagger se puede consultar en el siguiente link una vez que se corra el programa y este activo: http://localhost:8085/swagger-ui/index.html#/

Contrasena basica de localhost es 
User: bancosiga
Pass: bancosiga
