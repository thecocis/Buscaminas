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
	
	//comprueba si todas las bombas han sido marcadas
	public boolean isWon(int [][] tableroInt, char[][] tableroUs, int m, int n , int nBombas) {
		boolean win = false;
		int contBombas = 0;
		for (int i = 0; i<m; i++) {
			for (int j = 0; j < n; j++) {
				if (tableroUs[i][j] == 'P' && tableroInt[i][j] == 9) {
					contBombas++;
				}
			}
		}
		if (contBombas == nBombas) {
			win = true;
		}
		return win;
	}
	
	//Comprueba si hay alguna bomba abierta
	public boolean isLost(int [][] tableroInt, char[][] tableroUs, int m, int n) {
		boolean lost = false;
		int i = 0;
		int j = 0;
		while (i<m && !lost ) {
			j = 0;
			while (j < n && !lost) {
				if (tableroUs[i][j] == 'X') {
					lost = true;
				}
				j++;
			}
			i++;
		}
		
		return lost;
		
	}
}
