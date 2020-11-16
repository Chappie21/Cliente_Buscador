package UI;

import javax.swing.*;
import Componentes.*;

public class principal extends JFrame{

    //ATRIBUTOS
    private JPanel panel = new JPanel();

    //CONSTRUCTOR VACIO
    public principal(){
        super("Busqueda de archivos");
        this.setSize(500,300);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    //INICIAR COMPONENTES
    private void Componentes(){

    }
}


