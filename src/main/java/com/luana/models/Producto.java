package com.luana.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_productos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
	@Id
	private int id_prod;
	private String desc_prod;
	private int stock_prod;
	private double preciocosto_prod;
	private double precioventa_prod;
	private int id_cat;
	private int id_prov;
	private int id_est;
	
	@ManyToOne
	@JoinColumn(name = "id_est", insertable = false, updatable = false)
	private Estado objEst;
	
	@ManyToOne
	@JoinColumn(name = "id_cat", insertable = false, updatable = false)
	private Categoria objCat;
	
	@ManyToOne
	@JoinColumn(name = "id_prov", insertable = false, updatable = false)
	private Proveedor objProv;
}
