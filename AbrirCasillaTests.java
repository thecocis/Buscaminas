package Tests;

import static org.junit.Assert.*;
import Buscaminas.*;
import org.junit.Test;

public class AbrirCasillaTests {
	
	public int[][] TableroEnsayo() {
		CreacionTableros creacion = new CreacionTableros();
		UbicarBombas ubicarBombas = new UbicarBombas();
		PonerNumeros ponerNumeros = new PonerNumeros();
		PrintsPantalla prints = new PrintsPantalla();
		int arrayBombas[] = {1,8, 32, 28, 35, 36, 38, 41, 47, 48, 52, 55};
		int tableroInterno[][] = creacion.tableroInterno(8, 8);
		ubicarBombas.posicionarBombasCreadas(arrayBombas, 12, tableroInterno, 8, 8);
		tableroInterno = ponerNumeros.crearTableroConNumeros(8, 8, tableroInterno);
		prints.tableroInterno(8, 8, tableroInterno);
		return tableroInterno;
	}
	
	
	@Test
	public void TestOfNumero() {
		AbrirCasilla abrir = new AbrirCasilla();
		int tableroInterno[][] = TableroEnsayo();
		char[][] tableroUsuario = {{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}};
		
		tableroUsuario = abrir.abrirCasilla(0, 1, 1, tableroUsuario, tableroInterno);
		char[][] expected = {{'-', '1', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}};
		
		assertArrayEquals("La casilla numérica se abre maaal", expected, tableroUsuario);
	}
	
	@Test
	public void TestOfMarcaBomba() {
		AbrirCasilla abrir = new AbrirCasilla();
		int tableroInterno[][] = TableroEnsayo();
		char[][] tableroUsuario = {{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}};
		
		tableroUsuario = abrir.abrirCasilla(0, 1, 3, tableroUsuario, tableroInterno);
		char[][] expected = {{'-', '!', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}};
		
		assertArrayEquals("La casilla numérica se abre maaal", expected, tableroUsuario);
	}
	
	@Test
	public void TestOfInterrogante() {
		AbrirCasilla abrir = new AbrirCasilla();
		int tableroInterno[][] = TableroEnsayo();
		char[][] tableroUsuario = {{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}};
		
		tableroUsuario = abrir.abrirCasilla(0, 0, 4, tableroUsuario, tableroInterno);
		char[][] expected = {{'?', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}};
		
		assertArrayEquals("La casilla numérica se abre maaal", expected, tableroUsuario);
	}
	
	@Test
	public void TestOfBandera() {
		AbrirCasilla abrir = new AbrirCasilla();
		int tableroInterno[][] = TableroEnsayo();
		char[][] tableroUsuario = {{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}};
		
		tableroUsuario = abrir.abrirCasilla(0, 0, 2, tableroUsuario, tableroInterno);
		char[][] expected = {{'P', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}};
		
		assertArrayEquals("La casilla numérica se abre maaal", expected, tableroUsuario);
	}
	
	@Test
	public void TestOfHayBombaYPicas1() {
		AbrirCasilla abrir = new AbrirCasilla();
		int tableroInterno[][] = TableroEnsayo();
		char[][] tableroUsuario = {{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}};
		
		tableroUsuario = abrir.abrirCasilla(0, 0, 1, tableroUsuario, tableroInterno);
		char[][] expected = {{'X', '-', '-', '-', '-', '-', '-', 'X'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', 'X', '-', '-', '-', 'X'},{'-', '-', 'X', 'X', '-', 'X', '-', '-'},{'X', '-', '-', '-', '-', '-', 'X', 'X'},{'-', '-', '-', 'X', '-', '-', 'X', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}};
		
		assertArrayEquals("La casilla numérica se abre maaal", expected, tableroUsuario);
	}
	
	@Test
	public void TestOfHayBombaYPicas2() {
		AbrirCasilla abrir = new AbrirCasilla();
		int tableroInterno[][] = TableroEnsayo();
		char[][] tableroUsuario = {{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}};
		
		tableroUsuario = abrir.abrirCasilla(0, 7, 1, tableroUsuario, tableroInterno);
		char[][] expected = {{'X', '-', '-', '-', '-', '-', '-', 'X'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', 'X', '-', '-', '-', 'X'},{'-', '-', 'X', 'X', '-', 'X', '-', '-'},{'X', '-', '-', '-', '-', '-', 'X', 'X'},{'-', '-', '-', 'X', '-', '-', 'X', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}};
		
		assertArrayEquals("La casilla numérica se abre maaal", expected, tableroUsuario);
	}
	
	@Test
	public void TestOfHayBombaYPicas3() {
		AbrirCasilla abrir = new AbrirCasilla();
		int tableroInterno[][] = TableroEnsayo();
		char[][] tableroUsuario = {{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}};
		
		tableroUsuario = abrir.abrirCasilla(5, 0, 1, tableroUsuario, tableroInterno);
		char[][] expected = {{'X', '-', '-', '-', '-', '-', '-', 'X'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', 'X', '-', '-', '-', 'X'},{'-', '-', 'X', 'X', '-', 'X', '-', '-'},{'X', '-', '-', '-', '-', '-', 'X', 'X'},{'-', '-', '-', 'X', '-', '-', 'X', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}};
		
		assertArrayEquals("La casilla numérica se abre maaal", expected, tableroUsuario);
	}
	
	@Test
	public void TestOfCasilla0() {
		AbrirCasilla abrir = new AbrirCasilla();
		int tableroInterno[][] = TableroEnsayo();
		char[][] tableroUsuario = {{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}};
		
		tableroUsuario = abrir.abrirCasilla(0, 4, 1, tableroUsuario, tableroInterno);
		char[][] expected = {{'-', '1', '0', '0', '0', '0', '1', '-'},{'-', '1', '0', '0', '0', '0', '1', '-'},{'0', '0', '1', '1', '1', '0', '1', '-'},{'0', '1', '3', '-', '3', '1', '2', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}};
		
		assertArrayEquals("La casilla numérica se abre maaal", expected, tableroUsuario);
	}

}
