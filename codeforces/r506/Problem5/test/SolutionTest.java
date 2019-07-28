import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void test01() throws IOException {
        testFileIO("t1_in.txt", "t1_out.txt");
    }

    @Test
    void test02() throws IOException {
        testFileIO("t2_in.txt", "t2_out.txt");
    }

    @Test
    void test03() throws IOException {
        testFileIO("t3_in.txt", "t3_out.txt");
    }

    private void testFileIO(String input, String output) throws IOException {
        System.setIn(new FileInputStream(new File(input)));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Solution.main(null);

        String ans = new String(Files.readAllBytes(Paths.get(output)));
        assertEquals(ans, outputStream.toString());
    }
}