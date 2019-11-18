package Buscaminas;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Tablero {
	
	
	public static void main(String[] args) {
		
		//***********************
		// CAPA INICIALIZACIONES
		//***********************
		
		Menu menu = new Menu();
		CreacionTableros creacion = new CreacionTableros();
		CrearBombas crearBombas = new CrearBombas();
		PonerNumeros ponerNumeros = new PonerNumeros();
		
		boolean start = true;
		
		
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
		
		
		menu.tableroInterno(m, n, tableroInterno);
		
		//***********************
		// CAPA EXTERNA
		//***********************
		int filaSeleccionada = 0;
		int columnaSeleccionada = 0;
		int accion = 0;
		int arrayTirada[] = new int[3];
		
		char tableroUsuario[][] = creacion.tableroUsuario(m, n);
		
		//JUEGO - START
		while (start) {
			System.out.println(" ");
			
			menu.tableroUsuario(m, n, tableroUsuario);
			
			arrayTirada = menu.crearMenuTirada(m, n);
			filaSeleccionada = arrayTirada[0];
			columnaSeleccionada = arrayTirada[1];
			accion = arrayTirada[2];
	
			AbrirCasilla abrirCasilla = new AbrirCasilla();
			tableroUsuario = abrirCasilla.abrirCasilla(filaSeleccionada, columnaSeleccionada, accion, tableroUsuario, tableroInterno , m, n);
	
			//prints.tableroUsuario(m, n, tableroUsuario);
			if (creacion.isLost(tableroInterno, tableroUsuario, m, n)) {
				start = false;
				menu.tableroUsuario(m, n, tableroUsuario);
				System.out.println(" F, has perdido ");
			} else if (creacion.isWon(tableroInterno, tableroUsuario, m, n, nBombas)) {
				start = false;
				System.out.println(" Enhorabuena, has ganado ");
			}
		}
	}
	
}