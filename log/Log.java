package com.olimpia.registro.log;

import java.util.Date;

public class Log {
    
    private String address; 
    private int port; 
    private String request; 
    private Date timestamp; 
    
    private static FileLog file = FileLog.getIstance();
    
    private Log() {
        
    }

    public Log(String address, int port, String request) {
        this.address = address;
        this.port = port;
        this.request = request;
        this.timestamp = new Date();
        file.write(this);    
    }
    

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }
    
    
    public String toString() {
        return new String(""+address+":"+port+"\t"+request+"\t"+timestamp+"\n");
    }
    
}
