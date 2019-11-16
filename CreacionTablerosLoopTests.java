package Buscaminas;

import static org.junit.Assert.*;

import org.junit.Test;

public class CreacionTablerosLoopTests {

	@Test
	public void Looptest() {


		CreacionTableros creacion = new CreacionTableros();
	
		//Verificacion que no sale ninguna excepcion en el loop interno
		creacion.tableroInterno(0, 0);
		creacion.tableroInterno(1, 0);
		creacion.tableroInterno(2, 0);
		creacion.tableroInterno(3, 0);
		creacion.tableroInterno(4, 0);
		creacion.tableroInterno(5, 0);
		creacion.tableroInterno(6, 0);
		creacion.tableroInterno(7, 0);
		creacion.tableroInterno(8, 0);
		creacion.tableroInterno(9, 0);
		creacion.tableroInterno(10, 0);

		
		//Verificacion que no sale ninguna excepcion en el loop externo
		creacion.tableroInterno( 0, 0);
		creacion.tableroInterno( 0, 1);
		creacion.tableroInterno( 0, 2);
		creacion.tableroInterno( 0, 3);
		creacion.tableroInterno( 0, 4);
		creacion.tableroInterno( 0, 5);
		creacion.tableroInterno( 0, 6);
		creacion.tableroInterno( 0, 7);
		creacion.tableroInterno( 0, 8);
		creacion.tableroInterno( 0, 9);
		creacion.tableroInterno( 0, 10);
		
		
	}

}
