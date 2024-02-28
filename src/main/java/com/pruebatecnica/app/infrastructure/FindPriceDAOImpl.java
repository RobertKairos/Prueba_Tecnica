/**
 * 
 */
package com.pruebatecnica.app.infrastructure;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebatecnica.app.domain.dtos.FirstConsultationInDTO;
import com.pruebatecnica.app.domain.model.Prices;
import com.pruebatecnica.app.domain.repository.FindPriceDAO;
import com.pruebatecnica.app.infrastructure.outbound.database.PricesRepository;

/**
 * Component for the intermediary process in the DB query.
 */
@Service
public class FindPriceDAOImpl implements FindPriceDAO {
	
	/**
	 * Reference for PricesRepository
	 */
	@Autowired
	private PricesRepository pricesRepository;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Prices> findListaPrices(FirstConsultationInDTO primerConsultaInDTO) {
		
		return pricesRepository.findListaPrices(
				primerConsultaInDTO.getIdentCad(), primerConsultaInDTO.getIdentProduct(), primerConsultaInDTO.getDateApp())
					.orElse(new ArrayList<>());
	}

}
