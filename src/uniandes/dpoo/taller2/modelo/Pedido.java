package uniandes.dpoo.taller2.modelo;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Pedido extends Restaurante{
	static int numeroPedidos;
	int idPedido;
	String nombreCliente;
	String direccionCliente;
	ArrayList<Producto> itemsPedido;
	
	public Pedido(String nameCliente, String direcCliente) 
	{
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
			suma += precio;
		}
		return suma;
	}
	private int getPrecioTotalPedido() {
		
		return getPrecioIvaPedido() + getPrecioNetoPedido();
	}
	private int getPrecioIvaPedido() {
		int iva = 19;
		int total = getPrecioNetoPedido();
		return (iva*total)/100;
	}
	private String generarTextoFactura() {
		String factura = "";
		factura += "nombre:"+ nombreCliente;
		factura += "\n Dirección: "+direccionCliente;
		factura += "\n" + "-".repeat(20);
		for (Producto producto : itemsPedido) {
			factura += producto.generarTextoFactura();
		}
		factura += "\nTotal Neto: "+ getPrecioNetoPedido();
		factura += "\nIva "+ getPrecioIvaPedido();
		factura += "\nTotal: "+getPrecioTotalPedido();
		
		return factura;
	}
	public void guardarFactura(File archivo) {
		String factura = generarTextoFactura();
		try (PrintWriter writer = new PrintWriter(archivo)){
			writer.write(generarTextoFactura());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}