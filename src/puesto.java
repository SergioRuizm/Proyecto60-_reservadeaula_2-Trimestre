public class puesto {
    private int idPuesto;
    private boolean ocupado;

    public puesto (int idPuesto) {
        this.idPuesto = idPuesto;
        this.ocupado = false;
    }

    public int getIdPuesto() {
        return idPuesto;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void ocupar() {
        this.ocupado = true;
    }

    public void liberar() {
        ocupado = false;
    }

    @Override
    public String toString() {
        return "Puesto, " + idPuesto + ", Ocupado: " + ocupado;
    }
}
