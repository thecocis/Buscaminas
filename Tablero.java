
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

@SuppressWarnings("unused")
public class Tablero {

	
	
	public int[][] crearTablero(int m, int n) {
		
	int tablero[][] = new int[m][n];
	for (int i = 0; i<m; i++) {
		for (int j = 0; j < n; j++) {
			tablero[i][j] = 0;
		}
	}
		
		return tablero;
	}
	public char[][] crearTableroUsuario(int m, int n) {
		char tablero[][] = new char[m][n];
		for (int i = 0; i<m; i++) {
			for (int j = 0; j < n; j++) {
				tablero[i][j] = '-';
			}
		}
		return tablero;
	}
	
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
	
	public void crearNumeros(int i, int j, int tablero[][], int m, int n, Tablero tab) {
		
		//arriba
		if (i <= 0 && j >= 1 && j < n-1) {
			tab.right(i, j, tablero);
			tab.downRight(i, j, tablero);
			tab.down(i, j, tablero);
			tab.downLeft(i, j, tablero);
			tab.left(i, j, tablero);
		}
		
		//esquina superior derecha
		else if (i <= 0 && j >= n-1) {
			tab.down(i, j, tablero);
			tab.downLeft(i, j, tablero);
			tab.left(i, j, tablero);
		}
		
		//derecha
		else if (j >= n-1 && i >= 1 && i < m-1) {
			tab.down(i, j, tablero);
			tab.downLeft(i, j, tablero);
			tab.left(i, j, tablero);
			tab.upLeft(i, j, tablero);
			tab.up(i, j, tablero);
		}
		
		//esquina inferior derecha
		else if (i >= m-1 && j >= n-1) {
			tab.left(i, j, tablero);
			tab.upLeft(i, j, tablero);
			tab.up(i, j, tablero);
		}
		
		//abajo
		else if (i >= m-1 && j >= 1 && j < n-1) {
			tab.up(i, j, tablero);
			tab.upRight(i, j, tablero);
			tab.right(i, j, tablero);
			tab.left(i, j, tablero);
			tab.upLeft(i, j, tablero);
		}
		
		//esquina inferior izquierda
		else if (i >= m-1 && j <= 0) {
			tab.up(i, j, tablero);
			tab.upRight(i, j, tablero);
			tab.right(i, j, tablero);
		}
		
		//izquierda
		else if (j <= 0 && i >= 1 && i < m-1) {
			tab.up(i, j, tablero);
			tab.upRight(i, j, tablero);
			tab.right(i, j, tablero);
			tab.downRight(i, j, tablero);
			tab.down(i, j, tablero);
		}
		
		//esquina superior izquierda
		else if (i <= 0 && j <= 0) {
			tab.right(i, j, tablero);
			tab.downRight(i, j, tablero);
			tab.down(i, j, tablero);
		}
		
		else if (i>=1 && i<= m-1 && j>=1  && j <= n-1){
			tab.up(i, j, tablero);
			tab.upRight(i, j, tablero);
			tab.right(i, j, tablero);
			tab.downRight(i, j, tablero);
			tab.down(i, j, tablero);
			tab.downLeft(i, j, tablero);
			tab.left(i, j, tablero);
			tab.upLeft(i, j, tablero);
		}else {
			System.out.print("F, ha petado");
		}
	}
	
	public int[] crearBombas(int m, int n, int nBombas) {
		int mul = m*n;
		int arrayBombas[] = new int[nBombas];
		for (int z = 0; z<nBombas; z++) {
			arrayBombas[z] = 0;
		}
		
		List<Integer> numbers = new ArrayList<>(mul);
		for (int i = 1; i < mul+1; i++) {
			numbers.add(i);
		}
		
		Random rand = new Random();
		
		int contador = 0;
		while(numbers.size()>(mul - nBombas)) {
			int valorEntero = rand.nextInt(numbers.size());
			arrayBombas[contador] = valorEntero;
			numbers.remove(valorEntero);
			contador++;
		}
		
		//comprobacion de los numeros
		for (int s = 0; s< nBombas; s++) {
			//System.out.print(arrayBombas[s]);
			//System.out.println(" ");
		}
		
		return arrayBombas;
	}
	
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
			/*
			System.out.println(" ");
			System.out.print(auxiliar);
			System.out.print(" ");
			System.out.print(fila);
			System.out.print(" ");
			System.out.print(columna);
			System.out.println(" ");
			*/
			
			tablero[fila][columna] = 9;
		}
		
		return tablero;
	}
	
	public int[][] crearTableroConNumeros(int m, int n, int[][] tablero, Tablero tab) {

		for (int i = 0; i<m; i++) {
			for (int j = 0; j < n; j++) {
				if (tablero[i][j] == 9) 
					tab.crearNumeros(i, j, tablero, m, n, tab);
			}
		}
		
		return tablero;
	}
	
	public void mostrarTablero(int m, int n, int tablero[][]) {
		
		for (int i = 0; i<m; i++) {
			System.out.print(" | ");
			for (int j = 0; j < n; j++) {
				System.out.print(tablero[i][j]);
				System.out.print(" | ");
			}
			System.out.println("\n");
		}
	}

	public static void main(String[] args) {
		
		int seleccion = 0;
		int m = 0 ;
		int n = 0;
		int nBombas = 0;
		System.out.println("----------------------------------------------\n");
		System.out.println("  SELECCIONA UN NIVEL DE DIFICULTAD\n");
		
		System.out.println("   1. NIVEL F�CIL: 8x8 Y 7 BOMBAS\n");
		
		System.out.println("   2. NIVEL MEDIO 15x20 Y 30 BOMBAS\n");

		
		
		while(seleccion < 1 || seleccion >2) {
			System.out.println("----------------------------------------------\n");
			System.out.println("  PULSA 1 PARA NIVEL F�CIL, PULSA 2 PARA NIVEL DIF�CIL");
			
			Scanner reader = new Scanner(System.in);
			seleccion = reader.nextInt();
			
			if(seleccion < 1 || seleccion >2) {
				System.out.println("  ERROR INSERTA UN N�MERO V�LIDO\n");
			}
		}
		
		if (seleccion == 1) {
			m = 8;
			n = 8;		
			nBombas = 7;
		}else if (seleccion == 2) {
			m = 15;
			n = 20;
			nBombas = 30;
		}
		Tablero tab = new Tablero();

		
		int tablero[][] = new int[m][n];
		
		tablero = tab.crearTablero(m, n);
		
		int arrayBombas[] = new int[nBombas];
		
		arrayBombas = tab.crearBombas(m, n, nBombas);
		tablero = tab.posicionarBombasCreadas(arrayBombas, nBombas, tablero, m, n);
		
		/*
		//PARA PRUEBAS
		tablero[0][0] =  9;
		tablero[0][4] =  9;
		tablero[0][7] =  9;
		tablero[5][0] =  9;
		tablero[6][2] =  9;
		tablero[6][3] =  9;
		tablero[6][4] =  9;
		tablero[7][0] =  9;
		tablero[7][3] =  9;
		tablero[7][5] =  9;
		*/
		
		tab.mostrarTablero(m, n, tablero);
		
		tablero = tab.crearTableroConNumeros(m, n, tablero, tab);
		
		
		System.out.println(" ");
		tab.mostrarTablero(m, n, tablero);
		
		
		tab.crearBombas(8, 8, 10);
	}
	
}
