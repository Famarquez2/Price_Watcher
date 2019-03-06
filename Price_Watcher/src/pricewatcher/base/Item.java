package pricewatcher.base;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Item {
	private String Item_Name = "Samsung TV";
	private String Item_Price = "350.49";
	private String Item_URL = ("https://www.bestbuy.com/site/samsung-50-class-led-nu6900-series-2160p-smart-4k-uhd-tv-with-hdr/6288348.p?skuId=6288348&ref=212&loc=1&extStoreId=237&ds_rl=1260573&ds_rl=1266837&ref=212&loc=1&ds_rl=1266837&gclid=CjwKCAiA2fjjBRAjEiwAuewS_ZODSB6I_4uKw_ZM-hvPYr1EWI7PYI5wmhykLD7gTt2GxHyRDf7c9xoCwJUQAvD_BwE&gclsrc=aw.ds");
	private String Price_Change = "0.00";
		
	public void getWpage() throws IOException, URISyntaxException {
		// TODO Auto-generated method stub
		Desktop d = Desktop.getDesktop();
		String url = getItem_URL();
		d.browse(new URI(url));
		
	}

	public double priceChange() {
		// TODO Auto-generated method stub
		PriceFinder pf = new PriceFinder();
		double price_change = Double.parseDouble((getItem_Price()));
		price_change = pf.getPrice();
		String pC = String.format("%.2f", price_change);
		setPrice_Change(pC);
		return price_change;
	}

	public String getItem_URL() {
		return Item_URL;
	}

	public void setItem_URL(String item_URL) {
		Item_URL = item_URL;
	}

	public String getItem_Price() {
		return Item_Price;
	}

	public void setItem_Price(String item_Price) {
		Item_Price = item_Price;
	}

	public String getItem_Name() {
		return Item_Name;
	}

	public void setItem_Name(String item_Name) {
		Item_Name = item_Name;
	}

	public String getPrice_Change() {
		return Price_Change;
	}

	public void setPrice_Change(String price_Change) {
		Price_Change = price_Change;
	}

	public String percentChange() {
		// TODO Auto-generated method stub
		double pChange = Double.parseDouble(getPrice_Change());
		double iPrice = Double.parseDouble(getItem_Price());
		double per_change = 0;
		double diff = 0;
		String Percent_Change = null;
		if (pChange == iPrice) {
			return getItem_Price();
		}
		else if (pChange < iPrice) {
			diff = (iPrice - pChange);
			per_change = (diff/iPrice) * 100;
		}
		else {
			diff = (pChange - iPrice);
			per_change = (diff/iPrice) * 100;
		}
		Percent_Change = String.format("%.2f", per_change);
		return Percent_Change;
	}

}