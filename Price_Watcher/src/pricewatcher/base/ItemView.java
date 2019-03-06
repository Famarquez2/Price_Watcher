package pricewatcher.base;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/** A special panel to display the detail of an item. */

@SuppressWarnings("serial")
public class ItemView extends JPanel {
	
	private Item item;
    
	/** Interface to notify a click on the view page icon. */
	public interface ClickListener {
		
		/** Callback to be invoked when the view page icon is clicked. */
		void clicked();
	}
	
	/** Directory for image files: src/image in Eclipse. */
	private final static String IMAGE_DIR = "/image/";
        
	/** View-page clicking listener. */
    private ClickListener listener;
    
    /** Create a new instance. */
    public ItemView() {
    	this.item = new Item();
    	setPreferredSize(new Dimension(100, 160));
        setBackground(Color.WHITE);
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            	if (isViewPageClicked(e.getX(), e.getY()) && listener != null) {
            		listener.clicked();
            	}
            }
        });
    }
    public ItemView(Item item) {
    	this.item = item;
    	setPreferredSize(new Dimension(100, 160));
        setBackground(Color.WHITE);
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            	if (isViewPageClicked(e.getX(), e.getY()) && listener != null) {
            		listener.clicked();
            	}
            }
        });
    }
        
    /** Set the view-page click listener. */
    public void setClickListener(ClickListener listener) {
    	this.listener = listener;
    }
    
    /** Overridden here to display the details of the item. */
    @Override
	public void paintComponent(Graphics g) {
    	System.out.println("Called");
        super.paintComponent(g); 
        Dimension dim = getSize();
        
        //--
        //-- WRITE YOUR CODE HERE!
        //--
        int x = 20, y = 30;
        g.drawOval(300, 10, 25, 25);
        g.drawString("Name: " + item.getItem_Name() , x, y);
        y += 20;
        g.drawString("Initial Price: $" + item.getItem_Price(), x, y);
        y += 20;
        g.drawString("URL: " + item.getItem_URL(), x, y);
        y += 20;
        g.drawString("Current Price: $" + item.getPrice_Change(), x, y);
        y += 20;
        g.drawString("Percent Change: "  + item.percentChange() + "%" , x, y);
        item.setItem_Price(item.getPrice_Change());
    }
    
    /** Return true if the given screen coordinate is inside the viewPage icon. */
    private boolean isViewPageClicked(int x, int y) {
    	//--
    	//-- WRITE YOUR CODE HERE
    	//--
    	if (x < 325 && x > 300)
    		return true;
    	
    	return new Rectangle(20, 20, 30, 20).contains(x,  y);
    }
        
    /** Return the image stored in the given file. */
    public Image getImage(String file) {
        try {
        	URL url = new URL(getClass().getResource(IMAGE_DIR), file);
            return ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    	

}