
package com.olimpia.registro.log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileLog implements FileLogInterface {

    private static FileLog  istance; 
    
    private File file; 
    
    private FileLog() {
        file = new File("log.txt"); 
    }
    
    public static FileLog getIstance() {
        if (istance == null)   
            istance = new FileLog();
        return istance; 
    }
    
    @Override
    public String read() {
        BufferedReader buffer;
        String reader=new String();
        try {
            buffer = new BufferedReader(new FileReader(file));
            String bufferLine = buffer.readLine(); 
            while (bufferLine != null) {
                reader += bufferLine + "\n"; 
                bufferLine = buffer.readLine();
            }
            buffer.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            System.err.println("Exception in read");
            ex.printStackTrace();
        }
        return reader;
    }

    @Override
    public void write(Log log) {
        BufferedWriter buffer;  
        String tmpString = log + read();
        try {
            buffer = new BufferedWriter(new FileWriter(file));
            
            System.out.println(read());
            buffer.write(tmpString);
            buffer.close();
        } catch(Exception e) {
            System.err.println("Exception in write");
            e.printStackTrace();
        }
        
    }
    
}
