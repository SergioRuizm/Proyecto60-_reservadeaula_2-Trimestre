import java.util.ArrayList;
import java.util.List;
public class gestorPrestamos {
    private List<prestamo> prestamos = new ArrayList<>();
    public void registrarPrestamo(usuario u, equipo e) {
        if (!e.isDisponible()){
            System.out.println("Equipo no disponible");
            return;
        }
        prestamos.add(new prestamo(u, e));
         System.out.println("Préstamo registrado: " + u.getIdUsuario() + " -> " + e.getTipo() + " " + e.getIdEquipo());
    }

    public void registrarDevolucion(equipo e) {
        for (prestamo p : prestamos) {
            if (p.equipo == e && p.fechaDevolucion == null) {
                p.devolver();
                if (p.estaRetrasado()) {
                    System.out.println("Devolucion hecha con retraso.");
                }else{
                    System.out.println("Devolucion hecha a tiempo.");
                }
                return;
                }
            }
            System.out.println("No se a encontrado ningun prestamo activo para este equipo.");
        }

        public void listarPrestamosActivos() {
            System.out.println("Prestamos activos:");
            for (prestamo p : prestamos) {
                if (p.fechaDevolucion == null){
                    System.out.println(p);
                }
            }
        }
    }

