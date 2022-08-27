package bitacoras;

import java.util.Scanner;

public enum Trabajadores {
    //Lista Trabajadores
    KENNET("110236896"),JOAB("120000147"),LISSETH("111444556"),MARCELA("120853699");

    private String  nitEmpleado;

    /**
     * Constructor Vacio
     */
    Trabajadores(){
    }


    /**
     *
     * @param nitEmpleado Aca vemos el nit ya cargado en una clase Enum para facilitar la asignacion y demas.
     */
    Trabajadores(String nitEmpleado){
        this.nitEmpleado=nitEmpleado;
    }

    //Metodo getNit
    public String getNitEmpleado() {
        return this.nitEmpleado;
    }

    //Metodo setNit
    public void setNitEmpleado(String nitEmpleado) {
        this.nitEmpleado = nitEmpleado;
    }


    /**
     * Funcion ver Empleados
     */
    private static void mostrarListaEmpleados(){
        Scanner sc= new Scanner(System.in);
        Trabajadores [] listaTrabajadores= Trabajadores.values();
        //Recorremos Array Para Ver Elementos
        for(int i=0;i< listaTrabajadores.length;i++){
            System.out.println((i+1)+" )"+listaTrabajadores[i]);
        }
        System.out.println("Opcion: ");
        int opcTrabajador=sc.nextInt();
        System.out.println("Haz elegido: "+listaTrabajadores[opcTrabajador-1]);
    }
}
