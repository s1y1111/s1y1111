package Tools;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.bytedeco.javacpp.opencv_core.IplImage;

/**
 *
 * @author JiTuo
 */
public class TakePhotos {
    
    private  String savedImageFileCenter = "D:\\database\\picturesGet\\center.jpg";
    private  String savedImageFileLeft = "D:\\database\\picturesGet\\left.jpg";
    private  String savedImageFileRight = "D:\\database\\picturesGet\\right.jpg";

    public void takePhotos(IplImage grabbedImageCenter, IplImage grabbedImageLeft, IplImage grabbedImageRight) {
        try {
            if (grabbedImageCenter != null) {
                ImageIO.write(grabbedImageCenter.getBufferedImage(), "jpg", new File(savedImageFileCenter));
            }
            if (grabbedImageLeft != null) {
                ImageIO.write(grabbedImageLeft.getBufferedImage(), "jpg", new File(savedImageFileLeft));
            }
            if (grabbedImageRight != null) {
                ImageIO.write(grabbedImageRight.getBufferedImage(), "jpg", new File(savedImageFileRight));
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

}
