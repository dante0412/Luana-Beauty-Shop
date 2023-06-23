package com.luana.controller;

import java.io.OutputStream;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luana.models.Categoria;
import com.luana.models.Producto;
import com.luana.models.Proveedor;
import com.luana.models.Usuario;
import com.luana.repository.CategoriaRepository;
import com.luana.repository.EstadoRepository;
import com.luana.repository.ProductoRepository;
import com.luana.repository.ProveedorRepository;
import com.luana.repository.TipoUsuarioRepository;
import com.luana.repository.UsuarioRepository;

import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@Controller
public class luanaController {
	
	@GetMapping("/")
	public String cargarIndex() {
		return "index";
	}
	
	@Autowired
	private ProductoRepository prodRepo;
	@Autowired
	private CategoriaRepository catRepo;

	@Autowired
	private ProveedorRepository provRepo;
	@Autowired
	private UsuarioRepository usuRepo;
	@Autowired
	private TipoUsuarioRepository tipoRepo;
	
//	Controlador producto
	
	private ArrayList<Producto> lstProductos() {
		ArrayList<Producto> lista = new ArrayList<Producto>();
		try {
			var productos = prodRepo.findAll();
			for (Producto producto : productos) {
				if(producto.getId_est() == 1) {
					lista.add(producto);
				}
			}
		} catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		return lista;
	}
	@GetMapping("/crud/productos")
	public String paginaproducto(Model model) {
		cargarCombos(model);
		model.addAttribute("productos", lstProductos());
		model.addAttribute("producto", new Producto());
		return "crudProductos";
	}
	
	@PostMapping("/crud/producto/eliminar")
	public String eliminarProducto(@RequestParam("id") int id, Model model, RedirectAttributes redirectAttributes) {
		Producto producto = prodRepo.findById(id).orElse(new Producto());
		producto.setId_est(2);
		prodRepo.save(producto);
		model.addAttribute("producto", new Producto());
		model.addAttribute("productos", lstProductos());
		return "redirect:/crud/productos";
	}
	
	@PostMapping("/crud/productos/guardar")
	public String guardarProducto(@ModelAttribute Producto producto, Model model, RedirectAttributes redirectAttributes) {
		String mensaje = "";
		producto.setId_est(1);
		try {
			prodRepo.save(producto);
			mensaje = "Registro exitoso";
		} catch (Exception e) {
			mensaje = "Error al guardar";
		}
		cargarCombos(model);
		model.addAttribute("productos", lstProductos());
		model.addAttribute("mensaje", mensaje);
		
		redirectAttributes.addFlashAttribute("mensaje", mensaje);
		return "redirect:/crud/productos";
	}
	
	
//	-----------------------------------------------------------------------------------------------
//	Controlador Usuario
	
	private ArrayList<Usuario> lstUsuarios() {
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		try {
			var usuarios = usuRepo.findAll();
			for (Usuario usuario : usuarios) {
				if(usuario.getId_est() == 1) {
					lista.add(usuario);
				}
			}
		} catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		return lista;
	}
	
	@GetMapping("/crud/usuarios")
	public String paginausuario(Model model) {
		cargarCombos(model);
		model.addAttribute("usuarios", lstUsuarios());
		model.addAttribute("usuario", new Usuario());
		return "crudUsuario";
	}
	
	@PostMapping("/crud/usuarios/eliminar")
	public String eliminarUsuario(@RequestParam("id") int id, Model model, RedirectAttributes redirectAttributes) {
		Usuario usuario = usuRepo.findById(id).orElse(new Usuario());
		usuario.setId_est(2);
		usuRepo.save(usuario);
		model.addAttribute("Usuario", new Usuario());
		model.addAttribute("usuarios", lstUsuarios());
		return "redirect:/crud/usuarios";
	}
	
	@PostMapping("/crud/usuarios/guardar")
	public String guardarUsuario(@ModelAttribute Usuario usuario, Model model, RedirectAttributes redirectAttributes) {
		String mensaje = "";
		usuario.setId_est(1);
		try {
			usuRepo.save(usuario);
			mensaje = "Registro exitoso";
		} catch (Exception e) {
			mensaje = "Error al guardar";
		}
		cargarCombos(model);
		model.addAttribute("usuarios", lstUsuarios());
		model.addAttribute("mensaje", mensaje);
		
		redirectAttributes.addFlashAttribute("mensaje", mensaje);
		return "redirect:/crud/usuarios";
	}
	
//	-----------------------------------------------------------------------------------------------
//	Controlador Proveedor
	
	private ArrayList<Proveedor> lstProveedores() {
		ArrayList<Proveedor> lista = new ArrayList<Proveedor>();
		try {
			var proveedores = provRepo.findAll();
			for (Proveedor proveedor : proveedores) {
				if(proveedor.getId_est() == 1) {
					lista.add(proveedor);
				}
			}
		} catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		return lista;
	}
	
	@GetMapping("/crud/proveedor")
	public String paginaproveedor(Model model) {
		model.addAttribute("proveedores", lstProveedores());
		model.addAttribute("proveedor", new Proveedor());
		return "crudProveedores";
	}
	
	@PostMapping("/crud/proveedor/eliminar")
	public String eliminarProveedor(@RequestParam("id") int id, Model model, RedirectAttributes redirectAttributes) {
		Proveedor proveedor = provRepo.findById(id).orElse(new Proveedor());
		proveedor.setId_est(2);
		provRepo.save(proveedor);
		model.addAttribute("proveedor", new Proveedor());
		model.addAttribute("proveedores", lstProveedores());
		return "redirect:/crud/proveedor";
	}
	
	@PostMapping("/crud/proveedor/guardar")
	public String guardarProveedor(@ModelAttribute Proveedor proveedor, Model model, RedirectAttributes redirectAttributes) {
		String mensaje = "";
		proveedor.setId_est(1);
		try {
			provRepo.save(proveedor);
			mensaje = "Registro exitoso";
		} catch (Exception e) {
			mensaje = "Error al guardar";
		}
		model.addAttribute("proveedores", lstProveedores());
		model.addAttribute("mensaje", mensaje);
		
		redirectAttributes.addFlashAttribute("mensaje", mensaje);
		return "redirect:/crud/proveedor";
	}
//	-----------------------------------------------------------------------------------------------
// Controller Categoria
	
	private ArrayList<Categoria> lstCategorias() {
		ArrayList<Categoria> lista = new ArrayList<Categoria>();
		try {
			var categorias = catRepo.findAll();
			for (Categoria categoria : categorias) {
				if(categoria.getId_est() == 1) {
					lista.add(categoria);
				}
			}
		} catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		return lista;
	}
	
	@GetMapping("/crud/categoria")
	public String paginacategoria(Model model) {
		model.addAttribute("categorias", lstCategorias());
		model.addAttribute("categoria", new Categoria());
		return "crudCategorias";
	}
	
	@PostMapping("/crud/categoria/eliminar")
	public String eliminarCategoria(@RequestParam("id") int id, Model model, RedirectAttributes redirectAttributes) {
		Categoria categoria = catRepo.findById(id).orElse(new Categoria());
		categoria.setId_est(2);
		catRepo.save(categoria);
		model.addAttribute("categoria", new Categoria());
		model.addAttribute("categorias", lstCategorias());
		return "redirect:/crud/categoria";
	}
	
	@PostMapping("/crud/categoria/guardar")
	public String guardarCategoria(@ModelAttribute Categoria categoria, Model model, RedirectAttributes redirectAttributes) {
		String mensaje = "";
		categoria.setId_est(1);
		try {
			catRepo.save(categoria);
			mensaje = "Registro exitoso";
		} catch (Exception e) {
			mensaje = "Error al guardar";
		}
		model.addAttribute("categorias", lstCategorias());
		model.addAttribute("mensaje", mensaje);
		
		redirectAttributes.addFlashAttribute("mensaje", mensaje);
		return "redirect:/crud/categoria";
	}
//	-----------------------------------------------------------------------------------------------
//	Controller Reportes
	
	@Autowired
	private DataSource dataSource; // javax.sql
	@Autowired
	private ResourceLoader resourceLoader; // core.io
	
	@GetMapping("/reporte/producto")
	public void reporteProd(HttpServletResponse response) {
		response.setHeader("Content-Disposition", "inline;"); 
		response.setContentType("application/pdf");
		
		try {
			String ru = resourceLoader.getResource("classpath:reportes/reporte_productos.jasper").getURI().getPath();
			JasperPrint jasperPrint = JasperFillManager.fillReport(ru, null, dataSource.getConnection());
			OutputStream outStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping("/reporte/usuarios")
	public void reporteUsu(HttpServletResponse response) {
		response.setHeader("Content-Disposition", "inline;"); 
		response.setContentType("application/pdf");
		
		try {
			String ru = resourceLoader.getResource("classpath:reportes/reporte_usuarios.jasper").getURI().getPath();
			JasperPrint jasperPrint = JasperFillManager.fillReport(ru, null, dataSource.getConnection());
			OutputStream outStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping("/reporte/grafico")
	public void reporteGrafico(HttpServletResponse response) {
		response.setHeader("Content-Disposition", "inline;"); 
		response.setContentType("application/pdf");
		
		try {
			String ru = resourceLoader.getResource("classpath:reportes/grafico.jasper").getURI().getPath();
			JasperPrint jasperPrint = JasperFillManager.fillReport(ru, null, dataSource.getConnection());
			OutputStream outStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	-----------------------------------------------------------------------------------------------
	void cargarCombos(Model model) {
		model.addAttribute("lstTipoUsu", tipoRepo.findAll());
		model.addAttribute("lstCategorias", catRepo.findAll());
		model.addAttribute("lstProveedores", provRepo.findAll());
	}
}
