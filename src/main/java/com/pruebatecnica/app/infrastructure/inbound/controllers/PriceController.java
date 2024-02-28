/**
 * 
 */
package com.pruebatecnica.app.infrastructure.inbound.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebatecnica.app.domain.dtos.FirstConsultationInDTO;
import com.pruebatecnica.app.domain.dtos.FirstConsultationOutDTO;
import com.pruebatecnica.app.domain.util.CommonsUtil;
import com.pruebatecnica.app.infrastructure.inbound.input.FindPricesUseCase;

/**
 *Component that exposes the API requests.
 */
@RestController
@RequestMapping("/consulta")
public class PriceController {
	
	/**
	 *  Reference for IFindPricesUseCase
	 */
	@Autowired
	private FindPricesUseCase findPricesUseCase;

	/**
	 * Check the final price (pvp) and the rate that applies to a product from a chain between certain dates.
	 * 
	 * @param Idproduct
	 * @param idCad
	 * @param hour
	 * @param day
	 * @return PrimerConsultaOutDTO
	 */
	@GetMapping("/findPrice/{producto}/{brand}/{date}")
	public FirstConsultationOutDTO findPrice(@PathVariable(name = "producto", required = true) Long Idproduct, 
			@PathVariable(name = "brand", required = true) Long idCad, 
			@PathVariable(name = "date", required = true) String date){
		
		FirstConsultationInDTO primerConsultaInDTO = new FirstConsultationInDTO();
		
		primerConsultaInDTO.setDateApp(CommonsUtil.obtainDatePrice(date));
		primerConsultaInDTO.setIdentCad(idCad);
		primerConsultaInDTO.setIdentProduct(Idproduct);
		
		return findPricesUseCase.findListaPrices(primerConsultaInDTO);
	}
}
