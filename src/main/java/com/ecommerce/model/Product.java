package com.ecommerce.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Table(name = "product")
@Data
public class Product {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id",length = 20)
	private Long id;
	
	@Column(name = "sku",nullable = false, length = 255)
	private String sku;
	
	@Column(name = "name", nullable = false, length = 255)
	private String name;
	
	@Column(name = "description", nullable = false, length = 255)
	private String description;
	
	@Column(name = "unit_price", nullable = false, precision = 13, length = 2)
	private BigDecimal unitPrice;
	
	@Column(name = "image_url", nullable = false, length = 255)
	private String imageUrl;
	
	@Column(name = "active", columnDefinition="BIT", nullable = false, length = 1)
	private boolean active;
	
	@Column(name = "units_in_stock", nullable = false)
	private Integer unitsInStock;
	
	@Column(name = "date_created", nullable = false)
	@CreationTimestamp
	private Date dateCreated;
	
	@Column(name = "last_updated")
	@UpdateTimestamp
	private Date lastUpdated;
	
	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private ProductCategory category;

}
