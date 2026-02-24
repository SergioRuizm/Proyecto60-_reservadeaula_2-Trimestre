import java.util.ArrayList;
import java.util.List;
public class gestorReservas {
    private List<reserva> reservas = new ArrayList<>();
    public void reservar (usuario u, aula a, int idPuesto, String franjaHoraria) {
      
        puesto p = a.buscarPuesto(idPuesto);
        if (p == null) {
            System.out.println("el puesto no existe");
            return;
        }

        if (p.isOcupado()) {
            System.out.println("el puesto esta ocupado");
            return;
        }

        p.ocupar();
        reservas.add(new reserva(u, a, p, franjaHoraria));
        System.out.println("la reserva se ha realizado con exito");
    }

    public void liberarPuesto(aula a, int idPuesto) {

        puesto p = a.buscarPuesto(idPuesto);
        if (p != null && p.isOcupado()) {
            p.liberar();
            System.out.println("el puesto fue liberado correctamente");
        } else {
            System.out.println("el puesto no esta ocupado");
        }
    }

    public void mostrarEstadoAula(aula a) {
        System.out.println("estado del aula" + a.getNombre());
        for (puesto p : a.getPuestos()) {
            System.out.println("puesto" + p.getIdPuesto() + 
            (p.isOcupado() ? "ocupado" : "libre")); 
        }
    }
}
