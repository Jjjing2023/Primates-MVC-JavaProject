import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SanctuaryTest {

  private Sanctuary sanctuary;

  @BeforeEach
  void setUp() {
    sanctuary = new Sanctuary();
  }

  // test that verifies that monkeys can be added to isolation successfully
  @Test
  void testAddMonkeyToIsolation() {
    Monkey monkey = new Monkey("George", MonkeySpecies.DRILL, "Male", "Medium", 25.0, 10, Food.EGGS);
    sanctuary.addMonkeyToIsolation(monkey);

    assertEquals(1, sanctuary.getIsolationCageMonkeys().size());
    assertEquals(monkey, sanctuary.getIsolationCageMonkeys().get(0));
  }

  // test that verifies that a monkey cannot be added to isolation if it's full
  @Test
  void testAddMonkeyToFullIsolation() {
    for (int i = 0; i < Sanctuary.ISOLATION_CAPACITY; i++) {
      Monkey monkey = new Monkey("Monkey" + i, MonkeySpecies.DRILL, "Male", "Small", 10.0, 5, Food.EGGS);
      sanctuary.addMonkeyToIsolation(monkey);
    }

    Monkey extraMonkey = new Monkey("ExtraMonkey", MonkeySpecies.DRILL, "Female", "Medium", 15.0, 7, Food.EGGS);
    IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
      sanctuary.addMonkeyToIsolation(extraMonkey);
    });

    assertEquals("Isolation is full. Cannot add monkey.", exception.getMessage());
  }


  // test that verifies a monkey cannot be added to an enclosure if hasn't received medical attention
  @Test
  void testMoveMonkeysToEnclosuresWithUnattendedMonkey() {
    Monkey healthyMonkey = new Monkey("George", MonkeySpecies.DRILL, "Male", "Medium", 25.0, 10, Food.EGGS);
    Monkey unattendedMonkey = new Monkey("Molly", MonkeySpecies.MANGABEY, "Female", "Small", 12.0, 8, Food.EGGS);

    sanctuary.addMonkeyToIsolation(healthyMonkey);
    sanctuary.addMonkeyToIsolation(unattendedMonkey);

    unattendedMonkey.receiveMedicalAttention(); // Marking the monkey as attended

    sanctuary.moveMonkeysToEnclosures();

    assertEquals(1, sanctuary.getEnclosureMonkeys().size());
    assertTrue(sanctuary.getEnclosureMonkeys().contains(healthyMonkey));
    assertFalse(sanctuary.getEnclosureMonkeys().contains(unattendedMonkey));
  }


  // test that verifies a monkey can be moved from isolation to enclosure successfully
  @Test
  void testMoveMonkeysToEnclosures() {
    Monkey monkey = new Monkey("George", MonkeySpecies.DRILL, "Male", "Medium", 25.0, 10, Food.EGGS);
    sanctuary.addMonkeyToIsolation(monkey);
    assertEquals(1, sanctuary.getIsolationCageMonkeys().size());

    sanctuary.moveMonkeysToEnclosures();
    assertEquals(0, sanctuary.getIsolationCageMonkeys().size());
    assertEquals(1, sanctuary.getEnclosureMonkeys().size());
  }


  @Test
  void testGetAllMonkeysList() {
    Monkey monkey1 = new Monkey("George", MonkeySpecies.DRILL, "Male", "Medium", 25.0, 10, Food.EGGS);
    Monkey monkey2 = new Monkey("Molly", MonkeySpecies.MANGABEY, "Female", "Small", 12.0, 8, Food.EGGS);

    sanctuary.addMonkeyToIsolation(monkey1);
    sanctuary.addMonkeyToIsolation(monkey2);

    assertEquals(2, sanctuary.getAllMonkeysList().size());
  }

  @Test
  void testGetAlphabeticallySortedMonkeys() {
    Monkey monkey1 = new Monkey("George", MonkeySpecies.DRILL, "Male", "Medium", 25.0, 10, Food.EGGS);
    Monkey monkey2 = new Monkey("Molly", MonkeySpecies.MANGABEY, "Female", "Small", 12.0, 8, Food.EGGS);

    sanctuary.addMonkeyToIsolation(monkey1);
    sanctuary.addMonkeyToIsolation(monkey2);

    assertEquals("George", sanctuary.getAlphabeticallySortedMonkeys().get(0).getName());
  }

  @Test
  void testGetIsolationCageMonkeys() {
    Monkey monkey = new Monkey("George", MonkeySpecies.DRILL, "Male", "Medium", 25.0, 10, Food.EGGS);
    sanctuary.addMonkeyToIsolation(monkey);

    assertEquals(1, sanctuary.getIsolationCageMonkeys().size());
  }

  @Test
  void testGetEnclosureMonkeys() {
    Monkey monkey = new Monkey("George", MonkeySpecies.DRILL, "Male", "Medium", 25.0, 10, Food.EGGS);
    sanctuary.addMonkeyToIsolation(monkey);
    sanctuary.moveMonkeysToEnclosures();

    assertEquals(1, sanctuary.getEnclosureMonkeys().size());
  }
}
