package uniandes.dpoo.taller2.modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Restaurante {
private ArrayList<Ingrediente> ingredientes;
private ArrayList<Combo> combos;
private Pedido pedidoEnCurso;

public Restaurante() {
	ingredientes = new ArrayList<Ingrediente>();

}
	public void iniciarPedido(String nombreCliente,String direccionCliente) {
	//TODO: Completar methodo	
	}
	
	public Pedido cerrarPedidoEnCUrso() {
		//TODO el methodod
		Pedido pedido = null;
		return pedido;	
	}
	
	public void CerrarYGuardarPedido() {
		
	}
	public Pedido getPedidoEnCurso() {
		//TODO el metodo
		Pedido pedido=null;
		return pedido;
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
		}
	
	private void cargarIngredientes(File archivoIngredientes) {
		try {
		BufferedReader br = new BufferedReader(new FileReader(archivoIngredientes));
		String linea = br.readLine();
		while(linea != null) 
		{
		String[] partes = linea.split(";");
		String nombreProd = partes[0];
		int PrecioProd = Integer.parseInt(partes[1]); // Parse es para convertir de str a otro tipo de val... paseInt convierte a integer
		Ingrediente nuevo = new Ingrediente(nombreProd,PrecioProd);
		ingredientes.add(nuevo);
		}
		}
		catch(Exception e)
		{e.printStackTrace();
			
		}
	}
	private void cargarMenu(File archivoMenu) {
		
	}
	private void CargarCombos(File archivoCombos) {
		
	}
	

}
