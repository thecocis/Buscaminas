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
public class IsLostTests {

	private boolean _expected;
	private char[][] _tableroUsuario;
	private int[][] _tableroInterno;
	private int _m;
	private int _n;
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
	
	public IsLostTests(boolean expected, char[][] tableroUsuario, int[][] tableroInterno, int m, int n, String mensaje) {
		_expected = expected;
		_tableroUsuario = tableroUsuario;
		_tableroInterno = tableroInterno;
		_m = m;
		_n = n;
		_mensaje = mensaje;
	}
	
	@Parameterized.Parameters
	public static Collection<Object[]> getData() {
		return Arrays.asList(new Object[][] {
			{true, new char[][] {{'P','X','P','-'},{'P','5','-','P'},{'P','-','5','P'},{'P','P','P','P'}}, new int[][]{{9,9,9,9}, {9,5,5,9}, {9,5,5,9}, {9,9,9,9}},  4, 4,"Test tablero 4x4 bombas en los bordes versión 1"},
			{true, new char[][] {{'X','P','X','P'},{'P','5','-','P'},{'P','-','5','P'},{'P','P','P','P'}}, new int[][]{{9,9,9,9}, {9,5,5,9}, {9,5,5,9}, {9,9,9,9}},  4, 4,  "Test tablero 4x4 bombas en los bordes version 2"},
			{false, new char[][] {{'P','P','P','P'},{'P','P','-','P'},{'P','-','5','P'},{'P','P','P','P'}}, new int[][]{{9,9,9,9}, {9,5,5,9}, {9,5,5,9}, {9,9,9,9}},  4, 4, "Test tablero 4x4 bombas en los bordes version 3"},
			
		});
	}
	
	@Test
	public void isWonTests() {
		assertEquals(_mensaje, _expected, _sut.isLost(_tableroInterno, _tableroUsuario, _m, _n));
	}

}
