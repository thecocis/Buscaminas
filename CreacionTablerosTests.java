package Tests;

import static org.junit.Assert.*;
import org.junit.Test;
import Buscaminas.*;

public class CreacionTablerosTests {
	
	//Probar con negativos y 0
	@Test
	public void testOfCrearTablero1() {
		CreacionTableros creacion = new CreacionTableros();
		int tablero[][] = new int[8][8];
		tablero = creacion.tableroInterno(8, 8);
		
		int tablero_expected[][] = {{0,0,0,0,0,0,0,0}, {0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}};
		assertArrayEquals("El tablero no se inicializa bien", tablero, tablero_expected);
	}
	
	@Test
	public void testOfCrearTablero2() {
		CreacionTableros creacion = new CreacionTableros();
		int tablero[][] = new int[2][2];
		tablero = creacion.tableroInterno(2, 2);
		int tablero_expected[][] = {{0,0}, {0,0}};
		assertArrayEquals("El tablero no se inicializa bien", tablero, tablero_expected);
	}
	
	@Test
	public void testOfCrearTablero3() {
		CreacionTableros creacion = new CreacionTableros();
		int tablero[][] = new int[3][5];
		tablero = creacion.tableroInterno(3, 5);
		int tablero_expected[][] = {{0,0,0,0,0}, {0,0,0,0,0},{0,0,0,0,0}};
		assertArrayEquals("El tablero no se inicializa bien", tablero, tablero_expected);
	}
	
	@Test
	public void testOfCrearTablero4() {
		CreacionTableros creacion = new CreacionTableros();
		int tablero[][] = new int[1][9];
		tablero = creacion.tableroInterno(1, 9);
		int tablero_expected[][] = {{0,0,0,0,0,0,0,0,0}};
		assertArrayEquals("El tablero no se inicializa bien", tablero, tablero_expected);
	}
	@Test
	public void testOfCrearTablero5() {
		CreacionTableros creacion = new CreacionTableros();
		int tablero[][] = new int[9][1];
		tablero = creacion.tableroInterno(9, 1);
		int tablero_expected[][] = {{0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}};
		assertArrayEquals("El tablero no se inicializa bien", tablero, tablero_expected);
	}
	
	
	
	@Test
	public void testOfTableroUsuario1() {
		int m = 8;
		int n = 8;
		CreacionTableros creacion = new CreacionTableros();
		char[][] tableroUsuario = creacion.tableroUsuario(m,n);
		char[][] tableroExpected = {{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}};
		assertArrayEquals("Tablero usuario mal", tableroUsuario, tableroExpected);
	}
	
	@Test
	public void testOfTableroUsuario2() {
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
}
