package uniandes.dpoo.taller2.consola;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import uniandes.dpoo.taller2.modelo.Pedido;
import uniandes.dpoo.taller2.modelo.Producto;
import uniandes.dpoo.taller2.modelo.Restaurante;

public class Aplicacion {
	
	private Restaurante restaurante = new Restaurante();
	private String nombre;
	private String direc;
	private Integer id;
	private boolean pedAct = false;
	public void ejecutarAplicacion()
	{
	
	System.out.println("Bienvenido al restaurante\n");
	cargarMenu();
	boolean continuar = true;
	while (continuar)
	{
		try
		{
			mostrarOpciones();

			int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
			if (opcion_seleccionada == 1)
				ejedcutarMostrarMenu();
			else if (opcion_seleccionada == 2 && restaurante != null) {
				nombre = input("Por favor introduzca su nombre");
				direc = input("Por favor introduzca su direccion");
				pedAct = ejecutarNuevoPedido(nombre,direc);
			}
			else if (opcion_seleccionada == 3 && restaurante != null) {
				if (pedAct) {
					int opc = Integer.parseInt(input("ingrese el numero de producto que desea comprar:")); 
				ejecutarAgregarElementoPedido(opc);}
				else {
					System.out.println("no tiene pedido activo, primero cree su pedido");
				}}
			else if (opcion_seleccionada == 4 && restaurante != null) {
				ejecutarCerrarPedidoYGuardarFact();
				pedAct = false;
			}
			
			else if (opcion_seleccionada == 5 && restaurante != null) {
				id = Integer.parseInt(input("introduzca el id del pedido"));
				ejecutarInfoPedido(id);}
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
private void ejecutarInfoPedido(int id) {
		Pedido ped = restaurante.verifyIdPedido(id);
		if (ped == null)
			System.out.println("Antes debes crear un pedido");
		else {
		File archivo = new File("./data/"+"facturas/"+ped.getPedido()+".txt");
		try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
			String linea = br.readLine();
			while(linea != null) 
			{
				System.out.println(linea);
				linea = br.readLine();
;			}
		}
		catch(Exception e)
		{e.printStackTrace();
			
		}
		}
		
	}
private void ejecutarCerrarPedidoYGuardarFact() {
	int id = restaurante.CerrarYGuardarPedido();
	System.out.println("su pedido fue cerrado con exito");
	System.out.println(id);
	}
private void ejecutarAgregarElementoPedido(int id ) {
	Pedido pedActual = restaurante.getPedidoEnCurso();
	ArrayList<Producto> lstMenu = restaurante.getMenuBase();
	Producto prFound = lstMenu.get(id-1);
	pedActual.agregarProducto(prFound);
	}
private boolean ejecutarNuevoPedido(String nombre,String direccion) {
		restaurante.iniciarPedido(nombre, direccion);
		return true;


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

	File archCombo = new File("./data/combos.txt");
	File archMenu = new File("./data/menu.txt");
	File archIngr = new File("./data/ingredientes.txt");

	restaurante.cargarInformacionRestaurante(archIngr, archMenu,archCombo);
	}
/**
 * Muestra al usuario el menú con las opciones para que escoja la siguiente
 * acción que quiere ejecutar.
 */

public void ejedcutarMostrarMenu() {
	System.out.println("");
	ArrayList<Producto> lst = restaurante.getMenuBase();
	int i = 1;
	for (Producto x : lst) {

		String namePro = x.getNombre();

		Integer precioPro = x.getPrecio();
		System.out.println(i+") "+ namePro+ ": "+precioPro);
		i+=1;
		}
	System.out.println("gracias a messi salio");
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
