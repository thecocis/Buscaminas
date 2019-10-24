package Buscaminas;

public class CreacionTableros {

	public int[][] tableroInterno(int m, int n) {
		
		int tablero[][] = new int[m][n];
		for (int i = 0; i<m; i++) {
			for (int j = 0; j < n; j++) {
				tablero[i][j] = 0;
			}
		}
		
		return tablero;
	}
	
	
	public char[][] tableroUsuario(int m, int n) {
		char tablero[][] = new char[m][n];
		for (int i = 0; i<m; i++) {
			for (int j = 0; j < n; j++) {
				tablero[i][j] = '-';
			}
		}
		return tablero;
	}
	
}
