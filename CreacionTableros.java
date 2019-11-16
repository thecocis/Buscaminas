package Buscaminas;

public class CreacionTableros {

	//Crea el tablero con la medida pasada por parametro y se inicializan todos los valores a 0.
	//Este será el tablero interno que no se verá por pantalla, pero donde estará guardada toda la informacion del juego.
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
	
	//Crea el tablero con la medida pasada por parametro y se inicializan todos los valores a "-".
	//Este será el tablero que se verá por pantalla, es el tablero a través del cual el usuario podrá interactuar.
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
	
	//Comprueba si todas las bombas han sido marcadas con la bandera "P", en caso afirmativo, se habrá ganado el juego.
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
	
	//Comprueba si se muestra alguna bomba en el tablero del Usuario, en caso afirmativo, se habrá perdido el juego.
	public boolean isLost(int [][] tableroInt, char[][] tableroUs, int m, int n) {
		boolean lost = false;
		int i = 0;
		int j = 0;
		while (i<m && !lost ) {
			j = 0;
			while (j < n && !lost) {
				if (tableroUs[i][j] == 'X' && (tableroInt[i][j] == 9)) {
					lost = true; 
				}
				j++;
			}
			i++;
		}
		
		return lost;
		
	}
}
