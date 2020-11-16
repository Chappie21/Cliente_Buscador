package Componentes;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import com.placeholder.PlaceHolder;

public class Ctext extends JTextField{
	
	//CONSTRUCTOR
	public Ctext(String mensaje) {
		this.setOpaque(false);
		PlaceHolder placeholder = new PlaceHolder(this, mensaje);/*MENSAJE TRASLUCIDO*/
	}
}
