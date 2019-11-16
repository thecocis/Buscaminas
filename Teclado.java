package Buscaminas;

import java.util.Scanner;

//Clase encargada de los inputs por teclado
public class Teclado
{
	private Scanner _reader;
	
	public Teclado() {
		_reader = new Scanner(System.in);
	}
	
	public int inputKey()
	{
		return _reader.nextInt();
	}
}
