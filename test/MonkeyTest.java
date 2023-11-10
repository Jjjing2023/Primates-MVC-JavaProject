import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MonkeyTest {

  @Test
  void testGetName() {
    Monkey monkey = new Monkey("George", MonkeySpecies.DRILL, "Male", "Medium", 25.0, 10, Food.EGGS);
    assertEquals(MonkeySpecies.DRILL, monkey.getSpecies());
  }

  @Test
  void testGetSpecies() {
    Monkey monkey = new Monkey("George", MonkeySpecies.DRILL, "Male", "Medium", 25.0, 10, Food.EGGS);
    assertEquals(MonkeySpecies.DRILL, monkey.getSpecies());
  }

  @Test
  void testGetSex() {
    Monkey monkey = new Monkey("George", MonkeySpecies.DRILL, "Male", "Medium", 25.0, 10, Food.EGGS);
    assertEquals("Male", monkey.getSex());
  }

  @Test
  void testGetSize() {
    Monkey monkey = new Monkey("George", MonkeySpecies.DRILL, "Male", "Medium", 25.0, 10, Food.EGGS);
    assertEquals("Medium", monkey.getSize());
  }

  @Test
  void testGetWeight() {
    Monkey monkey = new Monkey("George", MonkeySpecies.DRILL, "Male", "Medium", 25.0, 10, Food.EGGS);
    assertEquals(25.0, monkey.getWeight(), 0.01); // Allow a small delta for floating-point comparison
  }

  @Test
  void testGetAge() {
    Monkey monkey = new Monkey("George", MonkeySpecies.DRILL, "Male", "Medium", 25.0, 10, Food.EGGS);
    assertEquals(10, monkey.getAge());
  }

  @Test
  void testGetFavoriteFood() {
    Monkey monkey = new Monkey("George", MonkeySpecies.DRILL, "Male", "Medium", 25.0, 10, Food.EGGS);
    assertEquals(Food.EGGS, monkey.getFavoriteFood());
  }

  @Test
  void testNeedsMedicalAttention() {
    Monkey monkey = new Monkey("George", MonkeySpecies.DRILL, "Male", "Medium", 25.0, 10, Food.EGGS);
    assertFalse(monkey.needsMedicalAttention());
  }

  @Test
  void testReceiveMedicalAttention() {
    Monkey monkey = new Monkey("George", MonkeySpecies.DRILL, "Male", "Medium", 25.0, 10, Food.EGGS);
    assertFalse(monkey.needsMedicalAttention());
    monkey.receiveMedicalAttention();
    assertFalse(monkey.needsMedicalAttention());
  }

  @Test
  void testCompareTo() {
    Monkey monkey1 = new Monkey("George", MonkeySpecies.DRILL, "Male", "Medium", 25.0, 10, Food.EGGS);
    Monkey monkey2 = new Monkey("Molly", MonkeySpecies.GUEREZA, "Female", "Large", 150.0, 15, Food.NUTS);
    assertTrue(monkey1.compareTo(monkey2) < 0);
    assertTrue(monkey2.compareTo(monkey1) > 0);
    assertTrue(monkey1.compareTo(monkey1) == 0);
  }

  @Test
  void testToString() {
    Monkey monkey = new Monkey("George", MonkeySpecies.DRILL, "Male", "Medium", 25.0, 10, Food.EGGS);
    String expected = "Name: George\nSpecies: DRILL\nSex: Male\nSize: Medium\nWeight: 25.0 kg\nAge: 10 years\nFavorite Food: EGGS\nMedical Attention Needed: No";
    assertEquals(expected, monkey.toString());
  }

  @Test
  void testInvalidMonkeyCreation() {
    assertThrows(IllegalArgumentException.class, () -> {
      Monkey monkey = new Monkey("Invalid Monkey", MonkeySpecies.DRILL, "Male", "Medium", 25.0, 10, null);
    });
  }
}
