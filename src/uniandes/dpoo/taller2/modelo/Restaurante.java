package uniandes.dpoo.taller2.modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Restaurante  {
private ArrayList<Ingrediente> ingredientes;
private ArrayList<Combo> combos;
private ArrayList<Pedido> pedidos;
private Pedido pedidoEnCurso;
private ArrayList<ProductoMenu> menuBase;

public Restaurante() {
	ingredientes = new ArrayList<Ingrediente>();

}
	public void iniciarPedido(String nombreCliente,String direccionCliente) {
	//TODO: Completar methodo	
		
		
	}
	
	
	public void CerrarYGuardarPedido() {
		pedidos.add(pedidoEnCurso);
		pedidoEnCurso = null;
	}
	public Pedido getPedidoEnCurso() {

		return pedidoEnCurso;
	}
	
	public ArrayList<Producto> getMenuBase() {
		ArrayList<Producto> lista = null;
		return lista;
	}
	
	public ArrayList<Ingrediente> getIngredientes(){
		
		ArrayList<Ingrediente> lista = null;
		return lista;
	}
	
	public void cargarInformacionRestaurante(File archivoIngredientes, File archivoMenu, File archivoCombos) {
		cargarIngredientes(archivoIngredientes);
		cargarMenu(archivoMenu);
		CargarCombos(archivoCombos);
		}
	
	private void cargarIngredientes(File archivoIngredientes) {
		try (BufferedReader br = new BufferedReader(new FileReader(archivoIngredientes))) {
		String linea = br.readLine();
		while(linea != null) 
		{
		String[] partes = linea.split(";");
		String nombreIng = partes[0];
		int PrecioIng = Integer.parseInt(partes[1]); // Parse es para convertir de str a otro tipo de val... paseInt convierte a integer
		Ingrediente nuevo = new Ingrediente(nombreIng,PrecioIng);
		ingredientes.add(nuevo);
		}
		}
		catch(Exception e)
		{e.printStackTrace();
			
		}
	}
	private void cargarMenu(File archivoMenu) {
		try (BufferedReader br = new BufferedReader(new FileReader(archivoMenu))) {
		String linea = br.readLine();
		while(linea != null) 
		{
		String[] partes = linea.split(";");
		String nombreProd = partes[0];
		int PrecioProd = Integer.parseInt(partes[1]); // Parse es para convertir de str a otro tipo de val... paseInt convierte a integer
		ProductoMenu nuevo = new ProductoMenu(nombreProd,PrecioProd);
		menuBase.add(nuevo);
		}
		}
		catch(Exception e)
		{e.printStackTrace();
			
		}
		
	}
	private void CargarCombos(File archivoCombos) {
		try (BufferedReader br = new BufferedReader(new FileReader(archivoCombos))) {
		String linea = br.readLine();
		while(linea != null) 
		{
		String[] partes = linea.split(";");
		String nombreProd = partes[0];
		double PrecioProd = Double.parseDouble(partes[1]); // Parse es para convertir de str a otro tipo de val... paseInt convierte a integer
		Combo nuevo = new Combo(nombreProd,PrecioProd);
		combos.add(nuevo);
		}
		}
		catch(Exception e)
		{e.printStackTrace();
			
		}
	}
	

}
