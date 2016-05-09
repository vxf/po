package pt.ipbeja.po2;

public class Product
{
	private int price;
	
	public Product(int price)
	{
		this.price = price;
	}

	public int getPrice()
	{
		return this.price;
	}

	public void setPrice(int price)
	{
		this.price = price;
	}
	
	public boolean isIexpensive(int limit)
	{
		return this.getPrice() <= limit;
	}
}
