/**
 * 
 */
package com.pruebatecnica.app.domain.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;

/**
 * Data transfer object
 */
@Data
public class FirstConsultationOutDTO implements Serializable{
	
	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 4705795998637259277L;

	private Long identProduct;
	
	private Long identCad;
	
	private Integer tarifAplic;
	
	private LocalDateTime dateInic;
	
	private LocalDateTime datefin;
	
	private BigDecimal price;

}
