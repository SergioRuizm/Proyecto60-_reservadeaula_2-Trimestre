public class alumno extends usuario {
    private String nia;

    public alumno(int idUsuario, String dni, String nombre, String apellidos, String nia) {
        super(idUsuario, nombre, apellidos, dni);
        this.nia = nia;
    }

    @Override
    public int getMaxPrestamos() {
        return 1;
    }

    @Override
    public String toString() {
        return super.toString() + ", nia = " + nia;
    }
}
