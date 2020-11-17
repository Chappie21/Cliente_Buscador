package SERVIDOR.Servidor;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;

import SERVIDOR.UI.*;

public class Server implements Runnable {

     // INSTANCIA CON LA CLASE "ServerVista"
     private ServerVista ventana = ServerVista.getInstancia();

     // ATRIBUTOS DEL SERVIDOR
     private ServerSocket server;
     private Socket so;
     private DataOutputStream out;
     private DataInputStream input;
     private String data;

     // CONSTRUCTOR VACIO
    public Server(){

          try{ 
               this.server = new ServerSocket(9999);/*SE ALOJA EL SERVIDOR EN EL PUERTO 9999*/

               //ESPERA DE SOLICITUD
                while(true){
                    this.so =  this.server.accept(); 
                    this.input = new DataInputStream(so.getInputStream());
                    
                    this.data = input.readUTF();
                    
                    this.ventana.setConsola("Cliente pide archivo: "+data);

                    //CREA UN HILO INICIANDO LA OPERACIOND BUSQUEDA
                    Thread hilo = new Thread(this);
                    hilo.start();

                }

          }catch(IOException e){
               System.out.println("Error en server: "+e.getMessage());/*EN CASO DE ERROR*/
          }finally{
               try {
                    this.server.close();
               } catch (IOException e) {
                    e.printStackTrace();
               }
          }
    }

    //METODO RUN
    @Override
    public void run(){
          
          File archivo = new File(data);

          if(archivo.exists()){
               this.ventana.setConsola("Existe");

               try {
                    FileInputStream archivodata = new FileInputStream(archivo);

                    this.out = new DataOutputStream(so.getOutputStream());

                    this.out.write(archivodata.readAllBytes());

                    this.out.close();
                    this.so.close();
               } catch (IOException e) {
                    e.printStackTrace();
               }


          }

    }

}
