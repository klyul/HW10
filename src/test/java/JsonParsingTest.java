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

            HumanTests humanTests = mapper.readValue(isr, HumanTests.class);

            Assertions.assertEquals("Yuliya", humanTests.name);
            Assertions.assertEquals(30, humanTests.age);
            Assertions.assertEquals(List.of("Volleyball", "Wine"), humanTests.hobbies);
            Assertions.assertTrue(humanTests.isClever);
            Assertions.assertEquals(3112453425L,humanTests.passport.number);
            Assertions.assertEquals("14 JAN 2021",humanTests.passport.issueDate);
        }
    }
}
