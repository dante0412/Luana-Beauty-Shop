package com.luana.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_estado")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Estado {
	@Id
	private int id_est;
	private String desc_est;
}
