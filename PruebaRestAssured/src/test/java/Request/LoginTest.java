package Request;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


public class LoginTest {

    @Test
    public void leginTest(){
    //nos loguiamos para obtener el token de seguridad

        Response resp = given()
                .body(new File("./LoginTest"))
                .contentType(ContentType.JSON)
                .post("http://localhost:3000/login");

        resp.prettyPrint();
        //status de la peticion
        System.out.println("Status code is: " + resp.statusCode());
        //assertEquals al status. 200 en caso correcto
        assertEquals(resp.statusCode(), 200);

        //copiamos el token que nos genera el Json de la respuesta y lo colocaremos en las siguientes pruebas
    }
}
