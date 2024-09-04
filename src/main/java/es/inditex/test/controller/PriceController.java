package es.inditex.test.controller;

import es.inditex.test.controllers.api.PricesApi;
import es.inditex.test.dto.FilterDto;
import es.inditex.test.model.api.ApiPrice;
import es.inditex.test.service.PriceService;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "prices/v1")
@RequiredArgsConstructor
public class PriceController implements PricesApi {

  private final PriceService priceService;

  @Override
  public ResponseEntity<ApiPrice> findAllConsumers(@PathVariable("product_id") Long productId,
      @RequestParam(value = "date", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date,
      @RequestParam(value = "brand_id", required = true) Integer brandId) {
    return ResponseEntity.
        ok(priceService.getPrice(FilterDto.builder().productId(productId).date(date).brandId(brandId).build()));
  }

}
