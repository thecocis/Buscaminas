package Buscaminas;

public class AbrirCasilla {
	
	// 1 --> abrir casilla
	// 2 --> banderita --> P
	// 3 --> marca bomba --> !
	// 4 --> interrogante --> ?
	public char[][] abrirCasilla(int m, int n, int a, char[][] tableroUsuario, int[][] tableroInterno) {
		
		if(a == 1) {
			picarCasilla(tableroUsuario, tableroInterno, m, n);
		}else if(a == 2) {
			banderita(tableroUsuario, m, n);
		}else if(a == 3){
			marcaBomba(tableroUsuario, m, n);
		}else if(a == 4) {
			interrogante(tableroUsuario, m, n);
		}
		
		return tableroUsuario;
	}
	
	public void picarCasilla(char[][] tableroUsuario,int[][] tableroInterno, int m, int n) {
		if (tableroInterno[m][n] == 9) {
			mostrarTodasLasBombas(tableroUsuario, tableroInterno);
		}else if (tableroInterno[m][n]>0) {
			tableroUsuario[m][n] = (char)(tableroInterno[m][n]+48);
		}else if(tableroInterno[m][n] == 0) {
			casillaRecursiva();
		}
	}
	public void casillaRecursiva() {
		
	}
	
	public void banderita(char[][] tableroUsuario, int m, int n) {
		tableroUsuario[m][n] = 'P';
	}
	
	public void marcaBomba(char[][] tableroUsuario, int m, int n) {
		tableroUsuario[m][n] = '!';
	}
	
	public void interrogante(char[][] tableroUsuario, int m, int n) {
		tableroUsuario[m][n] = '?';
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



