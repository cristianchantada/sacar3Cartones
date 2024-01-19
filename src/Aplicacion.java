import java.awt.*;
import javax.swing.*;

public class Aplicacion {

	public static final String PATH = "C:\\DAW\\Programación\\Java2Evaluacion\\sacar3Cartones\\src\\";
	// Frame que alberga la aplicación
	static JFrame jFM = new JFrame("Cuadro texto");
	// Panel asociado al Frame donde coloco los elementos.
	static JPanel jpanel = (JPanel) jFM.getContentPane();
	// scroll
	static JScrollPane scroll = new JScrollPane();

	public static void main(String[] args) {

		int numCartones = 0;
		String numCartonesStr = JOptionPane.showInputDialog("Ingrese el número de cartones que desea");

		try {
			numCartones = Integer.parseInt(numCartonesStr);
		} catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null,"Ingresa un número, melón");
			main(null);
		}

		lanzarVentana(numCartones);
		for(int i = 0; i < numCartones; i++){
			CartonVDA carton = new CartonVDA(i);
			carton.mostrarBolasCartonVDA(jpanel);
		}

		// Creo la ventana principal
		jFM.setSize(800, 700 + (275 * numCartones));
		jpanel.setLayout(null);
		jpanel.setBackground(Color.WHITE);

		// Scroll:
		jpanel.setPreferredSize(new Dimension(0, 900 + (275) * numCartones));
		// Coloco las imágenes fijas
		colocarImagenesFijas(numCartones);

		scroll.setViewportView(jpanel);
		jFM.add(scroll);

		// Coloco los botones

		jFM.setVisible(true);

	}

	static void lanzarVentana(int numCartones) {

		// Creo la ventana principal
		jFM.setSize(800, 700 + (275 * numCartones));
		jpanel.setLayout(null);
		jpanel.setBackground(Color.WHITE);

		// Scroll:
		jpanel.setPreferredSize(new Dimension(0, 900 + (275) * numCartones));
		// Coloco las imágenes fijas
		colocarImagenesFijas(numCartones);

		scroll.setViewportView(jpanel);
		jFM.add(scroll);

		// Coloco los botones
		jFM.setVisible(true);
	}

	static void colocarImagenesFijas(int numCartones) {

		// Colocar logo IES VDA label1
		ImageIcon miimagen1 = new ImageIcon(PATH + "imgBingo\\bingoIESVDA.png");
		JLabel label1 = new JLabel(miimagen1);
		label1.setBounds(49, 13, 300, 249);
		jpanel.add(label1);
		jpanel.setComponentZOrder(label1, 0);
		// Colocar numeros 1 a 90

		ImageIcon miimagen2 = new ImageIcon(PATH + "imgBingo\\tableroNumeros.png");
		JLabel label2 = new JLabel(miimagen2);
		label2.setBounds(477, 19, 300, 249);
		jpanel.add(label2);
		jpanel.setComponentZOrder(label2, 0);

		// Colocar cartón vacío
		for(int i = 0; i < numCartones; i++) {
			int movimientoVerticalPanel = 275 * i;
			ImageIcon miimagen3 = new ImageIcon(PATH + "imgBingo\\CartonBingoEnBlanco.png");
			JLabel label3 = new JLabel(miimagen3);
			label3.setBounds(113, 260+movimientoVerticalPanel, 600, 297);
			jpanel.add(label3);
			jpanel.setComponentZOrder(label3, 0);
		}

		jpanel.repaint();
	}


}
