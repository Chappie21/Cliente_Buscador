package Componentes;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BotonE extends JButton{
	
	private ImageIcon imagen;
	private Icon porta;
	
	//CONSTRUCTOR 
	public BotonE() {
		super();
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);
		this.setVisible(true);
	}
	
	public void Estilo(String url) {
		this.imagen = new ImageIcon(url);
		
		this.porta = new ImageIcon(imagen.getImage().getScaledInstance(this.getWidth(),this.getHeight(),
				Image.SCALE_DEFAULT));
		
		this.setIcon(porta);
	}
}
