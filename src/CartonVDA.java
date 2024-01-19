import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

class CartonVDA {
	
	final int BOLASTOTALES = 15;
	
	BolaBingo[] bolas = new BolaBingo[15];
	Posicion[] posBola = new Posicion[BOLASTOTALES];
	int nBolasCarton = 0;
	int numCartones;

	CartonVDA(int numCartones) {

		this.numCartones = numCartones;
		sacarBolas(2, 1, 10);
		sacarBolas(2, 11, 20);
		sacarBolas(2, 21, 30);
		sacarBolas(1, 31, 40);
		sacarBolas(2, 41, 50);
		sacarBolas(2, 51, 60);
		sacarBolas(1, 61, 70);
		sacarBolas(2, 71, 80);
		sacarBolas(1, 81, 90);
		
		//Inicializar posiciones
		inicializaPosiciones(numCartones);
	}

	void sacarBolas(int numBolas, int limInf, int limSup) {
		// Para sacar 1 o 2 bolas (intervado de decenas)
		int nBolas = 1;

		BolaBingo bolaNueva = new BolaBingo(limInf, limSup);
		bolas[nBolasCarton] = new BolaBingo(bolaNueva);
		nBolasCarton++;
		//System.out.println("Sacada a bola " + nBolasCarton);

		while (nBolas < numBolas) {
			bolaNueva = new BolaBingo(limInf, limSup);
			if (!bolaNueva.equals(bolas[nBolasCarton - 1])) {
				// Asignación de 2da bola en la decena
				bolas[nBolasCarton] = new BolaBingo(bolaNueva);
				nBolasCarton++;

				// Control de segunda bola
				nBolas++;
			}
		}

		// Ordenar bolas
		if (numBolas == 2) {
			int valorBola1 = bolas[nBolasCarton - 2].getNum();
			int valorBola2 = bolas[nBolasCarton - 1].getNum();

			if (valorBola1 > valorBola2) {
				bolas[nBolasCarton - 2].setNum(valorBola2);
				bolas[nBolasCarton - 1].setNum(valorBola1);
			}
		}
	}

	void mostrarCartonVDA() {
		System.out.println("Bolas que han salido");
		for (int i = 0; i < BOLASTOTALES; i++) {
			System.out.print("Bola " + i + ":");
			System.out.println(bolas[i].getNum());
		}
	}

	void inicializaPosiciones(int numCartones) {
		// Cargar posiciones
		int movimiento = 275 * numCartones;
		int[] posx = { 139, 139, 200, 200, 262, 262, 324, 386, 386, 449, 449, 510, 572, 572, 635 };
		int[] posy = { 300+movimiento, 382+movimiento, 382+movimiento, 464+movimiento,
				300+movimiento, 464+movimiento, 382+movimiento, 300+movimiento, 464+movimiento,
				300+movimiento, 382+movimiento, 464+movimiento, 382+movimiento, 464+movimiento,
				300+movimiento };

		for (int i = 0; i < BOLASTOTALES; i++)
			posBola[i] = new Posicion(posx[i], posy[i]);
	}
	
	void LineaCarton(BolaBingo[] bolascarton) {
		final int BOLASTOTALES = 15;
		BolaBingo[] bolalinea = new BolaBingo[BOLASTOTALES];

		// Cargar Bolas
		for (int i = 0; i < BOLASTOTALES; i++)
			bolalinea[i] = new BolaBingo(bolascarton[i]);
		// Cargar posiciones
		int[] posx = { 139, 139, 200, 200, 262, 262, 324, 386, 386, 449, 449, 510, 572, 572, 635 };
		int[] posy = { 300, 382, 382, 464, 300, 464, 382, 300, 464, 300, 382, 464, 382, 464, 300 };

		for (int i = 0; i < BOLASTOTALES; i++)
			posBola[i] = new Posicion(posx[i], posy[i]);

	}

	void mostrarBolasCartonVDA(JPanel panel) {
		final String dirImg = "imgBingo\\";

		for (int posicion = 0; posicion < BOLASTOTALES; posicion++) {

			final String nomBola = this.bolas[posicion].getNum() + ".png";
			ImageIcon imagenBola = new ImageIcon(Aplicacion.PATH + dirImg + nomBola);
			JLabel bola = new JLabel(imagenBola);
			int x = posBola[posicion].getX();
			int y = posBola[posicion].getY();

			bola.setBounds(x, y, 55, 55);
			panel.add(bola);

			panel.setComponentZOrder(bola, 0);

			panel.repaint();
		}

	}

	void mostrarBolaCarton(int posicion) {
		if (posicion < BOLASTOTALES)
			System.out.println(bolas[posicion].getNum());
	}
}