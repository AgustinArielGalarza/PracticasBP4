package Request;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

//ACLARACION: Todos los TEST funcionan mandando response a una API local de mi propiedad que corre en el puerto 3000.
//Sin esta API no funcionará el TEST.

public class TestRequest {

    @Test
    public void getTest(){
        //mandamos un Response a la API local corriendo en el puerto 3000 con la dirreccion del controlador a la que apuntamos
        Response resp = given().get("http://localhost:3000/usuario");
        //Formas de imprimer
        //1
        resp.prettyPrint();
        //2
        //String resJson = resp.asString();
        //System.out.println(resJson);

        //status de la peticion
        System.out.println("Status code is: " + resp.statusCode());
        //assertEquals al status. 200 en caso correcto
        assertEquals(resp.statusCode(), 200);
    }
}
