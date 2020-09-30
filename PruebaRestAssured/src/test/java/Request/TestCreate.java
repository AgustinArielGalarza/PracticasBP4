package Request;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
//import org.json.JSONObject;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class TestCreate {

    @Test
    public void postTest() {

        // Existen distintas formas de pasarle la informacion en formato Json al Body.... ejemplo

        //1. con los formParam("","") estos unicamente se pasara clave y valor en tipo String
                /*Response resp = given()
                .formParam("nombre","REST")
                .formParam("apellido","assured")
                .formParam("nickname","RESTassured")
                .formParam("img","null")
                .formParam("direccion","asd")
                .formParam("dni",1231231221)
                .formParam("telefono",1212121212)
                .formParam("role","ADMIN_ROLE")
                .formParam("email","rest@assured.com")
                .formParam("cuit",1312321)
                .post("http://localhost:3000/usuario");*/

        //2. Desde una variable String con un formato especial, haciendo ilucion a un Json
                /*String bodymensaje = "{\n" +
                "  \"nombre\": \"REST cuatro\",\n" +
                "  \"apellido\": \"ssured cuatro\",\n" +
                "  \"nickname\": \"RESTassured cuatro\",\n" +
                "  \"img\": null,\n" +
                "  \"empresa\": \"BP4-4\",\n" +
                "  \"direccion\": \"asd1\",\n" +
                "  \"cuit\": 123112311213,\n" +
                "  \"dni\": 12312131113,\n" +
                "  \"telefono\": 12312113,\n" +
                "  \"role\": \"ADMIN_ROLE\",\n" +
                "  \"email\": \"REST22@assured.com\",\n" +
                "  \"cuit\": 1233122123,\n" +
                "  \"password\": \"123\"\n" +
                "}";*/


        //3. Con HashMap este a diferencia de los formParam hay mas posibilidades de jugar con los tipos de variables
            /* HashMap<String, String> map = new HashMap<String, String>();
            map.put("nombre","REST tres");
            map.put("apellido","assured tres");
            map.put("nickname","AgusRestAssured tres");
            map.put("img","null");
            map.put("empresa","BP4 tres");
            map.put("direccion","asd tres");
            map.put("email","agustRest@gmail.com"); */

        //4. JSONObject muy similar al HashMap pero en cambio este se requiere una libreria
            /*JSONObject message = new JSONObject();
            message.put("nombre","REST tres");
            message.put("apellido","assured tres");
            message.put("nickname","AgusRestAssured tres");
            message.put("img","null");
            message.put("empresa","BP4 tres");
            message.put("direccion","asd tres");
            message.put("email","agustRest@gmail.com");
            message.put("cuit", 123123); */

        //5. Con un archivo externo
        //.body(new File("./PutTestJson"))

        Response resp = given()
                .body(new File("./PostTestJson"))
                .contentType(ContentType.JSON)
                .post("http://localhost:3000/usuario");



        //se puede imprimir de esta manera
        resp.prettyPrint();

        // y tambien de esta manera
        /* String resJson = resp.asString();
        System.out.println(resJson); */

        //status de la peticion
        System.out.println("Status code is: " + resp.statusCode());
        //assertEquals al status. 200 en caso correcto
        assertEquals(resp.statusCode(), 200);
    }
}
