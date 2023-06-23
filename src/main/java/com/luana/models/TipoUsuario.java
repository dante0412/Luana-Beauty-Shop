package com.luana.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_tipousuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoUsuario {
	@Id
	private int id_tipousu;
	private String desc_tipousu;
}
