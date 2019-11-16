package Buscaminas;

public class MockTeclado extends Teclado {

	private int valors[] = {1,2,3,4};
	
	public int seleccionOpcion(int seleccionMock) {
		int valor = 0;
		switch (seleccionMock) {
		case 1:
			valor = valors[0]; 
			break;
		case 2:
			valor = valors[1]; 
			break;
		case 3:
			valor = valors[2]; 
			break;
		case 4:
			valor = valors[3]; 
			break;
		default:
			break;
	}
	return valor;
	}
	
}
