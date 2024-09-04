package es.inditex.test.mapper;

import es.inditex.test.model.Prices;
import es.inditex.test.model.api.ApiPrice;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PriceMapper {

  PriceMapper INSTANCE = Mappers.getMapper( PriceMapper.class );

  ApiPrice priceToApiPrice( Prices prices);

  List<ApiPrice> pricesToApiPrices( List<Prices> prices);


}
