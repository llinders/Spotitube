package dea.luclinders.businesslogic;

import java.util.Random;

public class TokenGeneratorImpl implements TokenGenerator {

    private final int AMOUNT_OF_SUBSTRINGS = 4;
    private final int SUBSTRING_LENGTH = 4;

    public String generateToken() {
        Random r = new Random();
        String token = "";
        for (int i = 0; i < AMOUNT_OF_SUBSTRINGS; i++) {
            token = i == 0 ? "" : token.concat("-");
            for (int j = 0; j < SUBSTRING_LENGTH; j++) {
                token = token.concat(String.valueOf(r.nextInt(9)));
            }
        }
        return token;
    }
}
