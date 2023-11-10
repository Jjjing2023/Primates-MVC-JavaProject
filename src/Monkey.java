import java.util.EnumSet;

/**
 * The Monkey class represents an individual primate residing in the sanctuary.
 * It encapsulates attributes such as name, species, sex, size, weight, age, and favorite food.
 */
public class Monkey implements Comparable<Monkey>{
  private String name;
  private MonkeySpecies species;
  private String sex;
  private String size;
  private double weight;
  private int age;
  private Food favoriteFood;
  private boolean isMedicalAttentionNeeded;


  /**
   * Constructs a new Monkey object with specified attributes.
   * @param name         The name of the monkey.
   * @param species      The species of the monkey.
   * @param sex          The sex of the monkey.
   * @param size         The size category of the monkey.
   * @param weight       The weight of the monkey in kilograms.
   * @param age          The approximate age of the monkey in years.
   * @param favoriteFood The favorite food of the monkey.
   */
  public Monkey(String name, MonkeySpecies species, String sex, String size, double weight, int age,
                Food favoriteFood){
    if (name == null || name.isEmpty()){
      throw new IllegalArgumentException("Name cannot be null or empty");
    }
    if (!sex.equals("Male") && !sex.equals("Female")){
      throw new IllegalArgumentException("sex must be 'Male' or 'Female'");
    }
    if (!EnumSet.allOf(MonkeySpecies.class).contains(species)){
      throw new IllegalArgumentException("Invalid species");
    }
    if (!EnumSet.allOf(Food.class).contains(favoriteFood)){
      throw new IllegalArgumentException("Invalid favorite food");
    }
    this.name = name;
    this.species = species;
    this.sex = sex;
    this.size = size;
    this.weight = weight;
    this.age = age;
    this.favoriteFood = favoriteFood;
    this.isMedicalAttentionNeeded = false;
  }

  /**
   * Retrieves the name of the monkey.
   * @return The name of the monkey.
   */
  public String getName() {
    return name;
  }

  /**
   * Retrieves the species of the monkey.
   * @return The species of the monkey.
   */
  public MonkeySpecies getSpecies() {
    return species;
  }

  /**
   * Retrieves the sex of the monkey.
   * @return The sex of the monkey.
   */
  public String getSex() {
    return sex;
  }

  /**
   * Retrieves the size category of the monkey.
   * @return The size category of the monkey.
   */
  public String getSize() {
    return size;
  }

  /**
   * Retrieves the weight of the monkey in kilograms.
   * @return The weight of the monkey.
   */
  public double getWeight() {
    return weight;
  }

  /**
   * Retrieves the approximate age of the monkey in years.
   * @return The age of the monkey.
   */
  public int getAge() {
    return age;
  }

  /**
   * Retrieves the favorite food of the monkey.
   * @return The favorite food of the monkey.
   */
  public Food getFavoriteFood() {
    return favoriteFood;
  }

  /**
   * Checks if the monkey needs medical attention.
   * @return True if the monkey needs medical attention, false otherwise.
   */
  public boolean needsMedicalAttention(){
    return isMedicalAttentionNeeded;
  }

  /**
   * Receives medical attention, indicating that the monkey no longer needs it.
   */
  public void receiveMedicalAttention(){
    isMedicalAttentionNeeded = false;
  }

  @Override
  public int compareTo(Monkey otherMonkey) {
    return this.getName().compareTo(otherMonkey.getName());
  }

  public String toString(){
    return "Name: " + name +
            "\nSpecies: " + species +
            "\nSex: " + sex +
            "\nSize: " + size +
            "\nWeight: " + weight + " kg" +
            "\nAge: " + age + " years" +
            "\nFavorite Food: " + favoriteFood +
            "\nMedical Attention Needed: " + (isMedicalAttentionNeeded ? "Yes" : "No");

  }
}
