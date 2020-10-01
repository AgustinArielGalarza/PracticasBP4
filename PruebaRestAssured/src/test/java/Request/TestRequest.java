package Request;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.io.File;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

//ACLARACION: Todos los TEST funcionan mandando response a una API local de mi propiedad que corre en el puerto 3000.
//Sin esta API no funcionará el TEST.

public class TestRequest {

    @Test
    public void get200Test(){
        Response resp = given().get("http://localhost:3000/usuario"); //mandamos un Response a la API local corriendo en el puerto 3000 con la dirreccion del controlador a la que apuntamos
        resp.prettyPrint();
        System.out.println("Status code is: " + resp.statusCode()); //status de la peticion
        assertEquals(resp.statusCode(), 200); //assertEquals al status. 200 en caso correcto
    }

    @Test
    public void getError404Test(){
        Response resp = given().get("http://localhost:3000/usuari"); //mandamos un Response a la API local corriendo en el puerto 3000 con la dirreccion del controlador a la que apuntamos
        resp.prettyPrint();
        System.out.println("Status code is: " + resp.statusCode());
        assertEquals(resp.statusCode(), 404);
    }

    @Test
    public void post200Test() {
        Response resp = given()
                .body(new File("./PostJson"))
                .contentType(ContentType.JSON)
                .post("http://localhost:3000/usuario");
        resp.prettyPrint();
        System.out.println("Status code is: " + resp.statusCode());
        assertEquals(resp.statusCode(), 200);
    }

    @Test
    public void post400Test() {
        Response resp = given()
                .body(new File("./PostJson400"))
                .contentType(ContentType.JSON)
                .post("http://localhost:3000/usuario");
        resp.prettyPrint();
        System.out.println("Status code is: " + resp.statusCode());
        assertEquals(resp.statusCode(), 400);
    }

    @Test
    public void post404Test() {
        Response resp = given()
                .body(new File("./PostJson"))
                .contentType(ContentType.JSON)
                .post("http://localhost:3000/usuari");
        resp.prettyPrint();
        System.out.println("Status code is: " + resp.statusCode());
        assertEquals(resp.statusCode(), 404);
    }

    @Test
    public void legin200Test(){
        Response resp = given()                         //nos loguiamos para obtener el token de seguridad
                .body(new File("./LoginJson"))
                .contentType(ContentType.JSON)
                .post("http://localhost:3000/login");
        resp.prettyPrint();
        System.out.println("Status code is: " + resp.statusCode());
        assertEquals(resp.statusCode(), 200);
        //copiamos el token que nos genera el Json de la respuesta y lo colocaremos en las siguientes pruebas
    }

    @Test
    public void legin404Test(){
        Response resp = given()                         //nos loguiamos para obtener el token de seguridad
                .body(new File("./LoginJson"))
                .contentType(ContentType.JSON)
                .post("http://localhost:3000/logi");
        resp.prettyPrint();
        System.out.println("Status code is: " + resp.statusCode());
        assertEquals(resp.statusCode(), 404);
        //copiamos el token que nos genera el Json de la respuesta y lo colocaremos en las siguientes pruebas
    }

    @Test
    public void legin400Test(){
        Response resp = given()                         //nos loguiamos para obtener el token de seguridad
                .body(new File("./LoginJson400"))
                .contentType(ContentType.JSON)
                .post("http://localhost:3000/login");
        resp.prettyPrint();
        System.out.println("Status code is: " + resp.statusCode());
        assertEquals(resp.statusCode(), 400);
        //copiamos el token que nos genera el Json de la respuesta y lo colocaremos en las siguientes pruebas
    }

    @Test
    public void put200Test(){
        Response resp = given() //Es aqui donde tenemos que colocar como parametro el token de seguridad que generamos en el Login para que funcione el Put.
                .body(new File("./PutJson"))
                .contentType(ContentType.JSON)
                .put("http://localhost:3000/usuario/5f735943e005e218745aa19e?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c3VhcmlvIjp7InJvbGUiOiJVU0VSX1JPTEUiLCJfaWQiOiI1ZjczNTk0M2UwMDVlMjE4NzQ1YWExOWUiLCJub21icmUiOiJSRVNUIiwiYXBlbGxpZG8iOiJzc3VyZWQiLCJlbXByZXNhIjoiQlA0IiwiaW1nIjpudWxsLCJkaXJlY2Npb24iOiJhc2QiLCJjdWl0IjoiMTIzMzEyMyIsImRuaSI6IjEyMzEyMzExMyIsInRlbGVmb25vIjoiMTIzMTIxMyIsImVtYWlsIjoicmVzdEBhc3N1cmVkLmNvbSIsInBhc3N3b3JkIjoiPSkiLCJfX3YiOjB9LCJpYXQiOjE2MDEzOTUyNjksImV4cCI6MTYwMTQwOTY2OX0.Bg_1-l9IEglaNrNu2WiD8ZfUtng3p7PjOYusIjDKGoo");
        resp.prettyPrint();
        System.out.println("Status code is: " + resp.statusCode());
        assertEquals(resp.statusCode(), 200);
    }

    @Test
    public void put404Test(){
        Response resp = given()
                .body(new File("./PutJson"))
                .contentType(ContentType.JSON)
                .put("http://localhost:3000/usuari/5f735943e005e218745aa19e?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c3VhcmlvIjp7InJvbGUiOiJVU0VSX1JPTEUiLCJfaWQiOiI1ZjczNTk0M2UwMDVlMjE4NzQ1YWExOWUiLCJub21icmUiOiJSRVNUIiwiYXBlbGxpZG8iOiJzc3VyZWQiLCJlbXByZXNhIjoiQlA0IiwiaW1nIjpudWxsLCJkaXJlY2Npb24iOiJhc2QiLCJjdWl0IjoiMTIzMzEyMyIsImRuaSI6IjEyMzEyMzExMyIsInRlbGVmb25vIjoiMTIzMTIxMyIsImVtYWlsIjoicmVzdEBhc3N1cmVkLmNvbSIsInBhc3N3b3JkIjoiPSkiLCJfX3YiOjB9LCJpYXQiOjE2MDEzOTUyNjksImV4cCI6MTYwMTQwOTY2OX0.Bg_1-l9IEglaNrNu2WiD8ZfUtng3p7PjOYusIjDKGoo");
        resp.prettyPrint();
        System.out.println("Status code is: " + resp.statusCode());
        assertEquals(resp.statusCode(), 404);
    }

    @Test
    public void put400Test(){
        Response resp = given()
                .body(new File("./PutJson"))
                .contentType(ContentType.JSON)
                .put("http://localhost:3000/usuari/5f735943e00e218745aa19e?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c3VhcmlvIjp7InJvbGUiOiJVU0VSX1JPTEUiLCJfaWQiOiI1ZjczNTk0M2UwMDVlMjE4NzQ1YWExOWUiLCJub21icmUiOiJSRVNUIiwiYXBlbGxpZG8iOiJzc3VyZWQiLCJlbXByZXNhIjoiQlA0IiwiaW1nIjpudWxsLCJkaXJlY2Npb24iOiJhc2QiLCJjdWl0IjoiMTIzMzEyMyIsImRuaSI6IjEyMzEyMzExMyIsInRlbGVmb25vIjoiMTIzMTIxMyIsImVtYWlsIjoicmVzdEBhc3N1cmVkLmNvbSIsInBhc3N3b3JkIjoiPSkiLCJfX3YiOjB9LCJpYXQiOjE2MDEzOTUyNjksImV4cCI6MTYwMTQwOTY2OX0.Bg_1-l9IEglaNrNu2WiD8ZfUtng3p7PjOYusIjDKGoo");
        resp.prettyPrint();
        System.out.println("Status code is: " + resp.statusCode());
        assertEquals(resp.statusCode(), 400);
    }

    @Test
    public void delete200Test(){
        Response resp = given()
                .delete("http://localhost:3000/usuario/5f7354cfe005e218745aa19d?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c3VhcmlvIjp7InJvbGUiOiJVU0VSX1JPTEUiLCJfaWQiOiI1ZjczNTRjZmUwMDVlMjE4NzQ1YWExOWQiLCJub21icmUiOiJSRVNUIiwiYXBlbGxpZG8iOiJzc3VyZWQiLCJlbXByZXNhIjoiQlA0IiwiaW1nIjpudWxsLCJkaXJlY2Npb24iOiJhc2QiLCJjdWl0IjoiMTIzMzEyMyIsImRuaSI6IjEyMzEyMzExMyIsInRlbGVmb25vIjoiMTIzMTIxMyIsImVtYWlsIjoicmVzdEBhc3N1cmVkLmNvbSIsInBhc3N3b3JkIjoiPSkiLCJfX3YiOjB9LCJpYXQiOjE2MDEzOTQ3NDIsImV4cCI6MTYwMTQwOTE0Mn0.RuRV5t1HoIRDE9dNlUPqPiTa_TEuhkstW-cN5gDPOMs");

        resp.prettyPrint();
        System.out.println("Status code is: " + resp.statusCode());
        assertEquals(resp.statusCode(), 200);

    }

    @Test
    public void delete404Test(){
        Response resp = given()  //Es aqui donde tenemos que colocar como parametro el token de seguridad que generamos en el Login para que funcione el Delete.
                .delete("http://localhost:3000/usuario/5f7354cfe005e218745aa19d?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c3VhcmlvIjp7InJvbGUiOiJVU0VSX1JPTEUiLCJfaWQiOiI1ZjczNTRjZmUwMDVlMjE4NzQ1YWExOWQiLCJub21icmUiOiJSRVNUIiwiYXBlbGxpZG8iOiJzc3VyZWQiLCJlbXByZXNhIjoiQlA0IiwiaW1nIjpudWxsLCJkaXJlY2Npb24iOiJhc2QiLCJjdWl0IjoiMTIzMzEyMyIsImRuaSI6IjEyMzEyMzExMyIsInRlbGVmb25vIjoiMTIzMTIxMyIsImVtYWlsIjoicmVzdEBhc3N1cmVkLmNvbSIsInBhc3N3b3JkIjoiPSkiLCJfX3YiOjB9LCJpYXQiOjE2MDEzOTQ3NDIsImV4cCI6MTYwMTQwOTE0Mn0.RuRV5t1HoIRDE9dNlUPqPiTa_TEuhkstW-cN5gDPOMs");
        resp.prettyPrint();
        System.out.println("Status code is: " + resp.statusCode());
        assertEquals(resp.statusCode(), 404);
    }

    @Test
    public void delete400Test(){
        Response resp = given()  //Es aqui donde tenemos que colocar como parametro el token de seguridad que generamos en el Login para que funcione el Delete.
                .delete("http://localhost:3000/usuario/5f7354cfe00518745aa19d?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c3VhcmlvIjp7InJvbGUiOiJVU0VSX1JPTEUiLCJfaWQiOiI1ZjczNTRjZmUwMDVlMjE4NzQ1YWExOWQiLCJub21icmUiOiJSRVNUIiwiYXBlbGxpZG8iOiJzc3VyZWQiLCJlbXByZXNhIjoiQlA0IiwiaW1nIjpudWxsLCJkaXJlY2Npb24iOiJhc2QiLCJjdWl0IjoiMTIzMzEyMyIsImRuaSI6IjEyMzEyMzExMyIsInRlbGVmb25vIjoiMTIzMTIxMyIsImVtYWlsIjoicmVzdEBhc3N1cmVkLmNvbSIsInBhc3N3b3JkIjoiPSkiLCJfX3YiOjB9LCJpYXQiOjE2MDEzOTQ3NDIsImV4cCI6MTYwMTQwOTE0Mn0.RuRV5t1HoIRDE9dNlUPqPiTa_TEuhkstW-cN5gDPOMs");
        resp.prettyPrint();
        System.out.println("Status code is: " + resp.statusCode());
        assertEquals(resp.statusCode(), 400);
    }
}
