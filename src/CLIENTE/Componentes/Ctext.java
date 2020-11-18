package CLIENTE.Componentes;

import javax.swing.JTextField;
import com.placeholder.PlaceHolder;

public class Ctext extends JTextField{
	
	//CONSTRUCTOR
	public Ctext(String mensaje) {
		this.setOpaque(false);
		PlaceHolder placeholder = new PlaceHolder(this, mensaje);/*MENSAJE TRASLUCIDO*/
		placeholder.setFont("Arial");
		placeholder.setSize(18);
	}
}
