package com.pruebatecnica.app.infrastructure.outbound.database;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.pruebatecnica.app.domain.model.Prices;

/**
 * Component to consult the Prices entity.
 */
public interface PricesRepository extends CrudRepository<Prices, Long>{
	
	/**
	 * Searches a list of results based on a system date and string and product identifiers.
	 * 
	 * @param product
	 * @param cad
	 * @param fechaApp
	 * @return List<Prices>
	 */
	@Query("Select p From Prices p Where :idCad = p.brandId And :idProct = p.productId And (:fecha between p.startDate And p.endDate) ")
	Optional<List<Prices>> findListaPrices(@Param("idCad") Long cad, @Param("idProct") Long product, 
			@Param("fecha") LocalDateTime fechaApp); 
}
