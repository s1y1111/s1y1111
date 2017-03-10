package Tools;

import View.FaceRecognizeFrame;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

/**
 * @author JiTuo
 */
public class Main {
    public static void main(String[] args){
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FaceRecognizeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FaceRecognizeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FaceRecognizeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FaceRecognizeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            private Object frame;
            public void run() {
                FaceRecognizeFrame faceRecognizeFrame = new FaceRecognizeFrame("  Running Face");
                faceRecognizeFrame.setSize(1100,730);
                faceRecognizeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	            	 //定义工具包
	    	        Toolkit toolkit = Toolkit.getDefaultToolkit();
	    	        Dimension screenSize = toolkit.getScreenSize();
	    	        int screenWidth = screenSize.width/2;
	    	        int screenHeight = screenSize.height/2;
	    	        int frameWidth = faceRecognizeFrame.getWidth();
	    	        int frameHeight = faceRecognizeFrame.getHeight();
	    	        
	    	        faceRecognizeFrame.setLocation(screenWidth-frameWidth/2, screenHeight-frameHeight/2-20);
	            	faceRecognizeFrame.setResizable(false);
	            	faceRecognizeFrame.setVisible(true);
            }
        });
    }
}
