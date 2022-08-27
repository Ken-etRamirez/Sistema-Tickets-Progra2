package colas;

import bitacoras.Bitacora;
import bitacoras.TipoEvento;
import bitacoras.Trabajadores;
import clases.Ticket;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import static colas.ColaMesaAyuda.*;


public class ColaSoporteTecnico extends ColaServicio {
    static ArrayList<Ticket> copiaDesarrollo;

    Scanner sc = new Scanner(System.in);
    Ticket ticketBitacorizado;
    Bitacora asignarTicket;
    Bitacora resolverTicket;
    ArrayList<Ticket> ticketsResueltos;
    ArrayList<Ticket> ticketsAsignados;
    ArrayList<Ticket> escalandoSoporte;
    ArrayList<Ticket> escalandoDesarrollo;
    String opcResolver;


    /**
     * Mandamos a inicializar el constructor padre
     */
    public ColaSoporteTecnico() {
        super();
        ticketsResueltos = new ArrayList<>();
        ticketsAsignados = new ArrayList<>();
        ticketBitacorizado = new Ticket();
        escalandoDesarrollo = new ArrayList<>();
        copiaDesarrollo = (ArrayList<Ticket>) copiaParaSoporte.clone();
    }

    @Override
    public void sacarCola() {
        Scanner cs = new Scanner(System.in);
        System.out.println("==========================================");
        System.out.println("Funcionamiento de Cola: L I F O");
        System.out.println("==========================================");

        int lastIdx = copiaParaSoporte.size() - 1;
        Ticket lastElement = copiaParaSoporte.get(lastIdx);
        System.out.println(lastElement.toString());
        System.out.println("Puedes Resolverlo? ");
        System.out.println("S/n");
        System.out.println("Opcion: ");
        opcResolver = sc.nextLine();
        System.out.println("");

        if (opcResolver.equalsIgnoreCase("S")|| opcResolver.equalsIgnoreCase("s")) {
            System.out.println("Seleccion de Empleado: ");
            Trabajadores[] listadoEmpleados = Trabajadores.values();

            /**
             *  Recorremos el Array para ver sus elementos
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

            //Creamos un Evento de Asignacion de Ticket en la Bitacora
            asignarTicket = new Bitacora(ticketBitacorizado.getNitUsuario(),
                    ticketBitacorizado.getNombreUsuario(), ticketBitacorizado.getDescripcionProblema(), ticketBitacorizado.getEstado(),
                    ticketBitacorizado.getMovimientoTicket(), listadoEmpleados[opcTrabajador - 1], fechaYHoraEmision, msjRespuesta, TipoEvento.ASIGNAR);

            //Creamos un Evento de Resolver Ticket en la Bitacora
            resolverTicket = new Bitacora(ticketBitacorizado.getNitUsuario(),
                    ticketBitacorizado.getNombreUsuario(), ticketBitacorizado.getDescripcionProblema(), ticketBitacorizado.getEstado(),
                    ticketBitacorizado.getMovimientoTicket(), listadoEmpleados[opcTrabajador - 1], fechaYHoraEmision, msjRespuesta, TipoEvento.SOLUCION);

            ticketsAsignados.add(asignarTicket);
            ticketsResueltos.add(resolverTicket);
            copiaParaSoporte.remove(lastElement);
            listadoGeneral();
        } else if (opcResolver.equalsIgnoreCase("N")|| opcResolver.equalsIgnoreCase("n")) {
            System.out.println("Ticket: ");
            System.out.println(lastElement);
            System.out.println("Escalando a Cola Desarrollador...");
            copiaDesarrollo.add(lastElement);
            copiaParaSoporte.remove(lastElement);
            miListaTickets.remove(lastElement);
        }

    }

    /**
     * Creacion de Metodo Tickets Asignados
     */
    public void asignadosSoporte(){
     for(int i=0;i<ticketsAsignados.size();i++){
         System.out.println(ticketsAsignados.toString());
     }
    }


    /**
     * Creacion de Metodo ver Tickets Resueltos
     */
    public void soporteResueltos(){
        for(int i=0;i<ticketsResueltos.size();i++){
            System.out.println(ticketsResueltos.toString());
        }
    }


    /**
     * Creacion de metodo ver el nuevo arrayList
     */
    public void GeneralesSoporte(){
        for(int i=0;i<copiaDesarrollo.size();i++){
            System.out.println(copiaDesarrollo.toString());
        }
    }


}

