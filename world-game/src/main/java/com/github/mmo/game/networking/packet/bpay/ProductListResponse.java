package com.github.mmo.game.networking.packet.bpay;


import java.util.ArrayList;


public class ProductListResponse extends ServerPacket
{
	private int result = 0;
	public final int getResult()
	{
		return result;
	}
	public final void setResult(int value)
	{
		result = value;
	}
	private int currencyID = 0;
	public final int getCurrencyID()
	{
		return currencyID;
	}
	public final void setCurrencyID(int value)
	{
		currencyID = value;
	}
	private ArrayList<BpayProductInfo> productInfos = new ArrayList<>();
	public final ArrayList<BpayProductInfo> getProductInfos()
	{
		return productInfos;
	}
	public final void setProductInfos(ArrayList<BpayProductInfo> value)
	{
		productInfos = value;
	}
	private ArrayList<BpayProduct> products = new ArrayList<>();
	public final ArrayList<BpayProduct> getProducts()
	{
		return products;
	}
	public final void setProducts(ArrayList<BpayProduct> value)
	{
		products = value;
	}
	private ArrayList<BpayGroup> productGroups = new ArrayList<>();
	public final ArrayList<BpayGroup> getProductGroups()
	{
		return productGroups;
	}
	public final void setProductGroups(ArrayList<BpayGroup> value)
	{
		productGroups = value;
	}
	private ArrayList<BpayShop> shops = new ArrayList<>();
	public final ArrayList<BpayShop> getShops()
	{
		return shops;
	}
	public final void setShops(ArrayList<BpayShop> value)
	{
		shops = value;
	}

	public ProductListResponse()
	{
		super(ServerOpcode.BattlePayGetProductListResponse);
	}

	@Override
	public void write()
	{
		this.write(getResult());
		this.write(getCurrencyID());
		this.writeInt32((int)getProductInfos().size());
		this.writeInt32((int)getProducts().size());
		this.writeInt32((int)getProductGroups().size());
		this.writeInt32((int)getShops().size());

		for (var p : getProductInfos())
		{
			p.write(this);
		}

		for (var p : getProducts())
		{
			p.write(this);
		}

		for (var p : getProductGroups())
		{
			p.write(this);
		}

		for (var p : getShops())
		{
			p.write(this);
		}
	}
}
