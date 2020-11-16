package UI;

import javax.swing.*;
import Componentes.*;

public class principal extends JFrame{

    //ATRIBUTOS
    private JPanel panel = new JPanel();
    private Wallper fondo;

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


        //COLOCAR FONDO
        this.fondo = new Wallper(this.getWidth(),this.getHeight(),"src/Imagenes/fondo.jpg");
        this.panel.add(fondo);
        this.repaint();
    }
}


