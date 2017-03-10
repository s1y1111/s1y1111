package View;

import java.awt.*;  
import javax.swing.ImageIcon;
import javax.swing.JPanel;  
  
/** 
 * 有背景图片的Panel类 
 * @author tntxia 
 * 
 */  
public class BackgroundPanel extends JPanel {  
     
    private final Image image=new ImageIcon(getClass().getResource("/View/background.png")).getImage();  
    private static final long serialVersionUID = -6352788025440244338L; 
  
    // 固定背景图片，允许这个JPanel可以在图片上添加其他组件  
    @Override
    protected void paintComponent(Graphics g) {  
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);  
    }  
}  