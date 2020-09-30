package mockito.autos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

class VerificaSudministrosTest {

    private VerificaSudministros verificaSudministros;
    @Mock
    private Message message;

    @BeforeEach
    public void setUp(){
        verificaSudministros = new VerificaSudministros();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void enciendeTest(){
        Sudministros sudministros = new Sudministros(80,50);
        verificaSudministros.estado(sudministros, message);
        verify(message).Encender("Sudministors llenos");
    }

    @Test
    public void enciendeErrorTest(){
        Sudministros sudministros = new Sudministros(20,510);
        verificaSudministros.estado(sudministros, message);
        verify(message).Fallar("Faltan sudministors");
    }
}