package com.mms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Check;
import org.hibernate.validator.constraints.Range;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "mobile")

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter 
@Getter
public class Mobile {
	@Id
	private Long ime;
	
	@Column
	@NotNull
	private String model;
	
	@Column
	@NotNull
	
	private String maker;
	
	@Column
	private String color;
	
	@Column
	@Range(max=150000)
	private Double price;
	
	@Column
	private Integer processor;
	
	@Column
	private Integer camera;

	

	
	  public Long getIme() { return ime; }
	  
	  public void setIme(Long ime) { this.ime = ime; }
	  
	  public String getModel() { return model; }
	  
	  public void setModel(String model) { this.model = model; }
	  
	  public String getMaker() { return maker; }
	  
	  public void setMaker(String maker) { this.maker = maker; }
	  
	  public String getColor() { return color; }
	  
	  public void setColor(String color) { this.color = color; }
	  
	  public Double getPrice() { return price; }
	  
	  public void setPrice(Double price) { this.price = price; }
	  
	  public Integer getProcessor() { return processor; }
	  
	  public void setProcessor(Integer processor) { this.processor = processor; }
	  
	  public Integer getCamera() { return camera; }
	  
	  public void setCamera(Integer camera) { this.camera = camera; }
	 



}
