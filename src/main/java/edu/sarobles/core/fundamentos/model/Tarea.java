package edu.sarobles.core.fundamentos.model;

public abstract class Tarea {

    private int id;
    private String description;


    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }


    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    @Override
    public String toString() {
        return "id= " + id + "\n"
                + "descripción= " + description + "\n";
    }
}
