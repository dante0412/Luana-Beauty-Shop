package com.luana.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_proveedor")
@Data
public class Proveedor {
	@Id
	private int id_prov;
	private String desc_prov;
	private String correo_prov;
	private String telefono_prov;
	private int id_est;
}
