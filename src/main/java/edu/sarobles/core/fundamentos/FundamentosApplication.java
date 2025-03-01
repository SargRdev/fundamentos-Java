package edu.sarobles.core.fundamentos;

import edu.sarobles.core.fundamentos.model.Agenda;
import edu.sarobles.core.fundamentos.model.Tarea;
import edu.sarobles.core.fundamentos.model.TareaDomestica;
import edu.sarobles.core.fundamentos.model.TareaLaboral;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.ArrayList;
import java.util.Date;
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
                4. Mostrar Información
                5. Salir""");

        System.out.print("Digite el número de opción: ");
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

                mostrarInformacion(tareas);
                break;

            case 5:

                salir = true;
                break;

            default:

                System.out.println("¡Opción no valida!");
        }

        return salir;
    }


    public static void agregar(Scanner entrada, ArrayList<Tarea> tareas) {
        Tarea tareaNueva;

        System.out.println("""
                Elija el tipo de tarea que desea agregar:
                1. Tarea Laboral
                2. Tarea Doméstica
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
                ((TareaLaboral)tareaNueva).asignarFecha(new Date());
                ((TareaLaboral)tareaNueva).asignarHoraInicio(new Date());
                ((TareaLaboral)tareaNueva).asignarHoraFin(new Date());
                tareas.add(tareaNueva);
                System.out.println("Tarea agregada con éxito");
                break;
            case 2:
                tareaNueva = new TareaDomestica();
                tareaNueva.setId(tareas.size()+1);
                System.out.println("Ingrese la descripción: ");
                tareaNueva.setDescription(entrada.nextLine());
                System.out.println("Indique el área: ");
                ((TareaDomestica)tareaNueva).setArea(entrada.nextLine());
                ((TareaDomestica)tareaNueva).asignarFecha(new Date());
                ((TareaDomestica)tareaNueva).asignarHoraInicio(new Date());
                ((TareaDomestica)tareaNueva).asignarHoraFin(new Date());
                tareas.add(tareaNueva);
                System.out.println("*** Tarea agregada con exito ***");
                break;
            case 3:
                System.out.println("*** REGRESANDO AL MENÚ PRINCIPAL ***");
                break;

            default:
                System.out.println("*** opción incorrecta *** ");
        }

    }

    public static void mostrarInformacion(ArrayList<Tarea> tareas) {
        Agenda agenda = new Agenda();
        for (int i = 0; i < tareas.size(); i++){
            if (tareas.get(i) instanceof TareaLaboral){
                agenda.mostrarInformacion((TareaLaboral)tareas.get(i));
            }else if (tareas.get(i) instanceof TareaDomestica){
                agenda.mostrarInformacion((TareaDomestica)tareas.get(i));
            }
        }
    }

    public static void listar(ArrayList<Tarea> tareas) {
        if (tareas.isEmpty()) {
            System.out.println("*** No hay tareas en la Lista ***");
        }else {
            System.out.println("****** Tareas: ******");
            for (Tarea tarea : tareas) {
                System.out.println(tarea.toString());
                //System.out.println(tarea.getId() + " " + tarea.getDescription());
                System.out.println(tarea.notificar());
                tarea.enviarPorEmail();
            }
            System.out.println("****** FIN ******");
        }
    }

    public static void eliminar(Scanner entrada, ArrayList<Tarea> tareas) {
            listar(tareas);
            if (tareas.isEmpty()) {
                return;
            }
            System.out.print("Ingrese el id de la tarea que deseas eliminar: ");
            String id = entrada.nextLine();
            for (int i = 0; i < tareas.size(); i++) {
                if (tareas.get(i).getId()==Integer.parseInt(id)) {
                    tareas.remove(i);

                    System.out.println("*** Tarea eliminada con éxito ***");
                }
        }
    }
}
