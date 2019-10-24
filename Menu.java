package Buscaminas;

import java.util.Scanner;

public class Menu {

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
			
			Scanner reader = new Scanner(System.in);
			seleccion = reader.nextInt();
			
			if(seleccion < 1 || seleccion >2) {
				System.out.println("  ERROR INSERTA UN NÚMERO VÁLIDO\n");
			}
		}
		return seleccion;
	}
}
