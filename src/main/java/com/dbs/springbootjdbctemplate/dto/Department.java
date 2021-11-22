package com.dbs.springbootjdbctemplate.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "deptTBL")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {

	private String deptName;
	@Id
	private String deptId;
	private String location;
}
