package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Buscaminas.*;

public class PonerNumerosTests {
	//*****************************************************
	//			TESTS CAJA NEGRA CREAR NÚMEROS
	//*****************************************************
	@Test
	public void testOfCrearNumeros1() {
		CreacionTableros creacion = new CreacionTableros();
		int tablero[][] = new int[8][8];
		tablero = creacion.tableroInterno(8, 8);
		
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
		
		PonerNumeros poner = new PonerNumeros();
		tablero = poner.crearTableroConNumeros(8, 8, tablero);
		int tablero_expected[][] = {{9,1,0,1,9,1,1,9},{1,1,0,1,1,1,1,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{1,1,0,0,0,0,0,0},{9,2,2,3,2,1,0,0},{2,3,9,9,9,2,1,0},{9,2,3,9,4,9,1,0}};
		assertArrayEquals("Los numeros no se crean bien", tablero, tablero_expected);	
	}
	
	
	@Test
	public void testOfCrearNumeros2() {
		int m = 3;
		int n = 3;
		CreacionTableros creacion = new CreacionTableros();
		int tablero[][] = new int[m][n];
		tablero = creacion.tableroInterno(m, n);

		tablero[0][0] = 9;
		

		PonerNumeros poner = new PonerNumeros();
		tablero = poner.crearTableroConNumeros(m, n, tablero);
		int tablero_expected[][] = {{9,1,0},{1,1,0},{0,0,0}};
		assertArrayEquals("Los numeros no se crean bien", tablero, tablero_expected);	

	}
	
	@Test
	public void testOfCrearNumeros3() {
		int m = 2;
		int n = 2;
		CreacionTableros creacion = new CreacionTableros();
		int tablero[][] = new int[m][n];
		tablero = creacion.tableroInterno(m, n);

		tablero[0][1] = 9;

		PonerNumeros poner = new PonerNumeros();
		tablero = poner.crearTableroConNumeros(m, n, tablero);
		int tablero_expected[][] = {{1,9},{1,1}};
		assertArrayEquals("Los numeros no se crean bien", tablero, tablero_expected);	

	}
	
	@Test
	public void testOfCrearNumeros4() {
		int m = 3;
		int n = 3;
		CreacionTableros creacion = new CreacionTableros();
		int tablero[][] = new int[m][n];
		tablero = creacion.tableroInterno(m, n);
		
		for (int i = 0; i<m; i++) {
			for (int j = 0; j<n; j++) {
				tablero[i][j] = 9;
			}
		}

		PonerNumeros poner = new PonerNumeros();
		tablero = poner.crearTableroConNumeros(m, n, tablero);
		int tablero_expected[][] = {{9,9,9}, {9,9,9}, {9,9,9}};
		assertArrayEquals("Los numeros no se crean bien", tablero, tablero_expected);	

	}
	
	@Test
	public void testOfCrearNumeros5() {
		int m = 3;
		int n = 3;
		CreacionTableros creacion = new CreacionTableros();
		int tablero[][] = new int[m][n];
		tablero = creacion.tableroInterno(m, n);
		
		for (int i = 0; i<m; i++) {
			for (int j = 0; j<n; j++) {
				tablero[i][j] = 9;
			}
		}
		tablero[1][1] = 0;

		PonerNumeros poner = new PonerNumeros();
		tablero = poner.crearTableroConNumeros(m, n, tablero);
		int tablero_expected[][] = {{9,9,9}, {9,8,9}, {9,9,9}};
		assertArrayEquals("Los numeros no se crean bien", tablero, tablero_expected);	

	}	
	
	@Test
	public void testOfCrearNumeros6() {
		int m = 4;
		int n = 4;
		CreacionTableros creacion = new CreacionTableros();
		int tablero[][] = new int[m][n];
		tablero = creacion.tableroInterno(m, n);
		
		tablero[0][0] = 9;
		tablero[0][1] = 9;
		tablero[0][2] = 9;
		tablero[0][3] = 9;
		tablero[2][3] = 9;
		tablero[1][0] = 9;
		tablero[2][0] = 9;
		tablero[3][0] = 9;
		tablero[3][1] = 9;
		tablero[3][2] = 9;
		tablero[3][3] = 9;
		tablero[1][3] = 9;

		PonerNumeros poner = new PonerNumeros();
		tablero = poner.crearTableroConNumeros(m, n, tablero);
		int tablero_expected[][] = {{9,9,9,9}, {9,5,5,9}, {9,5,5,9}, {9,9,9,9}};
		assertArrayEquals("Los numeros no se crean bien", tablero, tablero_expected);	
	}	
}
