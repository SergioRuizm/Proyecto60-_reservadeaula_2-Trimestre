import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        gestorUsuario gestorUsuarios = new gestorUsuario();
        gestorPrestamos gestorPrestamos = new gestorPrestamos();
        gestorReservas gestorReservas = new gestorReservas();

        aula aula1 = new aula("Aula 1", 10);

        List<equipo> equipos = new ArrayList<>();
        equipos.add(new portatil(1));
        equipos.add(new portatil(2));
        equipos.add(new tablet(1));
        equipos.add(new tablet(2));
        int opcion;
        do {
            System.out.println("1. Registrar alumno");
            System.out.println("2. Registrar profesor");
            System.out.println("3. Listar usuarios");
            System.out.println("4. Registrar préstamo");
            System.out.println("5. Registrar devolución");
            System.out.println("6. Listar préstamos activos");
            System.out.println("7. Reservar puesto");
            System.out.println("8. Liberar puesto");
            System.out.println("9. Mostrar estado del aula");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                
                case 1:
                    System.out.print("DNI: ");
                    String dniAlumno = sc.nextLine();
                    System.out.print("Nombre: ");
                    String nombreAlumno = sc.nextLine();
                    System.out.print("Apellidos: ");
                    String apellidosAlumno = sc.nextLine();
                    System.out.print("NIA: ");
                    String nia = sc.nextLine();
                    gestorUsuarios.registrarAlumno(dniAlumno, nombreAlumno, apellidosAlumno, nia);
                    break;

                    case 2:
                        System.out.print("DNI: ");
                        String dniProfesor = sc.nextLine();
                        System.out.print("Nombre: ");
                        String nombreProfesor = sc.nextLine();
                        System.out.print("Apellidos: ");
                        String apellidosProfesor = sc.nextLine();
                        System.out.print("ID Profesor: ");
                        int idProfesor = sc.nextInt();
                        gestorUsuarios.registrarProfesor(dniProfesor, nombreProfesor, apellidosProfesor, idProfesor);
                        break;

                        case 3:
                            gestorUsuarios.listarUsuarios();
                            break;

                    case 4:
                        System.out.print("Id usuario:");
                        int idUsuario = sc.nextInt();
                        usuario u = gestorUsuarios.buscarUsuario(idUsuario);
                        if (u != null) {
                            System.out.print("id equipo:");
                            int idPuesto = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Franja horaria:");
                            String franja = sc.nextLine();
                            gestorReservas.reservar(u, aula1, idPuesto, franja);
                        }else{
                            System.out.println("Usuario no encontrado");
                        }
                        break;

                        case 5:
                            System.out.print("id del puesto a liberar:");
                            int idP = sc.nextInt();
                            gestorReservas.liberarPuesto(aula1, idP);
                            break;

                            case 6:
                                gestorReservas.mostrarEstadoAula(aula1);
                                break;

                                case 7:
                                    System.out.print("id usuario:");
                                    idUsuario = sc.nextInt();
                                    u = gestorUsuarios.buscarUsuario(idUsuario);
                                    if (u == null) {
                                        System.out.println("usuario no encontrado");
                                        break;
                                    }

                                    System.out.println("equipos disponibles:");
                                    for (equipo e : equipos){
                                        if(e.isDisponible()){
                                            System.out.println(e.getIdEquipo() + " - " + e.getTipo());
                                        }
                                    }

                                    System.out.print("id equipo:");
                                    int idEquipo = sc.nextInt();

                                    equipo equipoSeleccionado = null;
                                    for (equipo e : equipos){
                                        if(e.getIdEquipo() == idEquipo) {
                                            equipoSeleccionado = e;
                                        }
                                    }
                                    if (equipoSeleccionado != null) {
                                        gestorPrestamos.registrarPrestamo(u, equipoSeleccionado);
                                    } else {
                                        System.out.println("equipo no encontrado");
                                    }
                                    break;

                                    case 8:
                                        System.out.print(" Id equipo a devolver:");
                                        idEquipo = sc.nextInt();

                                        for (equipo e : equipos) {
                                            if (e.getIdEquipo() == idEquipo) {
                                                gestorPrestamos.registrarDevolucion(e);
                                            }
                                        }
                                        break;

                                        case 9:
                                            gestorPrestamos.listarPrestamosActivos();
                                            break;

                                        case 0:
                                            System.out.println("saliendo...");
                                            break;

                                            default:
                                                System.out.println("opcion no valida");
                                    }
        } while (opcion != 0);
         sc.close();          
    }

    
}
    

