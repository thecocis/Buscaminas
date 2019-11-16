package Buscaminas;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import Buscaminas.*;

@RunWith(Parameterized.class)
public class UbicarBombasTests {

	
	private UbicarBombas _sut;
	private int[][] _expected;
	private int _numero1;
	private int _numero2;
	private int _nBombas;
	private int[][] _tableroInterno;
	private String _mensaje;
	
	private static MockBombas _mock;
	private int _seleccionMock;
	
	@Before
	public void inicializacion() {
		_sut = new UbicarBombas();
		_mock = new MockBombas();
	}
	
	public UbicarBombasTests(int numero1, int numero2, int nBombas, int seleccionMock, int[][] expected, int[][] tablero, String mensaje) {
		_expected = expected;
		_numero1 = numero1;
		_numero2 = numero2;
		_nBombas = nBombas;
		_seleccionMock = seleccionMock;
		_tableroInterno = tablero;
		_mensaje = mensaje;
	}
	
	
	@Parameterized.Parameters
	public static Collection<Object[]> getData() {
		return Arrays.asList(new Object[][] {
			{ 3, 3, 1, 1, new int[][]{{9,0,0},{0,0,0},{0,0,0}}, new int[][]{{0,0,0},{0,0,0},{0,0,0}}, "Test de Primera bomba"},
			{ 3, 3, 1, 2, new int[][]{{0,0,9},{0,0,0},{0,0,0}}, new int[][]{{0,0,0},{0,0,0},{0,0,0}}, "Test de tercera bomba"},
			{ 3, 3, 1, 3, new int[][]{{0,0,0},{0,0,0},{9,0,0}}, new int[][]{{0,0,0},{0,0,0},{0,0,0}}, "Test de 7 bomba"},
			{ 3, 3, 1, 4, new int[][]{{0,0,0},{0,0,0},{0,0,9}}, new int[][]{{0,0,0},{0,0,0},{0,0,0}}, "Test de nueve bomba"},
			{ 3, 3, 1, 5, new int[][]{{0,0,0},{0,9,0},{0,0,0}}, new int[][]{{0,0,0},{0,0,0},{0,0,0}}, "Test de 5 bomba"},
			{ 3, 3, 2, 6, new int[][]{{0,9,0},{0,9,0},{0,0,0}}, new int[][]{{0,0,0},{0,0,0},{0,0,0}}, "Test de 2 y 5 bomba"},
			{ 3, 3, 4, 7, new int[][]{{9,9,0},{0,9,0},{0,0,9}}, new int[][]{{0,0,0},{0,0,0},{0,0,0}}, "Test de cuatro bombas"},
			{ 3, 3, 9, 8, new int[][]{{9,9,9},{9,9,9},{9,9,9}}, new int[][]{{0,0,0},{0,0,0},{0,0,0}}, "Test de todas las bombas"},		
			{ 3, 3, 4, 9, new int[][]{{9,0,9},{0,0,0},{9,0,9}}, new int[][]{{0,0,0},{0,0,0},{0,0,0}}, "Test de bombas en las esquinas"},
			
			{ 3, 3, 0, 10, new int[][]{{0,0,0},{0,0,0},{0,0,0}}, new int[][]{{0,0,0},{0,0,0},{0,0,0}}, "Test de 0 bomba"},
			
		});
	}
	
	@Test
	public void testOfUbicarBombas() {
		assertArrayEquals(_mensaje, _expected, _sut.posicionarBombasCreadas( _mock.getArrayBombas(_seleccionMock), _nBombas, _tableroInterno, _numero1, _numero2));
	}
	

}
