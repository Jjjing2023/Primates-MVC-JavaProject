import javax.swing.*;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class SanctuaryView extends JFrame{
  private JTextField monkeyNameField, monkeySpeciesField, monkeySizeField, monkeyWeightField, monkeyAgeField;
  private JComboBox<String> monkeySexComboBox;
  private JTextField monkeyFavFoodField;
  private JButton registerButton, moveButton;
  private JTextArea enclosureTextArea, enclosureDetailsArea, allMonkeysTextArea, isolationTextArea;
  private JList<Monkey> isolationList;
  private JTextArea outputTextArea;
  private JScrollPane isolationScrollPane;

  public SanctuaryView() {
    super("Primate Sanctuary");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(550, 400);
    setLayout(new BorderLayout());

    designElements();
    addElements();

    pack();
    setLocationRelativeTo(null);
    setVisible(true);
  }

  private void designElements() {

    monkeyNameField = new JTextField();
    monkeySexComboBox = new JComboBox<>(new String[]{"Male", "Female"});
    monkeyFavFoodField = new JTextField();
    monkeySpeciesField = new JTextField();
    monkeySizeField = new JTextField();
    monkeyWeightField = new JTextField();
    monkeyAgeField = new JTextField();

    enclosureDetailsArea = new JTextArea(15, 20);
    enclosureDetailsArea.setEditable(false);
    enclosureDetailsArea.setBorder(
            BorderFactory.createTitledBorder("Detailed Enclosure Information"));

    registerButton = new JButton("Register Monkey");
    moveButton = new JButton("Move Monkeys to Enclosure");

    enclosureTextArea = new JTextArea(15, 20);
    enclosureTextArea.setEditable(false);
    allMonkeysTextArea = new JTextArea(15, 20);
    allMonkeysTextArea.setEditable(false);
    isolationTextArea = new JTextArea(15, 20);
    isolationTextArea.setEditable(false);

    isolationList = new JList<>();
    isolationList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    isolationScrollPane = new JScrollPane(isolationList);
    isolationScrollPane.setBorder(BorderFactory.createTitledBorder("Monkeys in Isolation"));

    enclosureTextArea.setBorder(BorderFactory.createTitledBorder("Monkeys in Enclosures"));
    allMonkeysTextArea.setBorder(BorderFactory.createTitledBorder("Monkeys in Sanctuary"));
  }

  private void addElements(){
    JPanel inputPanel = new JPanel();
    inputPanel.setLayout(new GridLayout(9, 2, 6, 4));
    inputPanel.setBorder(BorderFactory.createEmptyBorder(9, 9, 9, 9));

    inputPanel.add(new JLabel("Monkey Name:"));
    inputPanel.add(monkeyNameField);
    inputPanel.add(new JLabel("Sex:"));
    inputPanel.add(monkeySexComboBox);
    inputPanel.add(new JLabel("Favourite Food:"));
    inputPanel.add(monkeyFavFoodField);
    inputPanel.add(new JLabel("species:"));
    inputPanel.add(monkeySpeciesField);
    inputPanel.add(new JLabel("size:"));
    inputPanel.add(monkeySizeField);
    inputPanel.add(new JLabel("weight:"));
    inputPanel.add(monkeyWeightField);
    inputPanel.add(new JLabel("age:"));
    inputPanel.add(monkeyAgeField);

    inputPanel.add(registerButton);
    inputPanel.add(moveButton);

    JPanel listPanel = new JPanel(new GridLayout(1, 4, 10, 5));
    listPanel.setBorder(BorderFactory.createEmptyBorder(9, 9, 9, 9));
    listPanel.add(new JScrollPane(enclosureTextArea));
    listPanel.add(new JScrollPane(enclosureDetailsArea));
    listPanel.add(new JScrollPane(allMonkeysTextArea));
    listPanel.add(isolationScrollPane);

    add(inputPanel, BorderLayout.NORTH);
    add(listPanel, BorderLayout.CENTER);

    outputTextArea = new JTextArea();

  }

  public void setRegisterButtonListener(ActionListener listener) {
    registerButton.addActionListener(listener);
  }

  public void setMoveButtonListener(ActionListener listener) {
    moveButton.addActionListener(listener);
  }

  public String getMonkeyName() {
    return monkeyNameField.getText();
  }

  public String getMonkeySize() {
    return monkeySizeField.getText();
  }

  public String getMonkeyWeight() {
    return monkeyWeightField.getText();
  }
  public String getMonkeyAge() {
    return monkeyAgeField.getText();
  }
  public String getMonkeySpecies() {
    return monkeyNameField.getText();
  }
  public String getMonkeySex() {
    return (String) monkeySexComboBox.getSelectedItem();
  }

  public String getMonkeyFavFood() {
    return monkeyFavFoodField.getText();
  }

  public void display() {
    setVisible(true);
  }

  public void updateEnclosureMonkeysPanel(List<Monkey> monkeys) {
    StringBuilder enclosureMonkeysText = new StringBuilder("Monkeys in Enclosures:\n");

    for (Monkey monkey : monkeys) {
      enclosureMonkeysText.append(String.format("Name: %s, Sex: %s, Favourite Food: %s\n",
              monkey.getName(), monkey.getSex(), monkey.getFavoriteFood()));
    }
    // Update the enclosureMonkeysPanel with enclosureMonkeysText

  }

  public void addIsolationListSelectionListener(ListSelectionListener listener) {
    isolationList.addListSelectionListener(listener);
  }

  public void updateEnclosureList(List<Monkey> monkeys) {
    enclosureTextArea.setText(formatMonkeyList(monkeys));
  }

  public void updateAllMonkeysList(List<Monkey> monkeys) {
    allMonkeysTextArea.setText(formatMonkeyList(monkeys));
  }

  public void updateIsolationList(List<Monkey> monkeys) {
    isolationList.setListData(monkeys.toArray(new Monkey[0]));
    isolationTextArea.setText(formatMonkeyList(monkeys));
  }

  public void updateSelectedMonkeyDetails(Monkey monkey) {
    isolationTextArea.setText(printMonkeyDetails(monkey));
  }

  private String printMonkeyDetails(Monkey monkey) {
    if (monkey != null) {
      return "Name: " + monkey.getName()
              + ", Species: " + monkey.getSpecies()
              + ", Sex: " + monkey.getSex()
              + ", Size: " + monkey.getSize()
              + ", Weight: " + monkey.getWeight()
              + ", Age: " + monkey.getAge()
              + ", Favorite Food: " + monkey.getFavoriteFood();
    } else {
      return null;
    }
  }

  public Monkey getSelectedIsolationMonkey() {
    return isolationList.getSelectedValue();
  }

  private String formatMonkeyList(List<Monkey> monkeys) {
    StringBuilder sb = new StringBuilder();
    for (Monkey monkey : monkeys) {
      sb.append("Name: ").append(monkey.getName()).append(", ")
              .append("Species: ").append(monkey.getSpecies()).append(", ")
              .append("Sex: ").append(monkey.getSex()).append(", ")
              .append("Size: ").append(monkey.getSize()).append(", ")
              .append("Weight: ").append(monkey.getWeight()).append(", ")
              .append("Age: ").append(monkey.getAge()).append(", ")
              .append("Favorite Food: ").append(monkey.getFavoriteFood()).append("\n");
    }
    return sb.toString();
  }

  public void displayErrorMessage(String message) {
    JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
  }

  public void displaySuccessMessage(String message){
    JOptionPane.showMessageDialog(this, message, "Success", JOptionPane.INFORMATION_MESSAGE);
  }

  public boolean displayConfirmationMessage(String message){
    int result = JOptionPane.showConfirmDialog(this, message, "Confirmation", JOptionPane.YES_NO_OPTION);

    return result == JOptionPane.YES_OPTION;
  }

}
