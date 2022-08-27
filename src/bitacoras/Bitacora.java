package bitacoras;

import clases.Ticket;

import java.util.Date;

public class Bitacora extends Ticket {
    //Atributo private Trabajadores
    private Trabajadores listadoTrabajadores;
    //Atributo priv fehchay hora
    private Date fechayHora;

    //Atributo priv msj respuesta
    private String mensajeRespuesta;
    //Atributo priv evento
    private TipoEvento eventoBitacora;

    /**
     * Constructor Vacio
     */
    public Bitacora() {
    }

    /**
     * Cosntructor con Parametros
     * @param nitUsuario Nit del Usuario
     * @param nombreUsuario Nombre Usuario
     * @param descripcionProblema Descripcion Problema
     * @param estado Estado ticket
     * @param movimientoTicket Evento Ticket
     * @param listadoTrabajadores Empleados
     * @param fechayHora Fecha y Hora
     * @param mensajeRespuesta Solucion
     * @param eventoBitacora Nuevo Evento Bitacora
     */
    public Bitacora(String nitUsuario, String nombreUsuario, String descripcionProblema, int estado, TipoEvento movimientoTicket, Trabajadores listadoTrabajadores, Date fechayHora, String mensajeRespuesta, TipoEvento eventoBitacora) {
        super(nitUsuario, nombreUsuario, descripcionProblema, estado, movimientoTicket);
        this.listadoTrabajadores = listadoTrabajadores;
        this.fechayHora = fechayHora;
        this.mensajeRespuesta = mensajeRespuesta;
        this.eventoBitacora = eventoBitacora;
    }

    /**
     * Constructor Heradado de Ticket con sus parametros y con propios de la clase Bitacora
     */

    //Metodo get
    public Trabajadores getListadoTrabajadores() {
        return listadoTrabajadores;
    }
    //Metodo set
    public void setListadoTrabajadores(Trabajadores listadoTrabajadores) {
        this.listadoTrabajadores = listadoTrabajadores;
    }
    //Metodo get
    public Date getFechayHora() {
        return fechayHora;
    }

    //Metodo set
    public void setFechayHora(Date fechayHora) {
        this.fechayHora = fechayHora;
    }

    //Metodo get
    public String getMensajeRespuesta() {
        return mensajeRespuesta;
    }

    //Metodo set
    public void setMensajeRespuesta(String mensajeRespuesta) {
        this.mensajeRespuesta = mensajeRespuesta;
    }
    //Metodo get
    public TipoEvento getEventoBitacora() {
        return eventoBitacora;
    }
    //Metodo set
    public void setEventoBitacora(TipoEvento eventoBitacora) {
        this.eventoBitacora = eventoBitacora;
    }

    /**
     * Metodo toString
     * @return Nos devuelve lo contenido dentro del objeto usando el toString
     */
    @Override
    public String toString() {
        return "Bitacora [" +
                "Trabajador: " + listadoTrabajadores +
                "Fecha y Hora: " + fechayHora +
                "Mensaje Respuesta: '" + mensajeRespuesta + '\'' +
                "Evento Bitacora: " + eventoBitacora +
                "} " + super.toString();
    }


}
