/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.app;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class printing extends Thread {
    DataInputStream cin;
    public printing(DataInputStream cin)
    {
        this.cin=cin;
    }
    @Override
    public void run()
    {
        try {
            while(true){
            
            System.out.println("               "+cin.readUTF());
            }
        } catch (IOException ex) {
            Logger.getLogger(printing.class.getName()).log(Level.SEVERE, null, ex);      
    }
}
}
