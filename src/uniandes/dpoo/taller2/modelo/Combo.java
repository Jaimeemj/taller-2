package uniandes.dpoo.taller2.modelo;
import java.util.ArrayList;

public class Combo implements Producto {
	private double descuento;
	private String nombreCombo;
	private ArrayList<Producto> itemsCombo;
	public Combo(String nombre, double pdescuento) {
		nombreCombo = nombre;
		descuento = pdescuento;
	}
	public void agregarItemACOmbo(Producto itemCombo) {
		itemsCombo.add(itemCombo);

	}
	public int getPrecio() {
		double sumatoria = 0;
		for(int i = 0;i <= itemsCombo.size();i++) {
			Producto itemObject = itemsCombo.get(i);
			int itemValue = itemObject.getPrecio();
			sumatoria += itemValue;
			
		}
		double porcentajeDinero = (sumatoria*descuento)/100 ;
		
		return (int) (sumatoria - porcentajeDinero);
		}



	public String getNombre() {
		return nombreCombo;
	}
	@Override
	public String generarTextoFactura() {
		// TODO Auto-generated method stub
		return null;
	}

}
