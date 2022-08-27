package colas;

import bitacoras.Bitacora;
import bitacoras.TipoEvento;
import clases.Main;
import clases.Ticket;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class ColaServicio {
    static ArrayList<Ticket> miListaTickets= new ArrayList<>();
    ArrayList<Ticket> copiaListaTickets;
    Ticket nuevoTicket;
    Scanner sc= new Scanner(System.in);

    /**
     * Hacemos una copia para trabajar con ella en las distintas mesas/colas
     */
    public ColaServicio(){
        copiaListaTickets= (ArrayList<Ticket>) miListaTickets.clone();
    }

    /**
     * Metodo para introducir un objeto en el ArrayList
     */
    public void introducirTicket(){
        System.out.println("==========================================");
        System.out.println("Ingrese NIT: ");
        String NIT= sc.nextLine();

        System.out.println("Ingrese Nombre: ");
        String nombreUsuario=sc.nextLine();

        System.out.println("Ingrese Deescripcion Problema: ");
        String descripcionProblema=sc.nextLine();

        int estado=1;

        nuevoTicket=new Ticket(NIT,nombreUsuario,descripcionProblema,estado,TipoEvento.CREAR);
        miListaTickets.add(nuevoTicket);

        System.out.println("==========================================");
    }

    /**
     * Metodo para ver el Listado
     */
    public void listadoGeneral(){
        for(int i=0;i<miListaTickets.size();i++){
            System.out.println("ID Ticket: " + miListaTickets.get(i).getIdTicket() + " " +
                    "NIT Usuario: "+miListaTickets.get(i).getNitUsuario()+" "+
                    "Nombre Usuario: " + miListaTickets.get(i).getNombreUsuario() + " " +
                    "Descripcion Problema: " + miListaTickets.get(i).getDescripcionProblema() + " " +
                    "Estado: " + miListaTickets.get(i).getEstado() + " " +
                    "Tipo Evento: " + miListaTickets.get(i).getMovimientoTicket());
        }
    }

    /**
     * Implementacion de metodo abstracto sacar cola
     */
   public abstract void sacarCola();

}
