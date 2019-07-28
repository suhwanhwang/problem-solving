import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @org.junit.jupiter.api.Test
    void main() {
        ByteArrayInputStream in = new ByteArrayInputStream(new String("5 10\n" +
                "5 7\n" +
                "11 12\n" +
                "16 20\n" +
                "25 26\n" +
                "30 33\n").getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setIn(in);
        System.setOut(new PrintStream(out));
        Main.main(null);
        assertEquals("18\n", out.toString());
    }
}