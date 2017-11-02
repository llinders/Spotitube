package dea.luclinders.businesslogic;

import java.util.Random;

public class TokenGeneratorImpl implements TokenGenerator {

    private final int AMOUNT_OF_PARTITIONS = 3;
    private final int PARTITION_LENGTH = 4;

    public String generateToken() {
        Random r = new Random();
        String token = "";
        for (int i = 0; i < AMOUNT_OF_PARTITIONS; i++) {
            token = i == 0 ? "" : token.concat("-");
            for (int j = 0; j < PARTITION_LENGTH; j++) {
                token = token.concat(String.valueOf(r.nextInt(10)));
            }
        }
        return token;
    }
}
