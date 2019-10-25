package Buscaminas;

public class PonerNumeros {
	
	public void up(int i, int j, int tablero[][]) {
		if (tablero[i-1][j] != 9)
			tablero[i-1][j]++;
	}
	
	public void upRight(int i, int j, int tablero[][]) {
		if (tablero[i-1][j+1] != 9)
			tablero[i-1][j+1]++;
	}
	
	public void right(int i, int j, int tablero[][]) {
		if (tablero[i][j+1] != 9)
			tablero[i][j+1]++;
	}
	
	public void downRight(int i, int j, int tablero[][]) {
		if (tablero[i+1][j+1] != 9)
			tablero[i+1][j+1]++;
	}
	
	public void down(int i, int j, int tablero[][]) {
		if (tablero[i+1][j] != 9)
			tablero[i+1][j]++;
	}
	
	public void downLeft(int i, int j, int tablero[][]) {
		if (tablero[i+1][j-1] != 9)
			tablero[i+1][j-1]++;
	}
	
	public void left(int i, int j, int tablero[][]) {
		if (tablero[i][j-1] != 9)
			tablero[i][j-1]++;
	}
	
	public void upLeft(int i, int j, int tablero[][]) {
		if (tablero[i-1][j-1] != 9)	
			tablero[i-1][j-1]++;
	}
	
	public void crearNumeros(int i, int j, int tablero[][], int m, int n) {
		
		//arriba
		if (i <= 0 && j >= 1 && j < n-1) {
			right(i, j, tablero);
			downRight(i, j, tablero);
			down(i, j, tablero);
			downLeft(i, j, tablero);
			left(i, j, tablero);
		}
		
		//esquina superior derecha
		else if (i <= 0 && j >= n-1) {
			 down(i, j, tablero);
			 downLeft(i, j, tablero);
			 left(i, j, tablero);
		}
		
		//derecha
		else if (j >= n-1 && i >= 1 && i < m-1) {
			 down(i, j, tablero);
			 downLeft(i, j, tablero);
			 left(i, j, tablero);
			 upLeft(i, j, tablero);
			 up(i, j, tablero);
		}
		
		//esquina inferior derecha
		else if (i >= m-1 && j >= n-1) {
			 left(i, j, tablero);
			 upLeft(i, j, tablero);
			 up(i, j, tablero);
		}
		
		//abajo
		else if (i >= m-1 && j >= 1 && j < n-1) {
			 up(i, j, tablero);
			 upRight(i, j, tablero);
			 right(i, j, tablero);
			 left(i, j, tablero);
			 upLeft(i, j, tablero);
		}
		
		//esquina inferior izquierda
		else if (i >= m-1 && j <= 0) {
			 up(i, j, tablero);
			 upRight(i, j, tablero);
			 right(i, j, tablero);
		}
		
		//izquierda
		else if (j <= 0 && i >= 1 && i < m-1) {
			 up(i, j, tablero);
			 upRight(i, j, tablero);
			 right(i, j, tablero);
			 downRight(i, j, tablero);
			 down(i, j, tablero);
		}
		
		//esquina superior izquierda
		else if (i <= 0 && j <= 0) {
			 right(i, j, tablero);
			 downRight(i, j, tablero);
			 down(i, j, tablero);
		}
		
		else if (i>=1 && i<= m-1 && j>=1  && j <= n-1){
			 up(i, j, tablero);
			 upRight(i, j, tablero);
			 right(i, j, tablero);
			 downRight(i, j, tablero);
			 down(i, j, tablero);
			 downLeft(i, j, tablero);
			 left(i, j, tablero);
			 upLeft(i, j, tablero);
		}else {
			System.out.print("F, ha petado");
		}
	}
	
	public int[][] crearTableroConNumeros(int m, int n, int[][] tablero) {

		for (int i = 0; i<m; i++) {
			for (int j = 0; j < n; j++) {
				if (tablero[i][j] == 9) 
					crearNumeros(i, j, tablero, m, n);
			}
		}
		
		return tablero;
	}
	
	
}
