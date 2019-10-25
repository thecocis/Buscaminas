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
public class PonerNumerosTests {


	private PonerNumeros _sut ;
	private int[][] _expected;
	private int numero1;
	private int numero2;
	private int[][] _tablero;
	
	@Before
	public void inicializacion() {
		_sut = new PonerNumeros();
	}
	
	public PonerNumerosTests(int[][] expected, int[] input, int[][] tablero) {
		_expected = expected;
		numero1 = input[0];
		numero2 = input[1];
		_tablero = tablero;
	}
	
	@Parameterized.Parameters
	public static Collection<Object[]> getData() {
		return Arrays.asList(new Object[][] {
			{ new int[][]{{9,1,0,1,9,1,1,9},{1,1,0,1,1,1,1,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{1,1,0,0,0,0,0,0},{9,2,2,3,2,1,0,0},{2,3,9,9,9,2,1,0},{9,2,3,9,4,9,1,0}}, 
				new int[] {8, 8}, 
				new int[][]{{9,0,0,0,9,0,0,9}, {0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{9,0,0,0,0,0,0,0},{0,0,9,9,9,0,0,0},{9,0,0,9,0,9,0,0}}},
			{ new int[][]{{9,1,0},{1,1,0},{0,0,0}},
				new int[] {3,3},
				new int[][]{{9,0,0},{0,0,0},{0,0,0}}},
			{ new int[][]{{9,9,9},{9,9,9},{9,9,9}},
				new int[] {3,3},
				new int[][]{{9,9,9},{9,9,9},{9,9,9}}},
			{ new int[][]{{9,9,9},{9,8,9},{9,9,9}},
				new int[] {3,3},
				new int[][]{{9,9,9},{9,0,9},{9,9,9}}},
			{ new int[][] {{1,9},{1,1}},
				new int[] {2,2},
				new int[][]{{0,9},{0,0}}},
			{ new int[][]  {{9,9,9,9}, {9,5,5,9}, {9,5,5,9}, {9,9,9,9}},
				new int[] {4,4},
				new int[][] {{9,9,9,9}, {9,0,0,9}, {9,0,0,9}, {9,9,9,9}}},
			
		});
	}
	
	@Test
	public void testOfCreacionNumeros() {
		assertArrayEquals(_expected, _sut.crearTableroConNumeros(numero1, numero2, _tablero));
	}
	
}
