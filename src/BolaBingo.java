class BolaBingo {
	int num;
	

	BolaBingo() {
		this.num = (int) (Math.random() * 90) + 1;
	}

	BolaBingo(int limSup, int limInf) {
		this.num = (int) (Math.random() * (limSup - limInf)) + limInf;
	}

	BolaBingo(BolaBingo b) {
		this.num = b.getNum();
	}

	Boolean equals(BolaBingo b) {
		if (this.num == b.getNum())
			return true;
		else
			return false;
	}

	public int getNum() {
		return this.num;
	}

	public void setNum(int valorBola) {
		this.num = valorBola;
	}

	String strImg() {
		return this.num + ".png";
	}

	Boolean rango(int min, int max) {
		if (this.num >= min && this.num >= max)
			return true;
		else
			return false;
	}
}