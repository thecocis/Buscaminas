package Buscaminas;

public class MockBombas extends CrearBombas{
	
	public int[] getArrayBombas(int seleccionMock) {
		
		switch (seleccionMock) {
			case 1:
				return new int[] {1};
			case 2:
				return new int[] {3};
			case 3:
				return new int[] {7};
			case 4:
				return new int[] {9};
			case 5:
				return new int[] {5};
			case 6:
				return new int[] {5, 2};
			case 7:
				return new int[] {5, 2, 1, 9};
			case 8:
				return new int[] {3,4,6,7,8,5,2,1,9};
			case 9:
				return new int[] {1, 3, 7, 9};
		}
				
		return new int[] {};
	}
	
}
