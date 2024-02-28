/**
 * 
 */
package com.pruebatecnica.app.domain.repository;

import java.util.List;

import com.pruebatecnica.app.domain.dtos.FirstConsultationInDTO;
import com.pruebatecnica.app.domain.model.Prices;

/**
 * Interface for the intermediary process in the DB query.
 */
public interface FindPriceDAO {

	/**
	 * You get a price list.
	 * 
	 * @param primerConsultaInDTO
	 * @return List<Prices>
	 */
	List<Prices> findListaPrices(FirstConsultationInDTO primerConsultaInDTO);
}
