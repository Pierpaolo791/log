
package com.olimpia.registro.log;

import com.olimpia.registro.model.Iscritto;

public class LogModifica extends Log {
    private Iscritto vecchio;
    private Iscritto nuovo; 

    public LogModifica(String address, int port, Iscritto vecchio, Iscritto nuovo) {
        super(address, port);
        this.vecchio = vecchio;
        this.nuovo = nuovo; 
        if (!matchIscritto(vecchio).equals(nuovo))
            super.file.write(this);
    }
    
    @Override
    protected String composeLog() {
        String x = "_____________\n" 
                +  "Modificaa iscritto.\n" 
                + getUserInfo() + "\n"
                + "Iscritto prima della modifica" + "\n"
                + matchIscritto(vecchio) + "\n" 
                + "Iscritto dopo della modifica" + "\n"
                + matchIscritto(nuovo) + "\n"
                + getTimeStamp() + "\n"
                + "_____________"
            ;  
        return x;
    }
    
    private String matchIscritto(Iscritto iscritto) {
        String x = "id: " + iscritto.getId() + "\n"
                + iscritto.getNome() + " " + iscritto.getCognome() + "\n"
                + "Data nascita: " + iscritto.getNascita() + "\n"
                + "Genere: " + iscritto.getGenere() + "\n"
                + "Cellulare: " + iscritto.getCellulare() + "\n"
                + "Email: " + iscritto.getEmail() + "\n"
                + "Data iscrizione: " + iscritto.getIscrizione() + "\n"
                + "Path foto: " + iscritto.getFoto() + "\n"
                + "Data scadenza: " + iscritto.getScadenza(); 
                
        return x; 
    }
}
