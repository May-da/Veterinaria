public class Mascota {

    private String nombreMascota;
    private String raza;
    private String genero;
    private String tipoEspecie;
    private int edad;
    private int peso;

    public Mascota( String nombreMascota, String raza, String genero, String tipoEspecie,  int edad, int peso) {
        this.genero = genero;
        this.nombreMascota = nombreMascota;
        this.peso = peso;
        this.raza = raza;
        this.tipoEspecie = tipoEspecie;
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNombre() {
        return nombreMascota;
    }

    public void setNombre(String nombre) {
        this.nombreMascota = nombre;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getTipoEspecie() {
        return tipoEspecie;
    }

    public void setTipoEspecie(String tipoEspecie) {
        this.tipoEspecie = tipoEspecie;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
