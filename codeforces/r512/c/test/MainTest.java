import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @org.junit.jupiter.api.Test
    void solve() {
        Random random = new Random();
        for (int j = 0; j < 1000; ++j) {
            int n = 10;
            int[] num = new int[n];
            for (int i = 0; i < n; ++i) {
                num[i] = random.nextInt(10);
            }
            System.out.print(Arrays.toString(num));
            System.out.println(Main.solve(num));
        }
    }
}