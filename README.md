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
    * ``

Remark: **We are assuming here you are using a _real_ shell (e.g., anything but PowerShell on Windows)**

## Feature Backlog

 * Status: 
   * Pending (P), Started (S), Blocked (B), Done (D)
 * Definition of Done (DoD):
   * The feature is functioning without bugs, and the conditions it must satisfy are met (accepted by the client)

### Backlog 

| MVP? | Id  | Feature  | Status  |  Started  | Delivered |
| :-:  |:-:  |---       | :-:     | :-:       | :-:       |
| x   | F01 | Roll a dice |  D | 01/01/23 | 01/30/23 |
| x   | F02 | Roll eight dices  |  D (F01) |   | 01/30/23 |
| x   | F03 | Select how many games as command-line arg.  |  D  |   | 01/30/23|
| x   | F04 | end of game with three skulls | D | |
| x   | F05 | Player keeping random dice at their turn | D (F02) | | 01/30/23 |
| x   | F06 | Score points: 3-of-a-kind | D (F04) | |  01/30/23 |
| x   | F07 | Score points: diamonds and gold | D (F04) | | 01/30/23 |
| x   | F08 | Random-die strategy  | D (F05) | | 01/30/23 |
| -   | F09 | Score points: 4-of-a-kind | D (F04) | | 01/30/23 |
| -   | F10 | Score points: 5-of-a-kind | D (F04) | | 01/30/23 |
| -   | F11 | Score points: 6-of-a-kind | D (F04) | | 01/30/23 |
| -   | F12 | Score points: 7-of-a-kind | D (F04) | | 01/30/23 |
| -   | F13 | Score points: 8-of-a-kind | D (F04) | | 01/30/23 |
| -   | F14 | Play 42 games during a simulation | D (F03) | | 01/30/23 |
| -   | F15 | Combo-driven strategy | D | | 01/30/23 |
| -   | F16 | Print out percentage of wins for each player | D | | 01/30/23 |
| -   | F17 | Specify strategies used from command line argument | D | | 01/30/23 |
| -   | F18 | Introduce card deck | D | | 01/30/23 |
| -   | F19 | Add Sea Battle with 2 sabers cards | D (F18) | | 01/30/23 |
| -   | F20 | Add Sea Battle with 3 sabers cards | D (F18) | | 01/30/23 |
| -   | F21 | Add Sea Battle with 4 sabers cards | D (F18) | | 01/30/23 |
| -   | F22 | Add Do Nothing Cards to deck | D (F18) | | 01/30/23 |
| -   | F23 | Shuffle Card Deck | D (F18) | | 01/30/23 |
| -   | F24 | Player Draws a Card | D (F18) | | 01/30/23 |
| -   | F25 | Add Monkey Business Cards to deck | D (F18) | | 01/30/23 |
| -   | F26 | Score points: Based on sea battle cards | D (F04) | | 01/30/23 |
| -   | F27 | Score points: Based on monkey business cards | D (F04) | | 01/30/23 |
| -   | F28 | Score points: Full Chest | D (F04) | | 01/30/23 |
| -   | F29 | Trace player decisions | D | | 01/30/23 |
| -   | F30 | Display important actions to user | D | | 01/30/23 |


