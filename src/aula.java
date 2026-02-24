import java.util.ArrayList;
import java.util.List;

public class aula {
    
    private String nombre;
    private List<puesto> puestos = new ArrayList<>();

    public aula(String nombre, int cantidadPuestos) {
        this.nombre = nombre;

        for (int i = 1; i <= cantidadPuestos; i++) {
            puestos.add(new puesto(i));
        }
    }

    public String getNombre() {
        return nombre;
    }

    public List<puesto> getPuestos() {
        return puestos;
    }

    public puesto buscarPuesto(int id) {
        for (puesto p : puestos) {
            if (p.getIdPuesto() == id) {
                return p;
            }
        }
        return null;
    }
}
