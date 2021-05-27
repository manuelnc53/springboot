# INSTRUCCIONES DE INSTALACIÓN

_Instrucciones de instalación para el sistema de la prueba técnica de Stacktrace._

# Requerimientos del sistema

- Sistema operativo: Windows 10
- Java 8
- Spring-boot 2.5
- MySQL Server 8.0

# Instalación

- Clonar repositorio [https://github.com/manuelnc53/springboot](https://github.com/manuelnc53/springboot)
- Cambiar la configuración de acceso a su base de datos en el archivo **application.properties** ubicado en **.\src\main\resources\application.properties** dentro del proyecto raíz.

![](RackMultipart20210527-4-16bp12z_html_9a860eca8752bfdd.png)

Coloque su nombre de usuario y contraseña de su base de datos local o remota.

- Ejecutar los scripts creacion\_db.sql y carga\_db.sql en la consola de MySQL Server (Se puede usar un software cómo MySql Workbench)
- Entrar a la consola de Windows y ejecutar el siguiente comando
  - cmd spring-boot:run

- Probar funcionalidades con Postman [https://www.getpostman.com/collections/58252559b1c9bc5d2adb](https://www.getpostman.com/collections/58252559b1c9bc5d2adb)

#### 1
