package Buscaminas;

public class AbrirCasilla {
	
	
	// 1 --> abrir casilla
	// 2 --> banderita --> P
	// 3 --> marca bomba --> !
	// 4 --> interrogante --> ?
	public char[][] abrirCasilla(int coordX, int coordY, int a, char[][] tableroUsuario, int[][] tableroInterno, int m, int n) {
		
		if(a == 1) {
			picarCasilla(tableroUsuario, tableroInterno, coordX, coordY, m, n);
		}else if(a == 2) {
			banderita(tableroUsuario, coordX, coordY);
		}else if(a == 3){
			marcaBomba(tableroUsuario, coordX, coordY);
		}else if(a == 4) {
			interrogante(tableroUsuario, coordX, coordY);
		}
		
		return tableroUsuario;
	}
	
	public void picarCasilla(char[][] tableroUsuario,int[][] tableroInterno, int coordX, int coordY, int m, int n) {
		if (tableroInterno[coordX][coordY] == 9) {
			mostrarTodasLasBombas(tableroUsuario, tableroInterno);
		}else if (tableroInterno[coordX][coordY]>0) {
			tableroUsuario[coordX][coordY] = (char)(tableroInterno[coordX][coordY]+48);
		}else if(tableroInterno[coordX][coordY] == 0) {
			casillaRecursiva(coordX, coordY, tableroInterno, tableroUsuario, m, n);
		}
	}
	
	public void right(int[][] tableroInterno, char[][] tableroUsuario, int coordX, int coordY) {
		if(tableroUsuario[coordX][coordY] == '-' && tableroInterno[coordX][coordY] >= 0 && tableroInterno[coordX][coordY] < 9) {
			tableroUsuario[coordX][coordY] = '0';
			
		}
	}
	
	
	public void casillaRecursiva(int coordX, int coordY, int[][] tableroInterno, char[][] tableroUsuario, int m, int n) {
			
		
		if(tableroUsuario[coordX][coordY] == '-' && tableroInterno[coordX][coordY] == 0) {
			tableroUsuario[coordX][coordY] = '0';
			
			//arriba
			if (coordX <= 0 && coordY >= 1 && coordY < n-1) {
				right(coordX, coordY, tableroInterno, tableroUsuario, m, n);
				downRight(coordX, coordY, tableroInterno, tableroUsuario, m, n);
				down(coordX, coordY, tableroInterno, tableroUsuario, m, n);
				downLeft(coordX, coordY, tableroInterno, tableroUsuario, m, n);
				left(coordX, coordY, tableroInterno, tableroUsuario, m, n);
			}
			
			//esquina superior derecha
			else if (coordX <= 0 && coordY >= n-1) {
				down(coordX, coordY, tableroInterno, tableroUsuario, m, n);
				downLeft(coordX, coordY, tableroInterno, tableroUsuario, m, n);
				left(coordX, coordY, tableroInterno, tableroUsuario, m, n);
			}
			
			//derecha
			else if (coordY >= n-1 && coordX >= 1 && coordX < m-1) {
				up(coordX, coordY, tableroInterno, tableroUsuario, m, n);
				down(coordX, coordY, tableroInterno, tableroUsuario, m, n);
				downLeft(coordX, coordY, tableroInterno, tableroUsuario, m, n);
				left(coordX, coordY, tableroInterno, tableroUsuario, m, n);
				upLeft(coordX, coordY, tableroInterno, tableroUsuario, m, n);
			}
			
			//esquina inferior derecha
			else if (coordX >= m-1 && coordY >= n-1) {
				up(coordX, coordY, tableroInterno, tableroUsuario, m, n);
				left(coordX, coordY, tableroInterno, tableroUsuario, m, n);
				upLeft(coordX, coordY, tableroInterno, tableroUsuario, m, n);
			}
			
			//abajo
			else if (coordX >= m-1 && coordY >= 1 && coordY < n-1) {
				up(coordX, coordY, tableroInterno, tableroUsuario, m, n);
				upRight(coordX, coordY, tableroInterno, tableroUsuario, m, n);
				right(coordX, coordY, tableroInterno, tableroUsuario, m, n);
				left(coordX, coordY, tableroInterno, tableroUsuario, m, n);
				upLeft(coordX, coordY, tableroInterno, tableroUsuario, m, n);
			}
			
			//esquina inferior izquierda
			else if (coordX >= m-1 && coordY <= 0) {
				up(coordX, coordY, tableroInterno, tableroUsuario, m, n);
				upRight(coordX, coordY, tableroInterno, tableroUsuario, m, n);
				right(coordX, coordY, tableroInterno, tableroUsuario, m, n);
			}
			
			//izquierda
			else if (coordY <= 0 && coordX >= 1 && coordX < m-1) {
				up(coordX, coordY, tableroInterno, tableroUsuario, m, n);
				upRight(coordX, coordY, tableroInterno, tableroUsuario, m, n);
				right(coordX, coordY, tableroInterno, tableroUsuario, m, n);
				downRight(coordX, coordY, tableroInterno, tableroUsuario, m, n);
				down(coordX, coordY, tableroInterno, tableroUsuario, m, n);
			}
			
			//esquina superior izquierda
			else if (coordX <= 0 && coordY <= 0) {
				right(coordX, coordY, tableroInterno, tableroUsuario, m, n);
				downRight(coordX, coordY, tableroInterno, tableroUsuario, m, n);
				down(coordX, coordY, tableroInterno, tableroUsuario, m, n);
			}
			//medio
			else if (coordX>=1 && coordX<= m-1 && coordY>=1  && coordY <= n-1){
				up(coordX, coordY, tableroInterno, tableroUsuario, m, n);
				upRight(coordX, coordY, tableroInterno, tableroUsuario, m, n);
				right(coordX, coordY, tableroInterno, tableroUsuario, m, n);
				downRight(coordX, coordY, tableroInterno, tableroUsuario, m, n);
				down(coordX, coordY, tableroInterno, tableroUsuario, m, n);
				downLeft(coordX, coordY, tableroInterno, tableroUsuario, m, n);
				left(coordX, coordY, tableroInterno, tableroUsuario, m, n);
				upLeft(coordX, coordY, tableroInterno, tableroUsuario, m, n);
				
			}else {
				System.out.print("F, ha petado");
			}

		}else if (tableroUsuario[coordX][coordY] == '-' && tableroInterno[coordX][coordY] >= 1 && tableroInterno[coordX][coordY] <= 8) {
			tableroUsuario[coordX][coordY] = (char)(tableroInterno[coordX][coordY]+48);
		}

	}
	
	
	public void up(int coordX, int coordY, int[][] tableroInterno, char[][] tableroUsuario, int m, int n) {
		casillaRecursiva(coordX-1, coordY, tableroInterno, tableroUsuario, m, n);
	}
	
	public void upRight(int coordX, int coordY, int[][] tableroInterno, char[][] tableroUsuario, int m, int n) {
		casillaRecursiva(coordX-1, coordY+1, tableroInterno, tableroUsuario, m, n);
	}
	
	public void right(int coordX, int coordY, int[][] tableroInterno, char[][] tableroUsuario, int m, int n) {
		casillaRecursiva(coordX, coordY+1, tableroInterno, tableroUsuario, m, n);
	}
	
	public void downRight(int coordX, int coordY, int[][] tableroInterno, char[][] tableroUsuario, int m, int n) {
		casillaRecursiva(coordX+1, coordY+1, tableroInterno, tableroUsuario, m, n);
	}
	
	public void down(int coordX, int coordY, int[][] tableroInterno, char[][] tableroUsuario, int m, int n) {
		casillaRecursiva(coordX+1, coordY, tableroInterno, tableroUsuario, m, n);
	}
	
	public void downLeft(int coordX, int coordY, int[][] tableroInterno, char[][] tableroUsuario, int m, int n) {
		casillaRecursiva(coordX+1, coordY-1, tableroInterno, tableroUsuario, m, n);
	}
	
	public void left(int coordX, int coordY, int[][] tableroInterno, char[][] tableroUsuario, int m, int n) {
		casillaRecursiva(coordX, coordY-1, tableroInterno, tableroUsuario, m, n);
	}
	
	public void upLeft(int coordX, int coordY, int[][] tableroInterno, char[][] tableroUsuario, int m, int n) {
		casillaRecursiva(coordX-1, coordY-1, tableroInterno, tableroUsuario, m, n);
	}	
	
	
	
	
	public void banderita(char[][] tableroUsuario, int coordX, int coordY) {
		tableroUsuario[coordX][coordY] = 'P';
	}
	
	public void marcaBomba(char[][] tableroUsuario, int coordX, int coordY) {
		tableroUsuario[coordX][coordY] = '!';
	}
	
	public void interrogante(char[][] tableroUsuario, int coordX, int coordY) {
		tableroUsuario[coordX][coordY] = '?';
	}
	
	public void mostrarTodasLasBombas(char[][] tableroUsuario,int[][] tableroInterno) {
		for (int i = 0; i<8; i++) {
			for (int j = 0; j < 8; j++) {
				if(tableroInterno[i][j] == 9) {
					tableroUsuario[i][j] = 'X';
				}
			}
		}
	}
}



