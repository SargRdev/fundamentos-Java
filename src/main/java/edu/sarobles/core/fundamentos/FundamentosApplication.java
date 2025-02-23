package edu.sarobles.core.fundamentos;

import edu.sarobles.core.fundamentos.model.Tarea;
import edu.sarobles.core.fundamentos.model.TareaDomestica;
import edu.sarobles.core.fundamentos.model.TareaLaboral;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.ArrayList;
import java.util.Scanner;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {
    Scanner entrada = new Scanner(System.in);
    ArrayList<Tarea> tareas = new ArrayList<>();

    public static void main(String[] args) {
        SpringApplication.run(FundamentosApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        boolean salir = false;
        while (!salir) {
            menu();
            salir = ejecutar(entrada, tareas);
        }

    }

    public static void menu(){
        System.out.println("""
                1. Agregar Tarea
                2. Listar Tareas
                3. Eliminar Tarea
                4. Salir""");

        System.out.print("Digite el número de opción: ");
        System.out.println();
    }

    public boolean ejecutar(Scanner entrada, ArrayList<Tarea> tareas) {
        boolean salir = false;
        int opc = Integer.parseInt(entrada.nextLine());
        switch (opc) {
            case 1:
                agregar(entrada,tareas);
                break;
            case 2:
                listar(tareas);
                break;
            case 3:
                eliminar(entrada,tareas);
                break;

            case 4:

                salir = true;
                break;

            default:

                System.out.println("¡Opción no valida!");
        }

        return salir;
    }


    public static void agregar(Scanner entrada, ArrayList<Tarea> tareas) {
        Tarea tareaNueva;
        boolean salir = false;

        System.out.println("""
                Digite una opción
                1. Tarea Laboral
                2. Tarea Domestica
                3. Salir """);
        int opc = Integer.parseInt(entrada.nextLine());

        switch (opc) {
            case 1:
                tareaNueva  = new TareaLaboral();
                tareaNueva.setId(tareas.size()+1);
                System.out.print("Ingrese la descripción: ");
                tareaNueva.setDescription(entrada.nextLine());
                System.out.print("Indique la prioridad: ");
                ((TareaLaboral)tareaNueva).setPrioridad(entrada.nextLine());
                tareas.add(tareaNueva);
                System.out.println("Tarea agregada con exito");
                break;
            case 2:
                tareaNueva = new TareaDomestica();
                tareaNueva.setId(tareas.size()+1);
                System.out.println("Ingrese la descripción: ");
                tareaNueva.setDescription(entrada.nextLine());
                System.out.println("Indique el área: ");
                ((TareaDomestica)tareaNueva).setArea(entrada.nextLine());
                tareas.add(tareaNueva);
                System.out.println("Tarea agregada con exito");
                break;
            case 3:
                System.out.println("REGRESANDO AL MENÚ PRINCIPAL");
                salir = true;
                break;

            default:
                System.out.println("opción incorrecta");
        }

    }


    public static void listar(ArrayList<Tarea> tareas) {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas");
        }else {
            System.out.println("****** Tareas: ******");
            for (Tarea tarea : tareas) {

                System.out.println(tarea.toString());
                //System.out.println(tarea.getId() + " " + tarea.getDescription());
            }
            System.out.println("****** FIN ******");
        }
    }

    public static void eliminar(Scanner entrada, ArrayList<Tarea> tareas) {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas");
        } else {
            System.out.print("Ingrese el nombre del tarea que desea eliminar: ");
            String eliminar = entrada.nextLine();

            for (int i = 0; i < tareas.size(); i++) {
                if (tareas.get(i).getDescription().equalsIgnoreCase(eliminar)) {
                    tareas.remove(i);
                    System.out.println("Tarea eliminada con exito");
                }

            }
        }
    }
}
