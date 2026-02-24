public abstract class usuario {
    private int idUsuario;
    private String nombre;
    private String apellidos;
    private String dni;
    private boolean activo;

    public usuario(int idUsuario, String nombre, String apellidos, String dni) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;    
        this.activo = true;
    }

    public int getIdUsuario(){
        return idUsuario;
    }

    public String getNombre() {
    return nombre;
    }
    public String getApellidos() {
        return apellidos;
    }

    public String getDni() {
    return dni;
    }

    public boolean isActivo() {
        return activo;
    }
    public void darBaja() {
        this.activo = false;
    }
    public void modificarDatos(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public abstract int getMaxPrestamos();

    @Override
    public String toString(){
        return "ID: " + idUsuario + ", Nombre: " + nombre + " " + apellidos + ", DNI: " + dni + ", Activo: " + activo;
    }
}
