package CLIENTE.Componentes;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Wallper extends JLabel{
	
	//ATRIBUTOS
	private ImageIcon imagen;
	private Icon porta;
	
	public Wallper(int x, int y, String URL) {
		
		this.setBounds(0, 0, x, y);
		
		//COLOCAR IMAGEN DE FONDO
		this.imagen = new ImageIcon(URL);
		this.porta = new ImageIcon(imagen.getImage().getScaledInstance(this.getWidth(),this.getHeight(),
				Image.SCALE_DEFAULT));
		
		this.setIcon(porta);
	}
}
