package logica;

public class ProductoMenu implements Producto{
	
	private String nombre;
	private int precioBase;
	
	public ProductoMenu(String nombre, int precioBase) {
		this.nombre = nombre;
		this.precioBase = precioBase;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getPrecio() {
		return precioBase;
	}
	
	public String generarTextoFactura() {
		String factura = "El nombre es" + this.nombre + " y el precio base es " + this.precioBase;
		return factura;
	}
	
		

}
