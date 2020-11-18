package CLIENTE.UI;

import javax.swing.*;
import CLIENTE.Componentes.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class principal extends JFrame implements ActionListener{

    //ACCIONES DEL CLIENTE
    private DataOutputStream out;
    private DataInputStream input;

    //ATRIBUTOS
    private JPanel panel = new JPanel();
    private Wallper fondo;
    private JLabel info;
    private BotonE boton;
    private Ctext busq, rutadestino;

    //CONSTRUCTOR VACIO
    public principal(){
        super("Busqueda de archivos");
        this.setSize(600,250);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setContentPane(panel);
        Componentes();
    }

    //INICIAR COMPONENTES
    private void Componentes(){
        this.panel.setLayout(null);

        //BARRA DE BUSQUEDA
        this.busq = new Ctext("Ingrese ruta del archivo deseado");
        this.busq.setBounds(30,30,400,50);

        this.panel.add(busq);

        this.rutadestino = new Ctext("Ingrese ruta destino");
        this.rutadestino.setBounds(30,100,400,50);

        this.panel.add(rutadestino);


        //BOTON DE SIGUIENTE
        this.boton = new BotonE();
        this.boton.setBounds(450,35,100,100);
        this.boton.Estilo("src/CLIENTE/Imagenes/boton.png");
        this.boton.addActionListener(this);

        this.panel.add(boton);

        //JLabel Informativo
        this.info = new JLabel();
        this.info.setBounds(30,150,400,50);
        this.info.setFont(new Font("Arial",1,25));

        this.panel.add(info);

        //COLOCAR FONDO
        this.fondo = new Wallper(this.getWidth(),this.getHeight(),"src/CLIENTE/Imagenes/fondo.jpg");
        this.panel.add(fondo);
        this.repaint();
    }

    //EVENTOS
    @Override
    public void actionPerformed(ActionEvent e){

        if(e.getSource()== boton){
            EnviarURL();
        }
    }

    //OBTENER RUTA DESTINO
    private String destino(){
        String nuevo[] = this.busq.getText().split("/"); 

        return nuevo[nuevo.length-1];
    }

    private void EnviarURL(){
       
       try{
            Socket so = new Socket("192.168.10.107", 9999);
            this.out = new DataOutputStream(so.getOutputStream());
            this.out.writeUTF(busq.getText());

            this.input = new DataInputStream(so.getInputStream());

            boolean envio = this.input.readBoolean();

            if(envio){

                byte datos[] = this.input.readAllBytes();

                FileOutputStream salida = new FileOutputStream(rutadestino.getText()+"/"+destino());

                this.info.setForeground(Color.BLACK);
                this.info.setText("Copiando Archivo, por favor espere...");

                for(int i=0; i<datos.length;i++){
                    salida.write(datos[i]);
                }

                this.info.setForeground(Color.green);
                this.info.setText("Archivo copiado con exito");

                salida.close();
            }else{
                this.info.setForeground(Color.red);
                this.info.setText("ERROR, Archivo no existente...");
            }

            this.input.close();
            this.out.close();
       }catch(IOException e){
            System.out.println("Cliente ERROR: "+e.getMessage());
       }

    }
}


