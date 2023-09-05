package logica;

import java.util.ArrayList;

public class ProductoAjustado implements Producto{
	
	private ProductoMenu base;
	private ArrayList<Ingrediente> agregados;
	private ArrayList<Ingrediente> eliminados;
	
	public ProductoAjustado(ProductoMenu base) {
		
	}
	
	public String getNombre() {
		return base.getNombre();
		
	}
	
	public int getPrecio() {
		return base.getPrecio();
	}
	
	public String generarTextoFactura() {
		return "";
	}
}
