package SERVIDOR.UI;


import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;
import CLIENTE.Componentes.Wallper;
import SERVIDOR.Servidor.Server;

public class ServerVista extends JFrame {

    // SINGLETON
    private static ServerVista vista = new ServerVista();

    // ATRIBUTOS DE LA VENTANA
    private JPanel panel = new JPanel();
    private Wallper fondo;
    private JTextArea consola;

    // CONSTRUCTOR VACIO
    private ServerVista() {
        super("Servidor");
        this.setSize(600, 400);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setContentPane(panel);
        Componentes();

        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowClosing(WindowEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.exit(0);
            }

            @Override
            public void windowIconified(WindowEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowActivated(WindowEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                // TODO Auto-generated method stub

            }
        });
    }

    //INICIAR COMPONENTES
    private void Componentes(){
        this.panel.setLayout(null);

        //JTextArea
        this.consola = new JTextArea();

        //INFO
        this.consola.append("****************************************************************************************************************\n");
        this.consola.append("*\t\t\t\t\t                                      *\n");
        this.consola.append("*                                                         LINE CONSOLE INFORMATION SERVER                                                   *\n");
        this.consola.append("*\t\t\t\t\t                                      *\n");
        this.consola.append("****************************************************************************************************************\n");
        
        this.consola.setEditable(false);
        this.consola.setOpaque(false);
        this.consola.setForeground(Color.white);
        this.consola.setBounds(10,10,565,330);

        this.panel.add(consola);

        //COLOCAR FONDO
        this.fondo = new Wallper(this.getWidth(), this.getHeight(), "src/SERVIDOR/Imagenes/fondo.jpg");
        this.panel.add(fondo);
        this.repaint();
    }

    //RETORNAR INSTANCIA
    public static ServerVista getInstancia(){
        return vista;
    }

    //OBTENER JTEXTAREA
    public void setConsola(String info){
        this.consola.append(info+"\n");
    }

    //Main
    public static void main(String args[]){
        ServerVista l = ServerVista.getInstancia();
        Server w = new Server();
    }
}