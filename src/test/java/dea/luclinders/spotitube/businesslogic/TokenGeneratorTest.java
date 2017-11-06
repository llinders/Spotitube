package dea.luclinders.spotitube.businesslogic;

import dea.luclinders.spotitube.businesslogic.session.TokenGenerator;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

public class TokenGeneratorTest {
    @InjectMocks
    private TokenGenerator tokenGenerator;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void generateToken_tokenIsRightLength() throws Exception {
        // Test
        String token = tokenGenerator.generateToken();

        // Verify
        assertEquals(14, token.length());
    }
}