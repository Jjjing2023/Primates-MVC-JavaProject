import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SanctuaryController {
  private Sanctuary model;
  private SanctuaryView view;
  private Monkey selectedIsolationMonkey;

  public SanctuaryController(Sanctuary model, SanctuaryView view) {
    this.model = model;
    this.view = view;
    selectedIsolationMonkey = null;

    view.setRegisterButtonListener(new RegisterMonkey());
    view.setMoveButtonListener(new MoveMonkeys());
    view.addIsolationListSelectionListener(new IsolationListSelectionListener());

    updateViewLists();
  }


  class RegisterMonkey implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
      if (model.getIsolationCageMonkeys().size() >= 20){
        view.displayErrorMessage("Isolation is full!");
      } else {
        String name = view.getMonkeyName();
        String sex = view.getMonkeySex();
        String species = view.getMonkeySpecies();
        String size = view.getMonkeySize();
        Double weight;
        try {
          weight = Double.valueOf(view.getMonkeyWeight());
        } catch (NumberFormatException ex) {
          view.displayErrorMessage("Invalid weight input!");
          return;
        }

        int age;
        try {
          age = Integer.parseInt(view.getMonkeyAge());
        } catch (NumberFormatException ex) {
          view.displayErrorMessage("Invalid age input!");
          return;
        }

        Food favFood;
        try {
          favFood = Food.valueOf(view.getMonkeyFavFood());
        } catch (IllegalArgumentException ex) {
          view.displayErrorMessage("Invalid favorite food input!");
          return;
        }

        try {model.addMonkeyToIsolation(new Monkey(name, MonkeySpecies.SPIDER, sex, size, weight, age, favFood)); {
          updateViewLists();
          view.displaySuccessMessage("Monkey" + name + "added to isolation.");
        } } catch (IllegalArgumentException ex) {
          view.displayErrorMessage("Error registering monkey: " + ex.getMessage());
        }
      }
    }
  }


class MoveMonkeys implements ActionListener{
  @Override
  public void actionPerformed(ActionEvent e) {
    if (selectedIsolationMonkey != null){
      String enclosureSpecies = view.getMonkeySpecies();

      model.moveMonkeysToEnclosures();
      updateViewLists();

      view.displaySuccessMessage("Monkeys moved to enclosures.");

      selectedIsolationMonkey = null;

    }
  }

  }

//  public void updateView() {
//    String output = model.getAllMonkeysList();
//    view.displayErrorMessage(output);
//
//    List<Monkey> enclosureMonkeys = model.getEnclosureMonkeys();
//    view.updateEnclosureMonkeysPanel(enclosureMonkeys);
//  }


  class IsolationListSelectionListener implements ListSelectionListener {
    @Override
    public void valueChanged(ListSelectionEvent e) {
      if (!e.getValueIsAdjusting()) {
        selectedIsolationMonkey = view.getSelectedIsolationMonkey();
        view.updateSelectedMonkeyDetails(selectedIsolationMonkey);
      }
    }
  }

  private void updateViewLists() {
    List<Monkey> monkeysInEnclosures = model.getEnclosureMonkeys();

    List<Monkey> monkeysInIsolation = model.getIsolationCageMonkeys();

    List<Monkey> allMonkeys = model.getAllMonkeysList();

    List<Monkey> monkeys = model.getEnclosureMonkeys();
    view.updateEnclosureMonkeysPanel(monkeys);

    view.updateEnclosureList(monkeysInEnclosures);
    view.updateAllMonkeysList(allMonkeys);
    view.updateIsolationList(monkeysInIsolation);
  }

}
