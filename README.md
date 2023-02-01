# A1 - Piraten Karpen

  * Author: Prerna Prabhu
  * Email: prabhp3@mcmaster.ca

## Build and Execution

  * To clean your working directory:
    * `mvn clean`
  * To compile the project:
    * `mvn compile`
  * To run the project in development mode:
    * `mvn -q exec:java` (here, `-q` tells maven to be _quiet_)
  * To package the project as a turn-key artefact:
    * `mvn package`
  * To run the packaged delivery:
    * `java -jar target/piraten-karpen-jar-with-dependencies.jar` 
  * To run the project in trace mode:
    * `

Remark: **We are assuming here you are using a _real_ shell (e.g., anything but PowerShell on Windows)**

## Feature Backlog

 * Status: 
   * Pending (P), Started (S), Blocked (B), Done (D)
 * Definition of Done (DoD):
   * The feature is functioning without bugs, and the conditions it must satisfy are met (accepted by the client)

### Backlog 

| MVP? | Id  | Feature  | Status  |  Started  | Delivered |
| :-:  |:-:  |---       | :-:     | :-:       | :-:       |
| x   | F01 | Roll a dice |  S | 01/01/23 |  |
| x   | F02 | Roll eight dices  |  S (F01) |   |
| x   | F03 | Select how many games as command-line arg.  |  D  |   |
| x   | F04 | end of game with three skulls | S | |
| x   | F05 | Player keeping random dice at their turn | S (F02) | |
| x   | F06 | Score points: 3-of-a-kind | S (F04) | | 
| x   | F07 | Score points: diamonds and gold | S (F04) | |
| x   | F08 | Random-die strategy  | S (F05) | |
| -   | F09 | Score points: 4-of-a-kind | S (F04) | |
| -   | F10 | Score points: 5-of-a-kind | S (F04) | |
| -   | F11 | Score points: 6-of-a-kind | S (F04) | |
| -   | F12 | Score points: 7-of-a-kind | S (F04) | |
| -   | F13 | Score points: 8-of-a-kind | S (F04) | |
| -   | F14 | Play 42 games during a simulation | S (F03) | |
| -   | F15 | Combo-driven strategy | S | |
| -   | F16 | Print out percentatge of wins for each player | S | |
| -   | F17 | Specify strategies used from command line argument | S | |
| -   | F18 | Introduce card deck | S | |
| -   | F19 | Add Sea Battle with 2 sabers cards | S (F18) | |
| -   | F20 | Add Sea Battle with 3 sabers cards | S (F18) | |
| -   | F21 | Add Sea Battle with 4 sabers cards | S (F18) | |
| -   | F22 | Add Do Nothing Cards to deck | S (F18) | |
| -   | F23 | Shuffle Card Deck | S (F18) | |
| -   | F24 | Player Draws a Card | S (F18) | |
| -   | F25 | Add Monkey Business Cards to deck | S (F18) | |
| -   | F26 | Score points: Based on sea battle cards | S (F04) | |
| -   | F27 | Score points: Based on monkey business cards | S (F04) | |
| -   | F28 | Score points: Full Chest | S (F04) | |
| -   | F29 | Trace player decisions | S | |
| -   | F30 | Display important actions to user | S | |


