package pt.ipbeja.po2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DispenserTest
{
	static final int N_PRODUCTS = 40;
	static final int PRODUCT_PRICE = 40;
	
	private Dispenser dispenser;
	
	@Before
	public void setUp() throws Exception
	{
		this.dispenser = new Dispenser(N_PRODUCTS, PRODUCT_PRICE);
	}
	
	@Test
	public void testInsertCoin()
	{
		int insertedMoney = this.dispenser.insertCoin(20);
		
		assertEquals(20, insertedMoney);
		
		insertedMoney = this.dispenser.insertCoin(25);
		
		assertEquals(20, insertedMoney);
		
		insertedMoney = this.dispenser.insertCoin(10);
		
		assertEquals(30, insertedMoney);
		
		insertedMoney = this.dispenser.insertCoin(-10);
		
		assertEquals(30, insertedMoney);
	}
	
	@Test
	public void testSellProduct()
	{
		int insertedMoney = this.dispenser.insertCoin(50);
		
		int nProductsBefore = dispenser.getNProducts();
		int salesMoneyBefore = dispenser.getSalesMoney();

		int change = dispenser.buyProduct();
		assertEquals(10, change);
		
		int nProductsAfter = dispenser.getNProducts();
		assertEquals(nProductsBefore - 1, nProductsAfter);
		
		int salesMoneyAfter = dispenser.getSalesMoney();
		assertEquals(salesMoneyBefore + PRODUCT_PRICE, salesMoneyAfter);
	}
	
	@Test
	public void testInsuficientMoney()
	{
		int nProductsBefore = dispenser.getNProducts();
		int salesMoneyBefore = dispenser.getSalesMoney();
		
		this.dispenser.insertCoin(20);
		this.dispenser.insertCoin(5);
		
		int change = dispenser.buyProduct();
		assertEquals(-15, change);
		
		int nProductsAfter = dispenser.getNProducts();
		assertEquals(nProductsBefore, nProductsAfter);
		
		int salesMoneyAfter = dispenser.getSalesMoney();
		assertEquals(salesMoneyBefore, salesMoneyAfter);
	}
	
	@Test
	public void testCancelBuy()
	{
		int nProductsBefore = dispenser.getNProducts();
		int salesMoneyBefore = dispenser.getSalesMoney();
		
		this.dispenser.insertCoin(20);
		this.dispenser.insertCoin(10);
		
		int refund = this.dispenser.cancel();
		assertEquals(30, refund);

		int nProductsAfter = dispenser.getNProducts();
		assertEquals(nProductsBefore, nProductsAfter);
		
		int salesMoneyAfter = dispenser.getSalesMoney();
		assertEquals(salesMoneyBefore, salesMoneyAfter);
	}
	
	@Test
	public void testSetPrice()
	{
		dispenser.setProductPrice(50);
		int price = dispenser.getProductPrice();
		assertEquals(50, price);
	}
	
	@Test
	public void testSetNProducts()
	{

		dispenser.setNProducts(50);
		int n = dispenser.getNProducts();
		assertEquals(50, n);
	}
	
	@Test
	public void testGetNProducts()
	{
		int n = dispenser.getNProducts();
		assertEquals(40, n);
	}
	
	@Test
	public void testGetSalesMoney()
	{
		this.dispenser.insertCoin(20);
		this.dispenser.insertCoin(20);
		int change = dispenser.buyProduct();
		
		int salesMoney = dispenser.getSalesMoney();
		assertEquals(40, salesMoney);
	}
}