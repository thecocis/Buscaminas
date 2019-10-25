package Tests;

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
	private int[] _nArray;
	private int[][] _tableroInterno;
	
	@Before
	public void inicializacion() {
		_sut = new UbicarBombas();
	}
	
	public UbicarBombasTests(int numero1, int numero2, int nBombas, int[] nArray, int[][] expected, int[][] tablero) {
		_expected = expected;
		_numero1 = numero1;
		_numero2 = numero2;
		_nBombas = nBombas;
		_nArray = nArray;
		_tableroInterno = tablero;
	}
	
	
	@Parameterized.Parameters
	public static Collection<Object[]> getData() {
		return Arrays.asList(new Object[][] {
			{ 3, 3, 1, new int[] {1}, new int[][]{{9,0,0},{0,0,0},{0,0,0}}, new int[][]{{0,0,0},{0,0,0},{0,0,0}}},
			{ 3, 3, 1, new int[] {3}, new int[][]{{0,0,9},{0,0,0},{0,0,0}}, new int[][]{{0,0,0},{0,0,0},{0,0,0}}},
			{ 3, 3, 1, new int[] {7}, new int[][]{{0,0,0},{0,0,0},{9,0,0}}, new int[][]{{0,0,0},{0,0,0},{0,0,0}}},
			{ 3, 3, 1, new int[] {9}, new int[][]{{0,0,0},{0,0,0},{0,0,9}}, new int[][]{{0,0,0},{0,0,0},{0,0,0}}},
			{ 3, 3, 1, new int[] {5}, new int[][]{{0,0,0},{0,9,0},{0,0,0}}, new int[][]{{0,0,0},{0,0,0},{0,0,0}}},
			{ 3, 3, 0, new int[] {}, new int[][]{{0,0,0},{0,0,0},{0,0,0}}, new int[][]{{0,0,0},{0,0,0},{0,0,0}}},
			{ 3, 3, 2, new int[] {5,2}, new int[][]{{0,9,0},{0,9,0},{0,0,0}}, new int[][]{{0,0,0},{0,0,0},{0,0,0}}},
			{ 3, 3, 4, new int[] {5, 2, 1, 9}, new int[][]{{9,9,0},{0,9,0},{0,0,9}}, new int[][]{{0,0,0},{0,0,0},{0,0,0}}},
			{ 3, 3, 9, new int[] {3,4,6,7,8,5,2,1,9}, new int[][]{{9,9,9},{9,9,9},{9,9,9}}, new int[][]{{0,0,0},{0,0,0},{0,0,0}}}
		});
	}
	
	@Test
	public void testOfUbicarBombas() {
		assertArrayEquals(_expected, _sut.posicionarBombasCreadas( _nArray, _nBombas, _tableroInterno, _numero1, _numero2));
	}
	

}
