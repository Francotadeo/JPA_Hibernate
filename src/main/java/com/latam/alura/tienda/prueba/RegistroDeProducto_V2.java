package com.latam.alura.tienda.prueba;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import com.latam.alura.tienda.dao.CategoriaDao;
import com.latam.alura.tienda.dao.ProductoDao;
import com.latam.alura.tienda.modelo.Categoria;
import com.latam.alura.tienda.modelo.Producto;
import com.latam.alura.tienda.utils.JPAUtils;

public class RegistroDeProducto_V2 {

	public static void main(String[] args) {
		
		registrarProducto();
		EntityManager em = JPAUtils.getEntityManager();
		ProductoDao productoDao = new ProductoDao(em);
		Producto producto = productoDao.consultaPorId(1l);
		System.out.println("Nombre del producto: " + producto.getNombre());
		
		List<Producto> productos = productoDao.ConsultarTodos(); 
		productos.forEach(prod -> System.out.println("Nombres: " + prod.getNombre()));
		
		List<Producto> productosPorNombreDeProductos = productoDao.consultaPorNombre("Samsung Galaxy");
		productosPorNombreDeProductos.forEach(prod -> System.out.println("Descripción: " + prod.getDescripcion()));
		
		List<Producto> productosPorNombreDeCategoria = productoDao.consultaPorNombreDeCategoria("CELULARES");
		productosPorNombreDeCategoria.forEach(prod -> System.out.println("Descripción: " + prod.getDescripcion()));
		
		BigDecimal precioPorNombreDeProducto = productoDao.consultarPrecioPorNombreDeProducto("Xiaomi Redmi");
		System.out.println("Precio: " + precioPorNombreDeProducto);
	}

	private static void registrarProducto() {
		Categoria celulares = new Categoria("CELULARES");

		Producto celular = new Producto("Xiaomi Redmi", "Muy bueno", new BigDecimal("800"), celulares);
		Producto celular2 = new Producto("Samsung Galaxy", "Muy ilegal", new BigDecimal("1000"), celulares);
		
		EntityManager em = JPAUtils.getEntityManager(); // Connection - EntityManager, allow you to communicate with the database.
		ProductoDao productoDao = new ProductoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);
		
		em.getTransaction().begin(); // Connection obtained.
		
		categoriaDao.guardar(celulares);
		productoDao.guardar(celular);
		productoDao.guardar(celular2);
		
		em.getTransaction().commit(); // insert into products.
		em.close();
	}

}
