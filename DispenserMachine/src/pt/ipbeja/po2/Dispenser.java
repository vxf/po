package pt.ipbeja.po2;

import java.util.ArrayList;
import java.util.List;

public class Dispenser
{
	private int productPrice;
	private int nProducts;
	private int insertedMoney;
	private int salesMoney;
	
	private List<Product> products;
	
	public Dispenser(int nProducts, int productPrice)
	{
		this.nProducts = nProducts;
		this.productPrice = productPrice;
		this.insertedMoney = 0;
	}
	
	public int insertCoin(int coin)
	{
		if (coin == 5 || coin == 10 || coin == 20 || coin == 50)
		{
			this.insertedMoney += coin;
		}
		
		return this.insertedMoney;
	}

	public int buyProduct()
	{
		if (this.insertedMoney >= this.productPrice)
		{
			this.nProducts--;
			this.salesMoney += this.productPrice;
		}
		
		return this.insertedMoney - this.productPrice;
	}

	public int getProductPrice()
	{
		return this.productPrice;
	}

	public void setProductPrice(int productPrice)
	{
		this.productPrice = productPrice;
	}

	public void setNProducts(int nProducts)
	{
		this.nProducts = nProducts;
	}

	public int getNProducts()
	{
		return this.nProducts;
	}

	public int getInsertedMoney()
	{
		return this.insertedMoney;
	}

	public int getSalesMoney()
	{
		return this.salesMoney;
	}

	public int cancel()
	{
		// TODO Auto-generated method stub
		return this.insertedMoney;
	}
	
	public List<Product> getInexpensive(int limit)
	{
		List<Product> lst = new ArrayList<>();
		
		for (Product p: this.products)
		{
			if (p.getPrice() <= limit)
			{
				lst.add(p);
			}
		}
		
		return lst;
	}
}
