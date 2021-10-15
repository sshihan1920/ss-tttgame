Syed Shihan                                                                NET ID: 31749619
CS Project Three README                                                Prof. Purtee


Program Status/Algorithm Description:
The program I have created completes all of the tasks required for the project (except it has one kink which I will explain at the end). In the following lines, I will describe each method in the program and explain how they work. This program is rather lengthy and less straightforward than those of past projects so I will broadly overview each method rather than go into specifics.
* public void frameInitializer()
   * Sets up and displays the window in which the tic-tac-toe game is played. Window consists of three JPanels; panelLayout, gameBoard, and statBoard. The latter two panels are given dimensions based on the project specifications then are put onto panelLayout where they are formatted with a BorderLayout.
* public void statBoardInitializer()
   * Gives the statBoard a GridBagLayout (1 row and 3 columns) then adds a different component to each column.
      * New Game Button (JButton) - Planned to call tileReset() method when clicked, didn’t work (read Issues for more)
      * Game Status (JPanel) - Keeps track of game progression (displays which player’s turn it is, who won the game, or if game is a draw) via a JLabel called showStatus.
      * Game Stats (JPanel) - Keeps track of each player’s respective win count and games that end in draws. (int p1Wins, int p2Wins, int drawCounts)
* public void gameBoardInitializer()
   * Gives the gameBoard a GridBagLayout (3 rows and 3 columns) then places JButtons onto each square. These buttons are an array of 9 and serve as the gameTiles for the TTT board.
* public void tileReset()
   * Resets the entire game board, called whenever the game ends automatically.
   * Adds MouseListener back to gameTiles
* public boolean boardFilledCheck()
   * Returns true if all gameTiles have a symbol on them
*  public boolean checkTilesP1(int x, int y) / public boolean checkTilesP2(int x, int y)
   * Basis for the next method, compares gameTile[x] with gameTile[y] to see if they have matching symbols.
   * For the P1 method, checks if tiles have “X”
   * For the P2 method, checks if tiles have “O”
* public boolean checkForP1Win() / public boolean checkForP2Win()
   * Checks gameTiles horizontally, vertically, and diagonally for three of the same symbols in a row using the prior method
   * P1 method checks for tiles with “X”
   * P2 method checks for tiles with “O”
* public void printGameResults() 
   * Checks the last two methods and changes showStatus and gameStats accordingly
   * If P1 wins, showStatus displays “P1 WINS!” and gameStats updates P1 Wins 
   * If P1=2 wins, showStatus displays “P2 WINS!” and gameStats updates P2 Wins 
   * If neither win and the boardFilledCheck() method returns true, then showStatus displays “DRAW” and gameStats updates drawCounts.
* public void mouseClicked(MouseEvent e)
   * When gameTile is clicked, the gameTile displays a symbol based on int playerTurn
      * When playerTurn is even, the symbol displayed is “X”
      * When playerTurn is odd, the symbol displayed is “O”
   * After clicking on a tile, MouseListener is removed from gameTile to prevent tiles from changing
   * Also updates showStatus and gameStats accordingly with each new symbol placement
* main method
   * Creates a new object, testGame, and calls the first three methods I listed above.
   * This sets up the window with both the gameBoard and statBoard on it.


Issue:
* I was unable to get the newGame button to work so instead the gameBoard is automatically reset whenever either player wins or the game ends in a draw. statBoard still keeps track of all past game data (p1Wins, p2Wins, drawCount)
* Sometimes have to double click for placing symbols on gameTiles
