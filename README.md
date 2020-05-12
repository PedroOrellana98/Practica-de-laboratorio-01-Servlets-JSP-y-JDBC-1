# Practica-de-laboratorio-01-Servlets-JSP-y-JDBC
### **CARRERA:** INGENIERIA DE SISTEMAS/COMPUTACIÓN. **ASIGNATURA:** PLATAFORMAS WEB
### **NRO. PRÁCTICA:** 2. **TITULO PRÁCTICA:**  Desarrollo de una aplicación JEE basado en Servlets, JSP y JDBC
para el intercambio de datos en un modelo de tres capas aplicando los patrones diseño
de software MVC y DAO
### **OBJETIVO**:
   * Diseña y desarrolla modelos de software en diferentes niveles de abstracción y modelos de datos a nivel
     transaccional y analítico con entornos de desarrollo actuales 

  ### INSTRUCCIONES
  Se pide desarrollar una aplicación JEE que permita implementar una agenda
  telefónica en donde se tendrán usuarios con datos como cedula, nombres,
  apellidos, correo y contraseña. Y cada uno de estos usuarios podrá tener
  asignado uno o más teléfonos de contacto de diferente tipo y operador, por
  ejemplo:
  
  * •El usuario “Juanito” tiene los teléfonos 0998121212 de tipo celular y operadora Movistar; así como también tiene asignado el teléfono 0728222111 de tipo convencional y operador CNT.
  
  Para lo cual, se propone el siguiente diagrama de clases:
  ![Estructura](https://github.com/aReinoso007/Practica-de-laboratorio-01-Servlets-JSP-y-JDBC/blob/master/diagramas.png)

Los requerimientos funcionales del sistema son:
* 	Los usuarios pueden registrarse en la aplicación a través de un formulario de creación de cuentas.
* •	Un usuario puede iniciar sesión usando su correo y contraseña.
*•	Una vez iniciado sesión el usuario podrá:
  ** Registrar, modificar, eliminar, buscar y listar sus teléfonos
  ** Listar los números de teléfono de un usuario usando su número de cédula o correo electrónico
  ** Podrá llamar o enviar un correo electrónico desde el sistema usando aplicaciones externas.
 * Los datos siempre deberán ser validados cuando se trabaje a través de formularios
De igual manera, se pide manejar sesiones y filtros para que existe seguridad en el sistema de agenda telefónica. Por lo qué, debe existir una parte pública y una privada. La parte privada ha sido descrita en los requisitos antes planteados. Y la parte pública será una página index.html a través de la cual podrán acceder al sistema. No obstante, se debe generar una página con la experiencia e interfaz de usuario apropiada, como la que se muestra a continuación:
![Estructura](https://github.com/aReinoso007/Practica-de-laboratorio-01-Servlets-JSP-y-JDBC/blob/master/estructura.png)

Finalmente, el sistema de agenda telefónica debe aplicar los patrones de diseño de software MVC y DAO, en donde, el modelo será clases POJOs de Java, la vista será JSP + JSTL y los controladores serán a través de DAOs y Servlets.

###  ACTIVIDADES A DESARROLLAR
1. Crear un repositorio en GitHub con el nombre “Práctica de laboratorio 01: Servlets, JSP y JDBC”
2. Desarrollar una aplicación con tecnología JEE para gestionar una agenda telefónica en la web.
3.  Realizar varios commits en la herramienta GitHub que demuestren el desarrollo de la aplicación.
4. Generar el informe de la práctica con el desarrollo de cada uno de los puntos descritos anteriormente.
5. Implementar el README del repositorio del proyecto con la misma información del informe de la práctica
6. Subir al AVAC el informe del proyecto en formato *.pdf. El informe debe contar con conclusiones apropiadas
y la firma de cada estudiante. 


 ### RESULTADO(S) OBTENIDO(S):
  * Maneja diferentes formatos para el intercambio de datos entre aplicaciones
  * 
 ### CONCLUSIONES:
  * Los estudiantes podrán identificar arquitecturas web utilizando servicios en la nube. Así como también,
    podrán consumir APIs y manipular objetos JSON.
 ### RECOMEDACIONES:
  * Aplicar conceptos de interacción humano máquina para el desarrollo de la GUI.
