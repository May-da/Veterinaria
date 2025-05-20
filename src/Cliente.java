public class Cliente {

    private int clienteId;
    private String nombre;
    private String apellido;
    private String numeroDocumento;
    private String celular;
    private Mascota mascota;

    public Cliente(int clienteId, String nombre, String apellido, String numeroDocumento, String celular, Mascota mascota) {
        this.apellido = apellido;
        this.clienteId = clienteId;
        this.mascota = mascota;
        this.nombre = nombre;
        this.numeroDocumento = numeroDocumento;
        this.celular = celular;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
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
                "apellido='" + apellido + '\'' +
                ", numeroDocumento='" + numeroDocumento + '\'' +
                ", celular='" + celular + '\'' +
                ", mascota=" + mascota.toString() +
                '}';
    }
}
