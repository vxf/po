package pt.ipbeja.tictactoe.model;

public class Board 
{
	public static final int SIZE = 3;
	public static final int PLAYER1_ID = 1;
	public static final int PLAYER2_ID = 2;
	public static final char PLAYER1_LETTER = 'X';
	public static final char PLAYER2_LETTER = 'O';
	public static final char NOPLAYER_LETTER = ' ';
	
	private char [] [] board;
	private Player player1, player2, playing;
	
	public Board()
	{
		// estado inicial
		this.board = new char[Board.SIZE][Board.SIZE];
		this.player1 = new Player(Board.PLAYER1_ID, Board.PLAYER1_LETTER);
		this.player2 = new Player(Board.PLAYER2_ID, Board.PLAYER2_LETTER);
		this.playing = this.player1;
	}

	public Player getPlayer1() {
		return player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public Player getPlaying() {
		return playing;
	}

	public boolean gameEnded()
	{
		return false;
	}
	
	public boolean winGame(Player player)
	{
	   // Lines
		for (int line = 0; line < this.board.length; line++)
		{
			if (this.board[line][0] == this.board[line][1] &&
				 this.board[line][1] == this.board[line][2] &&
				 this.board[line][2] == player.getLetter())
			{
			   return true;
			}
		}
		
		// Columns
      for (int col = 0; col < Board.SIZE; col++)
      {
         if (this.board[0][col] == this.board[1][col] &&
             this.board[1][col] == this.board[2][col] &&
             this.board[2][col] == player.getLetter())
         {
            return true;
         }
      }
      
      // Diagonal \
      if (this.board[0][0] == this.board[1][1] &&
          this.board[1][1] == this.board[2][2] &&
          this.board[2][2] == player.getLetter())
      {
         return true;
      }
      
      // Diagonal /
      if (this.board[0][2] == this.board[1][1] &&
          this.board[1][1] == this.board[2][0] &&
          this.board[2][0] == player.getLetter())
      {
         return true;
      }
      
      return false;
	}
	
	public void restartBoard()
	{
		for (int line = 0; line < this.board.length; line++)
		{
			for (int col = 0; col < this.board[line].length; col++)
			{
				this.board[line][col] = Board.NOPLAYER_LETTER;
			}
		}
	}
}
