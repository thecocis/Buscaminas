package Buscaminas;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

@SuppressWarnings("unused")
public class Tablero {
	
	public static void main(String[] args) {
		
		//***********************
		// CAPA INICIALIZACIONES
		//***********************

		Menu menu = new Menu();
		CreacionTableros creacion = new CreacionTableros();
		PrintsPantalla prints = new PrintsPantalla();
		CrearBombas crearBombas = new CrearBombas();
		PonerNumeros ponerNumeros = new PonerNumeros();
		
		
		//***********************
		// CAPA INTERNA
		//***********************
		int arrayVal[] = new int[3];
		arrayVal = menu.crearMenu();
		int m = arrayVal[0];
		int n = arrayVal[1];
		int nBombas = arrayVal[2];
		
		
		int tableroInterno[][] = new int[m][n];
		tableroInterno = creacion.tableroInterno(m, n);

		
		int arrayBombas[] = new int[nBombas];
		arrayBombas = crearBombas.crearBombas(m, n, nBombas);
		
		
		UbicarBombas ubicarBombas = new UbicarBombas();
		tableroInterno = ubicarBombas.posicionarBombasCreadas(arrayBombas, nBombas, tableroInterno, m, n);

				
		tableroInterno = ponerNumeros.crearTableroConNumeros(m, n, tableroInterno);
		
		
		prints.tableroInterno(m, n, tableroInterno);
		//***********************
		// CAPA EXTERNA
		//***********************
		int filaSeleccionada = 0;
		int columnaSeleccionada = 0;
		int accion = 0;
		int arrayTirada[] = new int[3];
		
		AbrirCasilla abrirCasilla = new AbrirCasilla();
		
		//por aquí empezar el while.
		System.out.println(" ");
		char tableroUsuario[][] = creacion.tableroUsuario(m, n);

		
		prints.tableroUsuario(m, n, tableroUsuario);
		
		arrayTirada = menu.crearMenuTirada(m, n);
		filaSeleccionada = arrayTirada[0];
		columnaSeleccionada = arrayTirada[1];
		accion = arrayTirada[2];

		abrirCasilla.abrirCasilla(filaSeleccionada, columnaSeleccionada, accion, tableroUsuario, tableroInterno);
		
	}
	
}
