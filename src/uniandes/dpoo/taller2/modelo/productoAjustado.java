package uniandes.dpoo.taller2.modelo;

import java.util.ArrayList;

public class productoAjustado implements Producto{
	private ProductoMenu base;
	private ArrayList<Ingrediente> agregados;
	private ArrayList<Ingrediente> eliminados;
	public productoAjustado(ProductoMenu pbase){
		
	}
	@Override
	public int getPrecio() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public String generarTextoFactura() {
		// TODO Auto-generated method stub
		return null;
	}

}
