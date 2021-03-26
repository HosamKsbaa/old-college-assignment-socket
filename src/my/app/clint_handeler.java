/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.app;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class clint_handeler extends Thread {
    
    //temp input output 
     DataInputStream dis; 
     DataOutputStream dos; 
     
     
     clint_data []allclint;
     int size;
     String data;
     int f1=0;
     
     
     String name;
    public clint_handeler( DataInputStream dis, DataOutputStream dos,clint_data []allclint,int size,String name)  
    { 
         
        this.dis = dis; 
        this.dos = dos; 
        this.allclint=allclint;
        this.size=size;
        this.name=name;
       
    }
    //it is a threaded function so that every clent can send and recive from the same client
    @Override
    public void run(){
        while(true){
            try {
                data=dis.readUTF();
               while(allclint[f1] != null ){
                   if(allclint[f1].username!=name){allclint[f1].cout.writeUTF(name+" send :-"+data);}
                    
                    //System.out.println(f1);
                    f1++;
                }
                f1=0;
            } 
            catch (IOException ex) {
                Logger.getLogger(clint_handeler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
