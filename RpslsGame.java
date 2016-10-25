import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;
import javax.swing.JOptionPane;

public class RpslsGame extends Frame{

	private Label yourChoice, plyr, cmptr;
	private TextField forPlyr, forCmptr;
	private CheckboxGroup choices;
	private Button ropasclisp;
	private TextArea area;

	private String artif;
	private String you;
	private Random rand = new Random();
	private int score1=0, score2=0;
	private boolean win=true, tie=false;

	public RpslsGame(){
		setLayout(new FlowLayout());

		yourChoice = new Label("Your Choice: ");
		add(yourChoice);

		choices = new CheckboxGroup();
		Checkbox rock = new Checkbox("ROCK", choices, true); 
		add(rock);
		Checkbox paper = new Checkbox("PAPER", choices, false); 
		add(paper);
		Checkbox scissor = new Checkbox("SCISSOR", choices, false); 
		add(scissor);
		Checkbox lizard = new Checkbox("LIZARD", choices, false); 
		add(lizard);
		Checkbox spock = new Checkbox("SPOCK", choices, false); 
		add(spock);

		ropasclisp = new Button("RockPaperScissorLizardSpock!");
		area = new TextArea("Result: \n\n", 10, 60);

		plyr = new Label("Player's Score");
		forPlyr = new TextField(" ", 40);
		forPlyr.setEditable(false);

		cmptr = new Label("Computer's Score");	
		forCmptr = new TextField(" ", 37);
		forCmptr.setEditable(false);		

		add(ropasclisp);
		add(area);
		add(plyr);
		add(forPlyr);
		add(cmptr);
		add(forCmptr);	

		setTitle("Rock Paper Scissor Lizard Spock");
		setSize(500, 400);
		setVisible(true);

		ropasclisp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	area.setText("Result: \n\n");
            	forPlyr.setText(String.valueOf(score1));
              	forCmptr.setText(String.valueOf(score2));

              	int ai = rand.nextInt((5 - 1) + 1) + 1;
              	if (ai == 1) artif = "ROCK";
              	if (ai == 2) artif = "PAPER";
              	if (ai == 3) artif = "SCISSOR";
              	if (ai == 4) artif = "LIZARD";
              	if (ai == 5) artif = "SPOCK";
              	artif = "Computer chose "+artif+"\n\n";

              	if(choices.getSelectedCheckbox().equals(rock)) {
              		if (ai == 2 || ai == 5) {score2++; win=false;}
              		if (ai == 3 || ai == 4) {score1++; win=true;}
              		if (ai == 1) {tie=true;}
              		you = "Player chose ROCK\n\n";
              	}
              	if(choices.getSelectedCheckbox().equals(paper)) {
              		if (ai == 3 || ai == 4) {score2++; win=false;}
              		if (ai == 1 || ai == 5) {score1++; win=true;}
              		if (ai == 2) {tie=true;}
              		you = "Player chose PAPER\n\n";
              	} 
              	if(choices.getSelectedCheckbox().equals(scissor)) {
              		if (ai == 1 || ai == 5) {score2++; win=false;}
              		if (ai == 2 || ai == 4) {score1++; win=true;}
              		if (ai == 3) {tie=true;}
              		you = "Player chose SCISSOR\n\n";
              	}
              	if(choices.getSelectedCheckbox().equals(lizard)) {
              		if (ai == 1 || ai == 3) {score2++; win=false;}
              		if (ai == 2 || ai == 5) {score1++; win=true;}
              		if (ai == 4) {tie=true;}
              		you = "Player chose LIZARD\n\n";
              	}
              	if(choices.getSelectedCheckbox().equals(spock)) {
              		if (ai == 2 || ai == 4) {score2++; win=false;}
              		if (ai == 1 || ai == 3) {score1++; win=true;}
              		if (ai == 5) {tie=true;}
              		you = "Player chose SPOCK\n\n";
              	}

              	if(score1 == 5){
					area.setText("YOU WIN WITH FLYING COLORS");
					new RpslsGame();
              	}
              	if(score2 == 5){
              		area.setText("YOU LOSE WITH FLYING COLORS");
					new RpslsGame();
              	}

              	if(score1 == 5){
                    if(JOptionPane.showConfirmDialog(null,"YOU WON THE GAME\nPlay again?","GAME OVER!",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                        new RpslsGame();
                    else System.exit(ABORT);

                }
                else if(score2 == 5){
                    if(JOptionPane.showConfirmDialog(null,"YOU LOSE THE GAME\nPlay again?","GAME OVER!",JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION){
                        System.exit(ABORT);
                    }
                    else new RpslsGame();
                }

              	area.append(you);
              	area.append(artif);
              	forPlyr.setText(String.valueOf(score1));
              	forCmptr.setText(String.valueOf(score2));

              	if (tie==true) {
              		area.append("YOU TIED THIS ROUND!\n");
              		tie=false;
              	}
              	else{
              		if (win) area.append("YOU WIN THIS ROUND!\n");
              		else if (win==false) area.append("YOU LOSE THIS ROUND!\n");
              	}              	
            }
        });

		addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });	
	}

	public static void main(String[] args){
		new RpslsGame();
	}
}