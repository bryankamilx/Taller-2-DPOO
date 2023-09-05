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
		pedidos.add(nuevoPedido);
		pedidoEnCurso = nuevoPedido;
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
		System.out.println("\n"+"INGREDIENTES");
		FileReader file = new FileReader(archivoIngredientes);
		BufferedReader br = new BufferedReader(file);
		String message = "";
		String line = br.readLine();
		while(line != null) {
		message += line + " ";
		line = br.readLine();
		if (line != null){
		System.out.println(line.replace(";",": "));
		}
		else {
		System.out.println("\n");
		}
		}
		br.close();
	}
	
	private void cargarMenu(String archivoMenu) throws IOException {
		System.out.println("\n"+"MENU");
		FileReader file = new FileReader(archivoMenu);
		BufferedReader br = new BufferedReader(file);
		String message = "";
		String line = br.readLine();
		while(line != null) {
		message += line + " "; 
		line = br.readLine();
		if (line != null){
		System.out.println(line.replace(";",": "));
		}
		else {
		System.out.println("\n");
		}
		}
		br.close();
	}
	
	private void cargarCombos(String archivoCombos) throws IOException {
		System.out.println("\n"+"COMBOS");
		FileReader file = new FileReader(archivoCombos);
		BufferedReader br = new BufferedReader(file);
		String message = "";
		String line = br.readLine();
		while(line != null) {
		message += line + " "; 
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
	
	
	
	
