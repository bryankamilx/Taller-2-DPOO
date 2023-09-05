package logica;

import java.io.File;
import java.util.ArrayList;

public class Pedido {
	
	private static int numeroPedidos;
	private int idPedido;
	private String nombreCliente;
	private String direccionCliente;
	private ArrayList<Producto> itemsPedido;
	
	public Pedido(String nombreCliente,String direccionCliente){
		this.nombreCliente = nombreCliente;
		this.direccionCliente = direccionCliente;
	}
	
	public int getIdPedido() {
		return idPedido;
	}
	
	public void agregarProducto(Producto nuevoItem) {
		itemsPedido.add(nuevoItem);
	}
	
	private int getPrecioNetoPedido(){
		return 2;
	}
	
	private int getPrecioTotalPedido(){
		return 2;
	}

	private int getPrecioIvaPedido(){
		return 2;
	}
	
	private String generarTextoFactura() {
		return "2";
	}
	
	public void guardarFactura(File archivo) {
		
	}
}

