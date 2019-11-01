package Buscaminas;

public class PrintsPantalla {
	public void tableroInterno(int m, int n, int tablero[][]) {
		int j = 0;
		for (int i = 0; i < m; i++) {
			if (i == 0) {
				for (j = 0; j < (n+1); j++) {
					System.out.print(j );
					System.out.print("   ");
				}
				System.out.println("\n");
			}
			System.out.print(i + 1);
			System.out.print(" | ");
			for (j = 0; j < n; j++) {
				System.out.print(tablero[i][j]);
				System.out.print(" | ");
			}
			System.out.println("\n");
		}
	}
	
	public void tableroUsuario(int m, int n, char tablero[][]) {
		int j = 0;
		for (int i = 0; i < m; i++) {
			if (i == 0) {
				for (j = 0; j < (n+1); j++) {
					System.out.print(j );
					System.out.print("   ");
				}
				System.out.println("\n");
			}
			System.out.print(i + 1);
			System.out.print(" | ");
			for (j = 0; j < n; j++) {
				System.out.print(tablero[i][j]);
				System.out.print(" | ");
			}
			System.out.println("\n");
		}
	}
}
