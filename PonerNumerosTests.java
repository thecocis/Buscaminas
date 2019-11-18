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
public class PonerNumerosTests {

	private PonerNumeros _sut ;
	private int[][] _expected;
	private int _numero1;
	private int _numero2;
	private int[][] _tablero;
	private String _mensaje;
	
	@Before
	public void inicializacion() {
		_sut = new PonerNumeros();
	}
	
	@After
	public void clean() {
		_sut = null;
	}
	
	public PonerNumerosTests(int[][] expected, int[] input, String mensaje, int[][] tablero) {
		_expected = expected;
		_numero1 = input[0];
		_numero2 = input[1];
		_tablero = tablero;
		_mensaje = mensaje;
	}
	
	@Parameterized.Parameters
	public static Collection<Object[]> getData() {
		return Arrays.asList(new Object[][] {
			{ new int[][]{{9,1,0,1,9,1,1,9},{1,1,0,1,1,1,1,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{1,1,0,0,0,0,0,0},{9,2,2,3,2,1,0,0},{2,3,9,9,9,2,1,0},{9,2,3,9,4,9,1,0}}, 
				new int[] {8, 8}, "Insertar Numeros 8x8",
				new int[][]{{9,0,0,0,9,0,0,9}, {0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{9,0,0,0,0,0,0,0},{0,0,9,9,9,0,0,0},{9,0,0,9,0,9,0,0}}},
			{ new int[][]{{9,1,0},{1,1,0},{0,0,0}},
				new int[] {3,3}, "Insertar Numeros 3x3 esquina",
				new int[][]{{9,0,0},{0,0,0},{0,0,0}}},
			{ new int[][]{{9,9,9},{9,9,9},{9,9,9}},
				new int[] {3,3}, "Insertar Numeros 3x3 full tablero",
				new int[][]{{9,9,9},{9,9,9},{9,9,9}}},
			{ new int[][]{{9,9,9},{9,8,9},{9,9,9}},
				new int[] {3,3}, "Insertar Numeros 3x3 , todo bombas menos el del medio",
				new int[][]{{9,9,9},{9,0,9},{9,9,9}}},
			{ new int[][] {{1,9},{1,1}},
				new int[] {2,2}, "Insertar Numeros 3x3 esquina superior derecha bomba",
				new int[][]{{0,9},{0,0}}},
			{ new int[][]  {{9,9,9,9}, {9,5,5,9}, {9,5,5,9}, {9,9,9,9}},
				new int[] {4,4}, "Insertar Numeros 4x4 bombas en los bordes",
				new int[][] {{9,9,9,9}, {9,0,0,9}, {9,0,0,9}, {9,9,9,9}}},
			
		});
	}
	
	@Test
	public void testOfCreacionNumeros() {
		assertArrayEquals(_mensaje, _expected, _sut.crearTableroConNumeros(_numero1, _numero2, _tablero));
	}
	
}
