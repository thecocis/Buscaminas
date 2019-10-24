package Tests;

import static org.junit.Assert.*;
import org.junit.Test;
import Buscaminas.*;

public class CreacionTablerosTests {
	
	//Probar con negativos y 0
	@Test
	public void testOfCrearTablero8x8() {
		CreacionTableros creacion = new CreacionTableros();
		int tablero[][] = new int[8][8];
		tablero = creacion.tableroInterno(8, 8);
		
		int tablero_expected[][] = {{0,0,0,0,0,0,0,0}, {0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}};
		assertArrayEquals("El tablero no se inicializa bien", tablero, tablero_expected);
	}
	
	@Test
	public void testOfCrearTablero2x2() {
		CreacionTableros creacion = new CreacionTableros();
		int tablero[][] = new int[2][2];
		tablero = creacion.tableroInterno(2, 2);
		int tablero_expected[][] = {{0,0}, {0,0}};
		assertArrayEquals("El tablero no se inicializa bien", tablero, tablero_expected);
	}
	
	@Test
	public void testOfCrearTablero3x5() {
		CreacionTableros creacion = new CreacionTableros();
		int tablero[][] = new int[3][5];
		tablero = creacion.tableroInterno(3, 5);
		int tablero_expected[][] = {{0,0,0,0,0}, {0,0,0,0,0},{0,0,0,0,0}};
		assertArrayEquals("El tablero no se inicializa bien", tablero, tablero_expected);
	}
	
	@Test
	public void testOfCrearTablero1x9() {
		CreacionTableros creacion = new CreacionTableros();
		int tablero[][] = new int[1][9];
		tablero = creacion.tableroInterno(1, 9);
		int tablero_expected[][] = {{0,0,0,0,0,0,0,0,0}};
		assertArrayEquals("El tablero no se inicializa bien", tablero, tablero_expected);
	}
	
	@Test
	public void testOfCrearTablero9x1() {
		CreacionTableros creacion = new CreacionTableros();
		int tablero[][] = new int[9][1];
		tablero = creacion.tableroInterno(9, 1);
		int tablero_expected[][] = {{0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}};
		assertArrayEquals("El tablero no se inicializa bien", tablero, tablero_expected);
	}
	
	// EXCEPCIONES
	@Test
	public void testOfCrearTableroNumeroNegativo() {
		try {
		int m = -1;
		int n = 8;
		CreacionTableros creacion = new CreacionTableros();
		int[][] tableroUsuario = creacion.tableroInterno(m,n);
		assertTrue(false);
		}catch (Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testOfCrearTableroDosNumerosNegativos() {
		try {
		int m = -1;
		int n = -8;
		CreacionTableros creacion = new CreacionTableros();
		int[][] tableroUsuario = creacion.tableroInterno(m,n);
		assertTrue(false);
		}catch (Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testOfCrearTablero0x8() {
		int m = 0;
		int n = 8;
		CreacionTableros creacion = new CreacionTableros();
		int[][] tableroUsuario = creacion.tableroInterno(m,n);
		int tablero_expected[][] = {{0,0,0,0,0,0,0,0}, {0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}};
		
		assertArrayEquals("Tablero no inicializado bien", tablero_expected, tableroUsuario);
	}
	
	
	
	/////////////////////USUARIO///////////////////////////
	@Test
	public void testOfTableroUsuario8x8() {
		int m = 8;
		int n = 8;
		CreacionTableros creacion = new CreacionTableros();
		char[][] tableroUsuario = creacion.tableroUsuario(m,n);
		char[][] tableroExpected = {{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}};
		assertArrayEquals("Tablero usuario mal", tableroUsuario, tableroExpected);
	}
	
	@Test
	public void testOfTableroUsuarioNumeroNegativo() {
		try {
		int m = -1;
		int n = 8;
		CreacionTableros creacion = new CreacionTableros();
		char[][] tableroUsuario = creacion.tableroUsuario(m,n);
		assertTrue(false);
		}catch (Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testOfTableroUsuarioDosNumerosNegativos() {
		try {
		int m = -1;
		int n = -8;
		CreacionTableros creacion = new CreacionTableros();
		char[][] tableroUsuario = creacion.tableroUsuario(m,n);
		assertTrue(false);
		}catch (Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testOfTableroUsuario0x0() {
		int m = 0;
		int n = 0;
		CreacionTableros creacion = new CreacionTableros();
		char[][] tableroUsuario = creacion.tableroUsuario(m,n);
		char[][] tableroExpected = {{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}};
		assertArrayEquals("Tablero usuario mal", tableroUsuario, tableroExpected);
	}
}
