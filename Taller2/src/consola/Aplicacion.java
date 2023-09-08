package consola;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import logica.Ingrediente;
import logica.ProductoMenu;
import logica.Restaurante;

public class Aplicacion{
	
	Restaurante restaurante = new Restaurante();
	
	
	public static void main(String[] args) throws IOException
	{
		
		Aplicacion consola = new Aplicacion();
		consola.ejecutarAplicacion();
	}

	private void ejecutarAplicacion() throws IOException {
		{
			System.out.println("Opciones disponibles\n");

			boolean continuar = true;
			while (continuar)
			{
				try
				{
					mostrarMenu();
					int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
					if (opcion_seleccionada == 1)
						ejecutarcargarMenu();
					else if (opcion_seleccionada == 2)
						ejecutarIniciarNuevoPedido();
					else if (opcion_seleccionada == 3)
						ejecutarAgregarNuevoElemento();
					else if (opcion_seleccionada == 4)
						ejecutarConsultarPedido();
					else if (opcion_seleccionada == 5)
						{System.out.println("Saliendo de la aplicación ...");
						continuar = false;}

				}
				catch (NumberFormatException e)
				{
					System.out.println("Debe seleccionar uno de los números de las opciones.");
				}
			}
		}
		
		
	}
	
	private void ejecutarAgregarElemento() throws IOException{
		
					int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
					System.out.println("\n");
					if (opcion_seleccionada == 1)
						agregarProductoMenu();
					else if (opcion_seleccionada == 2)
						agregarCombo();
					else if (opcion_seleccionada == 3)
						agregarIngrediente();

	}
		
	
	private void ejecutarConsultarPedido() {
		
	}

	private void agregarIngrediente() throws IOException {
		
		ejecutarMostrarIngredientes();
	}


	private void ejecutarMostrarIngredientes() throws IOException {
		String[] nombresIngredientes = new String[15];
		int[] preciosIngredientes = new int[15];
		FileReader file = new FileReader("C:\\Users\\Bryan\\eclipse-workspace\\Taller2\\data\\ingredientes.txt");
		BufferedReader br = new BufferedReader(file);
		String line = br.readLine();
		int i = 0;
		while(line != null) {
		line = br.readLine();
		if (line !=null) {
		String[] fragmentos = line.split(";");
		nombresIngredientes[i]=fragmentos[0];
		preciosIngredientes[i]=Integer.parseInt(fragmentos[1]);
		System.out.println(i+1+". "+nombresIngredientes[i]+": "+preciosIngredientes[i]);
		i+=1;
		}
		}
		br.close();
		int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
		Ingrediente productoAgregado = restaurante.getIngredientes().get(opcion_seleccionada);
		restaurante.getPedidoEnCurso().agregarProducto(productoAgregado);
		System.out.println("Se agrego "+productoAgregado.getNombre()+ "con un valor de "+productoAgregado.getPrecio());
		
	}

	private void agregarCombo() {
		
		
	}

	private void agregarProductoMenu() throws IOException {
		ejecutarMostrarProductosMenu();
	}

	private void ejecutarMostrarProductosMenu() throws IOException {
		
		String[] nombresIngredientes = new String[22];
		int[] preciosIngredientes = new int[22];
		
		
		
		FileReader file = new FileReader("C:\\Users\\Bryan\\eclipse-workspace\\Taller2\\data\\menu.txt");
		BufferedReader br = new BufferedReader(file);
		String line = br.readLine();
		int i = 0;
		while(line != null) {
		line = br.readLine();
		if (line !=null) {
		String[] fragmentos = line.split(";");
		nombresIngredientes[i]=fragmentos[0];
		preciosIngredientes[i]=Integer.parseInt(fragmentos[1]);
		System.out.println(i+1+". "+nombresIngredientes[i]+": "+preciosIngredientes[i]);
		i+=1;
		}
		}
		br.close();
		int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
		ProductoMenu productoAgregado = restaurante.getMenuBase().get(opcion_seleccionada);
		restaurante.getPedidoEnCurso().agregarProducto(productoAgregado);
		System.out.println("Se agrego "+productoAgregado.getNombre()+ "con un valor de "+productoAgregado.getPrecio());
		}

	private void ejecutarAgregarNuevoElemento() throws IOException {
		mostrarAgregarElemento();
		ejecutarAgregarElemento();
	}

	private void ejecutarIniciarNuevoPedido() {
		
		String nombre = input("Por favor ingrese su nombre");
		String direccion = input("Por favor ingrese su dirección");
		restaurante.iniciarPedido(nombre, direccion);
		System.out.println("Se inició el pedido a nombre de "+nombre+" y dirección "+ direccion);
		
	}

	public void ejecutarcargarMenu() throws IOException {
		restaurante.cargarInformacionRestaurante("C:\\Users\\Bryan\\eclipse-workspace\\Taller2\\data\\ingredientes.txt", 
				"C:\\Users\\Bryan\\eclipse-workspace\\Taller2\\data\\menu.txt", 
				"C:\\Users\\Bryan\\eclipse-workspace\\Taller2\\data\\combos.txt");
	}

	public void mostrarMenu()
	{
		System.out.println("\nOpciones de la aplicación\n");
		System.out.println("1. Mostrar el menú");
		System.out.println("2. Iniciar un nuevo pedido");
		System.out.println("3. Agregar un elemento a un pedido");
		System.out.println("4. Consultar la información de un pedido dado su id");
		System.out.println("5. Salir de la aplicación");
	}
	
	public void mostrarAgregarElemento()
	{
		System.out.println("\nOpciones de la aplicación\n");
		System.out.println("1. Agregar producto básico");
		System.out.println("2. Agregar un combo");
		System.out.println("3. Agregar un ingrediente");
	}
	
	public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
	
}
