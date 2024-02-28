/**
 * 
 */
package com.pruebatecnica.app.infrastructure.inbound.input;

import com.pruebatecnica.app.domain.dtos.FirstConsultationInDTO;
import com.pruebatecnica.app.domain.dtos.FirstConsultationOutDTO;

/**
 * Intermediary interface from the controller to the implementation.
 */
public interface FindPricesUseCase {
	
	/**
	 * Gets a price list based on the application date, string ID, and product ID.
	 * 
	 * @param primerConsultaInDTO
	 * @return PrimerConsultaOutDTO
	 */
	FirstConsultationOutDTO findListaPrices(FirstConsultationInDTO primerConsultaInDTO);
}
