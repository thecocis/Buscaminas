package Buscaminas;

import java.util.Scanner;

public class Menu {

	private Teclado _teclado;
	
	public Menu() {
		_teclado = new Teclado();
	}
	
	public int[] crearMenu() {
		int n = 0;
		int m = 0;
		int nBombas = 0;
		int arrayVal[] = new int[3];
		int seleccion = seleccionParametrosTablero();
		
		
		if (seleccion == 1) {
			m = 8;
			n = 9;		
			nBombas = 7;
		}else if (seleccion == 2) {
			m = 15;
			n = 20;
			nBombas = 30;
		}

		arrayVal[0] = m;
		arrayVal[1] = n;
		arrayVal[2] = nBombas;
		
		return arrayVal;
	}
	
	public int seleccionParametrosTablero() {
		int seleccion = 0;
		
		System.out.println("----------------------------------------------\n");
		System.out.println("  SELECCIONA UN NIVEL DE DIFICULTAD\n");
		
		System.out.println("   1. NIVEL FÁCIL: 8x8 Y 7 BOMBAS\n");
		
		System.out.println("   2. NIVEL MEDIO 15x20 Y 30 BOMBAS\n");

		while(seleccion < 1 || seleccion >2) {
			System.out.println("----------------------------------------------\n");
			System.out.println("  PULSA 1 PARA NIVEL FÁCIL, PULSA 2 PARA NIVEL DIFÍCIL");
			
			seleccion = _teclado.inputKey();
			
			if(seleccion < 1 || seleccion >2) {
				System.out.println("  ERROR INSERTA UN NÚMERO VÁLIDO\n");
			}
		}
		return seleccion;
	}
	
	public int[] crearMenuTirada(int m, int n) {

		int arrayTirada[] = new int[3];
		System.out.println("----------------------------------------------\n");
		System.out.println("  SELECCIONA LA CASILLA QUE QUEIRES PICAR Y DI QUÉ QUIERES HACER: \n");
		
		
		int fila = 0;
		int columna = 0;
		int accion = 0;
		System.out.print("  FILA (de la 1 a la ");
		System.out.print(m);
		System.out.println("):");
		fila = _teclado.inputKey();
		while(fila<1 || fila > m) {
			System.out.print("   INSERTA UNA FILA VÁLIDA PESAO (de la 1 a la ");
			System.out.print(m);
			System.out.println("):");
			fila = _teclado.inputKey();
		}
		
		System.out.print("  COLUMNA (de la 1 a la ");
		System.out.print(n);
		System.out.println("):");
		columna = _teclado.inputKey();
		while(columna<1 || columna > n) {
			System.out.print("   INSERTA UNA COLUMNA VÁLIDA PESAO (de la 1 a la ");
			System.out.print(n);
			System.out.println("):");
			columna = _teclado.inputKey();
		}
		
		System.out.println("  SI DESEA ABRIR LA CASILLA PULSE 1");
		System.out.println("  SI DESEA PONER UNA BANDERITA PULSE 2");
		System.out.println("  SI DESEA PONER UNA MARCA DE BOMBA PULSE 3");
		System.out.println("  SI DESEA PONER UN INTERROGANTE PULSE 4");

		System.out.println("\n  	GRACIAS");

		accion = _teclado.inputKey();
		while(accion<1 || accion > 4) {
			System.out.print("   INSERTA UNA COLUMNA VÁLIDA PESAO (de la 1 a la ");
			System.out.print(n);
			System.out.println("):");
			accion = _teclado.inputKey();
		}
		
		arrayTirada[0] = fila - 1;
		arrayTirada[1] = columna - 1;
		arrayTirada[2] = accion;
		
		return arrayTirada;
	
	}
	
	
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
				System.out.print("       ");
				for (j = 1; j < (n+1); j++) {
					System.out.print(j);
					if(j<10) {
					System.out.print("   ");
					}
					else {

						System.out.print("  ");
					}
				}
				System.out.println("\n");
			}
			System.out.print(i + 1);
			
			if(i<9) {
				System.out.print("    | ");
			}else {

				System.out.print("   | ");
			}
			
			for (j = 0; j < n; j++) {
				System.out.print(tablero[i][j]);
				System.out.print(" | ");
			}
			System.out.println("\n");
		}
	}
	
	
}
