package uniandes.dpoo.taller2.modelo;
import java.io.File;
import java.util.ArrayList;

public class Pedido extends Restaurante{
	static int numeroPedidos;
	int idPedido;
	String nombreCliente;
	String direccionCliente;
	ArrayList<Producto> itemsPedido;
	
	public Pedido(String nameCliente, String direcCliente) 
	{
		//	TODO hacer todo
		this.nombreCliente = nameCliente;
		this.direccionCliente = direcCliente;	
	}
	public int getPedido() {
		return idPedido;
	}
	public void agregarProducto(Producto nuevOItem) {
		itemsPedido.add(nuevOItem);
	}
	private int getPrecioNetoPedido() {

		int suma = 0;
		for (int i = 0;i<itemsPedido.size();i++) {
			Producto objProducto = itemsPedido.get(i);
			int precio = objProducto.getPrecio();
			suma =+ precio;
		}
		return suma;
	}
	private int getPrecioTotalPedido() {
		
		return getPrecioIvaPedido() + getPrecioNetoPedido();
	}
	private int getPrecioIvaPedido() {
		//TODO hcer todo y cambiar value return
		
		return idPedido;
	}
	private String generarTextoFactura() {
		//TODO hacer todo y cambiar return
		
		return nombreCliente;
	}
	public void guardarFactura(File archivo) {
		//TODO hacer todo 
		
	}
}