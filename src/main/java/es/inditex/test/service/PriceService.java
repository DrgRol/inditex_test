package es.inditex.test.service;


import es.inditex.test.dto.FilterDto;
import es.inditex.test.model.api.ApiPrice;

public interface PriceService {

  public ApiPrice getPrice(FilterDto filter);

}
