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
@Table(name = "tb_usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
	@Id
	private int id_usu;
	private String nom_usu;
	private String ape_usu;
	private String email_usu;
	private String telefono_usu;
	private String pass_usu;
	private int id_tipousu;
	private int id_est;
	
	@ManyToOne
	@JoinColumn(name = "id_tipousu", insertable = false, updatable = false)
	private TipoUsuario objTipo;
}
