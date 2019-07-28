import java.io.ByteArrayInputStream;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @org.junit.jupiter.api.Test
    void main() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        sb.append("300000\n");
        for (int i = 0; i < 300000; ++i) {
            sb.append(random.nextInt(15000000));
            sb.append(" ");
        }
        sb.append("\n");
        ByteArrayInputStream in = new ByteArrayInputStream(sb.toString().getBytes());
        System.setIn(in);
        long tick = System.currentTimeMillis();
        Main.main(null);
        System.out.println("time = " +(System.currentTimeMillis() - tick));
    }
}