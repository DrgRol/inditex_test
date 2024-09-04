package es.inditex.test.dto;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class FilterDto {

  private Long productId;
  private LocalDateTime date;
  private Integer brandId;

}
