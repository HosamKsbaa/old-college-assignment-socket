/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.app;

/**
 *
 * @author User
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
public class myserv extends Thread{
    public int current_nline_clients;
    String name;
    int f1;
   clint_data []allclint=new clint_data[10];
            
    @Override
    public void run(){
       
            
         try {
                ServerSocket Serversocket=new ServerSocket(4123);
                while(true){
                    Socket client_port_data=Serversocket.accept();

                     DataInputStream cin=new DataInputStream(client_port_data.getInputStream());
                     DataOutputStream cout=new DataOutputStream(client_port_data.getOutputStream());
                     
                     name=cin.readUTF();//geting the clent name
                     
                     System.out.println("A new client is connected : " + client_port_data+" name: "+name);
                     ////////////
                        for(int f50=0;f50<current_nline_clients;f50++)
                        {
                            allclint[f50].cout.writeUTF("client" +name+" is online ");
                        }
                        /////////
                     clint_data c1=new clint_data(name,true,cin,cout);
                    allclint[current_nline_clients++]=c1;
                    for(int f3=0;f3<current_nline_clients;f3++)
                    {
                        cout.writeUTF(allclint[f3].username+" is online");
                    }
                     clint_handeler t1 =new clint_handeler(cin,cout,allclint,current_nline_clients,name);
                     t1.start();
                }
             
            } catch (IOException ex) {
             Logger.getLogger(myserv.class.getName()).log(Level.SEVERE, null, ex);}  
    }
    
    
    
}
