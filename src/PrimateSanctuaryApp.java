public class PrimateSanctuaryApp {
  public static void main(String[] args){
    Sanctuary sanctuary = new Sanctuary();
    SanctuaryController controller = new SanctuaryController(sanctuary, null);
  }

}
