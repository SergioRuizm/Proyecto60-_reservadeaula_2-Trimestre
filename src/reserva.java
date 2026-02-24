public class reserva {

    private usuario usuario;
    private aula aula;
    private puesto puesto;
    private String franjaHoraria;

    public reserva(usuario usuario, aula aula, puesto puesto, String franjaHoraria) {
        this.usuario = usuario;
        this.aula = aula;
        this.puesto = puesto;
        this.franjaHoraria = franjaHoraria;
    }
    
    @Override
    public String toString() {
        return "Reserva de " + usuario +
                "usuario="+ usuario +
                ", aula=" + aula.getNombre() +
                ", puesto=" + puesto.getIdPuesto() + 
                ", horario=" + franjaHoraria;
    }
}
