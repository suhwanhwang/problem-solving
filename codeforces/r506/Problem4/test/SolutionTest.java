import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringTokenizer;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void test01() {
        testFileIO("test1_in.txt", "test1_out.txt");
    }

    @Test
    void test02() {
        testFileIO("test2_in.txt", "test2_out.txt");
    }

    @Test
    void test03() {
        testFileIO("test3_in.txt", "test3_out.txt");
    }

    @Test
    void test04() {
        testFileIO("test4_in.txt", "test4_out.txt");
    }

    private void testFileIO(String input, String output) {
        try {
            System.setIn(new FileInputStream(new File(input)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Solution.main(null);

        try {
            String ans = new String(Files.readAllBytes(Paths.get(output)));
            assertEquals(ans, outputStream.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}