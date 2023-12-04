package test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import consola.Aplicacion;
import logica.Combo;
import logica.ProductoMenu;
import logica.Restaurante;


public class ComboTest {

	private Restaurante restaurante;
	private Combo combo;
	
	public void cargarDatos() {
		String ingr = "./data/ingredientes.txt";
		String menu = "./data/menu.txt";
		String comb = "./data/combos.txt";
		String bebi = "./data/bebidas.txt";
		Restaurante restaurante = new Restaurante();
		try {
			restaurante.cargarInformacionRestaurante(ingr, menu, comb, bebi);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	@BeforeEach
	public void setUp() {
		this.cargarDatos();
		ArrayList<ProductoMenu> lista = new ArrayList<ProductoMenu>();
		lista.add(restaurante.menuBase.get("corral"));
		lista.add(restaurante.menuBase.get("papas medianas"));
		lista.add(restaurante.bebidas.get("gaseosa"));
		Combo combo = new Combo("combo corral",0.10,lista);
	}
	
	@Test
	@Order(1)
	@DisplayName("agregarItemACombo")
	public void testAgregarItemACombo() {
		ProductoMenu producto = new ProductoMenu("corral pollo",15000,524);
		ArrayList<ProductoMenu> items = combo.getItemsCombo();
		int numero = items.size();
		combo.agregarItemACombo(producto);
		ArrayList<ProductoMenu> items2 = combo.getItemsCombo();
		int prueba = items2.size();
		assertTrue(numero < prueba, () -> "Se agrega el producto");
	}

	@Test
	@Order(2)
	@DisplayName("getPrecio")
	public void testGetPrecio() {
		int precio = 22050;
		int prueba = combo.getPrecio();
		assertTrue(precio == prueba, () -> "Se calcula el precio");
	}
	
	@Test
	@Order(3)
	@DisplayName("getCaloria")
	public void testGetCaloria() {
		int precio = 1156;
		int prueba = combo.getCaloria();
		assertTrue(precio == prueba, () -> "Se calcula las calorias");
	}
}