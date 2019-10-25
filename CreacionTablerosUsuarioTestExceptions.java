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
public class CreacionTablerosUsuarioTestExceptions {

	private CreacionTableros _sut ;
	private int numero1;
	private int numero2;
	
	@Before
	public void inicializacion() {
		_sut = new CreacionTableros();
	}
	
	public CreacionTablerosUsuarioTestExceptions(int[] input) {
		numero1 = input[0];
		numero2 = input[1];
	}
	
	@Parameterized.Parameters
	public static Collection<Object[]> getData() {
		return Arrays.asList(new Object[][] {
			{ new int[] {-2,2}},
			{ new int[] {2,-2}},
			{ new int[] {-2,-2}}
		});
	}
		
	@Test
	public void testOfCrearTableroNumeroNegativo() {
		try {
		_sut.tableroUsuario(numero1, numero2);
		assertTrue(false);
		}catch (Exception e) {
			assertTrue(true);
		}
	}

}
