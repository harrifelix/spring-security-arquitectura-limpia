# **GCO GESTION DE INVENTARIOS**

## **DUEÑO  DE LA SOLUCIÓN**


| **Contacto** | Harrison felix alvarez laverde        |

### **TABLA DE CONTENIDO**

- [Descripción de la necesidad](#descripción-de-la-necesidad)
- [Diagrama de componentes](#diagrama-de-componentes)

- [Configuración Proyecto](#Configuración Proyecto)

### Descripción de la necesidad GCO:

Yo como analista desarrollador deseo implementar un sistema para llevar control del inventario de productos permitiendo su mantenimiento y visualización historica.


### **Diagrama de componentes**

En el siguiente diagrama se muestra el diseño de los componentes de la arquitectura:

![Diseño de Arquitectura](diagrama%20componentes.jpg)

| **Nombre Componente** | **Descripción del componente**                                                                                   | **Responsabilidad** | **Tipo**      | **Herramienta**     |
|-----------------------|------------------------------------------------------------------------------------------------------------------|---------------------|---------------|---------------------|
| aplicacion            | Capa que tiene una sola responsabilidad y es manejar logica de aplicación                                        | logica aplicación   | Microservicio | Java                |
| domain                | Capa de negocio tiene una sola responsabilidad manejar logica de negocio nada mas ese es su objetivo             | logica negocio      | Microservicio| Java         |
| infraestructura       | capa de infraestructura capa que tiene referencia a librerias frameworks tecnologias etc tiene las depencias dll | tratar dependencias | Microservicior     | Java           |

### **Configuracion Proyecto**

Para poner en marcha el backend con spring boot simplemente se ejecuta se abre el proyecto con un IDE para JAVA se ejecuta y listo la base de datos esta en memoria con h2 no necesita configurarla
Si desea probar solamente el backend puede probarlo desde la documentacion de la api poneniendo swagger-ui.html a la ruta 
----
Si desea poner en marcha el frontEnd se abre con un editor de texto se instalan los paquetes y con el comando ng serve se ejecuta.

_**N/A**_