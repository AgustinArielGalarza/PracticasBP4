package mockito.velosidad;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class VerificaLimitesTest {

    private VerificaLimites verificaLimites;
    @Mock
    private Message message;

    @BeforeEach
    public void setUp(){
        verificaLimites = new VerificaLimites();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void calculaVelosidadTest (){
        Velosidades vel = new Velosidades(100,120);
        boolean resultado = verificaLimites.deVelosidad(vel);
        assertEquals( resultado ,true);
    }

    @Test
    public void calculaVelosidadErrorTest (){
        Velosidades vel = new Velosidades(120,100);
        boolean resultado = verificaLimites.deVelosidad(vel);
        assertEquals( resultado ,false);
    }

}