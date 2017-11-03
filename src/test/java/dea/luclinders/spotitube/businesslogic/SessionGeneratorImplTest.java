package dea.luclinders.spotitube.businesslogic;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SessionGeneratorImplTest {
    private TokenGeneratorImpl tokenGenerator;

    @Before
    public void setup() {
        tokenGenerator = new TokenGeneratorImpl();
    }

    @Test
    public void generateToken_tokenIsRightLength() throws Exception {
        // Test
        String token = tokenGenerator.generateToken();

        // Verify
        assertEquals(19, token.length());
    }
}