package Buscaminas;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import Buscaminas.*;

@RunWith(Parameterized.class)
public class IsWonTests {

	private boolean _expected;
	private char[][] _tableroUsuario;
	private int[][] _tableroInterno;
	private int _m;
	private int _n;
	private int _nBombas;
	private String _mensaje;
	private CreacionTableros _sut;
	
	@Before
	public void inicializacion() {
		_sut = new CreacionTableros();
	}
	
	@After
	public void clean() {
		_sut = null;
	}
	
	public IsWonTests(boolean expected, char[][] tableroUsuario, int[][] tableroInterno, int m, int n, int nBombas, String mensaje) {
		_expected = expected;
		_tableroUsuario = tableroUsuario;
		_tableroInterno = tableroInterno;
		_m = m;
		_n = n;
		_mensaje = mensaje;
		_nBombas = nBombas;
	}
	
	@Parameterized.Parameters
	public static Collection<Object[]> getData() {
		return Arrays.asList(new Object[][] {
			{false, new char[][] {{'P','P','P','-'},{'P','5','-','P'},{'P','-','5','P'},{'P','P','P','P'}}, new int[][]{{9,9,9,9}, {9,5,5,9}, {9,5,5,9}, {9,9,9,9}},  4, 4, 12, "Test tablero 4x4 bombas en los bordes"},
			{true, new char[][] {{'P','P','P','P'},{'P','5','-','P'},{'P','-','5','P'},{'P','P','P','P'}}, new int[][]{{9,9,9,9}, {9,5,5,9}, {9,5,5,9}, {9,9,9,9}},  4, 4, 12, "Test tablero 4x4 bombas en los bordes"},
			{true, new char[][] {{'P','P','P','P'},{'P','P','-','P'},{'P','-','5','P'},{'P','P','P','P'}}, new int[][]{{9,9,9,9}, {9,5,5,9}, {9,5,5,9}, {9,9,9,9}},  4, 4, 12, "Test tablero 4x4 bombas en los bordes"},
			{false, new char[][] {{'P','P','P','-'},{'P','P','-','P'},{'P','-','5','P'},{'P','P','P','P'}}, new int[][]{{9,9,9,9}, {9,5,5,9}, {9,5,5,9}, {9,9,9,9}},  4, 4, 12, "Test tablero 4x4 bombas en los bordes"},
			//CONSIDERAMOS QUE MIENTRAS ESTEN TODAS LAS BOMBAS CUBIERTAS SE ACABA EL JUEGO, DA IGUAL QUE HAYA P DONDE NO HAY BOMBAS
			{true, new char[][] {{'P','P','P','P'},{'P','P','P','P'},{'P','P','P','P'},{'P','P','P','P'}}, new int[][]{{9,9,9,9}, {9,5,5,9}, {9,5,5,9}, {9,9,9,9}},  4, 4, 12, "Test tablero 4x4 todo P"},
			{false, new char[][] {{'-','-','-','-'},{'-','-','-','-'},{'-','-','-','-'},{'-','-','-','-'}}, new int[][]{{9,9,9,9}, {9,5,5,9}, {9,5,5,9}, {9,9,9,9}},  4, 4, 12, "Test tablero 4x4 todo vació"},
			{false, new char[][] {{'P','P','P','P'},{'P','-','-','P'},{'P','-','-','-'},{'P','P','P','P'}}, new int[][]{{9,9,9,9}, {9,5,5,9}, {9,5,5,9}, {9,9,9,9}},  4, 4, 12, "Test tablero 4x4 todo menos una P bien"},
			
		});
	}
	
	@Test
	public void isWonTests() {
		assertEquals(_mensaje, _expected, _sut.isWon(_tableroInterno, _tableroUsuario, _m, _n, _nBombas));
	}

}
