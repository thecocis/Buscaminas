package Buscaminas;

public class MockBombas extends CrearBombas{
	
	private int _nBombas = 11;
	private int _m = 8;
	private int _n = 8;
	
	public int[][] getTableroRand1() {
		int[][] mock = {{9,1,0,0,0,0,1,9}, {1,1,0,0,0,0,1,1}, {0,0,1,1,1,0,1,1}, {0,1,3,9,3,1,2,9}, 
				{1,2,9,9,3,9,4,3}, {9,2,3,3,3,3,9,9}, {1,1,1,9,1,2,9,3}, {0,1,1,1,1,1,1,1}};
		return mock;
	}
	
	public int[][] getBombasRand1() {
		int[][] mock = {{9,0,0,0,0,0,0,0}, {0,0,0,0,0,0,0,0}, {0,0,0,0,0,0,0,0}, {0,0,0,9,0,0,0,9}, 
				{0,0,9,9,0,9,0,0}, {9,0,0,0,0,0,9,9}, {0,0,0,9,0,0,9,0}, {0,0,0,0,0,0,0,0}};
		return mock;
	}
		
	public int[] getArrayBombas() {
		int[] bombas = {1, 28, 32, 35, 36, 38, 41, 47, 48, 52, 55};
		return bombas;
	}
	public int[][] getTableroVacio() {
		int[][] mock = {{0,0,0,0,0,0,0,0}, {0,0,0,0,0,0,0,0}, {0,0,0,0,0,0,0,0}, {0,0,0,0,0,0,0,0}, 
				{0,0,0,0,0,0,0,0}, {0,0,0,0,0,0,0,0}, {0,0,0,0,0,0,0,0}, {0,0,0,0,0,0,0,0}, };
		return mock;
	}

	public int getnBombas() {
		return _nBombas;
	}

	public void setnBombas(int _nBombas) {
		this._nBombas = _nBombas;
	}

	public int getm() {
		return _m;
	}

	public void setm(int _m) {
		this._m = _m;
	}

	public int getn() {
		return _n;
	}

	public void setn(int _n) {
		this._n = _n;
	}
	
}
