package es.inditex.test.service.impl;

import es.inditex.test.dto.FilterDto;
import es.inditex.test.mapper.PriceMapper;
import es.inditex.test.model.Prices;
import es.inditex.test.model.api.ApiPrice;
import es.inditex.test.repository.PriceRepository;
import es.inditex.test.service.PriceService;
import java.util.Comparator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PriceServiceImpl implements PriceService {

  private final PriceRepository priceRepository;

  @Override
  public ApiPrice getPrice(FilterDto filter) {
    return PriceMapper.INSTANCE.priceToApiPrice(
        priceRepository.findPrices(
                filter.getDate(), filter.getBrandId(), filter.getProductId()).stream().max(Comparator.comparing(
            Prices::getPriority)).orElseGet(null));
  }
}
