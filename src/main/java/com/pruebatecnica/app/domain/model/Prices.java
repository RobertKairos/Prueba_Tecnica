/**
 * 
 */
package com.pruebatecnica.app.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Data object
 */
@Entity
@Table
@Data
public class Prices implements Serializable{
	
	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 3264028568018918639L;

	@Column(name = "BRAND_ID")
	private Long brandId;
	
	@Column(name = "START_DATE")
	private LocalDateTime startDate;
	
	@Column(name = "END_DATE")
	private LocalDateTime endDate;
	
	@Id
	@Column(name = "PRICE_LIST")
	private Integer priceList;
	
	@Column(name = "PRODUCT_ID")
	private Long productId;
	
	@Column(name = "PRIORITY")
	private Integer priority;
	
	@Column(name = "PRICE")
	private BigDecimal price;
	
	@Column(name = "CURRENCY")
	private String currency;
	
	@Column(name = "LAST_UPDATE")
	private LocalDateTime lastUpdate;
	
	@Column(name = "LAST_UPDATE_BY")
	private String lastUpdateBy;
}
