package colas;
import bitacoras.Bitacora;
import bitacoras.TipoEvento;
import bitacoras.Trabajadores;
import clases.Ticket;

import java.util.*;

import static colas.ColaSoporteTecnico.*;

public class ColaDesarrollador extends  ColaServicio{
    Scanner sc= new Scanner(System.in);
    String opcMesa;
    Ticket ticketBitacorizado;
    Bitacora asignarTicket;
    Bitacora resolverTicket;
    ArrayList<Ticket> ticketsResueltos;
    ArrayList<Ticket>ticketsAsignados;

    /**
     * Mandamos a llamar el constructor padre y se inicializa
     */
    public ColaDesarrollador(){
        super();
    }

    /**
     * Implementacion metodo abstracto de Sacar de Cola
     */
    @Override
    public void sacarCola() {
        System.out.println("==========================================");
        System.out.println("Funcionamiento de Cola: R A N D O M");
        System.out.println("==========================================");


        /**
         * Metodo Random
         */
        Random random_method = new Random();

        /**
         * Loop para obtener un aleatorio
         */
        for (int i = 0; i < copiaDesarrollo.size(); i++)
        {
            int index = random_method.nextInt(copiaDesarrollo.size());
            System.out.println("Random Element is :"
                    + copiaDesarrollo.get(index));
        }


        System.out.println("Seleccion de Empleado: ");
        Trabajadores[] listadoEmpleados = Trabajadores.values();

        /**
         * Ciclo For para recorrer la Enum de Empleados
         */
        for (int i = 0; i < listadoEmpleados.length; i++) {
            System.out.println((i + 1) + ") " + listadoEmpleados[i]);
        }

        System.out.print("Opcion: ");
        int opcTrabajador = sc.nextInt();
        System.out.println("Haz seleccionado: " + listadoEmpleados[opcTrabajador - 1]);

        Date fechaYHoraEmision = new Date();

        System.out.println("Ingrese Mensaje de Respuesta: ");
        String msjRespuesta = sc.nextLine();

        sc.nextLine();

        /**
         * Creamos un Evento de Asignar en la Bitacora
         */
        asignarTicket = new Bitacora(ticketBitacorizado.getNitUsuario(),
                ticketBitacorizado.getNombreUsuario(), ticketBitacorizado.getDescripcionProblema(), ticketBitacorizado.getEstado(),
                ticketBitacorizado.getMovimientoTicket(), listadoEmpleados[opcTrabajador - 1], fechaYHoraEmision, msjRespuesta, TipoEvento.ASIGNAR);

        /**
         * Creamos un Evento en la Bitacora Tipo Resolver
         */
        resolverTicket = new Bitacora(ticketBitacorizado.getNitUsuario(),
                ticketBitacorizado.getNombreUsuario(), ticketBitacorizado.getDescripcionProblema(), ticketBitacorizado.getEstado(),
                ticketBitacorizado.getMovimientoTicket(), listadoEmpleados[opcTrabajador - 1], fechaYHoraEmision, msjRespuesta, TipoEvento.SOLUCION);

        ticketsAsignados.add(asignarTicket);
        ticketsResueltos.add(resolverTicket);
        listadoGeneral();

    }

    /**
     * Metoodo Mostrar Tickets ASIGNADOS a esa cola
     */
    public void asignadosDesarrollo(){
        for (int i=0;i<ticketsAsignados.size();i++){
            System.out.println(ticketsAsignados.toString());
        }
    }

    /**
     * Metodo para Ver Tickets Resueltos de esa Cola
     */
    public void resueltosDesarrollo(){
        for(int i=0;i<ticketsResueltos.size();i++){
            System.out.println(ticketsResueltos.toString());
        }
    }


}
