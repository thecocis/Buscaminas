import static org.junit.Assert.*;

import org.junit.Test;

public class TableroTest {
	
	//*****************************************************
	//			TESTS CAJA NEGRA CREAR TABLERO	
	//*****************************************************
	
	@Test
	public void testOfCrearTablero1() {
		Tablero tab = new Tablero();
		int tablero[][] = new int[8][8];
		tablero = tab.crearTablero(8, 8);
		int tablero_expected[][] = {{0,0,0,0,0,0,0,0}, {0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}};
		assertArrayEquals("El tablero no se inicializa bien", tablero, tablero_expected);
	}
	
	@Test
	public void testOfCrearTablero2() {
		Tablero tab = new Tablero();
		int tablero[][] = new int[2][2];
		tablero = tab.crearTablero(2, 2);
		int tablero_expected[][] = {{0,0}, {0,0}};
		assertArrayEquals("El tablero no se inicializa bien", tablero, tablero_expected);
	}
	
	@Test
	public void testOfCrearTablero3() {
		Tablero tab = new Tablero();
		int tablero[][] = new int[3][5];
		tablero = tab.crearTablero(3, 5);
		int tablero_expected[][] = {{0,0,0,0,0}, {0,0,0,0,0},{0,0,0,0,0}};
		assertArrayEquals("El tablero no se inicializa bien", tablero, tablero_expected);
	}
	
	@Test
	public void testOfCrearTablero4() {
		Tablero tab = new Tablero();
		int tablero[][] = new int[1][9];
		tablero = tab.crearTablero(1, 9);
		int tablero_expected[][] = {{0,0,0,0,0,0,0,0,0}};
		assertArrayEquals("El tablero no se inicializa bien", tablero, tablero_expected);
	}
	@Test
	public void testOfCrearTablero5() {
		Tablero tab = new Tablero();
		int tablero[][] = new int[9][1];
		tablero = tab.crearTablero(9, 1);
		int tablero_expected[][] = {{0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}};
		assertArrayEquals("El tablero no se inicializa bien", tablero, tablero_expected);
	}

	

	//*****************************************************
	//			TESTS CAJA NEGRA CREAR NÚMEROS
	//*****************************************************
	@Test
	public void testOfCrearNumeros1() {
		Tablero tab = new Tablero();
		int tablero[][] = new int[8][8];
		tablero = tab.crearTablero(8, 8);
		
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
		
		tablero = tab.crearTableroConNumeros(8, 8, tablero, tab);
		int tablero_expected[][] = {{9,1,0,1,9,1,1,9},{1,1,0,1,1,1,1,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{1,1,0,0,0,0,0,0},{9,2,2,3,2,1,0,0},{2,3,9,9,9,2,1,0},{9,2,3,9,4,9,1,0}};
		assertArrayEquals("Los numeros no se crean bien", tablero, tablero_expected);	
	}
	
	
	@Test
	public void testOfCrearNumeros2() {
		int m = 3;
		int n = 3;
		Tablero tab = new Tablero();
		int tablero[][] = new int[m][n];
		tablero = tab.crearTablero(m, n);

		tablero[0][0] = 9;
		
		tablero = tab.crearTableroConNumeros(m, n, tablero, tab);
		int tablero_expected[][] = {{9,1,0},{1,1,0},{0,0,0}};
		assertArrayEquals("Los numeros no se crean bien", tablero, tablero_expected);	

	}
	
	@Test
	public void testOfCrearNumeros3() {
		int m = 2;
		int n = 2;
		Tablero tab = new Tablero();
		int tablero[][] = new int[m][n];
		tablero = tab.crearTablero(m, n);

		tablero[0][1] = 9;
		
		tablero = tab.crearTableroConNumeros(m, n, tablero, tab);
		int tablero_expected[][] = {{1,9},{1,1}};
		assertArrayEquals("Los numeros no se crean bien", tablero, tablero_expected);	

	}
	
	@Test
	public void testOfCrearNumeros4() {
		int m = 3;
		int n = 3;
		Tablero tab = new Tablero();
		int tablero[][] = new int[m][n];
		tablero = tab.crearTablero(m, n);
		
		for (int i = 0; i<m; i++) {
			for (int j = 0; j<n; j++) {
				tablero[i][j] = 9;
			}
		}
		
		tablero = tab.crearTableroConNumeros(m, n, tablero, tab);
		int tablero_expected[][] = {{9,9,9}, {9,9,9}, {9,9,9}};
		assertArrayEquals("Los numeros no se crean bien", tablero, tablero_expected);	

	}
	
	@Test
	public void testOfCrearNumeros5() {
		int m = 3;
		int n = 3;
		Tablero tab = new Tablero();
		int tablero[][] = new int[m][n];
		tablero = tab.crearTablero(m, n);
		
		for (int i = 0; i<m; i++) {
			for (int j = 0; j<n; j++) {
				tablero[i][j] = 9;
			}
		}
		tablero[1][1] = 0;
		tablero = tab.crearTableroConNumeros(m, n, tablero, tab);
		int tablero_expected[][] = {{9,9,9}, {9,8,9}, {9,9,9}};
		assertArrayEquals("Los numeros no se crean bien", tablero, tablero_expected);	

	}	
	
	@Test
	public void testOfCrearNumeros6() {
		int m = 4;
		int n = 4;
		Tablero tab = new Tablero();
		int tablero[][] = new int[m][n];
		tablero = tab.crearTablero(m, n);
		
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
		
		tablero = tab.crearTableroConNumeros(m, n, tablero, tab);
		int tablero_expected[][] = {{9,9,9,9}, {9,5,5,9}, {9,5,5,9}, {9,9,9,9}};
		assertArrayEquals("Los numeros no se crean bien", tablero, tablero_expected);	
	}	
	
	
	//*****************************************************
	//			TESTS CAJA NEGRA POSICIONAR BOMBAS
	//*****************************************************
	
	@Test
	public void testOfPosicionarBombasCreadas1() {
		int m = 3;
		int n = 3;
		int nBombas = 1;
		
		Tablero tab = new Tablero();
		int tablero[][] = new int[m][n];
		tablero = tab.crearTablero(m, n);
		
		int[] valorRandomTeorico = {1};
		tab.posicionarBombasCreadas(valorRandomTeorico, nBombas, tablero, m, n);
		
		int tablero_expected[][] = {{9,0,0},{0,0,0},{0,0,0}};
		

		assertArrayEquals("La bomba no se posiciona correctamente", tablero, tablero_expected);	
		
	}
	
	@Test
	public void testOfPosicionarBombasCreadas2() {
		int m = 3;
		int n = 3;
		int nBombas = 1;
		
		Tablero tab = new Tablero();
		int tablero[][] = new int[m][n];
		tablero = tab.crearTablero(m, n);
		
		int[] valorRandomTeorico = {9};
		tab.posicionarBombasCreadas(valorRandomTeorico, nBombas, tablero, m, n);
		
		int tablero_expected[][] = {{0,0,0},{0,0,0},{0,0,9}};
		assertArrayEquals("La bomba no se posiciona correctamente", tablero, tablero_expected);	
		
	}
	
	@Test
	public void testOfPosicionarBombasCreadas3() {
		int m = 3;
		int n = 3;
		int nBombas = 1;
		
		Tablero tab = new Tablero();
		int tablero[][] = new int[m][n];
		tablero = tab.crearTablero(m, n);
		
		int[] valorRandomTeorico = {5};
		tab.posicionarBombasCreadas(valorRandomTeorico, nBombas, tablero, m, n);
		
		int tablero_expected[][] = {{0,0,0},{0,9,0},{0,0,0}};
		assertArrayEquals("La bomba no se posiciona correctamente", tablero, tablero_expected);	
		
	}
	

	
}
