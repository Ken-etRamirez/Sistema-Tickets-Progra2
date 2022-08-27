package clases;

import bitacoras.TipoEvento;
import colas.ColaServicio;

public class Ticket  extends ColaServicio {

    private static int correlativoTicket=1;
    private int idTicket;
    private String nitUsuario;
    private String nombreUsuario;
    private int estado;
    private String descripcionProblema;
    private TipoEvento movimientoTicket;


    /**
     * Constructor Vacio
     */
    public  Ticket(){}

    /**
     * Constructor con Parametros
     * @param nitUsuario Nit del Usuario
     * @param nombreUsuario Nombre del Usuario
     * @param descripcionProblema Descripcion del Problema
     * @param estado Estado del Ticket
     * @param movimientoTicket Movimiento del Ticket
     */
    public Ticket(String nitUsuario, String nombreUsuario, String descripcionProblema, int estado, TipoEvento movimientoTicket){
        this.idTicket=correlativoTicket;
        correlativoTicket++;
        this.nitUsuario=nitUsuario;
        this.nombreUsuario=nombreUsuario;
        this.descripcionProblema=descripcionProblema;
        this.estado=estado;
        this.movimientoTicket=movimientoTicket;
    }

    public static int getCorrelativoTicket() {
        return correlativoTicket;
    }

    public static void setCorrelativoTicket(int correlativoTicket) {
        Ticket.correlativoTicket = correlativoTicket;
    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public String getNitUsuario() {
        return nitUsuario;
    }

    public void setNitUsuario(String nitUsuario) {
        this.nitUsuario = nitUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getDescripcionProblema() {
        return descripcionProblema;
    }

    public void setDescripcionProblema(String descripcionProblema) {
        this.descripcionProblema = descripcionProblema;
    }

    public TipoEvento getMovimientoTicket() {
        return movimientoTicket;
    }

    public void setMovimientoTicket(TipoEvento movimientoTicket) {
        this.movimientoTicket = movimientoTicket;
    }

    /**
     * Metodo toString
     * @return Este nos retorna el estado/info de nuestros objetos
     */
    @Override
    public String toString() {
        return "TICKET [" +
                "ID Ticket: " + idTicket +
                "NIT Usuario: '" + nitUsuario + '\'' +
                "Nombre Usuario: '" + nombreUsuario + '\'' +
                "Estado: " + estado +
                "Descripcion Problema: '" + descripcionProblema + '\'' +
                "Movimiento Ticket: " + movimientoTicket +
                ']';
    }


    @Override
    public void sacarCola() {
    }
}
