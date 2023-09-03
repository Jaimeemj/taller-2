package uniandes.dpoo.taller2.consola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import uniandes.dpoo.taller2.modelo.Restaurante;

public class Aplicacion {
	
	private Restaurante restaurante;
	public void ejecutarAplicacion()
	{
	
	System.out.println("Bienvenido al restaurante\n");

	boolean continuar = true;
	while (continuar)
	{
		try
		{
			mostrarOpciones();

			int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
			if (opcion_seleccionada == 1)
				ejedcutarMostrarMenu();
			else if (opcion_seleccionada == 2 && restaurante != null)
				ejecutarNuevoPedido();
			else if (opcion_seleccionada == 3 && restaurante != null)
				ejecutarAgregarElementoPedido();
			else if (opcion_seleccionada == 4 && restaurante != null)
				ejecutarCerrarPedidoYGuardarFact();
			else if (opcion_seleccionada == 5 && restaurante != null)
				ejecutarInfoPedido();
			else if (opcion_seleccionada == 6)
			{
				System.out.println("Saliendo de la aplicación ...");
				continuar = false;
			}
			else if (restaurante == null)
			{
				System.out.println("Para poder ejecutar esta opción primero debe cargar un archivo de atletas.");
			}
			else
			{
				System.out.println("Por favor seleccione una opción válida.");
			}
		}
		catch (NumberFormatException e)
		{
			System.out.println("Debe seleccionar uno de los números de las opciones.");
		}
	}
	}
private void ejecutarInfoPedido() {
		// TODO Auto-generated method stub
		
	}
private void ejecutarCerrarPedidoYGuardarFact() {
		// TODO Auto-generated method stub
		
	}
private void ejecutarAgregarElementoPedido() {
		// TODO Auto-generated method stub
		
	}
private void ejecutarNuevoPedido() {
		// TODO Auto-generated method stub
		
	}
public void mostrarOpciones()
	{
		System.out.println("\nMenú restaurnate\n");
		System.out.println("1. Mostrar menú");
		System.out.println("2. Iniciar un nuevo pedido");
		System.out.println("3. Agregar un elemento a un pedido");
		System.out.println("4. Cerrar un pedido y guardar la factura");
		System.out.println("5. Consultar la información de un pedido dado su id");
		System.out.println("6. Cerrar aplicación");
	}	
private void cargarMenu()
{
	}
/**
 * Muestra al usuario el menú con las opciones para que escoja la siguiente
 * acción que quiere ejecutar.
 */

public void ejedcutarMostrarMenu() {
	System.out.println("aaaaaaaaaaaaaaaa");
}

public String input(String mensaje)
{
	try
	{
		System.out.print(mensaje + ": ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		return reader.readLine();
	}
	catch (IOException e)
	{
		System.out.println("Error leyendo de la consola");
		e.printStackTrace();
	}
	return null;
}

public static void main(String[] args)
{
	Aplicacion consola = new Aplicacion();
	consola.ejecutarAplicacion();
}
}
