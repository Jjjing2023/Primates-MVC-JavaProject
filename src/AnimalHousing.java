import java.util.ArrayList;
import java.util.List;

/**
 * The AnimalHousing abstract class provides a common base for housing units in the primate sanctuary.
 * It defines methods for adding monkeys and retrieving the list of monkeys in the housing.
 * Subclasses of AnimalHousing must implement these methods.
 */
abstract class AnimalHousing implements Housing {
  protected int capacity;
  protected List<Monkey> monkeys;

  /**
   * Constructs a new AnimalHousing object with specified attributes.
   * @param capacity the capacity of the animal house.
   */
  public AnimalHousing(int capacity){
    this.capacity = capacity;
    this.monkeys = new ArrayList<>();
  }

  /**
   * Adds a Monkey to the housing unit.
   * @param monkey The Monkey object to be added to the housing unit.
   */
  public void addMonkey(Monkey monkey){
    if (monkeys.size() < capacity){
      monkeys.add(monkey);
    } else {
      System.out.println("Housing is full");
    }
  }

  /**
   * Retrieves the list of monkeys currently housed in the housing unit.
   * @return A List containing the Monkey objects in the housing unit.
   */
  public List<Monkey> getMonkeys(){
    return monkeys;
  }
}
