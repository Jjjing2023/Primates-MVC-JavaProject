Primate Sanctuary MVC Project

About/Overview
The Primate Sanctuary MVC Project is a software solution that manages a primate sanctuary, allowing users to register new monkeys, move monkeys to enclosures, and view details about the monkeys housed in the sanctuary. The project follows the Model-View-Controller (MVC) architectural pattern to ensure separation of concerns and maintainability.

List of Features
Register new monkeys into the sanctuary.
Move monkeys from isolation to appropriate enclosures based on species.
Display lists of monkeys in enclosures, isolation, and all monkeys.
View detailed information about monkeys and enclosures.
User-friendly graphical user interface (GUI) built using Java Swing.

How to Use the Program
Launch the application by clicing the .jar file
Use the input fields to register new monkeys by providing their details such as name, sex, species, size, weight, age, and favorite food.
Click the "Register Monkey" button to add the monkey to the sanctuary's isolation.
Click the "Move Monkeys to Enclosure" button to transfer monkeys from isolation to appropriate enclosures based on their species.
Select a monkey from the isolation list to view its details in the isolation details area.
Observe lists of monkeys in enclosures, isolation, and all monkeys in their respective text areas.
Interact with the graphical user interface to manage and view monkeys in the sanctuary.

Design/Model Changes
Implemented the MVC architectural pattern to separate concerns and enhance maintainability.
Created distinct classes for the Model (Sanctuary, Monkey, Housing), View (SanctuaryView), and Controller (SanctuaryController).

Assumptions
Users are responsible for inputting valid data for monkey registration (e.g., correct species, valid age and weight).
The program assumes that the user is familiar with basic GUI interactions.
