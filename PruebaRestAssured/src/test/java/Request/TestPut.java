package Request;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class TestPut {

    @Test
    public void putTest(){
        //Es aqui donde tenemos que colocar como parametro el token de seguridad que generamos en el Login para que funcione el Put.
        Response resp = given()
                .body(new File("./PutTestJson"))
                .contentType(ContentType.JSON)
                .put("http://localhost:3000/usuario/5f735943e005e218745aa19e?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c3VhcmlvIjp7InJvbGUiOiJVU0VSX1JPTEUiLCJfaWQiOiI1ZjczNTk0M2UwMDVlMjE4NzQ1YWExOWUiLCJub21icmUiOiJSRVNUIiwiYXBlbGxpZG8iOiJzc3VyZWQiLCJlbXByZXNhIjoiQlA0IiwiaW1nIjpudWxsLCJkaXJlY2Npb24iOiJhc2QiLCJjdWl0IjoiMTIzMzEyMyIsImRuaSI6IjEyMzEyMzExMyIsInRlbGVmb25vIjoiMTIzMTIxMyIsImVtYWlsIjoicmVzdEBhc3N1cmVkLmNvbSIsInBhc3N3b3JkIjoiPSkiLCJfX3YiOjB9LCJpYXQiOjE2MDEzOTUyNjksImV4cCI6MTYwMTQwOTY2OX0.Bg_1-l9IEglaNrNu2WiD8ZfUtng3p7PjOYusIjDKGoo");


        resp.prettyPrint();
        //status de la peticion
        System.out.println("Status code is: " + resp.statusCode());
        //assertEquals al status. 200 en caso correcto
        assertEquals(resp.statusCode(), 200);
    }
}
