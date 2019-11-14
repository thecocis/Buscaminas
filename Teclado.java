package Buscaminas;

import java.util.Scanner;

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
