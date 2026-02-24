import java.time.LocalDate;
public class prestamo {
    private usuario usuario;
    public equipo equipo;
    private LocalDate fechaPrestamo;
    public LocalDate fechaDevolucion;

    public prestamo(usuario usuario, equipo equipo) {
        this.usuario = usuario;
        this.equipo = equipo;
        this.fechaPrestamo = LocalDate.now();
        this.fechaDevolucion = null;
        equipo.prestar();
    }

    public boolean estaRetrasado() {
        if (fechaDevolucion != null) return false;
        return fechaPrestamo.plusDays(7).isBefore(LocalDate.now());
    }
    
    public void devolver() {
        fechaDevolucion = LocalDate.now();
        equipo.devolver();
    }

    @Override
    public String toString() {
        String estado = (fechaDevolucion == null) ? (estaRetrasado() ? "Retrasado" : "en curso ") : "Devuelto";
        return "Prestamo: " + usuario.getIdUsuario() + " - " + equipo + " - Estado: " + estado;
    }

}
