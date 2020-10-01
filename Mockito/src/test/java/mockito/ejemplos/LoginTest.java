package mockito.ejemplos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;


class LoginTest {

    @InjectMocks
    private Login login;
    @Mock
    private ValidaUsr validaUsr;
    @Mock
    private Message message;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    //Estilo BDD
    @Test
    public void doLoginTest (){
        doAnswer(new Answer() {
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                String user = (String)invocationOnMock.getArguments()[0];
                assertEquals("agustin.galarza@bp-4.com",user);
                String password = (String)invocationOnMock.getArguments()[1];
                assertEquals("123",password);
                Message message = (Message)invocationOnMock.getArguments()[2];
                message.Succes("OK");
                return null;
            }
        }).when(validaUsr).login(anyString(), anyString(), any(Message.class));

        login.doLogin();
        verify(validaUsr ,times(1)).login((anyString()), anyString(), any(Message.class));
        assertEquals(login.isLogin, true);
    }

    @Test
    public void doLoginErrorTest (){
        doAnswer(new Answer() {
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                String user = (String)invocationOnMock.getArguments()[0];
                assertNotEquals("agustin.galarzabp-4.com",user);
                String password = (String)invocationOnMock.getArguments()[1];
                assertNotEquals("12223",password);
                Message message = (Message)invocationOnMock.getArguments()[2];
                message.Succes("Falso");
                return null;
            }
        }).when(validaUsr).login(anyString(), anyString(), any(Message.class));

        login.doLogin();
        verify(validaUsr ,times(1)).login((anyString()), anyString(), any(Message.class));
        assertEquals(login.isLogin, true);
    }
}