package uniandes.dpoo.taller2.modelo;

public class Ingrediente {
	private String nombre; 
	private int costoAdicional;
	
	Ingrediente(String Inombre,int IcostoAdicional){
		nombre = Inombre;
		costoAdicional = IcostoAdicional;
	}
 public String getNombre() {
	return this.nombre;
}
public int getCostoAdicional() {
	return this.costoAdicional;
}
}
