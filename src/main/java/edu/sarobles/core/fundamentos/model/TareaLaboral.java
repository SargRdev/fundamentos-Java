package edu.sarobles.core.fundamentos.model;

import edu.sarobles.core.fundamentos.Interfaces.IAgenda;
import edu.sarobles.core.fundamentos.Interfaces.ITarea;
import edu.sarobles.core.fundamentos.utils.Utilities;

import java.util.Date;

public class TareaLaboral extends Tarea implements ITarea, IAgenda {
    private String prioridad;
    private Date fecha;
    private Date horaInicio;
    private Date horaFin;

    private Utilities utilities = new Utilities();

    public TareaLaboral() {
        super();
    }

    public TareaLaboral(String area) {
        super();
        this.prioridad = area;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    @Override
    public String toString() {
        return "Tarea tipo= Laboral \n" + super.toString()
        + "prioridad= " + prioridad + "\n"
                + "************************";
    }

    @Override
    public String notificar() {
        return "Tienes una tarea Laboral: " + getDescription()+" con prioridad: "+getPrioridad();
    }


    @Override
    public void asignarFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public void asignarHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    @Override
    public void asignarHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }


    @Override
    public void mostrarOcupacion() {
        System.out.println(this.getDescription()+ " " + this.getPrioridad()+ " " + utilities.formatearFecha(fecha) + " " + utilities.formatearFecha(horaInicio) + " " + utilities.formatearFecha(horaFin));
    }
}

