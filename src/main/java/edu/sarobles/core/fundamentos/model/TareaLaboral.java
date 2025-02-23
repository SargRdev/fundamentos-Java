package edu.sarobles.core.fundamentos.model;

public class TareaLaboral extends Tarea {
    private String prioridad;

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    @Override
    public String toString() {
        return super.toString()
        + "TareaLaboral [prioridad= " + prioridad + "]";

    }
}

