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
                    
                    this.ventana.setConsola("#Cliente pide archivo: "+data);

                    //CREA UN HILO INICIANDO LA OPERACIOND BUSQUEDA
                    Thread hilo = new Thread(this);
                    hilo.start();

                }

          }catch(IOException e){
               this.ventana.setConsola("->Sistema ERROR: "+e.getMessage());/*EN CASO DE ERROR*/
          }finally{
               try {
                    this.server.close();
               } catch (IOException e) {
                    e.printStackTrace();
               }
          }
    }

    private void enviar(byte datos[]){
         try{ 
               this.out = new DataOutputStream(so.getOutputStream());

              if(datos != null){
                    this.out.writeBoolean(true);
                    this.out.write(datos);
              }else{
                    this.out.writeBoolean(false);
              }

               this.ventana.setConsola("->Sistema: data correspondiente enviada");
               this.out.close();
               this.so.close();
         }catch(IOException e){
               this.ventana.setConsola("->Sistema ERROR: "+e.getMessage());
         }
    }

    //METODO RUN
    @Override
    public void run(){
          
          File archivo = new File(data);

          if(archivo.exists()){
               this.ventana.setConsola("->Sistema: archivo Existente, enviado data...");

               try {
                    FileInputStream archivodata = new FileInputStream(archivo);

                    enviar(archivodata.readAllBytes());

                    archivodata.close();
               } catch (IOException e) {
                    this.ventana.setConsola("->Sistema ERROR: "+e.getMessage());/*EN CASO DE ERROR*/
               }


          }else{

               this.ventana.setConsola("->Archivo no existente...");
               this.ventana.setConsola("->Se enviará un dato nulo");
               enviar(null);
          }

    }

}
