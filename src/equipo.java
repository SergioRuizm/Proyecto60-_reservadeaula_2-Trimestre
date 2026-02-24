public abstract class equipo {
    protected int idEquipo;
    protected String tipo;
    protected boolean disponible; 

    public equipo(int idEquipo, String tipo) {
        this.idEquipo = idEquipo;
        this.tipo = tipo;
        this.disponible = true;
    }

    public int getIdEquipo(){
        return idEquipo;
    }

    public String getTipo(){
        return tipo;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void prestar() {
        disponible = false;
    }

    public void devolver() {
        disponible = true;
    }

    @Override
    public String toString() {
        return tipo + "ID:" + idEquipo + ", Disponible:" + disponible;
    }
}
