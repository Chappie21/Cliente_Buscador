package CLIENTE.UI;

import javax.swing.*;
import CLIENTE.Componentes.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class principal extends JFrame implements ActionListener{

    //ACCIONES DEL CLIENTE
    private DataOutputStream out;
    private DataInputStream input;

    //ATRIBUTOS
    private JPanel panel = new JPanel();
    private Wallper fondo;
    private BotonE boton;
    private Ctext busq;

    //CONSTRUCTOR VACIO
    public principal(){
        super("Busqueda de archivos");
        this.setSize(600,400);
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
        this.busq = new Ctext("Ingrese el URL del archivo deseado");
        this.busq.setBounds(30,30,400,50);

        this.panel.add(busq);

        //BOTON DE SIGUIENTE
        this.boton = new BotonE();
        this.boton.setBounds(445,25,60,60);
        this.boton.Estilo("src/CLIENTE/Imagenes/boton.png");
        this.boton.addActionListener(this);

        this.panel.add(boton);

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

    private void EnviarURL(){

       try{
            Socket so = new Socket("192.168.10.107", 9999);
            this.out = new DataOutputStream(so.getOutputStream());
            this.out.writeUTF(busq.getText());

            this.out.close();
       }catch(IOException e){
            System.out.println("Cliente ERROR: "+e.getMessage());
       }

    }
}


