package edu.sarobles.core.fundamentos.model;

import edu.sarobles.core.fundamentos.Interfaces.IAgenda;
import edu.sarobles.core.fundamentos.Interfaces.ITarea;
import edu.sarobles.core.fundamentos.utils.Utilities;

import java.sql.SQLOutput;
import java.util.Date;

public class TareaDomestica extends Tarea implements ITarea, IAgenda {
    private String area;
    private Date fecha;
    private Date horaInicio;
    private Date horaFin;
    private Utilities utilities = new Utilities();
    public TareaDomestica() {
        super();
    }

    public TareaDomestica(String area) {
        super();
        this.area = area;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Tarea tipo= Doméstica \n" + super.toString()
                + "área= " + area + "\n"
                + "************************";
    }

    @Override
    public String notificar() {
        return "Tienes una tarea Domestica" + getDescription() + " " + getArea();
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
        System.out.println(this.getDescription()+ " " + this.getArea()+ " " + utilities.formatearFecha(fecha) + " " + utilities.formatearFecha(horaInicio) + " " + utilities.formatearFecha(horaFin));
    }
}
