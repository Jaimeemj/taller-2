package uniandes.dpoo.taller2.modelo;

import java.util.ArrayList;

public class productoAjustado implements Producto{
	private ProductoMenu base;
	private ArrayList<Ingrediente> agregados;
	private ArrayList<Ingrediente> eliminados;
	public productoAjustado(ProductoMenu pbase,ArrayList<Ingrediente> peliminados,ArrayList<Ingrediente> pagregados){
		base = pbase;
		eliminados = peliminados;
		agregados = pagregados;
	}
	public void addToAgregados(Ingrediente ingAgregar) {
		agregados.add(ingAgregar);
	}
	public void addToEliminados(Ingrediente ingEliminar) {
		eliminados.add(ingEliminar);
	}
	public ArrayList<Ingrediente> getAgregados(){
		return agregados;
	}
	public ArrayList<Ingrediente> getEliminados(){
		return eliminados;
	}
	@Override
	public int getPrecio() {
		// TODO Auto-generated method stub
		int sumatoria = base.getPrecio();
		for (Ingrediente agregado:agregados) {
			sumatoria += agregado.getCostoAdicional(); 
		}
		for (Ingrediente eliminado:eliminados) {
			sumatoria -= eliminado.getCostoAdicional();
		}
		return sumatoria;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return base.getNombre();
	}
	@Override
	public String generarTextoFactura() {
		// TODO Auto-generated method stub
		String factura = base.generarTextoFactura();
		if (agregados.size()>0)
		{
			factura +="\nadicion de:";
			for(Ingrediente ingrediente: agregados) {
				factura += "\n"+ingrediente.getNombre()+"-".repeat(10)+ String.valueOf(ingrediente.getCostoAdicional());
			}
		}
		if (eliminados.size()>0) {
			factura += "\nsin";
			for(Ingrediente ingrediente: eliminados) {
				factura += "\n"+ingrediente.getNombre();
			}
		}
		return factura;
	}

}
