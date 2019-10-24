package Buscaminas;

public class CreacionTableros {

	public int[][] tableroInterno(int m, int n) {
		if(m==0) m = 8;
		if(n==0) n = 8;
		int tablero[][] = new int[m][n];
		for (int i = 0; i<m; i++) {
			for (int j = 0; j < n; j++) {
				tablero[i][j] = 0;
			}
		}
		
		return tablero;
	}
	
	
	public char[][] tableroUsuario(int m, int n) {
		if(m==0) m = 8;
		if(n==0) n = 8;
		char tablero[][] = new char[m][n];
		for (int i = 0; i<m; i++) {
			for (int j = 0; j < n; j++) {
				tablero[i][j] = '-';
			}
		}
		return tablero;
	}
	
}
