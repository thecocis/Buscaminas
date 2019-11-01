package Buscaminas;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class CreacionTablerosTests {
	
	private CreacionTableros _sut ;
	private int[][] _expected;
	private int numero1;
	private int numero2;
	
	@Before
	public void inicializacion() {
		_sut = new CreacionTableros();
	}
	
	public CreacionTablerosTests(int[][] expected, int[] input) {
		_expected = expected;
		numero1 = input[0];
		numero2 = input[1];
	}
	
	@Parameterized.Parameters
	public static Collection<Object[]> getData() {
		return Arrays.asList(new Object[][] {
			{ new int[][]{{0,0,0,0,0,0,0,0}, {0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}}, new int[] {8, 8}},
			{ new int[][]{{0,0}, {0,0}}, new int[] {2,2}},
			{ new int[][]{{0,0,0,0,0}, {0,0,0,0,0},{0,0,0,0,0}}, new int[] {3,5}},
			{ new int[][]{{0,0,0,0,0,0,0,0,0}}, new int[] {1,9}},
			{ new int[][]{{0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}}, new int[] {9,1}},
			{ new int[][]{{0,0,0,0,0,0,0,0}, {0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}}, new int[] {0,8}},
			{ new int[][]{{0,0,0,0,0,0,0,0}, {0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}}, new int[] {0,0}},
		});
	}
	

	@Test
	public void testOfCrearTablero() {
		assertArrayEquals(_expected, _sut.tableroInterno(numero1, numero2));
	}
	
}
