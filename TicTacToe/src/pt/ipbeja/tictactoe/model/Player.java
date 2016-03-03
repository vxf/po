package pt.ipbeja.tictactoe.model;

public class Player
{
	private int id;
	private char letter; // X ou O
	private String name;
	private int score;
	private int nWonGames;
	private int nDrawGames;
	private int nLostGames;
	
	public Player(int id)
	{
		this(id, ' ', null);
	}
	
	public Player(int id, char letter)
	{
		this(id, letter, null);
	}
	
	public Player(int id, String name)
	{
		this(id, ' ', name);
	}

	public Player(int id, char letter, String name)
	{
		this.id = id;
		this.letter = letter;
		this.name = name;
		this.score = 0;
		this.nWonGames = 0;
		this.nDrawGames = 0;
		this.nLostGames = 0;
	}

	public int getId() {
		return this.id;
	}

	public char getLetter() {
		return this.letter;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getScore() {
		return score;
	}
	
	public void incScore(int value)
	{
		this.score += value;
	}
	
	public void decScore(int value)
	{
		this.score -= value;
	}
	
	public void incNWonGames()
	{
		this.nWonGames++;
	}
	
	public void incNDrawGames()
	{
		this.nDrawGames++;
	}
	
	public void incNLostGames()
	{
		this.nLostGames++;
	}
	
	public int getNWonGames()
	{
		return this.nWonGames;
	}
	
	public int getNDrawGames()
	{
		return this.nDrawGames;
	}
	
	public int getLostGames()
	{
		return this.nLostGames;
	}
	
}
