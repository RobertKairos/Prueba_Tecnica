/**
 * 
 */
package com.pruebatecnica.app.infrastructure.inbound.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pruebatecnica.app.domain.dtos.FirstConsultationOutDTO;

/**
 * Testing component
 */
@SpringBootTest
public class PriceControllerTest {

	@Autowired
	private PriceController priceController;
	
	/**
	 * Try the basic flow for findPrice
	 */
	@Test
	public void findPriceTest() {
		
		FirstConsultationOutDTO firstConsultationOutDTO = 
				priceController.findPrice(35455L, 1L, "20-06-16 21:00:00");
		
		assertEquals(firstConsultationOutDTO.getPrice().toString(), "38.95", "Prueba exitosa.");
	}
	
	/**
	 * Try the alternate flow for findPrice
	 */
	@Test
	public void findPriceTest_FA() {
		
		FirstConsultationOutDTO firstConsultationOutDTO = 
				priceController.findPrice(35455L, 1L, "21-11-11 11:11:11");
		
		assertNull(firstConsultationOutDTO, "Prueba exitosa.");
	}
	
	/**
	 * Try the alternate flow for findPrice
	 */
	@Test
	public void findPriceTest_FA_DateInvalit() {
		
		FirstConsultationOutDTO firstConsultationOutDTO = 
				priceController.findPrice(35455L, 1L, "test");
		
		assertNull(firstConsultationOutDTO, "Prueba exitosa.");
	}
}
