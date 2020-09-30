package Request;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


public class TestDelete {

    @Test
    public void deleteTest(){
        //Es aqui donde tenemos que colocar como parametro el token de seguridad que generamos en el Login para que funcione el Delete.
        Response resp = given()
                .delete("http://localhost:3000/usuario/5f7354cfe005e218745aa19d?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c3VhcmlvIjp7InJvbGUiOiJVU0VSX1JPTEUiLCJfaWQiOiI1ZjczNTRjZmUwMDVlMjE4NzQ1YWExOWQiLCJub21icmUiOiJSRVNUIiwiYXBlbGxpZG8iOiJzc3VyZWQiLCJlbXByZXNhIjoiQlA0IiwiaW1nIjpudWxsLCJkaXJlY2Npb24iOiJhc2QiLCJjdWl0IjoiMTIzMzEyMyIsImRuaSI6IjEyMzEyMzExMyIsInRlbGVmb25vIjoiMTIzMTIxMyIsImVtYWlsIjoicmVzdEBhc3N1cmVkLmNvbSIsInBhc3N3b3JkIjoiPSkiLCJfX3YiOjB9LCJpYXQiOjE2MDEzOTQ3NDIsImV4cCI6MTYwMTQwOTE0Mn0.RuRV5t1HoIRDE9dNlUPqPiTa_TEuhkstW-cN5gDPOMs");

        resp.prettyPrint();
        //status de la peticion
        System.out.println("Status code is: " + resp.statusCode());
        //assertEquals al status. 200 en caso correcto
        assertEquals(resp.statusCode(), 200);

    }
}
