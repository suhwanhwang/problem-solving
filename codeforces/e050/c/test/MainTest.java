import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @org.junit.jupiter.api.Test
    void solve() {
        assertEquals(1000, Main.solve(1, 1000));
        assertEquals(1, Main.solve(1024, 1024));
        assertEquals(0, Main.solve(65536, 65536));
        assertEquals(2, Main.solve(999999, 1000001));

    }
}