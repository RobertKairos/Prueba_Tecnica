/**
 * 
 */
package com.pruebatecnica.app.domain.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;

/**
 * Data transfer object
 */
@Data
//@Accessors(chain = true)
public class FirstConsultationInDTO implements Serializable{
	
	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 1680152479314349142L;

	private LocalDateTime dateApp;
	
	private Long identProduct;
	
	private Long identCad;

}
