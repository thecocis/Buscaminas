package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Buscaminas.*;

public class UbicarBombasTests {

	//*****************************************************
		//			TESTS CAJA NEGRA POSICIONAR BOMBAS
		//*****************************************************
		
		@Test
		public void testOfPosicionarBombasCreadas1() {
			int m = 3;
			int n = 3;
			int nBombas = 1;

			CreacionTableros creacion = new CreacionTableros();
			int tablero[][] = new int[m][n];
			tablero = creacion.tableroInterno(m, n);
			
			int[] valorRandomTeorico = {1};
			
			UbicarBombas ubicarBombas = new UbicarBombas();
			tablero = ubicarBombas.posicionarBombasCreadas(valorRandomTeorico, nBombas, tablero, m, n);
			
			int tablero_expected[][] = {{9,0,0},{0,0,0},{0,0,0}};
			

			assertArrayEquals("La bomba no se posiciona correctamente", tablero, tablero_expected);	
			
		}
		
		@Test
		public void testOfPosicionarBombasCreadas2() {
			int m = 3;
			int n = 3;
			int nBombas = 1;

			CreacionTableros creacion = new CreacionTableros();
			int tablero[][] = new int[m][n];
			tablero = creacion.tableroInterno(m, n);
			
			int[] valorRandomTeorico = {9};
			UbicarBombas ubicarBombas = new UbicarBombas();
			tablero = ubicarBombas.posicionarBombasCreadas(valorRandomTeorico, nBombas, tablero, m, n);
			
			int tablero_expected[][] = {{0,0,0},{0,0,0},{0,0,9}};
			assertArrayEquals("La bomba no se posiciona correctamente", tablero, tablero_expected);	
			
		}
		
		@Test
		public void testOfPosicionarBombasCreadas3() {
			int m = 3;
			int n = 3;
			int nBombas = 1;

			CreacionTableros creacion = new CreacionTableros();
			int tablero[][] = new int[m][n];
			tablero = creacion.tableroInterno(m, n);
			
			int[] valorRandomTeorico = {5};
			UbicarBombas ubicarBombas = new UbicarBombas();
			tablero = ubicarBombas.posicionarBombasCreadas(valorRandomTeorico, nBombas, tablero, m, n);
			
			int tablero_expected[][] = {{0,0,0},{0,9,0},{0,0,0}};
			assertArrayEquals("La bomba no se posiciona correctamente", tablero, tablero_expected);	
			
		}
		
		@Test
		public void testOfPosicionarBombasCreadas4() {
			int m = 3;
			int n = 3;
			int nBombas = 2;

			CreacionTableros creacion = new CreacionTableros();
			int tablero[][] = new int[m][n];
			tablero = creacion.tableroInterno(m, n);
			
			int[] valorRandomTeorico = {5, 2};
			UbicarBombas ubicarBombas = new UbicarBombas();
			tablero = ubicarBombas.posicionarBombasCreadas(valorRandomTeorico, nBombas, tablero, m, n);
			
			int tablero_expected[][] = {{0,9,0},{0,9,0},{0,0,0}};
			assertArrayEquals("La bomba no se posiciona correctamente", tablero, tablero_expected);	
			
		}
		
		@Test
		public void testOfPosicionarBombasCreadas5() {
			int m = 3;
			int n = 3;
			int nBombas = 0;

			CreacionTableros creacion = new CreacionTableros();
			int tablero[][] = new int[m][n];
			tablero = creacion.tableroInterno(m, n);
			
			int[] valorRandomTeorico = {0};
			UbicarBombas ubicarBombas = new UbicarBombas();
			tablero = ubicarBombas.posicionarBombasCreadas(valorRandomTeorico, nBombas, tablero, m, n);
			
			int tablero_expected[][] = {{0,0,0},{0,0,0},{0,0,0}};
			assertArrayEquals("La bomba no se posiciona correctamente", tablero, tablero_expected);	
			
		}
		
		@Test
		public void testOfPosicionarBombasCreadas6() {
			int m = 3;
			int n = 3;
			int nBombas = 4;

			CreacionTableros creacion = new CreacionTableros();
			int tablero[][] = new int[m][n];
			tablero = creacion.tableroInterno(m, n);
			
			int[] valorRandomTeorico = {5,2,1,9};
			UbicarBombas ubicarBombas = new UbicarBombas();
			tablero = ubicarBombas.posicionarBombasCreadas(valorRandomTeorico, nBombas, tablero, m, n);
			
			int tablero_expected[][] = {{9,9,0},{0,9,0},{0,0,9}};
			assertArrayEquals("La bomba no se posiciona correctamente", tablero, tablero_expected);	
			
		}
		
		@Test
		public void testOfPosicionarBombasCreadas7() {
			int m = 3;
			int n = 3;
			int nBombas = 9;

			CreacionTableros creacion = new CreacionTableros();
			int tablero[][] = new int[m][n];
			tablero = creacion.tableroInterno(m, n);
			
			int[] valorRandomTeorico = {3,4,6,7,8,5,2,1,9};
			UbicarBombas ubicarBombas = new UbicarBombas();
			tablero = ubicarBombas.posicionarBombasCreadas(valorRandomTeorico, nBombas, tablero, m, n);
			
			int tablero_expected[][] = {{9,9,9},{9,9,9},{9,9,9}};
			assertArrayEquals("La bomba no se posiciona correctamente", tablero, tablero_expected);	
			
		}

}
