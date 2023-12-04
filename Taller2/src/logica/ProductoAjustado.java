package logica;

import java.util.ArrayList;



public class ProductoAjustado implements Producto{

	private ProductoMenu base;

	private ArrayList<Ingrediente> agregados;

	private ArrayList<Ingrediente> eliminados;

	public ProductoAjustado(ProductoMenu base) {
		this.base = base;
		this.agregados = new ArrayList <Ingrediente>();
		this.eliminados = new ArrayList <Ingrediente>();
	}
	
	@Override
	public String getNombre() {
		return base.getNombre();
	}
	
	@Override
	public int getPrecio() {
		return base.getPrecio();
	}

	@Override
	public String getTextoFactura() {
		return null;
	}

	@Override
	public int getCaloria() {
		int calorias = 0;
		//for (ProductoMenu item:items) {
			//int iteracion = item.getCaloria();
			//calorias = calorias + iteracion;
		//}
		return calorias;
	}
	
}
