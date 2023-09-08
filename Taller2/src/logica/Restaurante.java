package logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Restaurante {
	
	private ArrayList<Combo> combos;
	private ArrayList<Pedido> pedidos;
	private Pedido pedidoEnCurso;
	private ArrayList<ProductoMenu> menuBase;
	private ArrayList<Ingrediente> ingredientes;


	public Restaurante() {
		
	}
	
	public void iniciarPedido(String nombreCliente, String direccionCliente) {
		
		Pedido nuevoPedido = new Pedido(nombreCliente,direccionCliente);
		ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
		this.pedidoEnCurso = nuevoPedido;
		pedidos.add(nuevoPedido);
		
	}
	
	public void cerrarYGuardarPedido() {
		
	}
	
	public Pedido getPedidoEnCurso() {
		return this.pedidoEnCurso;
	}
	
	public ArrayList<ProductoMenu> getMenuBase(){
		return menuBase;
	}
	
	public ArrayList<Ingrediente> getIngredientes(){
		return this.ingredientes;
	}
	
	public void cargarInformacionRestaurante(String Ingredientes, String Menu, String Combos) throws IOException {
		cargarMenu(Menu);
		cargarCombos(Combos);
		cargarIngredientes(Ingredientes);
	}
	
	private void cargarIngredientes(String archivoIngredientes) throws IOException {
		String[] nombresIngredientes = new String[15];
		int[] preciosIngredientes = new int[15];
		
		System.out.println("\n"+"INGREDIENTES");
		FileReader file = new FileReader(archivoIngredientes);
		BufferedReader br = new BufferedReader(file);
		String line = br.readLine();
		int i = 0;
		this.menuBase = new ArrayList<ProductoMenu>();
		while(line != null) {
			line = br.readLine();
			if (line !=null) {
			String[] fragmentos = line.split(";");
			nombresIngredientes[i]=fragmentos[0];
			preciosIngredientes[i]=Integer.parseInt(fragmentos[1]);
			ProductoMenu nuevoProducto = new ProductoMenu(nombresIngredientes[i],preciosIngredientes[i]);
			menuBase.add(nuevoProducto);
			System.out.println(i+1+". "+nombresIngredientes[i]+": "+preciosIngredientes[i]);
			i+=1;
			}
			}
		
		br.close();
	}
	
	private void cargarMenu(String archivoMenu) throws IOException {
		
		String[] nombresProductos = new String[22];
		int[] preciosProductos = new int[22];
		
		System.out.println("\n"+"MENU");
		FileReader file = new FileReader(archivoMenu);
		BufferedReader br = new BufferedReader(file);
		String line = br.readLine();
		int i = 0;
		this.menuBase = new ArrayList<ProductoMenu>();
		while(line != null) {
			line = br.readLine();
			if (line !=null) {
			String[] fragmentos = line.split(";");
			nombresProductos[i]=fragmentos[0];
			preciosProductos[i]=Integer.parseInt(fragmentos[1]);
			ProductoMenu nuevoProducto = new ProductoMenu(nombresProductos[i],preciosProductos[i]);
			menuBase.add(nuevoProducto);
			System.out.println(i+1+". "+nombresProductos[i]+": "+preciosProductos[i]);
			i+=1;
			}
			}
		
		br.close();
	}
	
	private void cargarCombos(String archivoCombos) throws IOException {
		System.out.println("\n"+"COMBOS");
		FileReader file = new FileReader(archivoCombos);
		BufferedReader br = new BufferedReader(file);
		String line = br.readLine();
		while(line != null) {
		line = br.readLine();
		if (line != null){
			System.out.println(line.replaceFirst(";", ": "));
		}
		else {
		System.out.println("\n");
		}
		}
		br.close();
	}
		
	}
	
	
	
	
