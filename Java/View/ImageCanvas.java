package View;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class ImageCanvas extends Canvas {
	
    private BufferedImage img = null;
    private Image image;
    
    public ImageCanvas(Image image){
        this.image = image;
    }
    
    @Override public void update(Graphics g) {
        paint(g);
    }
    
    @Override public void paint(Graphics g) {
    	
        // Calling BufferStrategy.show() here sometimes throws
        // NullPointerException or IllegalStateException,
        // but otherwise seems to work fine.
        try {
            if (getWidth() <= 0 || getHeight() <= 0) {
                return;
            }
            
            BufferStrategy strategy = getBufferStrategy();
            
            do {
                do {
                    g = strategy.getDrawGraphics();
                   
                    //g.drawImage(image, 0, 0, 120, 50, null);
//                    g.setColor(Color.red);
//              	    g.drawString("hahahah", 40,20);
    
                    if (img != null) {                        
                        g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
                        g.drawImage(image, 0, 0, 160, 40, null);
                        repaint();
//                        g.setColor(Color.red);
//                    	g.drawString("hahahah", 40,20);
                    }
                    else{
                    	g.clearRect(0, 0, getWidth(), getHeight());
                    	g.drawImage(image, 0, 0, 160, 40, null);
                        repaint();
//                        g.setColor(Color.red);
//                        g.drawString("hahahah", 40,20);
                    }
                    g.dispose();
                } while (strategy.contentsRestored());
                strategy.show();
            } while (strategy.contentsLost());
        } catch (NullPointerException e) {
        } catch (IllegalStateException e) { }
    }

    
    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;        
        repaint();    
    }
    
    public void finish(){
    	this.img = null;
    	repaint();
    }
   
    public void init(){
        new Thread(){
            public void run(){
                boolean error = true;
                while(error){
                    try{
                        error = false;
                        
                        createBufferStrategy(2);
                    }catch(IllegalStateException e){
                        error = true;
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                    }
                }
            }
        }.start();
    }
}