# webapp12
# Video de la aplicación Angular

https://youtu.be/k-bk23OIy_I

# Fase 0

### Nombre de la aplicación web

UnderSociety



### Descripción

Es una aplicación red social en la que se puede comprar y vender todo tipo de servicios y productos dentro de la legalidad vigente. Esta aplicación permitira a los usuarios y empresas ponerse en contacto entre si, nos dará pie a comprar y vender todo tipo de servicios y productos.

### Equipo de desarrollo

| Nombre	| Email	| Github |
| --- | :---: | :---: |
| David Montero Garcia | d.montero.2018@alumnos.urjc.es	| David-pnj |
| Enrique Martín Santorcaz	| e.martins.2018@alumnos.urjc.es	| kikmar |
| Cristian Nicu Terci	| cn.terci.2018@alumno.urjc.es	| Cette88 |
| Guillermo Martín García	| g.martingarcia@alumnos.urjc.es	| Wilhelm-mar |
| Antonio Jesus Pajuelo Chavez	| aj.pajuelo.2018@alumnos.urjc.es	| Antoniopc21z |


### Trello
https://trello.com/b/cdL2Eo7t/daw-g12

### Entidades

* Usuarios
* Post
* Producto
* Mensaje

### Permisos de los usuarios

Los usuarios pueden registrarse, postear, poner a la venta productos y mandar mensajes mediante el chat.

### Imágenes

* Los usuarios registrados podrán establecer una imagen de perfil.
* Los usuarios podrán subir imagenes a los post y a los productos en venta.

### Tecnología complementaria

* Envío de correos a los usuarios.
* Creación de usuario y login con Google, Facebook o Twitter.
* Algoritmo de filtrado y de recomendados.



# Fase 1

### Capturas de pantalla

Store- En esta pantalla permitirá al usuario ver todos los productos que están a la venta así como aplicar una serie de filtros para una busqueda más concreta de los productos que desea el usuario.
![store](https://user-images.githubusercontent.com/63242688/109434197-6bb6aa80-7a14-11eb-8c22-5ab0df0c10f5.PNG)
Profile-Feed- En esta pantalla permite al usuario logueado poder cambiar algunos aspectos de su perfil como por ejemplo su foto de perfil, encabezado o cambiar la información que se encuentra en su perfil.
![profile-feed](https://user-images.githubusercontent.com/63242688/109434248-a91b3800-7a14-11eb-8597-f6fa0574b82a.PNG)

Messages- En esta pantalla se permitirá al usuario ver las notificaciones de los mensajes de los distintos perfiles, así como poder responderlos o rechazarlos.
![image](https://user-images.githubusercontent.com/58060461/109435663-c1db1c00-7a1b-11eb-8f7d-a60eff0c89ea.png)

User Profile Settings- En estas pantallas podemos apreciar las distintas funcionalidades y opciones que tenemos a la hora de modificar nuestros datos de perfil y de la cuenta.
![image](https://user-images.githubusercontent.com/58060461/109435693-f5b64180-7a1b-11eb-9bd9-3d78cad5c89e.png)

![image](https://user-images.githubusercontent.com/58060461/109435695-fcdd4f80-7a1b-11eb-9c94-58eab0d14f80.png)

![image](https://user-images.githubusercontent.com/58060461/109435699-01a20380-7a1c-11eb-876c-f60f5486f996.png)

![image](https://user-images.githubusercontent.com/58060461/109435701-06ff4e00-7a1c-11eb-933b-9972d277a52d.png)

Company Profile- En esta pantalla podemos observar el perfil de la compañia elegida en la anterior ventana:"Company". En este perfil se observa la información
de la compañia a si como sus productos.
![image](https://user-images.githubusercontent.com/61882320/109435780-77a66a80-7a1c-11eb-9a77-4f2620ddbfee.png)

![image](https://user-images.githubusercontent.com/61882320/109435792-7ffea580-7a1c-11eb-923a-3b65503e8444.png)

![image](https://user-images.githubusercontent.com/61882320/109485036-78bdb300-7a81-11eb-9fbd-b47fc8e8aa88.png)


Profiles- En esta pantalla se muestran todos los perfiles de los usuarios de la pagina ademas de poder darles "like" o enivarles un mensaje
![image](https://user-images.githubusercontent.com/39275798/109435879-fbf8ed80-7a1c-11eb-9a59-c4d206b898b7.png)

Companies- En esta pantalla se muestran todos los perfiles de las compañias de la pagina ademas de poder darles "like" o enivarles un mensaje
![image](https://user-images.githubusercontent.com/39275798/109435873-f56a7600-7a1c-11eb-8018-5cbff0f2b6c0.png)

sign-in- En esta pantalla se puede realizar el login con el usuario y contraseña.
![image](https://user-images.githubusercontent.com/45694504/109436231-d7057a00-7a1e-11eb-8164-70694070b9ca.png)

sign-up- En esta pantalla se puede realizar el registro del usuario o empresa según se elija.
![image](https://user-images.githubusercontent.com/45694504/109436301-2481e700-7a1f-11eb-8d8d-4a003bc5d728.png)

index- En esta pantalla veremos el perfil basico del usuario o la empresa, y algunos post y y post de compras que se muestren. Desde esta pantalla crearemos los post y los post de compras.
![image](https://user-images.githubusercontent.com/45694504/109436400-a4a84c80-7a1f-11eb-90a9-fbd1bade9614.png)



### Diagrama de navegación
![image](https://user-images.githubusercontent.com/61882320/109484014-321b8900-7a80-11eb-8e62-035badc29783.png)






# Fase 2
### Navegación
### Prueba de documentación
https://raw.githack.com/CodeURJC-DAW-2020-21/webapp12/develop/api-docs/api-docs.html

Store: en esta pantalla el usuario podra ver todos los diferentes productos que podrá comprar con sus descripciones, titulo, imagen, costo, estado(In stock,reserved,sold), a la izquierda estan los buscadores para encontrar alguna de las "tag" que aacabamos de mencionar tambien se le puede seguir al producto o enviar un mensaje a la compañia o usuario que lo ha colgado.
![image](https://user-images.githubusercontent.com/61882320/111917842-6207ec00-8a82-11eb-9863-ef0e502a4b09.png)

![image](https://user-images.githubusercontent.com/61882320/111917976-0853f180-8a83-11eb-8c7b-9e0329ecd285.png)

Profile-feed: aqui el usuario puede sobreescribir algunos aspectos: nombre, imagen perfil, ciudad..
![image](https://user-images.githubusercontent.com/61882320/111918030-74cef080-8a83-11eb-9333-72a3e06470a0.png)

Messages: El usuario podra enviar tanto mensajes a usuarios diferentes como a las compañias
![image](https://user-images.githubusercontent.com/61882320/111918111-d55e2d80-8a83-11eb-857b-aa7300f37307.png)

Admin page: esta pantalla es para los usuarios admin aqui se muestran las estadisticas de los productos a si como sus estados
![image](https://user-images.githubusercontent.com/61882320/111968315-4db30600-8af9-11eb-9215-6ca0aae0093a.png)

User Profile Settings: Bookmark products, en esta pantalla vemos los productos que el usuario haya seguido en la pagina store
![image](https://user-images.githubusercontent.com/61882320/111918227-63d2af00-8a84-11eb-864f-4bf9940c753a.png)

User Profile Settings: Follows, en esta pantalla todos los follows que el usuario haya seleccionado en Profile User/Company  se mostraran
![image](https://user-images.githubusercontent.com/61882320/111918308-c926a000-8a84-11eb-95b9-0eb674503c10.png)

User profile Settings: modify Information User, datos mas peronales como correo y enlaces de redes sociales, ademas de su nombre, imagen de perfil.. etc. el usuario seran capaz de cambiarlo en esta pantalla
![image](https://user-images.githubusercontent.com/61882320/111918402-35090880-8a85-11eb-8c79-efc1b5276770.png)

User Profile Settings: modify contraseña, pantalla en caso de que el usuario quiera cambiar de contraseña
![image](https://user-images.githubusercontent.com/61882320/111918471-80bbb200-8a85-11eb-8571-e53db29d08e8.png)

User Profile: Todos los usuarios en la aplicacion el usuario tiene la opcion de seleccionar cualquier perfil
![image](https://user-images.githubusercontent.com/61882320/111918557-ea3bc080-8a85-11eb-920f-2c05da9647a1.png)

View of Users Profile: aqui el usuario puede ver el perfil de otros usuarios, su posts, sus productos, su informacion, podemos enviarle mensajes y seguirle.
![image](https://user-images.githubusercontent.com/61882320/111918656-6e8e4380-8a86-11eb-8104-62b67b5a6791.png)

Comapny Profile: Todos los usuarios en la aplicacion el usuario tiene la opcion de seleccionar cualquier compañia
![image](https://user-images.githubusercontent.com/61882320/111918760-fa07d480-8a86-11eb-8037-c3553c145189.png)

View of Company Profile: aqui el usuario puede ver el perfil de las compañias, su posts, sus productos, su informacion, podemos enviarle mensajes y seguirle.
![image](https://user-images.githubusercontent.com/61882320/111918812-32a7ae00-8a87-11eb-9169-9137c87bd64b.png)

Pagina principal Home: pagina principal aqui el usuario puede ver los posts, puede subir productos y posts, darle like enviar mensajes, ver los que sigues etc..
![image](https://user-images.githubusercontent.com/61882320/111918917-a3e76100-8a87-11eb-9551-4d9d75c76429.png)

Sign-In para loguearse
![image](https://user-images.githubusercontent.com/61882320/111919003-03457100-8a88-11eb-8e78-d11b00efb062.png)

Sign up registrarse desde el inicio en la aplicacion
![image](https://user-images.githubusercontent.com/61882320/111919020-18ba9b00-8a88-11eb-9637-0d89baa1f459.png)

Forgot password: en caso de que el usuario olvide su contraseña podra poner un correo donde se le enviará la nueva contraseña
![image](https://user-images.githubusercontent.com/61882320/111968495-7dfaa480-8af9-11eb-93e7-84a958aed844.png)

En caso de que ocurra algun error se mostrará esta pantalla:
![image](https://user-images.githubusercontent.com/61882320/111968605-9ec2fa00-8af9-11eb-90ef-6f73a9e5814f.png)

###Diagrama de navegación
![image](https://user-images.githubusercontent.com/61882320/111968775-cdd96b80-8af9-11eb-8f2e-e62df7ae0339.png)



### Instrucciones de ejecución
Para instalar y ejecutar la aplicación del grupo 12 se deben seguir los siguientes pasos:
1.	Nos dirigimos al repositorio de githbub que se encuentra en este enlace: https://github.com/CodeURJC-DAW-2020-21/webapp12 (Asegurarse que nos encontramos en la rama master).
2.	Nos dirigimos a MySQL y en nuestro servidor local creamos un schema vacío llamado “under_society_db” (Es importante que este vacío para que en la primera ejecución del programa se carguen los datos de la aplicación).
3.	Una vez que tenemos descargado el proyecto, dentro del entorno de desarrollo Eclipse previamente preparado para trabajar con aplicaciones basadas en Spring, abrimos el archivo application.properties y ponemos la contraseña y usuario que tengamos en nuestra base de datos de MySql ejecutamos el programa.
4.	Sin cerrar la ejecución del programa, en nuestro navegador de confianza introducimos en la URL la siguiente dirección: https://localhost:8443/
5.	Una vez que nos cargue la pantalla de logueo, la aplicación estará lista para usarse.

Requisitos para la ejecución del programa:
-	Versión de java: 11
-	Pack de Spring Boot para Eclipse u en su defecto para el entorno de desarrollo en el que se trabaje.
-	BootStrap 3.3.7
-	JQuery 3.1.1-1
-	MySqlWorkbench 8.0.22


### Diagrama con las entidades de la base de datos
![diagramabbdd](https://user-images.githubusercontent.com/63242688/111917648-81eae000-8a81-11eb-95c5-ad1fce0573d9.png)



### Diagrama de clases y templates
Leyenda del diagrama:
- Verde: Controladores
- Morado: Vistas
- Azul: Repositorios
- Negro: Modelos
- Rojo: Servicios
- Azul claro: Configuraciones

![diagrama de clases](https://user-images.githubusercontent.com/63242688/111919104-7e0e8c00-8a88-11eb-800d-a052cf5b2e64.png)


### Participación de miembros

##### David Montero Garcia:

Este miembro del equipo se encargó de ingresar todos los datos del loader implementado: descripciones, titulos, images..etc tanto para usuarios compañias, asi como los post y productos de cada uno, también ha implementado los buscadores de store(Reserved,In stock, Sold,Keywords), por último ha arreglado algunos errores en login/register, las traducciones de algunas de las pantallas que seguian estando es español y el css en todas las pantallas para poder colocar y administrar bien las imagenes los textos etc..
   
  | Número	| Descripción	| Commit | Archivos |
   | --- | :---: | :---: | :---: |
   | #1  | CSSImages Updated	| [Ver commit](https://github.com/CodeURJC-DAW-2020-21/webapp12/commit/ffc63f842fbc2e065ffbcaeff11b614b96b6980d) | [Style.css](https://github.com/CodeURJC-DAW-2020-21/webapp12/blob/master/UnderSociety/src/main/resources/static/css/style.css) |
   | #2	| Complete Script Filter	| [Ver commit](https://github.com/CodeURJC-DAW-2020-21/webapp12/commit/99d704795e6738d7bb7ecc5504119616b970f031) | [script.js](https://github.com/CodeURJC-DAW-2020-21/webapp12/blob/master/UnderSociety/src/main/resources/static/js/script.js) |
   | #3	| LoaderImagesUserCompany | [Ver commit](https://github.com/CodeURJC-DAW-2020-21/webapp12/commit/f55d62bc44b0a54d8da4822d62cc2d00d69dfb97) | [Loader.java](https://github.com/CodeURJC-DAW-2020-21/webapp12/blob/master/UnderSociety/src/main/java/undersociety/models/Loader.java) |
   | #4	| LoaderProductsImageDescription| [Ver commit](https://github.com/CodeURJC-DAW-2020-21/webapp12/commit/d1202f45e744d9610af8f8b3be76c1bfda9b03ba) | [Loader.java](https://github.com/CodeURJC-DAW-2020-21/webapp12/blob/master/UnderSociety/src/main/java/undersociety/models/Loader.java) |
   | #5	| LoaderPostsImages	| [Ver commit](https://github.com/CodeURJC-DAW-2020-21/webapp12/commit/a701426fe6364b0a66bdec419d3f4c5e1f7f97ac) | [Loader.java](https://github.com/CodeURJC-DAW-2020-21/webapp12/blob/master/UnderSociety/src/main/java/undersociety/models/Loader.java) |
   
   
##### Enrique Martín Santorcaz:

Este miembro del equipo se encargo de la implentacion de la página de admin, asi como la creación de nuevos campos para la base de datos en relación a los tags, implementación de gran parte de clase Loader para ingresar datos en la aplicación y creación de los constructores en todas las clases para el correcto funcionamiento del programa.
   
   | Número	| Descripción	| Commit | Archivos |
   | --- | :---: | :---: | :---: |
   | #1  | Implements news tags and load data in admin page	| [Ver commit](https://github.com/CodeURJC-DAW-2020-21/webapp12/commit/629a58e274a4933db4d40ee670a222618186c62c) | [admin.html](https://github.com/CodeURJC-DAW-2020-21/webapp12/blob/master/UnderSociety/src/main/resources/templates/admin.html) |
   | #2	| Implements admin data tags	| [Ver commit](https://github.com/CodeURJC-DAW-2020-21/webapp12/commit/7991041a1bfa146f2eb08823f81a8ae7bc9f98c0) | [NavigationController.java](https://github.com/CodeURJC-DAW-2020-21/webapp12/blob/master/UnderSociety/src/main/java/undersociety/controller/NavigationController.java) |
   | #3	| Complete AdminPage | [Ver commit](https://github.com/CodeURJC-DAW-2020-21/webapp12/commit/6640b741ce38960470d1d710954919ad48cbfc70) | [chart-pie-demo.js](https://github.com/CodeURJC-DAW-2020-21/webapp12/blob/master/UnderSociety/src/main/resources/static/js/demo/chart-pie-demo.js) |
   | #4	| Integration Tag, Product, Listproducts, Roles, users, post Data	| [Ver commit](https://github.com/CodeURJC-DAW-2020-21/webapp12/commit/a9916d9d197b13c73516c4235c56181b2fec4fae) | [Loader.java](https://github.com/CodeURJC-DAW-2020-21/webapp12/blob/master/UnderSociety/src/main/java/undersociety/models/Loader.java) |
   | #5	| Update and complete Constructors models	| [Ver commit](https://github.com/CodeURJC-DAW-2020-21/webapp12/commit/90082a820cda4b18a829a671da23ca00cbd14110) | [Product.java](https://github.com/CodeURJC-DAW-2020-21/webapp12/blob/master/UnderSociety/src/main/java/undersociety/models/Product.java) |
   
##### Cristian Nicu Terci:

   
   | Número	| Descripción	| Commit | Archivos |
   | --- | :---: | :---: | :---: |
   | #1 | 	|  |  |
   | #2	| 	|  |  |
   | #3	| 	|  |  |
   | #4	| 	|  |  |
   | #5	| 	|  |  |
   
##### Guillermo Martín García:

Este miembro del equipo creó en paralelo la base de la aplicación (finalmente se estableció la aplicacion base de Antonio Jesus), trabajó en el cambio de datos del usuario en account settings, profile settings, modificó las vistas correspondientes, modificó el sign-in y sign-up y modificó el sistema de errores.
   
   | Número	| Descripción	| Commit | Archivos |
   | --- | :---: | :---: | :---: |
   | #1 | Update ProfilePageController with change functions	| [Ver commit](https://github.com/CodeURJC-DAW-2020-21/webapp12/commit/18175cfef75a75a80dc3e08d1fc258665cd4f20b) | [ProfilePageController.java](https://github.com/CodeURJC-DAW-2020-21/webapp12/blob/master/UnderSociety/src/main/java/undersociety/controller/ProfilePageController.java) |
   | #2	| Update myprofilefeed.html and NavigationController for view more infor	| [Ver commit](https://github.com/CodeURJC-DAW-2020-21/webapp12/commit/6ec66fed819dbb96491338484ae9fbfdf98118b8)| [myprofilefeed.html](https://github.com/CodeURJC-DAW-2020-21/webapp12/blob/master/UnderSociety/src/main/resources/templates/myprofilefeed.html) |
   | #3	| Update change pass and updateProfile in userController	| [Ver commit](https://github.com/CodeURJC-DAW-2020-21/webapp12/commit/a1ad97b617a269a42a3d0ad007737bc7e2e4932f) | [UsersController.java](https://github.com/CodeURJC-DAW-2020-21/webapp12/blob/master/UnderSociety/src/main/java/undersociety/controller/UsersController.java) |
   | #4	| Implement error exception in all controller	| [Ver commit](https://github.com/CodeURJC-DAW-2020-21/webapp12/commit/dc97cbe22cd12565646b78cf67d2fd347ab272de) | [NavigationController.java](https://github.com/CodeURJC-DAW-2020-21/webapp12/blob/master/UnderSociety/src/main/java/undersociety/controller/NavigationController.java) |
   | #5	| Error fixed in Modify Information User	| [Ver commit](https://github.com/CodeURJC-DAW-2020-21/webapp12/commit/78f2265d7c883027cde8d986f4255d07ef24a454) | [StoreController.java](https://github.com/CodeURJC-DAW-2020-21/webapp12/blob/master/UnderSociety/src/main/java/undersociety/controller/StoreController.java) |
   
##### Antonio Jesus Pajuelo Chavez:

Este miembro del equipo creó en paralelo la aplicación que finalmente se estableció como base, trabajó en la implementacion del chat, el sistema de follow, el sistema de boookmarks, la carga de elementos mediante Ajax o mustache, el sistema de most followed, el sistema de likes asi como los botones de mensajes, los controller y la construccion de los model. Ademas de la implementación del CSRF y el servicio de enviar email.    
  
   | Número	| Descripción	| Commit | Archivos |
   | --- | :---: | :---: | :---: |
   | #1 | Implement Systema Likes	| [Ver commit](https://github.com/CodeURJC-DAW-2020-21/webapp12/commit/bb9584dd783197af8277adc489b6a7da22b9b78c) | [NavigationController.java](https://github.com/CodeURJC-DAW-2020-21/webapp12/blob/master/UnderSociety/src/main/java/undersociety/controller/NavigationController.java) |
   | #2	| Restore Mustache method	| [Ver commit](https://github.com/CodeURJC-DAW-2020-21/webapp12/commit/c1971c1e1a46bbf2c031df866bfb3a2c97ba8dfe)| [PostsController.java](https://github.com/CodeURJC-DAW-2020-21/webapp12/blob/master/UnderSociety/src/main/java/undersociety/controller/PostsController.java) |
   | #3	| Implement Markbooks and store in Index	| [Ver commit](https://github.com/CodeURJC-DAW-2020-21/webapp12/commit/1f9f268ef78dff9ffd3b58a2cdfec850d46d0177) | [StoreController.java](https://github.com/CodeURJC-DAW-2020-21/webapp12/blob/master/UnderSociety/src/main/java/undersociety/controller/StoreController.java) |
   | #4	| Init implement CSRF | [Ver commit](https://github.com/CodeURJC-DAW-2020-21/webapp12/commit/0469a68167cd5bd5a5015d7192e6a726501d21f4) | [index.html](https://github.com/CodeURJC-DAW-2020-21/webapp12/blob/master/UnderSociety/src/main/resources/templates/index.html) |
   | #5	| Desing user info | [Ver commit](https://github.com/CodeURJC-DAW-2020-21/webapp12/commit/28bc760ec927228922460d29f6d0b92ef178ac7b) | [user-profile.html](https://github.com/CodeURJC-DAW-2020-21/webapp12/blob/master/UnderSociety/src/main/resources/templates/user-profile.html) |
   
   

# Fase 3
### Documentación de la API REST:
Archivo yaml: https://github.com/CodeURJC-DAW-2020-21/webapp12/blob/master/api-docs/api-docs.yaml

Documentación API REST: https://raw.githack.com/CodeURJC-DAW-2020-21/webapp12/master/api-docs/api-docs.html

### Actualización del diagrama de clases:
Leyenda del diagrama:

- Gris: Controladores
- Verde: Controladores APIREST
- Naranja: Vistas
- Azul: Repositorios
- Rojo: Servicios

![diagrama de clases](https://user-images.githubusercontent.com/63242688/115125340-c8bbef00-9fc7-11eb-9828-26dff714bb17.PNG)


### Instrucciones de ejecución de la aplicación dockerizada:

1. Es necesaria la instalacion de docker y docker compose. 

2. Abrir la terminal navegar hasta la carpeta Docker. 

3.1. Windows: Escribir el comando: "docker-compose up --build". 

3.2. Linux: Escribir el comando: "sudo docker-compose up --build".

4. Una vez finalizado el proceso de construcción de docker abrir el navegador y escribir:"https://localhost:8443/". 

5. Una vez escrita te redirigida a la pantalla de registro de la aplicacion: "https://localhost:8443/sign-in" una vez se cargue estará lista para ser utilizada.

### Documentación para construcción de la imagen docker:
LINUX:

1. Clonar repositorio mediante git clone "https://github.com/CodeURJC-DAW-2020-21/webapp12.git"

2. Descargar Docker 

3. Descargar Docker Compose

4. Navegar hasta la carpeta Docker

5. Ejecutar el comando: "chmod 777 create_image.sh"

6. Ejecutar el comando: "./create_image.sh"

### Participación de miembros:

##### David Montero Garcia:
Este miembro ha realizado: El Docker junto con las modificaciones en pom, asi como el DockerFile,Docker-compose.Yml... También implementó toda la seguridad en el Docker.Modificaciones en las URL´S y en el POM debido a la seguridad del Docker y correcciones en las versiones para que funcionara el Docker correctamente.
   
   | Número	| Descripción	| Commit | Archivos |
   | --- | :---: | :---: | :---: |
   | #1  | Creación del Docker  	| [Ver commit](https://github.com/CodeURJC-DAW-2020-21/webapp12/commit/9acec10dba1c69e2b8898b3b5da027fade22f3fa) | [Dockerfile](https://github.com/CodeURJC-DAW-2020-21/webapp12/blame/master/Docker/Dockerfile) |
   | #2	| Correccion Version y Snapshot en DockerFile	| [Ver commit](https://github.com/CodeURJC-DAW-2020-21/webapp12/commit/9eec673f0dc036736a827cb321637649db058c9a) |[pom.xml](https://github.com/CodeURJC-DAW-2020-21/webapp12/blame/master/Backend/pom.xml)  |
   | #3	|  Security añadido |  [Ver commit](https://github.com/CodeURJC-DAW-2020-21/webapp12/commit/d5fe8aa2d4168be2d099b39b3429dd2726950153) | [LikesRestController.java](https://github.com/CodeURJC-DAW-2020-21/webapp12/blame/master/Backend/src/main/java/undersociety/controller/api/post/LikesRestController.java) |
   | #4	| Implemets Security en el Docker 	|  [Ver commit](https://github.com/CodeURJC-DAW-2020-21/webapp12/commit/7efe54c6d0d85e272fdde96c1b97374b99647a0d)| [RestSecurityConfig.java](https://github.com/CodeURJC-DAW-2020-21/webapp12/blame/master/Backend/src/main/java/undersociety/security/RestSecurityConfig.java) |
   | #5	| URL'S arregladas|  [Ver commit](https://github.com/CodeURJC-DAW-2020-21/webapp12/commit/3e72386ecfd1ff15b0e6a39c99bd85d45a084869)  | [LoginApiController.java](https://github.com/CodeURJC-DAW-2020-21/webapp12/blame/master/Backend/src/main/java/undersociety/controller/api/auth/LoginApiController.java) |
   
##### Enrique Martín Santorcaz:
Este miembro ha realizado: La creación de los Api Controller relacionados con los productos creando el bookmark y product rest controllers asi como la creación del DTO de product asi como la preparación de la documentación de los api docs y la creación de los archivos pertinentes.
   
   | Número	| Descripción	| Commit | Archivos |
   | --- | :---: | :---: | :---: |
   | #1 | Implemets DTO Products	| [Ver commit](https://github.com/CodeURJC-DAW-2020-21/webapp12/commit/388a03bdba3acfafbca15d32b0df1cb7ee2afc94) | [Product.java](https://github.com/CodeURJC-DAW-2020-21/webapp12/blame/master/Backend/src/main/java/undersociety/models/Product.java)  |
   | #2	| First image implement and finish id methods	| [Ver commit](https://github.com/CodeURJC-DAW-2020-21/webapp12/commit/388a03bdba3acfafbca15d32b0df1cb7ee2afc94) | [ProductsRestController.java](https://github.com/CodeURJC-DAW-2020-21/webapp12/blame/master/Backend/src/main/java/undersociety/controller/api/products/ProductsRestController.java)  |
   | #3	| complete productapicontroller	| [Ver commit](https://github.com/CodeURJC-DAW-2020-21/webapp12/commit/388a03bdba3acfafbca15d32b0df1cb7ee2afc94) | [BookmarksRestController.java](https://github.com/CodeURJC-DAW-2020-21/webapp12/blame/master/Backend/src/main/java/undersociety/controller/api/products/BookmarksRestController.java)  |
   | #4	| Created api bookmark basic	|   [Ver commit](https://github.com/CodeURJC-DAW-2020-21/webapp12/commit/388a03bdba3acfafbca15d32b0df1cb7ee2afc94) | [ListProducts.java](https://github.com/CodeURJC-DAW-2020-21/webapp12/blame/master/Backend/src/main/java/undersociety/models/ListProducts.java) |
   | #5	| changes apidocs	| [Ver commit](https://github.com/CodeURJC-DAW-2020-21/webapp12/commit/388a03bdba3acfafbca15d32b0df1cb7ee2afc94) | [api-docs.yaml](https://github.com/CodeURJC-DAW-2020-21/webapp12/blame/master/api-docs/api-docs.yaml) |
   
##### Guillermo Martín García:
Este miembro ha realizado la creación de los Api Controller relacionados con los posts, creando el like y post rest controllers asi como la creación del DTO de post asi como la preparación de la documentación de los api docs, y se ha documentado en docker para en caso de ser necesario ayudar al resto de miembros del equipo.
   
   | Número	| Descripción	| Commit | Archivos |
   | --- | :---: | :---: | :---: |
   | #1  | Implement LikesResController documentation | [Ver commit](https://github.com/CodeURJC-DAW-2020-21/webapp12/commit/9d908269272d9785708848c0134d92105ffd9133) | [LikesRestController.java](https://github.com/CodeURJC-DAW-2020-21/webapp12/blob/9d908269272d9785708848c0134d92105ffd9133/UnderSociety/src/main/java/undersociety/controller/api/post/LikesRestController.java) |
   | #2	| Implement LikesRestController | [Ver commit](https://github.com/CodeURJC-DAW-2020-21/webapp12/commit/1eac6231f82c9e0785723525f56f2f8d45831e16) | [LikeAPost.java](https://github.com/CodeURJC-DAW-2020-21/webapp12/blob/1eac6231f82c9e0785723525f56f2f8d45831e16/UnderSociety/src/main/java/undersociety/models/LikeAPost.java) |
   | #3	| Implement PostRestController documentation	| [Ver commit](https://github.com/CodeURJC-DAW-2020-21/webapp12/commit/215cf4cc39e73c61df9a9d8cb03ffd44523c984f) | [PostRestController.java](https://github.com/CodeURJC-DAW-2020-21/webapp12/blob/215cf4cc39e73c61df9a9d8cb03ffd44523c984f/UnderSociety/src/main/java/undersociety/controller/api/post/PostRestController.java) |
   | #4	| Implement service methods | [Ver commit](https://github.com/CodeURJC-DAW-2020-21/webapp12/commit/ce312b4fc5b241efc7666eb733ea47d6d5dd86ce) | [PostsService.java](https://github.com/CodeURJC-DAW-2020-21/webapp12/blob/ce312b4fc5b241efc7666eb733ea47d6d5dd86ce/UnderSociety/src/main/java/undersociety/services/PostsService.java) |
   | #5	| Start implementation of post api rest	| [Ver commit](https://github.com/CodeURJC-DAW-2020-21/webapp12/commit/812d96cc5e13a5aa7f90957c5cd8ba3c70c187af) | [Post.java](https://github.com/CodeURJC-DAW-2020-21/webapp12/blob/812d96cc5e13a5aa7f90957c5cd8ba3c70c187af/UnderSociety/src/main/java/undersociety/models/Post.java) |
   
##### Antonio Jesus Pajuelo Chavez:
Este miembro del equipo ha realizado las peticiones Postman, la apirest de los users y sus relaciones ademas de su dto, la generacion del docker-compose, el script y una configuracion basica de la seguridad que posteriormente seria mejorada por David.
   
   | Número	| Descripción	| Commit | Archivos |
   | --- | :---: | :---: | :---: |
   | #1 | Implements StatisticsRestController	| [Ver commit](https://github.com/CodeURJC-DAW-2020-21/webapp12/commit/e10d46f85d129f5d43343c480b22487714c7f3b4) | [RelationsRestController.java](https://github.com/CodeURJC-DAW-2020-21/webapp12/blob/master/Backend/src/main/java/undersociety/controller/api/users/RelationsRestController.java) |
   | #2	| Fixe Api Rest	| [Ver commit](https://github.com/CodeURJC-DAW-2020-21/webapp12/commit/5314d9571bef25a57c855537172941b0544725b2) | [UsersRestController.java](https://github.com/CodeURJC-DAW-2020-21/webapp12/blob/master/Backend/src/main/java/undersociety/controller/api/users/UsersRestController.java) |
   | #3	| Spring Security Basic	| [Ver commit](https://github.com/CodeURJC-DAW-2020-21/webapp12/commit/73f1aea78daa32b38a76fc1f4394078354d0174d) | [Users.java](https://github.com/CodeURJC-DAW-2020-21/webapp12/blob/master/Backend/src/main/java/undersociety/models/Users.java) |
   | #4	| Docker Loader Fixe	| [Ver commit](https://github.com/CodeURJC-DAW-2020-21/webapp12/commit/16d3a2b5254e0dc450a69c3c9259516db7c83897) | [UsersRelations.java](https://github.com/CodeURJC-DAW-2020-21/webapp12/blob/master/Backend/src/main/java/undersociety/models/UsersRelations.java) |
   | #5	| Implement Pageable Methods	| [Ver commit](https://github.com/CodeURJC-DAW-2020-21/webapp12/commit/3bd151a7fe8dfa1ee0d2b32c79b5e1aeac327e80) | [UserService.java](https://github.com/CodeURJC-DAW-2020-21/webapp12/blob/master/Backend/src/main/java/undersociety/services/UserService.java) |
   
# Fase 4
### Preparación del entorno de desarrollo Linux:

0. Navegar hasta la carpeta Docker y ejecutar "chmod 777" a los scripts de la carpeta de Docker.

1. Ejecutaremos en el terminal de comandos el script llamado: "Entorno_de_desarrollo.sh".

2. Ejecutaremos en el terminal de comando el script llamado: "create_image.sh".

3. Ejecutamos el comando: "sudo docker-compose up".







### Diagrama de clases y templates de la SPA:
Leyenda del diagrama:

- Rojo: Servicios
- Azul: Componentes
- Morado: Vista de los componentes


![uml](https://user-images.githubusercontent.com/63242688/116736789-a32fdc00-a9f0-11eb-920b-46567257a141.JPG)



### Participación de miembros:
##### David Montero Garcia:
Este miembro ha realizado: Ha pasado los archivos html a fronted, ha aplicado el Angular Material sobre: las diferentes imagenes/iconos que en su mayoria han sido cambiadas pero siguen compartiendo similitud con las anteriores, filtros de busqueda que han sido modificados y adaptados, tambien se ha borrado el filtro slider sobre el precio del producto. 
    
   | Número	| Descripción	| Commit | Archivos |
   | --- | :---: | :---: | :---: |
   | #1 | Templates Fronted	| [Ver commit](https://github.com/CodeURJC-DAW-2020-21/webapp12/commit/26bba19076eaea654d824ed224cdc604f19a2c87) |  [store.component.html](https://github.com/CodeURJC-DAW-2020-21/webapp12/blame/master/Frontend/src/app/Templates/store/store.component.html)|
   | #2	| Iconos con Angular material	| [Ver commit](https://github.com/CodeURJC-DAW-2020-21/webapp12/commit/b4e5292829ab5c0877e36daed38c7d20ad351d7a) | [navbar.component.html](https://github.com/CodeURJC-DAW-2020-21/webapp12/blame/master/Frontend/src/app/Templates/navbar/navbar.component.html) |
   | #3	| Menu usuario Angular Material	| [Ver commit](https://github.com/CodeURJC-DAW-2020-21/webapp12/commit/29326771ddce5d8a8778effcb45881616501f76d)  | [home.component.html](https://github.com/CodeURJC-DAW-2020-21/webapp12/blame/master/Frontend/src/app/Templates/home/home.component.html) |
   | #4	| Filtro Angular Material y borrar uno	| [Ver commit](https://github.com/CodeURJC-DAW-2020-21/webapp12/commit/297cf1edc5defde4b70f16ad9c0ae8cdece14d5a)  | [sign-in.component.html](https://github.com/CodeURJC-DAW-2020-21/webapp12/blame/master/Frontend/src/app/Templates/sign-in/sign-in.component.html) |
   | #5	| Resto de filtros Angular Material	| [Ver commit](https://github.com/CodeURJC-DAW-2020-21/webapp12/commit/0d2b1a3cd8965fbe7833073cd52309dde5bed8ab)  | [profiles.component.html](https://github.com/CodeURJC-DAW-2020-21/webapp12/blame/master/Frontend/src/app/Templates/profiles/profiles.component.html) |


##### Enrique Martín Santorcaz:
Este miembro ha realizado: La creacion de los servicios dedicados a la parte de la aplicación angular asi como la preparación del front para la correcta visualizacion de algunos iconos piechart y correcta implementación actualizando el package.json para arreglar una serie de errores que acontecian debido a un problema de versión y su incompatibilidad con algunas implementaciones realizadas.

   | Número	| Descripción	| Commit | Archivos |
   | --- | :---: | :---: | :---: |
   | #1 | Implements PieCharts Function | [Ver commit](https://github.com/CodeURJC-DAW-2020-21/webapp12/commit/197c35fab10b1b64d519fd8dc2384ba352db9f01) | [admin.component.html](https://github.com/CodeURJC-DAW-2020-21/webapp12/blob/master/Frontend/src/app/Templates/admin/admin.component.html) |
   | #2	| Implements function statitics	| [Ver commit](https://github.com/CodeURJC-DAW-2020-21/webapp12/commit/e6320a93f44ba24ae80ee5866fa33eb1e343d6d3) | [posts.service.ts](https://github.com/CodeURJC-DAW-2020-21/webapp12/blob/master/Frontend/src/app/Services/Posts/posts.service.ts) |
   | #3	| HTML AdminPage	| [Ver commit](https://github.com/CodeURJC-DAW-2020-21/webapp12/commit/29e9767196b91b4d642cc7ccf2e011983c810a27) | [users.service.ts](https://github.com/CodeURJC-DAW-2020-21/webapp12/blob/master/Frontend/src/app/Services/Users/users.service.ts) |
   | #4	| Fix Put and Post methods	| [Ver commit](https://github.com/CodeURJC-DAW-2020-21/webapp12/commit/3dc578c92c4265e8e8e285d22737942607fbb2b7) | [products.service.ts ](https://github.com/CodeURJC-DAW-2020-21/webapp12/blob/master/Frontend/src/app/Services/Products/products.service.ts) |
   | #5	| Created Services methods get | [Ver commit](https://github.com/CodeURJC-DAW-2020-21/webapp12/commit/adca33e15cc4e61ba108057b33a8fbe9c2ccbbb7) | [index.html](https://github.com/CodeURJC-DAW-2020-21/webapp12/blob/master/Frontend/src/index.html) |

##### Guillermo Martín García:
Este miembro del equipo se ha dedicado a la implementacion del stilo de los componentes de angular y estuvo revisando la implementación de angular y el funcionamiento de de los componentes.
   
   | Número	| Descripción	| Commit | Archivos |
   | --- | :---: | :---: | :---: |
   | #1  | Home styles	| [Ver commit](https://github.com/CodeURJC-DAW-2020-21/webapp12/commit/b3545dcec7317ef3ecdfbf3538f0585c900f77a9) | [home.component.css](https://github.com/CodeURJC-DAW-2020-21/webapp12/blob/master/Frontend/src/app/Templates/home/home.component.css) |
   | #2	| companies styles	| [Ver commit](https://github.com/CodeURJC-DAW-2020-21/webapp12/commit/cf9bdcd3748c1a9695b1b7dfc77f0ebb0deb7314) | [companies.component.css](https://github.com/CodeURJC-DAW-2020-21/webapp12/blob/master/Frontend/src/app/Templates/companies/companies.component.css) |
   | #3	| Profiles styles	| [Ver commit](https://github.com/CodeURJC-DAW-2020-21/webapp12/commit/ffa5d5eca1384dfd5c88a0f18d21e9b1d44df2ec) | [profiles.component.css](https://github.com/CodeURJC-DAW-2020-21/webapp12/blob/master/Frontend/src/app/Templates/profiles/profiles.component.css) |
   | #4	| Store styles	| [Ver commit](https://github.com/CodeURJC-DAW-2020-21/webapp12/commit/fd3166b26f1169407876036a4a5a0d945fe763eb) | [store.component.css](https://github.com/CodeURJC-DAW-2020-21/webapp12/blob/master/Frontend/src/app/Templates/store/store.component.css) |
   | #5	| UserPage Styles	| [Ver commit](https://github.com/CodeURJC-DAW-2020-21/webapp12/commit/ce2a420138881a190da9163fddd4ad8bbcec3f02) | [userpage.component.css](https://github.com/CodeURJC-DAW-2020-21/webapp12/blob/master/Frontend/src/app/Templates/userpage/userpage.component.css) |

##### Antonio Jesus Pajuelo Chavez:
Este miembro del equipo se ha dedicado a la implementacion de scripts de la fase 2 a Angular asi como la carga, modificacion y creacion de usuarios, post y productos. 
   
   | Número	| Descripción	| Commit | Archivos |
   | --- | :---: | :---: | :---: |
   | #1 | Fixe Carrusel	| [Ver commit](https://github.com/CodeURJC-DAW-2020-21/webapp12/commit/657edb536174bba715f1a76430660e6b3303a386) | [home.component.ts](https://github.com/CodeURJC-DAW-2020-21/webapp12/blob/master/Frontend/src/app/Templates/home/home.component.ts) |
   | #2	| Implement create bookmarks and likes	| [Ver commit](https://github.com/CodeURJC-DAW-2020-21/webapp12/commit/32cc7dd5c2fb71e43ba90a27f0bea720f76e35cb) | [messages.component.ts](https://github.com/CodeURJC-DAW-2020-21/webapp12/blob/master/Frontend/src/app/Templates/messages/messages.component.ts) |
   | #3	| implements delete functions bookmarks and likes	| [Ver commit](https://github.com/CodeURJC-DAW-2020-21/webapp12/commit/a8d3e7f1e29cd9502b38c26e76b20a94c3c8f3a1) | [navbar.component.ts](https://github.com/CodeURJC-DAW-2020-21/webapp12/blob/master/Frontend/src/app/Templates/navbar/navbar.component.ts) |
   | #4	| Implements Functions follow	| [Ver commit](https://github.com/CodeURJC-DAW-2020-21/webapp12/commit/4f10116fc0aa1d022ada7b87304745c903914776) | [profileaccountsettings.component.ts](https://github.com/CodeURJC-DAW-2020-21/webapp12/blob/master/Frontend/src/app/Templates/profileaccountsettings/profileaccountsettings.component.ts) |
   | #5	| websocket	| [Ver commit](https://github.com/CodeURJC-DAW-2020-21/webapp12/commit/e4f77aabfaced8c186f3762b5a21c7b4d8981365) | [store.component.ts](https://github.com/CodeURJC-DAW-2020-21/webapp12/blob/master/Frontend/src/app/Templates/store/store.component.ts) |
