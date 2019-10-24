package Buscaminas;

public class PrintsPantalla {
	public void tableroInterno(int m, int n, int tablero[][]) {

		for (int i = 0; i<m; i++) {
			System.out.print(" | ");
			for (int j = 0; j < n; j++) {
				System.out.print(tablero[i][j]);
				System.out.print(" | ");
			}
			System.out.println("\n");
		}
	}
	
	public void tableroUsuario(int m, int n, char tablero[][]) {

		for (int i = 0; i<m; i++) {
			System.out.print(" | ");
			for (int j = 0; j < n; j++) {
				System.out.print(tablero[i][j]);
				System.out.print(" | ");
			}
			System.out.println("\n");
		}
	}
}
