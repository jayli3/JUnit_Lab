import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GradeBookTest {

    private Gradebook g1;
    private Gradebook g2;
    private Gradebook g3;

    @BeforeEach
    public void setUp() {
        g1 = new Gradebook(5);
        g2 = new Gradebook(5);
        g3 = new Gradebook(5);

        g1.addScore(88.5);
        g1.addScore(95.0);
        g1.addScore(72.0);

        g2.addScore(80.0);
        g2.addScore(90.0);
    }

    @AfterEach
    public void tearDown() {
        g1 = null;
        g2 = null;
        g3 = null;
    }

    @Test
    public void testAddScore() {
        assertTrue(g1.toString().equals("88.5 95.0 72.0 "));
        assertTrue(g2.toString().equals("80.0 90.0 "));
        assertEquals(3, g1.getScoreSize());
        assertEquals(2, g2.getScoreSize());
    }

    @Test
    public void testSum() {
        assertEquals(255.5, g1.sum(), .0001); // 88.5 + 95.0 + 72.0
        assertEquals(170.0, g2.sum(), .0001); // 80.0 + 90.0
    }

    @Test
    public void testMinimum() {
        assertEquals(72.0, g1.minimum(), .001); // Lowest score in g1
        assertEquals(80.0, g2.minimum(), .001); // Lowest score in g2
    }

    @Test
    public void testFinalScore() {
        assertEquals(183.5, g1.finalScore(), .0001); // 255.5 - 72.0
        assertEquals(90.0, g2.finalScore(), .0001); // Only two scores, so the lowest is dropped
        assertEquals(0.0, g3.finalScore(), 0.001);
    }
}
