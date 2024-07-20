<h1>Que es esto?</h1>

Explicacion breve del programa, tenemos una venta de inmuebles, donde los datos se van a almacenar en una base de datos (El nombre con el que la creen da igual, sin embargo, la llamaremos inmuebles)
usaremos Java como lenguaje de programacion, siendo exactos, Java Maven (investiguen) <br>

<h1>Configuraciones</h1>

Nada raro, usaremos eclipse, busquen como clonar un repositorio Github a eclipse, el IDE ya viene con las herramientas para que no tengan que usar la terminal, la forma de trabajar sera de que cada uno
crea una rama (branch) y la nombraran de esta manera -> Nombre/Objetivo. Ejemplo: Francisco/ReporteVenta, iran trabajando en sus ramas y cuando todo este listo hacen su Pull Request y recemos para que no se
rompa nada. NOTA: TODOS tenemos que trabajar con la misma version, es decir, si yo (Francisco) termino mi rama primero y actualizo la rama master (raiz del proyecto) todos tendrian que crear una nueva rama
con la version actualizada, se traen los cambios de la rama anterior a la nueva, y listo, o eso creo.

<h1>Que es el sistema de patron DAO?</h1>

En palabras muy simples, es un patron de arquitectura, para no entrar en teoria (investiguen) solo me voy a mecionar lo basico para entender todo, asi que, expliquemos el sistema de paquetes:

<h3>com.mycompany.db</h3>

Aca hay una clase, llamada Database que establece metodos de conexion a la base de datos

<h3>com.mycompany.views</h3>

Aqui estan las vistas que tendra el usuario, asi como cada uno de sus form

<h3>com.mycompany.models</h3>

Este paquete contiene todos los modelos de las tablas de la base de datos, osea una "copia" de la estructura de cada tabla

<h3>com.mycompany.interfaces</h3>

Este paquete solo tiene interfaces, en palabras cortas, son clases que tienen metodos declarados pero no tienen escrita su logica, los metodos seran solicitudes GET, POST, UPDATE, DELETE. Basicamente
son para hacer el CRUD

<h3>com.mycompany.inmuebles</h3>

Aca esta (por fin) la logica de programacion, las clases cuentan con los metodos conectar y cerrar (de la clase Database en el paquete com.mycompany.db) e implementa los metodos de las interfaces
su funcion es manejar los Scripts y logica de cada una de las solicitudes o statement SQL
