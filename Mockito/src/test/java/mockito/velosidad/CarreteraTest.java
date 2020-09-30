package mockito.velosidad;

import mockito.autos.Sudministros;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class CarreteraTest {

    @InjectMocks
    private Carretera carretera;
    @Mock
    private VerificaLimites verificaLimites;
    @Mock
    private Message message;
    @Captor
    private ArgumentCaptor<Integer> captor;



    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void subiraCarretera(){
        Velosidades vel = new Velosidades(100,120);
        given(verificaLimites.deVelosidad(vel)).willReturn(true);
        boolean resultado2 = carretera.manejar(vel);
        assertEquals(resultado2, true);
    }

    @Test
    public void subiraCarreteraErrorTest(){
        Velosidades vel = new Velosidades(130,110);
        given(verificaLimites.deVelosidad(vel)).willReturn(false);
        boolean resultado2 = carretera.manejar(vel);
        assertEquals(resultado2, false);
    }

}