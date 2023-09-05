package logica;

import java.util.ArrayList;

public class Combo implements Producto{
	private double descuento;
	private String nombreCombo;
	private ArrayList<ProductoMenu> itemsCombo;
	
	public Combo(double descuento, String nombreCombo) {
		this.descuento = descuento;
		this.nombreCombo = nombreCombo;
	}
	
	public void agregarItemACombo(Producto itemCombo) {
		
	}
	
	public int getPrecio() {
		return this.getPrecio();
		
	}
	
	public String generarTextoFactura() {
		return this.generarTextoFactura();
	}
	
	public String getNombre() {
		return this.nombreCombo;
	}
	
	
}
