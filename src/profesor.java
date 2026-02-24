public class profesor extends usuario {
    private int idProfesor;

    public profesor(int idUsuario, String dni, String nombre, String apellidos, int idProfesor){
        super(idUsuario, nombre, apellidos, dni);
        this.idProfesor = idProfesor;
    }
    @Override
    public int getMaxPrestamos(){
        return 1;
    }
    @Override
    public String toString(){
        return super.toString() + ", idProfesor = " + idProfesor;
    }
    
}
