import java.util.ArrayList;
import java.util.List;

public class gestorUsuario {
    private List<usuario> usuarios = new ArrayList<>();
    private int contadorId = 1;

    public gestorUsuario() {
        usuarios = new ArrayList<>();
    }

    public void registrarAlumno(String dni, String nombre, String apellidos, String nia) {
        usuarios.add(new alumno(contadorId++, dni, nombre, apellidos, nia));
        System.out.println("El alumno ha sido registrado");

         XMLUsuarios.guardarUsuario(usuarios.get(usuarios.size() - 1));
    }

    public void registrarProfesor(String dni, String nombre, String apellidos, int idProfesor) {
        usuarios.add(new profesor(contadorId++, dni, nombre, apellidos, idProfesor));
        System.out.println("El profesor ha sido registrado");

        XMLUsuarios.guardarUsuario(usuarios.get(usuarios.size() - 1));


    }

    public void listarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("No hay ningún usuario registrado");
        } else {
            usuarios.forEach(System.out::println);
        }
    }


    public void darBajaUsuario(int idUsuario) {
        usuario u = buscarUsuario(idUsuario);

        if (u != null) {
            u.darBaja();
            System.out.println("el usuario a sido dado de baja");
            } else {
                System.out.println("no se ha encontrado el usuario");
            }
        }
    public void modificarUsuario(int idUsuario, String nuevoNombre, String nuevosApellidos) {
        usuario u = buscarUsuario(idUsuario);
        if (u != null) {
            u.modificarDatos(nuevoNombre, nuevosApellidos);
            System.out.println("usuario modificado");
        } else {
            System.out.println("usuario no encontrado");
        }

            }
             public usuario buscarUsuario(int id) {
            for (usuario u : usuarios) {
                if (u.getIdUsuario() == id) {
                    return u;
                }
            }
        return null;

        
    }
}
    

