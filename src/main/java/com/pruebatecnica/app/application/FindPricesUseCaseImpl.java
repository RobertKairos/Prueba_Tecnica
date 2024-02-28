/**
 * 
 */
package com.pruebatecnica.app.application;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebatecnica.app.domain.dtos.FirstConsultationInDTO;
import com.pruebatecnica.app.domain.dtos.FirstConsultationOutDTO;
import com.pruebatecnica.app.domain.model.Prices;
import com.pruebatecnica.app.domain.repository.FindPriceDAO;
import com.pruebatecnica.app.domain.util.CommonsUtil;
import com.pruebatecnica.app.infrastructure.inbound.input.FindPricesUseCase;

/**
 * Component that processes the business logic.
 */
@Service
public class FindPricesUseCaseImpl implements FindPricesUseCase{
	
	/**
	 * Reference for FindPriceRepository
	 */
	@Autowired
	private FindPriceDAO findPriceRepository;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public FirstConsultationOutDTO findListaPrices(FirstConsultationInDTO primerConsultaInDTO) {
		
		FirstConsultationOutDTO resultado = null;
		BigDecimal compararPrecio = new BigDecimal(0);	
		
		List<Prices> listaprecios = findPriceRepository.findListaPrices(primerConsultaInDTO);
		
		for(Prices price: listaprecios) {
			
			if((compararPrecio.compareTo(price.getPrice()) == -1) || (compararPrecio.compareTo(price.getPrice()) == 0)) {
				
				compararPrecio = price.getPrice();
				
				resultado = CommonsUtil.mapperToPrimerConsultaOutDTO(compararPrecio, price);
			}
		}
		
		return resultado;
	}

}
