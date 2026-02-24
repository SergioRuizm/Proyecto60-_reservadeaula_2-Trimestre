Descripción:
Este proyecto es un sistema de gestión de biblioteca desarrollado en Java, que permite administrar:

Usuarios (alumnos y profesores)
Préstamos de equipos (portátiles y tablets)
Reservas de puestos en un aula
Control de devoluciones y retrasos

El programa funciona mediante un menú interactivo por consola y utiliza Programación Orientada a Objetos (POO).

Gestión de Usuarios

Clase abstracta:

usuario
idUsuario
nombre
apellidos
dni
activo
método abstracto getMaxPrestamos()

Clases que heredan de usuario:

alumno
profesor

Clase gestora:

gestorUsuario
Registrar alumno
Registrar profesor
Listar usuarios
Buscar usuario
Modificar usuario
Dar de baja
Gestión de Equipos

Clase abstracta:

equipo
idEquipo
tipo
disponible
prestar()
devolver()

Clases que heredan de equipo:

portatil
tablet

Clase gestora:

gestorPrestamos
Registrar préstamo
Registrar devolución
Detectar retrasos (más de 7 días)
Listar préstamos activos

Gestión de Reservas

Clases:

puesto
aula
reserva
gestorReservas

Funcionalidades:

Reservar puesto
Liberar puesto
Mostrar estado del aula

Menú del Programa

Al ejecutar la clase main, se muestra el siguiente menú:

Registrar alumno
Registrar profesor
Listar usuarios
Registrar préstamo
Registrar devolución
Listar préstamos activos
Reservar puesto
Liberar puesto
Mostrar estado del aula
Salir

El sistema funciona utilizando ArrayList para almacenar los datos en memoria.