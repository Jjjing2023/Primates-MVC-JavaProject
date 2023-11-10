public class SanctuaryApp {
  public static void main(String[] args) {
    Sanctuary sanctuary = new Sanctuary();
    SanctuaryView view = new SanctuaryView();
    SanctuaryController controller = new SanctuaryController(sanctuary, view);

    view.display();
  }
}
