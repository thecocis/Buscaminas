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
public class CreacionTablerosTests {
	
	private CreacionTableros _sut ;
	private Object[][] _expected;
	private int _m;
	private int _n;
	private int _a;
	private String _mensaje;
	@Before
	public void inicializacion() {
		_sut = new CreacionTableros();
	}
	
	public CreacionTablerosTests(String mensaje, int a, Object[][] expected, int[] m_y_n) {
		_mensaje = mensaje;
		_expected = expected;
		_m = m_y_n[0];
		_n = m_y_n[1];
		_a = a;
		
	}
	
	@Parameterized.Parameters
	public static Collection<Object[]> getData() {
		
		return Arrays.asList(new Object[][] {
			{ "creacion tablero interno 8x8", 1, new Object[][]{{0,0,0,0,0,0,0,0}, {0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}}, new int[] {8, 8}},
			{ "creacion tablero interno 2x2", 1, new Object[][]{{0,0}, {0,0}}, new int[] {2,2}},
			{ "creacion tablero interno 3x5", 1, new Object[][]{{0,0,0,0,0}, {0,0,0,0,0},{0,0,0,0,0}}, new int[] {3,5}},
			{ "creacion tablero interno 1x9", 1, new Object[][]{{0,0,0,0,0,0,0,0,0}}, new int[] {1,9}},
			{ "creacion tablero interno 9x1", 1, new Object[][]{{0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}}, new int[] {9,1}},
			//En caso que reciba parámetros 0 se convierte en 8. Aunque el usuario nunca podrá poner el tamaño de tablero que quiere, e irá predefinido es uan capa de seguridad que añadimos
			{ "creacion tablero interno 0x8 ", 1, new Object[][]{{0,0,0,0,0,0,0,0}, {0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}}, new int[] {0,8}},
			{ "creacion tablero interno 0x0" , 1, new Object[][]{{0,0,0,0,0,0,0,0}, {0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}}, new int[] {0,0}},
			
			{ "creacion tablero usuario 8x8", 2, new Object[][]{{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}}, new int[] {8, 8}},
			{ "creacion tablero usuario 2x2",2, new Object[][]{{'-', '-'}, {'-', '-'}}, new int[] {2,2}},
			{ "creacion tablero usuario 3x5",2, new Object[][]{{'-', '-', '-', '-', '-'}, {'-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-'}}, new int[] {3,5}},
			{ "creacion tablero usuario 1x9",2, new Object[][]{{'-', '-', '-', '-', '-', '-', '-', '-','-'}}, new int[] {1,9}},
			{ "creacion tablero usuario 9x1",2, new Object[][]{{'-'}, {'-'}, {'-'},{'-'}, {'-'}, {'-'}, {'-'}, {'-'}, {'-'}}, new int[] {9,1}},
			//En caso que reciba parámetros 0 se convierte en 8. Aunque el usuario nunca podrá poner el tamaño de tablero que quiere, e irá predefinido es uan capa de seguridad que añadimos
			{ "creacion tablero usuario 0x8",2, new Object[][]{{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}}, new int[] {0,8}},
			{ "creacion tablero usuario 0x0",2, new Object[][]{{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'},{'-', '-', '-', '-', '-', '-', '-', '-'}}, new int[] {0,0}},
		
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
