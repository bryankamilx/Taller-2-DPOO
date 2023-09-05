package consola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
	
	private void ejecutarConsultarPedido() {
		// TODO Auto-generated method stub
		
	}

	private void ejecutarAgregarNuevoElemento() {
		// TODO Auto-generated method stub
		
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
