import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sanctuary {

  protected static final int ISOLATION_CAPACITY = 20;
  private List<Monkey> isolationCages;
  private List<Monkey> enclosure;

  public Sanctuary() {
    this.isolationCages = new ArrayList<>();
    this.enclosure = new ArrayList<>();
  }


  public void addMonkeyToIsolation(Monkey monkey) {
    if (isolationCages.size() < ISOLATION_CAPACITY) {
      isolationCages.add(monkey);
    } else {
      throw new IllegalStateException("Isolation is full. Cannot add monkey.");
    }
  }

  public void moveMonkeysToEnclosures() {
    List<Monkey> monkeysToMove = new ArrayList<>();
    for (Monkey monkey : isolationCages) {
      if (monkey.needsMedicalAttention()) {
        continue; // Skip monkeys needing medical attention
      }
      monkeysToMove.add(monkey);
    }
    enclosure.addAll(isolationCages);
    isolationCages.removeAll(monkeysToMove);
  }

  public List<Monkey> getAllMonkeysList() {
    List<Monkey> allMonkeys = new ArrayList<>();
    allMonkeys.addAll(isolationCages);
    allMonkeys.addAll(enclosure);

    return allMonkeys;

  }

  public List<Monkey> getAlphabeticallySortedMonkeys() {
    List<Monkey> allMonkeys = getAllMonkeysList();
    Collections.sort(allMonkeys);
    return allMonkeys;
  }

  public List<Monkey> getIsolationCageMonkeys() {
    return new ArrayList<>(isolationCages);
  }

  public List<Monkey> getEnclosureMonkeys() {
    return new ArrayList<>(enclosure);
  }
}
