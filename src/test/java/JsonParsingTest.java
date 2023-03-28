import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class JsonParsingTest {
    private ClassLoader cl =  ZipTests.class.getClassLoader();

    @Test
    void jsonCleverTest() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        try (InputStream is = cl.getResourceAsStream("human.json");
             InputStreamReader isr = new InputStreamReader(is)) {

            HumanTests game = mapper.readValue(isr, HumanTests.class);

            Assertions.assertEquals("Morrowind", game.name);
            Assertions.assertEquals(2003, game.releasedata);
            Assertions.assertEquals(List.of("RPG","Action"), game.genre);
            Assertions.assertTrue(game.singleplayer);
            Assertions.assertEquals(999,game.price);
        }
    }
}
