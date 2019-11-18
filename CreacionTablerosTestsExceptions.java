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
public class CreacionTablerosTestsExceptions {

	private CreacionTableros _sut ;
	private int numero1;
	private int numero2;
	private String _mensaje;
	
	@Before
	public void inicializacion() {
		_sut = new CreacionTableros();
	}
	
	public CreacionTablerosTestsExceptions(String mensaje, int[] input) {
		numero1 = input[0];
		numero2 = input[1];
		_mensaje = mensaje;
	}
	
	@Parameterized.Parameters
	public static Collection<Object[]> getData() {
		return Arrays.asList(new Object[][] {
			{ "Excepcion en el primer parámetro", new int[] {-2,2}},
			{ "Excepcion en el segundo parámetro",new int[] {2,-2}},
			{ "Excepcion en ambos parámetros",new int[] {-2,-2}}
		});
	}
		
	@Test
	public void testOfCrearTableroNumeroNegativo() {
		try {
		_sut.tableroInterno(numero1, numero2);
		assertTrue(false);
		}catch (Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testOfCrearTableroUsuarioNegativo() {
		try {
		_sut.tableroUsuario(numero1, numero2);
		assertTrue(false);
		}catch (Exception e) {
			assertTrue(true);
		}
	}


}
