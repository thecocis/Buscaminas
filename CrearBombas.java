package Buscaminas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CrearBombas {
	public int[] crearBombas(int m, int n, int nBombas) {
		int mul = m*n;
		int arrayBombas[] = new int[nBombas];
		for (int z = 0; z<nBombas; z++) {
			arrayBombas[z] = 0;
		}
		
		List<Integer> numbers = new ArrayList<>(mul);
		for (int i = 1; i < mul+1; i++) {
			numbers.add(i);
		}
		
		Random rand = new Random();
		
		int contador = 0;
		while(numbers.size()>(mul - nBombas)) {
			int valorEntero = rand.nextInt(numbers.size());
			while (valorEntero == 0) {
				valorEntero = rand.nextInt(numbers.size());
			}
			arrayBombas[contador] = valorEntero; 
			numbers.remove(valorEntero);
			contador++;
		}
		/*
		for( int c =0; c <nBombas; c++) {
			System.out.print(arrayBombas[c]);
			System.out.print(" ");
		}*/
		
		return arrayBombas;
	}
}
