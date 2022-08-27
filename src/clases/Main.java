package clases;


import colas.ColaDesarrollador;
import colas.ColaMesaAyuda;
import colas.ColaSoporteTecnico;

import java.io.IOException;
import java.util.Scanner;

public class Main extends Ticket{

//Metodo MAIN
    public static void main(String[] args)  throws IOException {
        //Variables Globales
        ColaMesaAyuda cMA= new ColaMesaAyuda();
        ColaSoporteTecnico cST= new ColaSoporteTecnico();
        ColaDesarrollador cD= new ColaDesarrollador();
        Scanner sc= new Scanner(System.in);
        Ticket ticket= new Ticket();
        boolean check=true;
        int opcGeneral;
        int opcMesa=0;

        //Inicio Ciclo While para el Menu
        while(check){
            System.out.println("==========================================");
            System.out.println("Bienvenido al Sistema de Tickets");
            System.out.println("1. Crear Ticket");
            System.out.println("2. Resolver/Asignar Ticket");
            System.out.println("3. Mostrar Reportes");
            System.out.println("4. Cargar Informacion Metodo JSON");
            System.out.println("5. Finalizar Programa");
            System.out.print("Opcion: ");
            opcGeneral=sc.nextInt();
            System.out.println("==========================================");

            switch (opcGeneral){
                case 1:
                    System.out.println("==========================================");
                    System.out.println("Menu de Creacion de Ticket");
                    ticket.introducirTicket();
                    ticket.listadoGeneral();
                    System.out.println("==========================================");
                    break;
                case 2:
                    System.out.println("==========================================");
                    System.out.println("Menu de Resolucion/Asignacion de Ticket");

                    System.out.println("Seleccione Mesa a la Que Pertenece: ");
                    System.out.println("1. Mesa de Ayuda");
                    System.out.println("2. Soporte Tecnico");
                    System.out.println("3. Desarrollador");
                    System.out.print("Opcion: ");

                     opcMesa=sc.nextInt();

                     if(opcMesa==1){
                         System.out.println("Mesa de Ayuda");
                         System.out.println("La Asignacion de Tickets es Tipo First In First Out");
                         cMA.sacarCola();
                     }
                     else if(opcMesa==2){
                         System.out.println("Soporte Tecnico");
                         System.out.println("La Asignacion de Tickets es Tipo Last In First Out");
                         cST.sacarCola();
                     }
                     else if(opcMesa==3){
                         System.out.println("Desarrollo");
                         System.out.println("La Asignacion de Tickets es RANDOM");
                         cD.sacarCola();
                     }

                    System.out.println("==========================================");
                    break;
                case 3:
                    System.out.println("==========================================");
                    System.out.println("Menu de Mostrar Reportes");
                    System.out.println("1. Listado General");
                    System.out.println("2.Listado Colas");
                    System.out.print("Opcion: ");
                    String opcImprimir=sc.nextLine();

                    if(opcImprimir.equals("1")){
                        ticket.listadoGeneral();
                    }
                    else if(opcImprimir.equals("2")){
                        System.out.println("==========================================");
                        System.out.println("Cola Mesa Ayuda");
                        System.out.println("Generales: ");
                        cMA.colaAyuda();
                        System.out.println("==========================================");
                        System.out.println("Resueltos: ");
                        cMA.resueltosAyuda();
                        System.out.println("==========================================");
                        System.out.println("Asignados: ");
                        cMA.mesaAyuda();
                        System.out.println("==========================================");

                        System.out.println("Resueltos: ");
                        cST.soporteResueltos();

                        System.out.println("==========================================");
                        System.out.println("Asignados: ");
                        cST.asignadosSoporte();

                        System.out.println("==========================================");

                        System.out.println("Cola Desarrollo");

                        System.out.println("Resueltos: ");
                        cD.resueltosDesarrollo();

                        System.out.println("==========================================");
                        System.out.println("Asignados: ");
                        cD.asignadosDesarrollo();

                        System.out.println("==========================================");
                    }

                    System.out.println("==========================================");
                    break;
                case 4:
                    System.out.println("==========================================");
                    System.out.println("Menu de Cargar Informacion por JSON");
                    System.out.println("==========================================");
                    break;
                case 5:
                    System.out.println("==========================================");
                    System.out.println("Cerrando Sistema");
                    System.out.println("==========================================");
                    check=false;
                    break;
                default:
                    System.out.println("==========================================");
                    System.out.println("Opcion no Valida!");
                    System.out.println("==========================================");
                    check=false;
                    break;
            }
        }
    }

}
