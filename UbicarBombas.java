package Buscaminas;

public class UbicarBombas {
	
	//A partir de "arrayBombas", que contiene las posiciones de las bombas, esta funci�n coloca cada bomba 
	//en el sitio que le toca dentro del tablero pasado por parametro
	public int[][] posicionarBombasCreadas(int arrayBombas[], int nBombas, int[][] tablero, int m, int n) {
		int fila = 0;
		int columna = 0;  
		double auxfila = 0.0;
		int auxiliar = 0;
		for (int i = 0; i < nBombas; i++) {
			auxiliar = arrayBombas[i];
			auxfila = auxiliar/n;
			fila = (int)auxfila;
			columna = auxiliar%n;
			if (columna == 0) {
				columna = n-1;
				fila--;
			}else {
				columna--;
			}
			
			tablero[fila][columna] = 9;
		}
		
		return tablero;
	}
}
