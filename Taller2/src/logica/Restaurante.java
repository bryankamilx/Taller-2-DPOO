package logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Restaurante {

	private ArrayList<Combo> combos;
	
	private HashMap<Integer, Pedido> pedidos;
	
	private ArrayList<Ingrediente> ingredientes;
	
	public HashMap<String,ProductoMenu> menuBase;
	
	public HashMap<String,ProductoMenu> bebidas;

	private Pedido pedidoenCurso;
	
	private int idActual;
	
	public Restaurante() {
		this.menuBase = new HashMap <String,ProductoMenu>();
		this.bebidas = new HashMap <String,ProductoMenu>();
		this.pedidos = new HashMap <Integer,Pedido>();
		this.ingredientes = new ArrayList <Ingrediente>();
		this.combos = new ArrayList <Combo>();
	}
	
	public void iniciarPedido(String nombreCliente, String direccionCliente) {
		idActual += 1;
		Pedido pedido = new Pedido(nombreCliente, direccionCliente, idActual);
		this.setPedidoenCurso(pedido);
		pedidos.put(idActual, pedido);
	}
	
	public void cerraryGuardadPedido() throws IOException {
		int id = pedidoenCurso.getIdPedido();
		this.pedidos.put(id,pedidoenCurso);
		File archivo = new File("./data/Factura"+id+".txt");
		this.pedidoenCurso.generarFactura(archivo);
	}

	public Pedido getPedidoenCurso() {
		return pedidoenCurso;
	}
	
	public ArrayList<ProductoMenu> getMenuBase() {
		ArrayList<ProductoMenu> menu = new ArrayList <ProductoMenu>();
		for (ProductoMenu producto : menuBase.values()) {
			menu.add(producto);
		}
		return menu;
			
	}
	
	public ArrayList<ProductoMenu> getBedidas() {
		ArrayList<ProductoMenu> liquido = new ArrayList <ProductoMenu>();
		for (ProductoMenu producto : bebidas.values()) {
			liquido.add(producto);
		}
		return liquido;
			
	}
	
	public ArrayList<Ingrediente> getIngredientes() {
		return ingredientes;
	}
	
	public int getIdActual() {
		return idActual;
	}

	public HashMap<Integer, Pedido> getPedidos() {
		return pedidos;
	}
	
	public void setCombos(ArrayList<Combo> combos) {
		this.combos = combos;
	}

	public void setPedidos(HashMap<Integer, Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public void setMenuBase(HashMap<String, ProductoMenu> menuBase) {
		this.menuBase = menuBase;
	}

	public void setPedidoenCurso(Pedido pedidoenCurso) {
		this.pedidoenCurso = pedidoenCurso;
	}

	public void setIdActual(int idActual) {
		this.idActual = idActual;
	}
	
	public ArrayList<Combo> getCombos() {
		return combos;
	}
	
	public void agregarProducto(String item) {
		ProductoMenu itemp = menuBase.get(item);
		try {
			this.pedidoenCurso.agregarProducto(itemp);
		} catch (ExceptionH e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void agregarProductoC(int item) {
		Combo combop = combos.get(item);
		try {
			this.pedidoenCurso.agregarProducto(combop);
		} catch (ExceptionH e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void cargarInformacionRestaurante(String archivoIngredientes, String archivoMenu, String archivoCombos, String archivoBebidas) throws IOException {
		menuBase = new HashMap <String,ProductoMenu>();
		bebidas = new HashMap<String,ProductoMenu>();
		ingredientes = new ArrayList <Ingrediente>();
		combos = new ArrayList <Combo>();
		File archivoI = new File(archivoIngredientes);
		File archivoM = new File(archivoMenu);
		File archivoC = new File(archivoCombos);
		File archivoB = new File(archivoBebidas);
		cargarIngredientes(archivoI);
		cargarMenu(archivoM);
		cargarCombos(archivoC);
		cargarBebidas(archivoB);
	}
	
	public void cargarIngredientes(File archivoIngredientes) throws IOException {
		BufferedReader lector = new BufferedReader(new FileReader(archivoIngredientes));
		String linea = lector.readLine();
		while(linea!=null) {
				
			String [] datos = linea.split(";");
			String nombreI = datos[0];
			String precioA = datos[1];
			String calorias = datos[2];
			int caloriasN = Integer.parseInt(calorias);
			int precioN = Integer.parseInt(precioA);
			Ingrediente nuevo = new Ingrediente(nombreI, precioN, caloriasN);
			ingredientes.add(nuevo);
			linea = lector.readLine();
			}
			lector.close();
	
	}
	
	public void cargarMenu(File archivoMenu) throws IOException {
		BufferedReader lector = new BufferedReader(new FileReader(archivoMenu));
		String linea = lector.readLine();
		while(linea!=null) {
			
			String [] datos = linea.split(";");
			String nombreI = datos[0];
			String precio = datos[1];
			String calorias = datos[2];
			int precioN = Integer.parseInt(precio);
			int caloriasN = Integer.parseInt(calorias);
			ProductoMenu nuevo = new ProductoMenu(nombreI, precioN, caloriasN);
			if (menuBase.containsValue(nuevo)) {
				System.out.println("Se encontro un producot repetido en el menu");
			} 
			else {
				menuBase.put(nombreI,nuevo);
			}
		}
		lector.close();
	}
	
	public void cargarBebidas(File archivoBebidas) throws IOException {
		BufferedReader lector = new BufferedReader(new FileReader(archivoBebidas));
		String linea = lector.readLine();
		while(linea!=null) {
			
			String [] datos = linea.split(";");
			String nombreI = datos[0];
			String precio = datos[1];
			String calorias = datos[2];
			int precioN = Integer.parseInt(precio);
			int caloriasN = Integer.parseInt(calorias);
			ProductoMenu nuevo = new ProductoMenu(nombreI, precioN, caloriasN);
			bebidas.put(nombreI,nuevo);
			linea = lector.readLine();
		}
		lector.close();
	}
	
	public void cargarCombos(File archivoCombos) throws IOException {
		BufferedReader lector = new BufferedReader(new FileReader(archivoCombos));
		String linea = lector.readLine();
		while(linea!=null) {
			
			String [] datos = linea.split(";");
			String nombreI = datos[0];
			String descuento = datos[1];
			String item1 = datos[2];
			String item2 = datos[3];
			String item3 = datos[4];
			ArrayList<ProductoMenu> items = new ArrayList<ProductoMenu>();
			descuento = descuento.replace("%", "");
			double descuentod = Double.valueOf(descuento);
			descuentod = descuentod/100;
			items.add(menuBase.get(item1));
			items.add(menuBase.get(item2));
			items.add(bebidas.get(item3));
			Combo nuevo = new Combo(nombreI, descuentod, items);
			combos.add(nuevo);
			linea = lector.readLine();
		}
		lector.close();
	}
	
}
	
	
	
	
