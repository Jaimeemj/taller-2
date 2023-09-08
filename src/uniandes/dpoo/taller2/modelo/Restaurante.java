package uniandes.dpoo.taller2.modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Restaurante  {
private ArrayList<Ingrediente> ingredientes;
private ArrayList<Combo> combos;
private ArrayList<Pedido> pedidos;
private ArrayList<String> nameProductsCombo;
private Pedido pedidoEnCurso;
private ArrayList<Producto> menuBase ;
public Restaurante() {
	ingredientes = new ArrayList<Ingrediente>();
	menuBase = new ArrayList<Producto>();
	combos = new ArrayList<Combo>();
	pedidos = new ArrayList<Pedido>();
	
}
	public void iniciarPedido(String nombreCliente,String direccionCliente) {
	pedidoEnCurso = new Pedido(nombreCliente,direccionCliente);
	}
public Pedido verifyIdPedido(int idPed) {
	for (Pedido p: pedidos) {
		if (p.getPedido()== idPed) {
			return p;
		}
	}
	return null;
		
}

	
	public int CerrarYGuardarPedido() {
		pedidos.add(pedidoEnCurso);
		pedidoEnCurso.guardarFactura();
		int suid = pedidoEnCurso.getPedido();
		return suid;
	}
	public Pedido getPedidoEnCurso() {

		return pedidoEnCurso;
	}
	
	public ArrayList<Producto> getMenuBase() {
		return menuBase;
	}
	
	public ArrayList<Ingrediente> getIngredientes(){
		
		return ingredientes;
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
		linea = br.readLine();
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
		linea = br.readLine();
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
		double PrecioProd = Double.parseDouble(partes[1].replace("%", "")); // Parse es para convertir de str a otro tipo de val... paseInt convierte a integer
		Combo nuevo = new Combo(nombreProd,PrecioProd);
		combos.add(nuevo);
		nameProductsCombo = new ArrayList<String>();
		for (int i= 2;i<5;i++) {
			nameProductsCombo.add(partes[i]);
		}

		for (int j = 0;j< menuBase.size();j++) {
			Producto obj = menuBase.get(j);
			if (nameProductsCombo.contains(obj.getNombre())) {
				nuevo.agregarItemACOmbo(obj);
			}
		}

		menuBase.add(nuevo);
		linea = br.readLine();
		}
		}
		catch(Exception e)
		{e.printStackTrace();
			
		}
	}
		
	}
	

