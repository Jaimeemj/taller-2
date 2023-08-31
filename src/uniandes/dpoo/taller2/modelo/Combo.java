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
	int hols = 0;
	descuento= descuento- hols;
	return hols;
}

public String generarTexto() {
	String txt = null;
	return txt;
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
