package de.ralfgraef.games;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {

  JFrame window;
  Container con;
  JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerStatsPanel;
  JLabel titleNameLabel, hpLabel, hpLabelNumber, wpLabel, wpLabelName;
  Font titleFont = new Font("Arial", Font.PLAIN, 48);
  Font normalFont = new Font("Arial", Font.PLAIN, 20);
  JButton startButton, choice1Button, choice2Button, choice3Button, choice4Button;
  JTextArea mainTextArea;
  int playerHP, monsterHP, silverRing;
  String playerWeapon, position;

  TitleScreenHandler tsHandler = new TitleScreenHandler();
  ChoiceHandler cHandler= new ChoiceHandler();

  public static void main(String[] args) {
    new Game();
  }

  public Game() {
    window = new JFrame();
    window.setSize(800, 600);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.getContentPane().setBackground(Color.black);
    window.setLayout(null);
    window.setTitle("Ralf's AdventureGame");
    window.setLocationRelativeTo(null);
    window.setVisible(true);
    con=window.getContentPane();

    titleNamePanel = new JPanel();
    titleNamePanel.setBounds(100,100,600, 150);
    titleNamePanel.setBackground(Color.black);

    titleNameLabel = new JLabel("Ralf's AdventureGame");
    titleNameLabel.setForeground(Color.white);
    titleNameLabel.setFont(titleFont);


    startButtonPanel = new JPanel();
    startButtonPanel.setBounds(300,400,200,100);
    startButtonPanel.setBackground(Color.black);

    startButton = new JButton("START");
    startButton.setBackground(Color.black);
    startButton.setForeground(Color.white);
    startButton.setFont(normalFont);
    startButton.setFocusPainted(false);
    startButton.addActionListener(tsHandler);

    titleNamePanel.add(titleNameLabel);
    startButtonPanel.add(startButton);

    con.add(titleNamePanel);
    con.add(startButtonPanel);
  }

  public void createGameScreen() {

    titleNamePanel.setVisible(false);
    startButtonPanel.setVisible(false);

    mainTextPanel = new JPanel();
    mainTextPanel.setBounds(100,100,600,250);
    mainTextPanel.setBackground(Color.black);

    mainTextArea = new JTextArea("This is the main text area.");
    mainTextArea.setBounds(100,100,600,250);
    mainTextArea.setBackground(Color.black);
    mainTextArea.setForeground(Color.white);
    mainTextArea.setFont(normalFont);
    mainTextArea.setLineWrap(true);

    mainTextPanel.add(mainTextArea);
    con.add(mainTextPanel);

    choiceButtonPanel = new JPanel();
    choiceButtonPanel.setBounds(250,350, 350,150);
    choiceButtonPanel.setBackground(Color.black);
    choiceButtonPanel.setLayout(new GridLayout(4,1));
    con.add(choiceButtonPanel);

    choice1Button = new JButton("Choice1");
    choice1Button.setBackground(Color.black);
    choice1Button.setForeground(Color.white);
    choice1Button.setFont(normalFont);
    choice1Button.setFocusPainted(false);
    choice1Button.addActionListener(cHandler);
    choice1Button.setActionCommand("c1");
    choiceButtonPanel.add(choice1Button);


    choice2Button = new JButton("Choice2");
    choice2Button.setBackground(Color.black);
    choice2Button.setForeground(Color.white);
    choice2Button.setFont(normalFont);
    choice2Button.setFocusPainted(false);
    choice2Button.addActionListener(cHandler);
    choice2Button.setActionCommand("c2");
    choiceButtonPanel.add(choice2Button);

    choice3Button = new JButton("Choice3");
    choice3Button.setBackground(Color.black);
    choice3Button.setForeground(Color.white);
    choice3Button.setFont(normalFont);
    choice3Button.setFocusPainted(false);
    choice3Button.addActionListener(cHandler);
    choice3Button.setActionCommand("c3");
    choiceButtonPanel.add(choice3Button);

    choice4Button = new JButton("Choice4");
    choice4Button.setBackground(Color.black);
    choice4Button.setForeground(Color.white);
    choice4Button.setFont(normalFont);
    choice4Button.setFocusPainted(false);
    choice4Button.addActionListener(cHandler);
    choice4Button.setActionCommand("c4");
    choiceButtonPanel.add(choice4Button);

    playerStatsPanel = new JPanel();
    playerStatsPanel.setBounds(100, 15,600,50);
    playerStatsPanel.setBackground(Color.black);
    playerStatsPanel.setLayout(new GridLayout(1,4));
    con.add(playerStatsPanel);

    hpLabel = new JLabel("Spieler HP: ");
    hpLabel.setFont(normalFont);
    hpLabel.setForeground(Color.white);
    playerStatsPanel.add(hpLabel);

    hpLabelNumber = new JLabel();
    hpLabelNumber.setFont(normalFont);
    hpLabelNumber.setForeground(Color.white);
    playerStatsPanel.add(hpLabelNumber);

    wpLabel = new JLabel("Waffe: ");
    wpLabel.setFont(normalFont);
    wpLabel.setForeground(Color.white);
    playerStatsPanel.add(wpLabel);

    wpLabelName = new JLabel();
    wpLabelName.setFont(normalFont);
    wpLabelName.setForeground(Color.white);
    playerStatsPanel.add(wpLabelName);

    playerSetUp();
  }

  public void playerSetUp() {
    playerHP = 15;
    monsterHP = 20;
    playerWeapon = "Messer";
    wpLabelName.setText(playerWeapon);
    hpLabelNumber.setText(Integer.toString(playerHP));

    townGate();
  }

  public void townGate() {
    position = "townGate";
    mainTextArea.setText("Du stehst am mächtigen Tor der Stadtmauer.\n\nEine Mann der Stadtwache nähert sich Dir.\n\nWas machst Du?");
    choice1Button.setText("Sprich mit der Wache...");
    choice2Button.setText("Greife die Wache an!");
    choice3Button.setText("Verlasse das Stadttor...");
    choice4Button.setText("");
    choice4Button.setVisible(false);

  }

  public void talkGuard() {
    position = "talkGuard";
    mainTextArea.setText("Wache: 'Fremder, ich kenne Dich nicht!'\n\n'Wir lassen keine Fremde in unsere Stadt!'\n\n'Hinfort mit Dir!'");
    choice1Button.setText("Bleib stehen!");
    choice2Button.setText("Greife die Wache an!");
    choice3Button.setText("Verlasse das Stadttor...");
    choice4Button.setText("");
  }

  public void attackGuard() {
    position = "attackGuard";
    mainTextArea.setText("Du: 'Attacke!!!!'\n\nWache: 'Hey, sei nicht dumm!'\n\nDie Wache schlägt zurück und trifft Dich hart!\n\nDu erleidest 3HP Schaden!");
    playerHP -= 3;
    hpLabelNumber.setText(Integer.toString(playerHP));
    choice1Button.setText("Weg von der Wache...");
    choice2Button.setText("Greif die Wache an!");
    choice3Button.setText("Verlasse das Stadttor...");
    choice4Button.setText("");
  }

  public void crossRoad() {
    position = "crossRoad";
    mainTextArea.setText("Du bist an einer Wegkreuzung.\n\nNach Süden kommst Du zurück zur Stadt.\n");
    choice1Button.setText("Geh nach Norden");
    choice2Button.setText("Geh nach Osten");
    choice3Button.setText("Geh nach Süden");
    choice4Button.setText("Geh nach Westen");
    choice2Button.setVisible(true);
    choice3Button.setVisible(true);
    choice4Button.setVisible(true);

  }

  public void north() {
    position = "north";
    mainTextArea.setText("Du bist an einem wuderschönen Flußlauf.\n\nDu trinkst das klare Wasser und erholst Dich.\n\nDeine HP steigen um 2 Punkte.");
    playerHP +=2;
    hpLabelNumber.setText(Integer.toString(playerHP));
    choice1Button.setText("Geh nach Süden");
    choice2Button.setText("");
    choice3Button.setText("");
    choice4Button.setText("");
  }


  public void east() {
    position = "east";
    mainTextArea.setText("Du bist in einem alten Wald.\n\nDu hast ein Langschwert gefunden.\n\nDu trägst nun das Langschwert der Macht.");
    playerWeapon = "Langschwert";
    wpLabelName.setText(playerWeapon);
    choice1Button.setText("Geh nach Westen");
    choice2Button.setText("");
    choice3Button.setText("");
    choice4Button.setText("");
    choice2Button.setVisible(false);
    choice3Button.setVisible(false);
    choice4Button.setVisible(false);
  }

  public void west() {
    position = "west";
    mainTextArea.setText("Du hast eine bösen Troll aufgespürt.");
    choice1Button.setText("Attacke!");
    choice2Button.setText("Lauf weg!");
    choice3Button.setText("");
    choice4Button.setText("");
    choice3Button.setVisible(false);
    choice4Button.setVisible(false);
  }

  public void fight() {
    position = "fight";
    mainTextArea.setText("Monster HP: " + monsterHP + "\n\nWas machst Du?");
    choice1Button.setText("Drauf hauen!");
    choice2Button.setText("Lauf weg!");
    choice3Button.setText("");
    choice4Button.setText("");
  }

  public void playerAttack() {
    position = "playerAttack";

    int playerDamage = 0;

    if (playerWeapon.equals("Messer")) {
      playerDamage = new java.util.Random().nextInt(3);
    }
    else if (playerWeapon.equals("Langschwert")) {
      playerDamage = new java.util.Random().nextInt(12);
    }

    mainTextArea.setText("Du hast das Monster angegriffen und " + playerDamage + " Schaden ausgeteilt.");

    monsterHP -= playerDamage;

    choice1Button.setText(">");
    choice2Button.setText("");
    choice3Button.setText("");
    choice4Button.setText("");

  }

  public void monsterAttack() {
    position = "monsterAttack";

    int monsterDamage = 0;

    monsterDamage = new java.util.Random().nextInt(6);

    mainTextArea.setText("Das Monster hat Dich angegriffen und " + monsterDamage + " Schaden ausgeteilt.");

    playerHP -= monsterDamage;

    hpLabelNumber.setText(Integer.toString(playerHP));

    choice1Button.setText("Attacke!!!!");
    choice2Button.setText("Weglaufen...");
    choice3Button.setText("");
    choice4Button.setText("");
    choice3Button.setVisible(false);
    choice4Button.setVisible(false);
  }

  public void win() {
    position = "win";

    mainTextArea.setText("Du hast das Monster besiegt!\n\nDas Monster hat einen Ring fallen gelassen.\n\nDu erhälst den Ring des Einlasses.");

    silverRing = 1;

    choice1Button.setText("Geh nach Osten");
    choice2Button.setText("");
    choice3Button.setText("");
    choice4Button.setText("");
    choice2Button.setVisible(false);
    choice3Button.setVisible(false);
    choice4Button.setVisible(false);

  }

  public void lose() {
    position = "lose";

    mainTextArea.setText("Du bist tot!\n\n<GAME OVER>");

    choice1Button.setText("");
    choice2Button.setText("");
    choice3Button.setText("");
    choice4Button.setText("");
    choice1Button.setVisible(false);
    choice2Button.setVisible(false);
    choice3Button.setVisible(false);
    choice4Button.setVisible(false);
  }

  public void ending() {
    position = "ending";

    mainTextArea.setText("Wache: Oh, Du hast den Troll getötet?\n\nDie Bewohner unserer Stadt schulden Dir Dankbarkeit.\n\nDu bist ein wahrer Held!\n\nTritt ein in unsere Stadt und feier mit uns!\n\n<THE END>");

    choice1Button.setText("");
    choice2Button.setText("");
    choice3Button.setText("");
    choice4Button.setText("");
    choice1Button.setVisible(false);
    choice2Button.setVisible(false);
    choice3Button.setVisible(false);
    choice4Button.setVisible(false);
  }

  public class TitleScreenHandler implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      createGameScreen();
    }
  }

  public class ChoiceHandler implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      String yourChoice = event.getActionCommand();

      switch (position) {
        case "townGate":
          switch (yourChoice) {
            case "c1":
              if (silverRing ==1){
                ending();
              } else {
                talkGuard();
              }
              break;
            case "c2":
              attackGuard(); break;
            case "c3": crossRoad(); break;
          }
            break;
        case "talkGuard":
          switch(yourChoice){
            case "c1":
              townGate(); break;
            case "c2": break;
            case "c3": break;
          }
            break;
        case "attackGuard":
          switch (yourChoice) {
            case "c1":
              townGate(); break;
          }
            break;
        case "crossRoad":
          switch (yourChoice) {
            case "c1": north(); break;
            case "c2": east(); break;
            case "c3": townGate(); break;
            case "c4": west(); break;
          }
            break;
        case "north":
        case "east":
          switch (yourChoice) {
            case "c1": crossRoad(); break;
          }
            break;
        case "west":
          switch (yourChoice) {
            case "c1": fight(); break;
            case "c2": crossRoad(); break;
          }
          break;
        case "fight":
          switch (yourChoice) {
            case "c1": playerAttack(); break;
            case "c2": crossRoad(); break;
          }
          break;
        case "playerAttack":
          switch (yourChoice) {
            case "c1":
              if (monsterHP<1){
                win();
              }else {
                monsterAttack();
              }
              break;
          }
          break;
        case "monsterAttack":
          switch (yourChoice) {
            case "c1":
              if (playerHP<1) {
                lose();
              } else{
                fight();
              }
              break;
          }
          break;
        case "win":
          switch (yourChoice) {
            case "c1": crossRoad(); break;
          }
          break;
      }
    }
  }

}
