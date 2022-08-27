package colas;

import bitacoras.Bitacora;
import bitacoras.TipoEvento;
import bitacoras.Trabajadores;
import clases.Ticket;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;

public class ColaMesaAyuda extends ColaServicio{
    Scanner sc= new Scanner(System.in);
    String opcMesa;
    Ticket ticketBitacorizado;
    Bitacora asignarTicket; //Bien
    Bitacora resolverTicket; //Bien
    ArrayList<Ticket>ticketsResueltos; //Bien
    ArrayList<Ticket>ticketsAsignados; //Bien

    static ArrayList<Ticket>copiaParaSoporte;

    /**
     * Mandamos a inicializar el constructor padre
     */
    public ColaMesaAyuda(){
        super();
        ticketsResueltos= new ArrayList<>();
        ticketsAsignados= new ArrayList<>();
        ticketBitacorizado= new Ticket();
        copiaParaSoporte=  (ArrayList<Ticket>) miListaTickets.clone();
    }

    @Override
    public void sacarCola() {

        //Este sera de tipo First In First Out
        System.out.println("==========================================");
        System.out.println("Funcionamiento de Cola: F I F O");
        System.out.println("==========================================");
        System.out.println("Mostrando Detalles Ticket: ");
        System.out.println(miListaTickets.get(0));
        System.out.println("Puedes Solucionarlo? ");
        System.out.print("S/N ");
        System.out.print("Opcion: ");
        opcMesa= sc.nextLine();
        System.out.println("");

        //Metodo de Validacion If
        if(opcMesa.equalsIgnoreCase("S")|| opcMesa.equalsIgnoreCase("s")){
            miListaTickets.remove(miListaTickets.get(0));
            System.out.println("Seleccion de Empleado: ");
            Trabajadores[] listadoEmpleados = Trabajadores.values();

            //Recorremos el Array para ver sus elementos
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
            //Parte 2
            //Creamos un Evento de Asignacion de Ticket en la Bitacora
            asignarTicket = new Bitacora(ticketBitacorizado.getNitUsuario(),
                    ticketBitacorizado.getNombreUsuario(), ticketBitacorizado.getDescripcionProblema(), ticketBitacorizado.getEstado(),
                    ticketBitacorizado.getMovimientoTicket(), listadoEmpleados[opcTrabajador - 1], fechaYHoraEmision, msjRespuesta, TipoEvento.ASIGNAR);

            //Creamos un Evento de Resolver Ticket en la Bitacora
            resolverTicket = new Bitacora(ticketBitacorizado.getNitUsuario(),
                    ticketBitacorizado.getNombreUsuario(), ticketBitacorizado.getDescripcionProblema(), ticketBitacorizado.getEstado(),
                    ticketBitacorizado.getMovimientoTicket(), listadoEmpleados[opcTrabajador - 1], fechaYHoraEmision, msjRespuesta, TipoEvento.SOLUCION);

            //Agregamos a ArrayList
            ticketsAsignados.add(asignarTicket);
            //Agregramos a ArrayList
            ticketsResueltos.add(resolverTicket);
            //Ver Listado
            listadoGeneral();
        }

        //Metodo Else-If
        else if(opcMesa.equalsIgnoreCase("N")|| opcMesa.equalsIgnoreCase("n")){
            System.out.println("Ticket: ");

            System.out.println(miListaTickets.get(0));
            System.out.println("Escalando a Cola Soporte Tecnico...");

            copiaParaSoporte.add(miListaTickets.get(0));
            miListaTickets.remove(miListaTickets.get(0));
            System.out.println("");
        }

    }

    /**
     * Metodo ver Tickets de Area
     */
    public void mesaAyuda(){
        for(int i=0;i<ticketsAsignados.size();i++) {
            System.out.println(ticketsAsignados.toString());
        }
    }

    /**
     * Metodo ver Tickets Solucionados
     */
    public void resueltosAyuda(){
        for(int i=0;i<ticketsResueltos.size();i++) {
            System.out.println(ticketsResueltos.toString());
        }
    }

    /**
     * Metodo ver Tickets Generales
     */
    public void colaAyuda(){
        for(int i=0;i<miListaTickets.size();i++){
            System.out.println(miListaTickets.toString());
        }
    }
}
