package edu.sarobles.core.fundamentos.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilities {
     public String formatearFecha(Date fecha) {
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy hh:mm");
         return formato.format(fecha);
     }

}
