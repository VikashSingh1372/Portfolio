package com.portfolio.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Details {
	
	@Id
	private int id;
	
	@Column(length = 1000)
	private String detail;
	
	@ManyToOne
	private Project project;

	@Override
	public String toString() {
		return "Details [id=" + id + ", detail=" + detail + ", project=" + project + "]";
	}
	
	
	
	

}
