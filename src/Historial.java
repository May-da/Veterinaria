import java.security.SignatureSpi;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Historial {

    private Long historialId;
    private String codigo;
    private Stack<String> estados;
    private Cliente cliente;
    private boolean operado;
    private boolean bonoBrigada;
    private boolean apto;

    public Historial() {
        this.estados = new Stack<>();
    }

    public Historial(boolean apto, boolean bonoBrigada, Cliente cliente, String codigo, Stack<String> estados, Long historialId, boolean operado) {
        this.apto = apto;
        this.bonoBrigada = bonoBrigada;
        this.cliente = cliente;
        this.codigo = codigo;
        this.estados = estados;
        this.historialId = historialId;
        this.operado = operado;
    }
   public void aptoCirugia(boolean apto){
        String nombreMascota = cliente.getMascota().getNombre();
        if (apto) {
            System.out.println("La mascota: " + nombreMascota + " ingresa a cirugía  " );
            estados.push("Si es apto, ingresa a cirugía." );
        }else{
            System.out.println("La mascota: " + nombreMascota + "no es apto para cirugía, se remite a consulta" );
            estados.push("no es apto para cirugía, se remite a consulta");
        }
    }
    public void agregarEstado(int nuevoEstado) {
         String[] opciones = {
                 "",
                "En cirugía",
                "En observación",
                "Posoperatorio",
                "En la morgue",
                "Operado",
                "Fallecido",
                "Dado de alta",
                "Observaciones"
        };
        estados.push(opciones[nuevoEstado]);
    }

    public String verEstadoActual() {
        if (!estados.isEmpty()) {
            return estados.peek();
        } else {
            return "No hay estados registrados";
        }
    }
    public void mostrarHistorial() {
        System.out.println("Historial de estados:");
        for (String estado : estados) {
            System.out.println(estado);
        }
    }

    public void deshacerEstado() {
        if (!estados.isEmpty()) {
            String estadoEliminado = estados.pop();
            System.out.println("Estado deshecho: " + estadoEliminado);
        } else {
            System.out.println("No hay estados para deshacer.");
        }
    }

    public boolean isApto() {
        return apto;
    }

    public void setApto(boolean apto) {
        this.apto = apto;
    }

    public boolean isBonoBrigada() {
        return bonoBrigada;
    }

    public void setBonoBrigada(boolean bonoBrigada) {
        this.bonoBrigada = bonoBrigada;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Stack<String> getEstados() {
        return estados;
    }

    public void setEstados(Stack<String> estado) {
        this.estados = estado;
    }

    public Long getHistorialId() {
        return historialId;
    }

    public void setHistorialId(Long historialId) {
        this.historialId = historialId;
    }

    public boolean isOperado() {
        return operado;
    }

    public void setOperado(boolean operado) {
        this.operado = operado;
    }

    @Override
    public String toString() {
        return "Historial{" +
                "apto=" + apto +
                ", historialId=" + historialId +
                ", codigo='" + codigo + '\'' +
                ", cliente=" + cliente +
                ", estados=" + estados +
                ", operado=" + operado +
                ", bonoBrigada=" + bonoBrigada +
                '}';
    }
}
