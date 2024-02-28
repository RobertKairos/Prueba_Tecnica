/**
 * 
 */
package com.pruebatecnica.app.domain.util;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.pruebatecnica.app.domain.dtos.FirstConsultationOutDTO;
import com.pruebatecnica.app.domain.model.Prices;

/**
 * Componente de utileria general
 */
public class CommonsUtil {
	
	/**
	 * Obtine una fecha en base el dia y la hora (hh:mm)
	 * 
	 * @param precio
	 * @param price
	 * @return LocalDateTime
	 */
	public static LocalDateTime obtainDatePrice(String date) {
		
		String[] dates = date.split("-");
		String[] hour = dates[2].substring(3).split(":");
		
		LocalDate dateData = LocalDate.of(
				Integer.valueOf(new StringBuilder("20").append(dates[0]).toString()), 
				Integer.valueOf(dates[1]), 
				Integer.valueOf(dates[2].substring(0, 2)));
		
		LocalTime hourData = LocalTime.of(
				Integer.valueOf(hour[0]), 
				Integer.valueOf(hour[1]), 
				Integer.valueOf(hour[2]));
		
		return LocalDateTime.of(dateData, hourData);
	}

	/**
	 * Transforma el objeto Prices a PrimerConsultaOutDTO
	 * 
	 * @param precio
	 * @param price
	 * @return PrimerConsultaOutDTO
	 */
	public static FirstConsultationOutDTO mapperToPrimerConsultaOutDTO(BigDecimal precio, Prices price) {
		
		FirstConsultationOutDTO resultado = new FirstConsultationOutDTO();
		
		resultado.setIdentProduct(price.getProductId());
		resultado.setIdentCad(price.getBrandId());
		resultado.setDateInic(price.getStartDate());
		resultado.setDatefin(price.getEndDate());
		resultado.setTarifAplic(price.getPriceList());
		resultado.setPrice(precio);
		
		return resultado;
	}

}
