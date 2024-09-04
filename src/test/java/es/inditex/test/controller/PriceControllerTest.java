package es.inditex.test.controller;

import static io.restassured.RestAssured.with;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Testing Price controller")
class PriceControllerTest {

  @LocalServerPort
  private Integer port;

  @BeforeEach
  public void setup() {
    RestAssured.baseURI = "http://localhost:" + port + "/prices/v1";
  }
  @Test
  void findPricesFor14061000() {
    with().contentType("application/json").when().pathParam("product_id", "35455")
        .queryParam("date","2020-06-14T10:00:00")
        .queryParam("brand_id","1")
        .request("GET", "/prices/{product_id}").then().statusCode(200)
        .assertThat().body("price",equalTo(35.5f));
  }

  @Test
  void findPricesFor14061600() {
    with().contentType("application/json").when().pathParam("product_id", "35455")
        .queryParam("date","2020-06-14T16:00:00")
        .queryParam("brand_id","1")
        .request("GET", "/prices/{product_id}").then().statusCode(200)
        .assertThat().body("price",equalTo(25.45f));
  }

  @Test
  void findPricesFor14062100() {
    with().contentType("application/json").when().pathParam("product_id", "35455")
        .queryParam("date","2020-06-14T21:00:00")
        .queryParam("brand_id","1")
        .request("GET", "/prices/{product_id}").then().statusCode(200)
        .assertThat().body("price",equalTo(35.5f));
  }

  @Test
  void findPricesFor15061000() {
    with().contentType("application/json").when().pathParam("product_id", "35455")
        .queryParam("date","2020-06-15T10:00:00")
        .queryParam("brand_id","1")
        .request("GET", "/prices/{product_id}").then().statusCode(200)
        .assertThat().body("price",equalTo(30.5f));
  }

  @Test
  void findPricesFor16062100() {
    with().contentType("application/json").when().pathParam("product_id", "35455")
        .queryParam("date","2020-06-16T21:00:00")
        .queryParam("brand_id","1")
        .request("GET", "/prices/{product_id}").then().statusCode(200)
        .assertThat().body("price",equalTo(38.95f));
  }
}