class Posicion {
	int posx;
	int posy;

	Posicion(int x, int y) {
		posx = x;
		posy = y;
	}

	void setXY(int x, int y) {
		posx = x;
		posy = y;
	}

	int getX() {
		return posx;
	}

	int getY() {
		return posy;
	}
}