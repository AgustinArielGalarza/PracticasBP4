package mockito.autos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class EncenderTest {

    @InjectMocks
    private Encender encender;
    @Mock
    private VerificaSudministros verificaSudministros;
    @Mock
    private Message message;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void darArranqueTest (){
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Sudministros sudm = (Sudministros)invocationOnMock.getArguments()[0];
                assertEquals(80,sudm.getNafta());
                assertEquals(70,sudm.getBateria());
                Message message = (Message)invocationOnMock.getArguments()[1];
                message.Encender("Prendio!");
                return null;
            }
        }).when(verificaSudministros).estado(any(Sudministros.class), any(Message.class));

        Sudministros sudministros = new Sudministros(80,70);
        encender.darArranque(sudministros);
        verify(verificaSudministros, times(1)).estado(any(Sudministros.class), any(Message.class));
        assertEquals(encender.prendio, true);
    }

    @Test
    public void darArranqueErrorTest (){
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Sudministros sudm = (Sudministros)invocationOnMock.getArguments()[0];
                assertEquals(20,sudm.getNafta());
                assertEquals(10,sudm.getBateria());
                Message message = (Message)invocationOnMock.getArguments()[1];
                message.Encender("Motor fallo!!");
                return null;
            }
        }).when(verificaSudministros).estado(any(Sudministros.class), any(Message.class));

        Sudministros sudministros = new Sudministros(20,10);
        encender.darArranque(sudministros);
        verify(verificaSudministros, times(1)).estado(any(Sudministros.class), any(Message.class));
        assertEquals(encender.prendio, true);
    }
}