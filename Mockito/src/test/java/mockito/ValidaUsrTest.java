package mockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class ValidaUsrTest {

    private ValidaUsr validaUsr;
    @Mock
    private Message message;

    @BeforeEach
    public void setUp(){
        validaUsr = new ValidaUsr();
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void validaTest() {
        validaUsr.login("agustin.galarza@bp-4.com", "123",message);
        verify(message).Succes("Usuario Exitoso!");
    }

    @Test
    public void validaUsrErrorTest() {
        validaUsr.login("agustin.galarzabp-4.com", "1234",message);
        verify(message).onFail("Usuario Erroneo!");
    }

}