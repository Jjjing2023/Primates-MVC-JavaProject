import java.util.List;

/**
 * The Housing interface represents a housing unit for monkeys in the primate sanctuary.
 * It defines methods for adding monkeys and retrieving the list of monkeys in the housing.
 */
public interface Housing {

  /**
   * Adds a Monkey to the housing unit.
   * @param monkey The Monkey object to be added to the housing unit.
   */
  void addMonkey(Monkey monkey);

  /**
   * Retrieves the list of monkeys currently housed in the housing unit.
   * @return A List containing the Monkey objects in the housing unit.
   */
  List<Monkey> getMonkeys();
}
