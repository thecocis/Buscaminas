package Buscaminas;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

@SuppressWarnings("unused")
public class Tablero {
	
	public static void main(String[] args) {
		
		int arrayVal[] = new int[3];

		Menu menu = new Menu();
		
		arrayVal = menu.crearMenu();
		
		int m = arrayVal[0];
		int n = arrayVal[1];
		int nBombas = arrayVal[2];
		
		int tablero[][] = new int[m][n];
		int tableroInterno[][] = new int[m][n];
		
		CreacionTableros creacion = new CreacionTableros();
		tableroInterno = creacion.tableroInterno(m, n);
		tablero = tableroInterno;

		
		int arrayBombas[] = new int[nBombas];
		CrearBombas crearBombas = new CrearBombas();
		arrayBombas = crearBombas.crearBombas(m, n, nBombas);
		
		
		UbicarBombas ubicarBombas = new UbicarBombas();
		tablero = ubicarBombas.posicionarBombasCreadas(arrayBombas, nBombas, tablero, m, n);

		
		PrintsPantalla prints = new PrintsPantalla();
		prints.mostrarTablero(m, n, tablero);
		
		
		PonerNumeros ponerNumeros = new PonerNumeros();
		tablero = ponerNumeros.crearTableroConNumeros(m, n, tablero);
		
		
		System.out.println(" ");
		prints.mostrarTablero(m, n, tablero);
		
		
		//tab.crearBombas(8, 8, 10);
	}
	
}
