package edu.sarobles.core.fundamentos.model;

public class TareaDomestica extends Tarea{
    private String area;

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return super.toString() + "TareaDomestica{" + "area=" + area + '}';
    }
}
