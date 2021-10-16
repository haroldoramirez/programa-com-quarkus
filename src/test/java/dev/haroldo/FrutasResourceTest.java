package dev.haroldo;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import javax.inject.Inject;

@QuarkusTest
@TestHTTPEndpoint(FrutasResource.class)
public class FrutasResourceTest {
	
	@Inject
	FrutasService frutasService;

	//Teste REST
    @Test
    public void testHelloEndpoint() {
        given()
          .when().get()
          .then()
             .statusCode(200)
             .body(is("[{\"id\":1,\"nome\":\"Maçã\",\"qtd\":5},{\"id\":2,\"nome\":\"Pêra\",\"qtd\":5},{\"id\":3,\"nome\":\"Laranja\",\"qtd\":5},{\"id\":4,\"nome\":\"Morango\",\"qtd\":5},{\"id\":5,\"nome\":\"Mamão\",\"qtd\":5},{\"id\":6,\"nome\":\"Pêssego\",\"qtd\":5},{\"id\":7,\"nome\":\"Ameixa\",\"qtd\":5}]"));
    }
    
    //Teste BEAN
    @Test
    public void testListFrutas() {
    	List<Fruta> list = frutasService.list();
    	assertFalse(list.isEmpty());
    }

}