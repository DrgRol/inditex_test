package es.inditex.test.repository;

import es.inditex.test.model.Prices;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<Prices, Integer> {

  @Query(value = "SELECT p"
      + " FROM "
      + "Prices p where p"
      + ".endDate "
      + ">= "
      + ":date AND p.startDate <= :date AND p.brandId = :brandId AND p.productId = :productId"
  )
  List<Prices> findPrices(@Param("date") LocalDateTime date,
      @Param("brandId") Integer brandId, @Param("productId") Long productId);

}
