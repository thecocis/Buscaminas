package Buscaminas;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class CreacionTablerosUsuarioTest {

	private CreacionTableros _sut ;
	private char[][] _expected;
	private int numero1;
	private int numero2;
	
	@Before
	public void inicializacion() {
		_sut = new CreacionTableros();
	}
	
	public CreacionTablerosUsuarioTest(char[][] expected, int[] input) {
		_expected = expected;
		numero1 = input[0];
		numero2 = input[1];
	}
	
	@Parameterized.Parameters
	public static Collection<Object[]> getData() {
		return Arrays.asList(new Object[][] {
			{ new char[][]{{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}}, new int[] {8, 8}},
			{ new char[][]{{'-', '-'}, {'-', '-'}}, new int[] {2,2}},
			{ new char[][]{{'-', '-', '-', '-', '-'}, {'-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-'}}, new int[] {3,5}},
			{ new char[][]{{'-', '-', '-', '-', '-', '-', '-', '-','-'}}, new int[] {1,9}},
			{ new char[][]{{'-'}, {'-'}, {'-'},{'-'}, {'-'}, {'-'}, {'-'}, {'-'}, {'-'}}, new int[] {9,1}},
			{ new char[][]{{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}}, new int[] {0,8}},
			{ new char[][]{{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}}, new int[] {0,0}},
		});
	}
	

	@Test
	public void testOfCrearTablero() {
		assertArrayEquals(_expected, _sut.tableroUsuario(numero1, numero2));
	}

}
