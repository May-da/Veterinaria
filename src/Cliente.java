public class Cliente {

    private String nombre;
    private String numeroDocumento;
    private String celular;
    private Mascota mascota;

    public Cliente(String nombre,  String numeroDocumento, String celular, Mascota mascota) {
        this.mascota = mascota;
        this.nombre = nombre;
        this.numeroDocumento = numeroDocumento;
        this.celular = celular;
    }


    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                ", nombre='" + nombre + '\'' +
                ", numeroDocumento='" + numeroDocumento + '\'' +
                ", celular='" + celular + '\'' +
                ", mascota=" + mascota.toString() +
                '}';
    }
}
