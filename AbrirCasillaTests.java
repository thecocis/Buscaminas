package Buscaminas;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class AbrirCasillaTests {
	
	private int[][] _tableroInterno;
	private char[][] _tableroUsuario;
	private int _m;
	private int _n;
	private AbrirCasilla _sut;
	private int _fila;
	private int _columna;
	private char[][] _expected;
	private String _mensaje;
	
	private static MockTeclado _mock;
	private int _seleccionMock;
		
	@Before
	public void inicializacion() {
		_sut = new AbrirCasilla();
		_mock = new MockTeclado();
	}
	
	@After
	public void clean() {
		_sut = null;
	}
	
	public AbrirCasillaTests(int m, int n, int fila, int columna, int seleccionMock, String mensaje, int[][] tableroInterno, char[][] tableroUsuario, char[][] expected) {
		_tableroInterno = tableroInterno;
		_tableroUsuario = tableroUsuario;
		_m = m;
		_n = n;
		_seleccionMock = seleccionMock;
		_fila = fila;
		_columna = columna;
		_expected = expected;
		_mensaje = mensaje;
	}	
	
	//Consideraciones para los test:
	// Siendo una matriz 4x4 con los siguientes valores
	// |1|2|2|3|
	// |4|5|5|6|
	// |4|5|5|6|
	// |7|8|8|9|
	//Distinguimos estas partes:
	//  1--> parte superior izquierda
	//  2--> parte superior
	//  3--> parte superior derecha
	//  4--> parte izquierda
	//  5--> medio
	//  6--> parte derecha
	//  7--> parte inferior izquierda
	//  8--> parte inferior
	//  9--> parte inferior derecha
	
	@Parameterized.Parameters
	public static Collection<Object[]> getData() {
		return Arrays.asList(new Object[][] {
			
			//numeros
			{8 ,8, 0, 1, 1, "Comprobación solo numero 1 al abrir casilla parte superior",
				new int[][] {{9,1,0,0,0,0,1,9},{1,1,0,0,0,0,1,1},{0,0,1,1,1,0,1,1},{0,1,3,9,3,1,2,9},{1,2,9,9,3,9,4,3},{9,2,3,3,3,3,9,9},{1,1,1,9,1,2,9,3},{0,1,1,1,1,1,1,1}},
				new char[][]{{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}},
				new char[][]{{'-', '1', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}}},
			{8 ,8, 3, 2, 1, "Comprobación solo numero 3 al abrir casilla parte del medio",
				new int[][] {{9,1,0,0,0,0,1,9},{1,1,0,0,0,0,1,1},{0,0,1,1,1,0,1,1},{0,1,3,9,3,1,2,9},{1,2,9,9,3,9,4,3},{9,2,3,3,3,3,9,9},{1,1,1,9,1,2,9,3},{0,1,1,1,1,1,1,1}},
				new char[][]{{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}},
				new char[][]{{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '3', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}}},
			{8 ,8, 3, 6, 1, "Comprobación solo numero 2 al abrir casilla paret del medio",
				new int[][] {{9,1,0,0,0,0,1,9},{1,1,0,0,0,0,1,1},{0,0,1,1,1,0,1,1},{0,1,3,9,3,1,2,9},{1,2,9,9,3,9,4,3},{9,2,3,3,3,3,9,9},{1,1,1,9,1,2,9,3},{0,1,1,1,1,1,1,1}},
				new char[][]{{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}},
				new char[][]{{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '2', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}}},
			{8 ,8, 4, 6, 1, "Comprobación solo numero 4 al abrir casilla parte del medio",
				new int[][] {{9,1,0,0,0,0,1,9},{1,1,0,0,0,0,1,1},{0,0,1,1,1,0,1,1},{0,1,3,9,3,1,2,9},{1,2,9,9,3,9,4,3},{9,2,3,3,3,3,9,9},{1,1,1,9,1,2,9,3},{0,1,1,1,1,1,1,1}},
				new char[][]{{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}},
				new char[][]{{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '4', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}}},
			{8 ,8, 7, 7, 1, "Comprobación solo numero al abrir casilla parte inferior derecha",
				new int[][] {{9,1,0,0,0,0,1,9},{1,1,0,0,0,0,1,1},{0,0,1,1,1,0,1,1},{0,1,3,9,3,1,2,9},{1,2,9,9,3,9,4,3},{9,2,3,3,3,3,9,9},{1,1,1,9,1,2,9,3},{0,1,1,1,1,1,1,1}},
				new char[][]{{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}},
				new char[][]{{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '1'}}},
			{3, 3, 0, 0, 1, "Comprobación solo numero al abrir casilla parte superior izquierda",
				new int[][] {{1,1,0},{9,1,0},{1,1,0}},
				new char[][] {{'-','-','-'},{'-','-','-'},{'-','-','-'}},
				new char[][] {{'1','-','-'},{'-','-','-'},{'-','-','-'}}},
			{3, 3, 2, 0, 1, "Comprobación solo numero al abrir casilla parte inferior izquierda",
				new int[][] {{1,1,0},{9,1,0},{1,1,0}},
				new char[][] {{'-','-','-'},{'-','-','-'},{'-','-','-'}},
				new char[][] {{'-','-','-'},{'-','-','-'},{'1','-','-'}}},
			{3, 3, 1, 0, 1, "Comprobación solo numero al abrir casilla parte izquierda",
				new int[][] {{9,1,0},{1,1,0},{0,0,0}},
				new char[][] {{'-','-','-'},{'-','-','-'},{'-','-','-'}},
				new char[][] {{'-','-','-'},{'1','-','-'},{'-','-','-'}}},
			{3, 3, 0, 2, 1, "Comprobación solo numero al abrir casilla parte superior derecha",
				new int[][] {{1,9,1},{1,1,1},{0,0,0}},
				new char[][] {{'-','-','-'},{'-','-','-'},{'-','-','-'}},
				new char[][] {{'-','-','1'},{'-','-','-'},{'-','-','-'}}},
			{3, 3, 1, 2, 1, "Comprobación solo numero al abrir casilla parte superior derecha",
				new int[][] {{1,9,1},{1,1,1},{0,0,0}},
				new char[][] {{'-','-','-'},{'-','-','-'},{'-','-','-'}},
				new char[][] {{'-','-','-'},{'-','-','1'},{'-','-','-'}}},
			{3, 3, 2, 1, 1, "Comprobación solo numero al abrir casilla parte abajo",
				new int[][] {{0,0,0},{0,1,1},{0,1,9}},
				new char[][] {{'-','-','-'},{'-','-','-'},{'-','-','-'}},
				new char[][] {{'-','-','-'},{'-','-','-'},{'-','1','-'}}},
			
			//marcar interrogantes
			{8 ,8, 0, 1, 4, "Comprobación interrogante con tablero vacío 1.0",
				new int[][] {{9,1,0,0,0,0,1,9},{1,1,0,0,0,0,1,1},{0,0,1,1,1,0,1,1},{0,1,3,9,3,1,2,9},{1,2,9,9,3,9,4,3},{9,2,3,3,3,3,9,9},{1,1,1,9,1,2,9,3},{0,1,1,1,1,1,1,1}},
				new char[][]{{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}},
				new char[][]{{'-', '?', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}}},
			{8 ,8, 3, 2, 4, "Comprobación interrogante al abrir casilla parte del medio",
				new int[][] {{9,1,0,0,0,0,1,9},{1,1,0,0,0,0,1,1},{0,0,1,1,1,0,1,1},{0,1,3,9,3,1,2,9},{1,2,9,9,3,9,4,3},{9,2,3,3,3,3,9,9},{1,1,1,9,1,2,9,3},{0,1,1,1,1,1,1,1}},
				new char[][]{{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}},
				new char[][]{{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '?', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}}},
			{8 ,8, 7, 7, 4, "Comprobación interrogante al abrir casilla parte inferior derecha",
				new int[][] {{9,1,0,0,0,0,1,9},{1,1,0,0,0,0,1,1},{0,0,1,1,1,0,1,1},{0,1,3,9,3,1,2,9},{1,2,9,9,3,9,4,3},{9,2,3,3,3,3,9,9},{1,1,1,9,1,2,9,3},{0,1,1,1,1,1,1,1}},
				new char[][]{{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}},
				new char[][]{{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '?'}}},
			{3, 3, 0, 0, 4, "Comprobación interrogante al abrir casilla parte superior izquierda",
				new int[][] {{1,1,0},{9,1,0},{1,1,0}},
				new char[][] {{'-','-','-'},{'-','-','-'},{'-','-','-'}},
				new char[][] {{'?','-','-'},{'-','-','-'},{'-','-','-'}}},
			{3, 3, 2, 0, 4, "Comprobación interrogante  al abrir casilla parte inferior izquierda",
				new int[][] {{1,1,0},{9,1,0},{1,1,0}},
				new char[][] {{'-','-','-'},{'-','-','-'},{'-','-','-'}},
				new char[][] {{'-','-','-'},{'-','-','-'},{'?','-','-'}}},
			{3, 3, 1, 0, 4, "Comprobación interrogante al abrir casilla parte izquierda",
				new int[][] {{9,1,0},{1,1,0},{0,0,0}},
				new char[][] {{'-','-','-'},{'-','-','-'},{'-','-','-'}},
				new char[][] {{'-','-','-'},{'?','-','-'},{'-','-','-'}}},
			{3, 3, 0, 2, 4, "Comprobación interrogante al abrir casilla parte superior derecha",
				new int[][] {{1,9,1},{1,1,1},{0,0,0}},
				new char[][] {{'-','-','-'},{'-','-','-'},{'-','-','-'}},
				new char[][] {{'-','-','?'},{'-','-','-'},{'-','-','-'}}},
			{3, 3, 1, 2, 4, "Comprobación interrogante al abrir casilla parte superior derecha",
				new int[][] {{1,9,1},{1,1,1},{0,0,0}},
				new char[][] {{'-','-','-'},{'-','-','-'},{'-','-','-'}},
				new char[][] {{'-','-','-'},{'-','-','?'},{'-','-','-'}}},
			{3, 3, 2, 1, 4, "Comprobación interrogante al abrir casilla parte abajo",
				new int[][] {{0,0,0},{0,1,1},{0,1,9}},
				new char[][] {{'-','-','-'},{'-','-','-'},{'-','-','-'}},
				new char[][] {{'-','-','-'},{'-','-','-'},{'-','?','-'}}},
				
			//marcar bombas
			{8 ,8, 0, 1, 3, "Comprobación marca bomba al abrir casilla parte superior",
				new int[][] {{9,1,0,0,0,0,1,9},{1,1,0,0,0,0,1,1},{0,0,1,1,1,0,1,1},{0,1,3,9,3,1,2,9},{1,2,9,9,3,9,4,3},{9,2,3,3,3,3,9,9},{1,1,1,9,1,2,9,3},{0,1,1,1,1,1,1,1}},
				new char[][]{{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}},
				new char[][]{{'-', '!', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}}},
			{8 ,8, 3, 2, 3, "Comprobación marca bomba  al abrir casilla parte del medio",
				new int[][] {{9,1,0,0,0,0,1,9},{1,1,0,0,0,0,1,1},{0,0,1,1,1,0,1,1},{0,1,3,9,3,1,2,9},{1,2,9,9,3,9,4,3},{9,2,3,3,3,3,9,9},{1,1,1,9,1,2,9,3},{0,1,1,1,1,1,1,1}},
				new char[][]{{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}},
				new char[][]{{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '!', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}}},
			{8 ,8, 7, 7, 3, "Comprobación marca bomba  al abrir casilla parte inferior derecha",
				new int[][] {{9,1,0,0,0,0,1,9},{1,1,0,0,0,0,1,1},{0,0,1,1,1,0,1,1},{0,1,3,9,3,1,2,9},{1,2,9,9,3,9,4,3},{9,2,3,3,3,3,9,9},{1,1,1,9,1,2,9,3},{0,1,1,1,1,1,1,1}},
				new char[][]{{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}},
				new char[][]{{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '!'}}},
			{3, 3, 0, 0, 3, "Comprobación marca bomba  al abrir casilla parte superior izquierda",
				new int[][] {{1,1,0},{9,1,0},{1,1,0}},
				new char[][] {{'-','-','-'},{'-','-','-'},{'-','-','-'}},
				new char[][] {{'!','-','-'},{'-','-','-'},{'-','-','-'}}},
			{3, 3, 2, 0, 3, "Comprobación marca bomba  al abrir casilla parte inferior izquierda",
				new int[][] {{1,1,0},{9,1,0},{1,1,0}},
				new char[][] {{'-','-','-'},{'-','-','-'},{'-','-','-'}},
				new char[][] {{'-','-','-'},{'-','-','-'},{'!','-','-'}}},
			{3, 3, 1, 0, 3, "Comprobación marca bomba  al abrir casilla parte izquierda",
				new int[][] {{9,1,0},{1,1,0},{0,0,0}},
				new char[][] {{'-','-','-'},{'-','-','-'},{'-','-','-'}},
				new char[][] {{'-','-','-'},{'!','-','-'},{'-','-','-'}}},
			{3, 3, 0, 2, 3, "Comprobación marca bomba  al abrir casilla parte superior derecha",
				new int[][] {{1,9,1},{1,1,1},{0,0,0}},
				new char[][] {{'-','-','-'},{'-','-','-'},{'-','-','-'}},
				new char[][] {{'-','-','!'},{'-','-','-'},{'-','-','-'}}},
			{3, 3, 1, 2, 3, "Comprobación marca bomba  al abrir casilla parte superior derecha",
				new int[][] {{1,9,1},{1,1,1},{0,0,0}},
				new char[][] {{'-','-','-'},{'-','-','-'},{'-','-','-'}},
				new char[][] {{'-','-','-'},{'-','-','!'},{'-','-','-'}}},
			{3, 3, 2, 1, 3, "Comprobación marca bomba al abrir casilla parte abajo",
				new int[][] {{0,0,0},{0,1,1},{0,1,9}},
				new char[][] {{'-','-','-'},{'-','-','-'},{'-','-','-'}},
				new char[][] {{'-','-','-'},{'-','-','-'},{'-','!','-'}}},
				
			//Marcar una bandera
			{8 ,8, 0, 1, 2, "Comprobación marca bandera al abrir casilla parte superior",
				new int[][] {{9,1,0,0,0,0,1,9},{1,1,0,0,0,0,1,1},{0,0,1,1,1,0,1,1},{0,1,3,9,3,1,2,9},{1,2,9,9,3,9,4,3},{9,2,3,3,3,3,9,9},{1,1,1,9,1,2,9,3},{0,1,1,1,1,1,1,1}},
				new char[][]{{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}},
				new char[][]{{'-', 'P', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}}},
			{8 ,8, 3, 2, 2, "Comprobación marca bandera  al abrir casilla parte del medio",
				new int[][] {{9,1,0,0,0,0,1,9},{1,1,0,0,0,0,1,1},{0,0,1,1,1,0,1,1},{0,1,3,9,3,1,2,9},{1,2,9,9,3,9,4,3},{9,2,3,3,3,3,9,9},{1,1,1,9,1,2,9,3},{0,1,1,1,1,1,1,1}},
				new char[][]{{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}},
				new char[][]{{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', 'P', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}}},
			{8 ,8, 7, 7, 2, "Comprobación marca bandera  al abrir casilla parte inferior derecha",
				new int[][] {{9,1,0,0,0,0,1,9},{1,1,0,0,0,0,1,1},{0,0,1,1,1,0,1,1},{0,1,3,9,3,1,2,9},{1,2,9,9,3,9,4,3},{9,2,3,3,3,3,9,9},{1,1,1,9,1,2,9,3},{0,1,1,1,1,1,1,1}},
				new char[][]{{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}},
				new char[][]{{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', 'P'}}},
			{3, 3, 0, 0, 2, "Comprobación marca bandera  al abrir casilla parte superior izquierda",
				new int[][] {{1,1,0},{9,1,0},{1,1,0}},
				new char[][] {{'-','-','-'},{'-','-','-'},{'-','-','-'}},
				new char[][] {{'P','-','-'},{'-','-','-'},{'-','-','-'}}},
			{3, 3, 2, 0, 2, "Comprobación marca bandera  al abrir casilla parte inferior izquierda",
				new int[][] {{1,1,0},{9,1,0},{1,1,0}},
				new char[][] {{'-','-','-'},{'-','-','-'},{'-','-','-'}},
				new char[][] {{'-','-','-'},{'-','-','-'},{'P','-','-'}}},
			{3, 3, 1, 0, 2, "Comprobación marca bandera  al abrir casilla parte izquierda",
				new int[][] {{9,1,0},{1,1,0},{0,0,0}},
				new char[][] {{'-','-','-'},{'-','-','-'},{'-','-','-'}},
				new char[][] {{'-','-','-'},{'P','-','-'},{'-','-','-'}}},
			{3, 3, 0, 2, 2, "Comprobación marca bandera  al abrir casilla parte superior derecha",
				new int[][] {{1,9,1},{1,1,1},{0,0,0}},
				new char[][] {{'-','-','-'},{'-','-','-'},{'-','-','-'}},
				new char[][] {{'-','-','P'},{'-','-','-'},{'-','-','-'}}},
			{3, 3, 1, 2, 2, "Comprobación marca bandera  al abrir casilla parte superior derecha",
				new int[][] {{1,9,1},{1,1,1},{0,0,0}},
				new char[][] {{'-','-','-'},{'-','-','-'},{'-','-','-'}},
				new char[][] {{'-','-','-'},{'-','-','P'},{'-','-','-'}}},
			{3, 3, 2, 1, 2, "Comprobación marca bandera al abrir casilla parte abajo",
				new int[][] {{0,0,0},{0,1,1},{0,1,9}},
				new char[][] {{'-','-','-'},{'-','-','-'},{'-','-','-'}},
				new char[][] {{'-','-','-'},{'-','-','-'},{'-','P','-'}}},
			
			//hay bomba y picas
			{8 ,8, 0, 0, 1, "Comprobación hay una bomba y picas con tablero vacío 1.0",
				new int[][] {{9,1,0,0,0,0,1,9},{1,1,0,0,0,0,1,1},{0,0,1,1,1,0,1,1},{0,1,3,9,3,1,2,9},{1,2,9,9,3,9,4,3},{9,2,3,3,3,3,9,9},{1,1,1,9,1,2,9,3},{0,1,1,1,1,1,1,1}},
				new char[][]{{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}},
				new char[][]{{'X', '-', '-', '-', '-', '-', '-', 'X'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', 'X', '-', '-', '-', 'X'},{'-', '-', 'X', 'X', '-', 'X', '-', '-'},{'X', '-', '-', '-', '-', '-', 'X', 'X'},{'-', '-', '-', 'X', '-', '-', 'X', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}}},
			{8 ,8, 0, 7, 1, "Comprobación hay una bomba y picas con tablero vacío 1.1",
				new int[][] {{9,1,0,0,0,0,1,9},{1,1,0,0,0,0,1,1},{0,0,1,1,1,0,1,1},{0,1,3,9,3,1,2,9},{1,2,9,9,3,9,4,3},{9,2,3,3,3,3,9,9},{1,1,1,9,1,2,9,3},{0,1,1,1,1,1,1,1}},
				new char[][]{{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}},
				new char[][]{{'X', '-', '-', '-', '-', '-', '-', 'X'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', 'X', '-', '-', '-', 'X'},{'-', '-', 'X', 'X', '-', 'X', '-', '-'},{'X', '-', '-', '-', '-', '-', 'X', 'X'},{'-', '-', '-', 'X', '-', '-', 'X', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}}},
			{8 ,8, 5, 0, 1, "Comprobación hay una bomba y picas con tablero vacío 1.2",
				new int[][] {{9,1,0,0,0,0,1,9},{1,1,0,0,0,0,1,1},{0,0,1,1,1,0,1,1},{0,1,3,9,3,1,2,9},{1,2,9,9,3,9,4,3},{9,2,3,3,3,3,9,9},{1,1,1,9,1,2,9,3},{0,1,1,1,1,1,1,1}},
				new char[][]{{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}},
				new char[][]{{'X', '-', '-', '-', '-', '-', '-', 'X'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', 'X', '-', '-', '-', 'X'},{'-', '-', 'X', 'X', '-', 'X', '-', '-'},{'X', '-', '-', '-', '-', '-', 'X', 'X'},{'-', '-', '-', 'X', '-', '-', 'X', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}}},
				
			
			//Abrir casilla todos los 0 y numeros circundantes
			{8 ,8, 0, 4, 1, "Comprobación abrir 0 y circundates de golpe con tablero vacío parte de arriba y parte izquierda y medio picada en posicion 1",
				new int[][] {{9,1,0,0,0,0,1,9},{1,1,0,0,0,0,1,1},{0,0,1,1,1,0,1,1},{0,1,3,9,3,1,2,9},{1,2,9,9,3,9,4,3},{9,2,3,3,3,3,9,9},{1,1,1,9,1,2,9,3},{0,1,1,1,1,1,1,1}},
				new char[][]{{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}},
				new char[][]{{'-', '1', '0', '0', '0', '0', '1', '-'},{'1', '1', '0', '0', '0', '0', '1', '-'},{'0', '0', '1', '1', '1', '0', '1', '-'},{'0', '1', '3', '-', '3', '1', '2', '-'},{'1', '2', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}}},
			{8 ,8, 0, 3, 1, "Comprobación abrir 0 y circundates de golpe con tablero vacío parte de arriba y parte izquierda y medio picada en posicion 2",
				new int[][] {{9,1,0,0,0,0,1,9},{1,1,0,0,0,0,1,1},{0,0,1,1,1,0,1,1},{0,1,3,9,3,1,2,9},{1,2,9,9,3,9,4,3},{9,2,3,3,3,3,9,9},{1,1,1,9,1,2,9,3},{0,1,1,1,1,1,1,1}},
				new char[][]{{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}},
				new char[][]{{'-', '1', '0', '0', '0', '0', '1', '-'},{'1', '1', '0', '0', '0', '0', '1', '-'},{'0', '0', '1', '1', '1', '0', '1', '-'},{'0', '1', '3', '-', '3', '1', '2', '-'},{'1', '2', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}}},
			{8 ,8, 1, 2, 1, "Comprobación abrir 0 y circundates de golpe con tablero vacío parte de arriba y parte izquierda y medio picada en posicion 3",
				new int[][] {{9,1,0,0,0,0,1,9},{1,1,0,0,0,0,1,1},{0,0,1,1,1,0,1,1},{0,1,3,9,3,1,2,9},{1,2,9,9,3,9,4,3},{9,2,3,3,3,3,9,9},{1,1,1,9,1,2,9,3},{0,1,1,1,1,1,1,1}},
				new char[][]{{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}},
				new char[][]{{'-', '1', '0', '0', '0', '0', '1', '-'},{'1', '1', '0', '0', '0', '0', '1', '-'},{'0', '0', '1', '1', '1', '0', '1', '-'},{'0', '1', '3', '-', '3', '1', '2', '-'},{'1', '2', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}}},
			{8 ,8, 1, 5, 1, "Comprobación abrir 0 y circundates de golpe con tablero vacío parte de arriba y parte izquierda y medio picada en posicion 4",
				new int[][] {{9,1,0,0,0,0,1,9},{1,1,0,0,0,0,1,1},{0,0,1,1,1,0,1,1},{0,1,3,9,3,1,2,9},{1,2,9,9,3,9,4,3},{9,2,3,3,3,3,9,9},{1,1,1,9,1,2,9,3},{0,1,1,1,1,1,1,1}},
				new char[][]{{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}},
				new char[][]{{'-', '1', '0', '0', '0', '0', '1', '-'},{'1', '1', '0', '0', '0', '0', '1', '-'},{'0', '0', '1', '1', '1', '0', '1', '-'},{'0', '1', '3', '-', '3', '1', '2', '-'},{'1', '2', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}}},
			{8 ,8, 2, 5, 1, "Comprobación abrir 0 y circundates de golpe con tablero vacío parte de arriba y parte izquierda y medio picada en posicion 5",
				new int[][] {{9,1,0,0,0,0,1,9},{1,1,0,0,0,0,1,1},{0,0,1,1,1,0,1,1},{0,1,3,9,3,1,2,9},{1,2,9,9,3,9,4,3},{9,2,3,3,3,3,9,9},{1,1,1,9,1,2,9,3},{0,1,1,1,1,1,1,1}},
				new char[][]{{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}},
				new char[][]{{'-', '1', '0', '0', '0', '0', '1', '-'},{'1', '1', '0', '0', '0', '0', '1', '-'},{'0', '0', '1', '1', '1', '0', '1', '-'},{'0', '1', '3', '-', '3', '1', '2', '-'},{'1', '2', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}}},
			{8 ,8, 2, 1, 1, "Comprobación abrir 0 y circundates de golpe con tablero vacío parte de arriba y parte izquierda y medio picada en posicion 6",
				new int[][] {{9,1,0,0,0,0,1,9},{1,1,0,0,0,0,1,1},{0,0,1,1,1,0,1,1},{0,1,3,9,3,1,2,9},{1,2,9,9,3,9,4,3},{9,2,3,3,3,3,9,9},{1,1,1,9,1,2,9,3},{0,1,1,1,1,1,1,1}},
				new char[][]{{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}},
				new char[][]{{'-', '1', '0', '0', '0', '0', '1', '-'},{'1', '1', '0', '0', '0', '0', '1', '-'},{'0', '0', '1', '1', '1', '0', '1', '-'},{'0', '1', '3', '-', '3', '1', '2', '-'},{'1', '2', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}}},
			{8 ,8, 3, 0, 1, "Comprobación abrir 0 y circundates de golpe con tablero vacío parte del medio",
				new int[][] {{9,1,0,0,0,0,1,9},{1,1,0,0,0,0,1,1},{0,0,1,1,1,0,1,1},{0,1,3,9,3,1,2,9},{1,2,9,9,3,9,4,3},{9,2,3,3,3,3,9,9},{1,1,1,9,1,2,9,3},{0,1,1,1,1,1,1,1}},
				new char[][]{{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}},
				new char[][]{{'-', '1', '0', '0', '0', '0', '1', '-'},{'1', '1', '0', '0', '0', '0', '1', '-'},{'0', '0', '1', '1', '1', '0', '1', '-'},{'0', '1', '3', '-', '3', '1', '2', '-'},{'1', '2', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}}},
			{4, 4, 0, 3, 1, "Comporbacion abrir 0 y circundates de golpe con tablero vacío esquina superior derecha y parte derecha y abajo",
				new int[][] {{9,2,0,0},{9,3,0,0},{9,3,0,0},{9,2,0,0}},
				new char[][] {{'-','-','-','-'},{'-','-','-','-'},{'-','-','-','-'},{'-','-','-','-'}},
				new char[][] {{'-','2','0','0'},{'-','3','0','0'},{'-','3','0','0'},{'-','2','0','0'}}},
			{4, 4, 0, 0, 1, "Comporbacion abrir 0 y circundates de golpe con tablero vacío esquina inferior izquierda y parte izquierda y abajo",
				new int[][] {{0,0,2,9},{0,0,3,9},{0,0,3,9},{0,0,2,9}},
				new char[][] {{'-','-','-','-'},{'-','-','-','-'},{'-','-','-','-'},{'-','-','-','-'}},
				new char[][] {{'0','0','2','-'},{'0','0','3','-'},{'0','0','3','-'},{'0','0','2','-'}}},			
		});
	}	
	
	@Test
	public void testOfAbrirCasilla() { 
		assertArrayEquals(_mensaje, _expected, _sut.abrirCasilla(_fila, _columna, _mock.seleccionOpcion(_seleccionMock), _tableroUsuario, _tableroInterno, _m, _n));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
