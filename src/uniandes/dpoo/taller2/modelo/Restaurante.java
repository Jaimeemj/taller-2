package uniandes.dpoo.taller2.modelo;

import java.io.File;
import java.util.ArrayList;

public class Restaurante {

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
		
	}
	
	private void cargarIngredientes(File archivoIngredientes) {
		
	}
	private void cargarMenu(File archivoMenu) {
		
	}
	private void CargarCombos(File archivoCombos) {
		
	}
	

}
