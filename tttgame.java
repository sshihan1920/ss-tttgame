import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class TTTgame extends JPanel implements MouseListener {             
JPanel gameBoard = new JPanel();
JPanel statBoard = new JPanel();
JPanel panelLayout = new JPanel();
JFrame frame = new JFrame();
JButton gameTile[]= new JButton[9];
JButton newGame = new JButton();
JLabel showStatus = new JLabel();
Border gridLine = BorderFactory.createLineBorder(Color.white);

int p1Wins = 0;
int p2Wins = 0;
int drawCount;
int playerTurn = 0;

JTextField player1Wins = new JTextField("P1 Wins: " + p1Wins);
JTextField player2Wins = new JTextField("P2 Wins: " + p2Wins);
JTextField gameDraws = new JTextField("Draws: " + drawCount);

//Frame Initializer Method
	public void frameInitializer() {
		frame.setTitle("Tic-Tac-Toe Game");
		frame.setSize(480, 580);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		
		gameBoard.setBounds(0, 0, 480, 480);
		statBoard.setBounds(0, 0, 480, 100);
		
		panelLayout.setLayout(new BorderLayout());
		panelLayout.add(statBoard, BorderLayout.NORTH);
		panelLayout.add(gameBoard, BorderLayout.CENTER);	
		
		frame.add(panelLayout);
	}
	
//Stat Board Initializer Method
		public void statBoardInitializer() {
			statBoard.setBackground(new Color(123, 10, 250));
			statBoard.setLayout(new GridLayout(1, 3));
			
			/*New Game Button*/
			JButton newGame = new JButton();
			newGame.setForeground(Color.white);
			newGame.setBackground(new Color(123, 10, 250));
			newGame.setText("New Game");
			newGame.setBorder(gridLine);
			
			/*Game Status*/
			JPanel gameStatus = new JPanel();
			gameStatus.setLayout(new GridBagLayout());
			gameStatus.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
			gameStatus.setBackground(new Color(123, 10, 250));
			showStatus = new JLabel("P1's Turn");
			showStatus.setForeground(Color.white);
			gameStatus.add(showStatus);
			gameStatus.setBorder(gridLine);
			
			/*Game Stats*/
			JPanel gameStats = new JPanel();
			gameStats.setLayout(new GridLayout(3, 1));
			player1Wins.setEditable(false);
			player2Wins.setEditable(false);
			gameDraws.setEditable(false);
			player1Wins.setBackground(new Color(123, 10, 250));
			player2Wins.setBackground(new Color(123, 10, 250));
			gameDraws.setBackground(new Color(123, 10, 250));
			player1Wins.setForeground(Color.white);
			player2Wins.setForeground(Color.white);
			gameDraws.setForeground(Color.white);
			gameStats.add(player1Wins);
			gameStats.add(player2Wins);
			gameStats.add(gameDraws);
			gameStats.setBorder(gridLine);
			
			statBoard.add(newGame);
			statBoard.add(gameStatus);
			statBoard.add(gameStats);
		}			
		
//Game Board Initializer Method
	public void gameBoardInitializerMethod() {
		gameBoard.setBackground(Color.black);
		gameBoard.setLayout(new GridLayout(3, 3));
		
		for (int i = 0; i < 9; ++i) {
 			gameTile[i] = new JButton();
 			gameTile[i].setForeground(Color.white);
 			gameTile[i].setBackground(Color.black);
 			gameTile[i].setBorder(gridLine);
 			gameTile[i].setText("");
		}
		
		for (int i = 0; i < 9; ++i) {
		gameBoard.add(gameTile[i]);
		gameTile[i].addMouseListener(this);
		}		
	}	

//Tile Reset Method
	public void tileReset() {
		for (int i = 0; i < 9; ++i) {
			gameTile[i].setText("");
		}
		
		for (int i = 0; i < 9; ++i) {
			gameTile[i].addMouseListener(this);
		}
	}
//Board Filled Check Method
	public boolean boardFilledCheck() {
		if (!gameTile[0].getText().equals("") && !gameTile[1].getText().equals("") && !gameTile[2].getText().equals("")
		&&	!gameTile[3].getText().equals("") && !gameTile[4].getText().equals("") && !gameTile[5].getText().equals("")
		&&	!gameTile[6].getText().equals("") && !gameTile[7].getText().equals("") && !gameTile[8].getText().equals("")) {
			return true;
		}
		else 
		return false;
	}
	
//P1 Tile Checker Method
	 public boolean checkTilesP1(int x, int y) {
		 if (!gameTile[x].getText().equals("") && gameTile[x].getText().equals("X") && gameTile[x].getText().equals(gameTile[y].getText())) {
	 			return true;
	 		}
	 		else {
	 			return false;
	 		}
	 }

//P1 Win Finder Method 	
	public boolean checkForP1Win() {
	 /*Horizontal Tile Checker*/		
		if (checkTilesP1(0, 1) == true && checkTilesP1(1, 2) == true) {
	 			return true;
	 		}
	 		else if (checkTilesP1(3, 4) == true && checkTilesP1(4, 5) == true) {
	 			return true;
	 		}
	 		else if (checkTilesP1(6, 7) == true && checkTilesP1(7, 8) == true) {
	 			return true;
	 		}
	 		
	 /*Vertical Tile Checker*/
	 		else if (checkTilesP1(0, 3) == true && checkTilesP1(3, 6) == true) {
	 			return true;
	 		}
	 		else if (checkTilesP1(1, 4) == true && checkTilesP1(4, 7) == true) {
	 			return true;
	 		}
	 		else if (checkTilesP1(2, 5) == true && checkTilesP1(5, 8) == true) {
	 			return true;
	 		}
	 		
	/*Diagonal Tile Checker*/
	 		else if (checkTilesP1(0, 4) == true && checkTilesP1(4, 8) == true) {
	 			return true;
	 		}
	 		else if (checkTilesP1(2, 4) == true && checkTilesP1(4, 6) == true) {
	 			return true;
	 		}
	 		else {
	 			return false;
	 		}
	 	}	

//P2 Tile Checker Method
	 public boolean checkTilesP2(int x, int y) {	
		 if (!gameTile[x].getText().equals("") && gameTile[x].getText().equals(gameTile[y].getText()) && gameTile[x].getText().equals("O")) {
	 			return true;
	 		}
	 		else {
	 			return false;
	 		}
	 }	

//P2 Win Finder Method 	
	 public boolean checkForP2Win() {
	/*Horizontal Tile Checker*/		
		if (checkTilesP2(0, 1) == true && checkTilesP2(1, 2) == true) {
	 			return true;
	 		}
	 		else if (checkTilesP2(3, 4) == true && checkTilesP2(4, 5) == true) {
	 			return true;
	 		}
	 		else if (checkTilesP2(6, 7) == true && checkTilesP2(7, 8) == true) {
	 			return true;
	 		}
	 		
	 /*Vertical Tile Checker*/
	 		else if (checkTilesP2(0, 3) == true && checkTilesP2(3, 6) == true) {
	 			return true;
	 		}
	 		else if (checkTilesP2(1, 4) == true && checkTilesP2(4, 7) == true) {
	 			return true;
	 		}
	 		else if (checkTilesP2(2, 5) == true && checkTilesP2(5, 8) == true) {
	 			return true;
	 		}
	 		
	 /*Diagonal Tile Checker*/
	 		else if (checkTilesP2(0, 4) == true && checkTilesP2(4, 8) == true) {
	 			return true;
	 		}
	 		else if (checkTilesP2(2, 4) == true && checkTilesP2(4, 6) == true) {
	 			return true;
	 		}
	 		else {
	 			return false;
	 		}
	 	}	
	
//Game Results Printer Method
	 public void printGameResults() {
		 if (checkForP1Win() == true) {
			showStatus.setText("P1 WINS ");
			 p1Wins++;
			 player1Wins.setText("P1 Wins: " + p1Wins);
			 tileReset();
			 playerTurn = 0;
		 }
		 else if (checkForP2Win() == true) {
			 showStatus.setText("P2 WINS!");
			 p2Wins++;
			 player2Wins.setText("P2 Wins: " + p2Wins);
			 tileReset();
			 playerTurn = 0;
		 }
		 else if (boardFilledCheck() == true && checkForP1Win() == false && checkForP2Win() == false) {
			 showStatus.setText("DRAW");
			 drawCount++;
			 gameDraws.setText("Draws: " + drawCount);
			 tileReset();
			 playerTurn = 0;
		 }
	 } 		 	
	 	
//Main Method
public static void main(String[] args) {
	TTTgame testGame = new TTTgame();
	testGame.gameBoardInitializerMethod();
	testGame.statBoardInitializer();
	testGame.frameInitializer();
}

@Override
public void mouseClicked(MouseEvent e) {
	JButton buttonClicked = (JButton)e.getSource();
		if (playerTurn % 2 == 0) {
			buttonClicked.setFont(new Font("Times New Roman", Font.BOLD, 30));
			buttonClicked.setText("X");
			++playerTurn;
			showStatus.setText("P2's Turn");
			checkForP1Win();
			checkForP2Win();
			printGameResults();
			buttonClicked.removeMouseListener(this);
			}
		else {
			buttonClicked.setFont(new Font("Times New Roman", Font.BOLD, 30));
			buttonClicked.setText("O");
			++playerTurn;
			showStatus.setText("P1's Turn");
			checkForP1Win();
			checkForP2Win();
			printGameResults();
			buttonClicked.removeMouseListener(this);
			}
	}

@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub	
}
}
