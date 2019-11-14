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
public class CreacionTablerosTests {
	
	private CreacionTableros _sut ;
	private Object[][] _expected;
	private int _m;
	private int _n;
	private int _a;
	
	@Before
	public void inicializacion() {
		_sut = new CreacionTableros();
	}
	
	public CreacionTablerosTests(int a, Object[][] expected, int[] m_y_n) {
		_expected = expected;
		_m = m_y_n[0];
		_n = m_y_n[1];
		_a = a;
	}
	
	@Parameterized.Parameters
	public static Collection<Object[]> getData() {
		
		return Arrays.asList(new Object[][] {
			{ 1, new Object[][]{{0,0,0,0,0,0,0,0}, {0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}}, new int[] {8, 8}},
			{ 1, new Object[][]{{0,0}, {0,0}}, new int[] {2,2}},
			{ 1, new Object[][]{{0,0,0,0,0}, {0,0,0,0,0},{0,0,0,0,0}}, new int[] {3,5}},
			{ 1, new Object[][]{{0,0,0,0,0,0,0,0,0}}, new int[] {1,9}},
			{ 1, new Object[][]{{0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}}, new int[] {9,1}},
			{ 1, new Object[][]{{0,0,0,0,0,0,0,0}, {0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}}, new int[] {0,8}},
			{ 1, new Object[][]{{0,0,0,0,0,0,0,0}, {0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}}, new int[] {0,0}},
			
			{ 2, new Object[][]{{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}}, new int[] {8, 8}},
			{ 2, new Object[][]{{'-', '-'}, {'-', '-'}}, new int[] {2,2}},
			{ 2, new Object[][]{{'-', '-', '-', '-', '-'}, {'-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-'}}, new int[] {3,5}},
			{ 2, new Object[][]{{'-', '-', '-', '-', '-', '-', '-', '-','-'}}, new int[] {1,9}},
			{ 2, new Object[][]{{'-'}, {'-'}, {'-'},{'-'}, {'-'}, {'-'}, {'-'}, {'-'}, {'-'}}, new int[] {9,1}},
			{ 2, new Object[][]{{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}}, new int[] {0,8}},
			{ 2, new Object[][]{{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}}, new int[] {0,0}},
		
		});
	}
	

	@Test
	public void testOfCrearTablero() {
		if(_a == 1) {
			assertArrayEquals(_expected, _sut.tableroInterno(_m, _n));
		}else {
			assertArrayEquals(_expected, _sut.tableroUsuario(_m, _n));
		}
	}
	
}
