

/**
 * The Enclosure class represents a larger housing unit for a troop of monkeys of a specific species.
 * It provides a space for monkeys to live and interact as a group within their own troop.
 */
public class Enclosure extends AnimalHousing{
  protected String species;

  /**
   * Constructs a new Enclosure object for a specific species with the specified capacity.
   * @param species  The species of monkeys that the enclosure is designed for.
   * @param capacity The maximum number of monkeys the enclosure can accommodate.
   */
  public Enclosure(String species, int capacity) {
    super(capacity);
    this.species = species;
  }

}
