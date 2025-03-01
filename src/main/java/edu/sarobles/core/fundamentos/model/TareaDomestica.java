package edu.sarobles.core.fundamentos.model;

import edu.sarobles.core.fundamentos.Interfaces.IAgenda;
import edu.sarobles.core.fundamentos.Interfaces.ITarea;

import java.sql.SQLOutput;
import java.util.Date;

public class TareaDomestica extends Tarea implements ITarea, IAgenda {
    private String area;
    private Date fecha;
    private Date horaInicio;
    private Date horaFin;

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
        System.out.println(this.getDescription()+ " " + this.getArea()+ " " + this.fecha + " " + this.horaInicio + " " + this.horaFin);
    }
}
