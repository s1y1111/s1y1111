package View;
//格式化代码：Alt+shift+f；

import Tools.Main;
import Tools.TakePhotos;
import com.mathworks.toolbox.javabuilder.MWException;
import Tools.ControlProperties;
import Tools.CopyTool;
import face.SampleTest;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import org.bytedeco.javacpp.opencv_core.IplImage;
import org.bytedeco.javacv.FrameGrabber;

/**
 *
 * @author JiTuo
 */
public class FaceRecognizeFrame extends javax.swing.JFrame {

    public FaceRecognizeFrame(String str) {
        super(str);
        initComponents();
        controlProperties = new ControlProperties();
        jlabelRightShow = new JLabel();
        jLabelInfo.setText("请开启系统 ！！");
        try {
            grabberCenter = FrameGrabber.createDefault(1);
            grabberLeft = FrameGrabber.createDefault(2);
            grabberRight = FrameGrabber.createDefault(0);
        } catch (Exception e2) {
            e2.printStackTrace();
        }

        timer = new Timer(changeTime, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (indexNow >= numImage) {
                    indexNow = 0;
                    timer.stop();
                }
                allImageIcon[indexNow].setImage(allImageIcon[indexNow].getImage().getScaledInstance(jPanelRightShow.getWidth(), jPanelRightShow.getHeight(), Image.SCALE_DEFAULT));
                jlabelRightShow.setIcon(allImageIcon[indexNow]);
                indexNow++;
            }
        });

        //设置实时画面；
        imageCenterpicture = Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/View/centerFace.png"));
        myCanvasCenter = new ImageCanvas(imageCenterpicture);
        myCanvasCenter.setSize(jPanelCenterFace.getWidth(), jPanelCenterFace.getHeight());
        myCanvasCenter.init();

        imageLeftpicture = Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/View/leftFace.png"));
        myCanvasLeft = new ImageCanvas(imageLeftpicture);
        myCanvasLeft.setSize(jPanelLeftFace.getWidth(), jPanelLeftFace.getHeight());
        myCanvasLeft.init();

        imageRightpicture = Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/View/RightFace.png"));
        myCanvasRight = new ImageCanvas(imageRightpicture);
        myCanvasRight.setSize(jPanelRightFace.getWidth(), jPanelRightFace.getHeight());
        myCanvasRight.init();

        jPanelCenterFace.add(myCanvasCenter);
        jPanelLeftFace.add(myCanvasLeft);
        jPanelRightFace.add(myCanvasRight);

        //jPanelRightShow.setLayout(null);
        jPanelRightShow.add(jlabelRightShow);

        try {
            sampleTest = new SampleTest();
        } catch (MWException e3) {
            e3.printStackTrace();
        }
        //按钮的设置监听事件
        jToggleButtonOnOff.addActionListener(new ONOFFActionListener());
        jButtonReset.addActionListener(new ResetActionListener());
        jButtonRecognize.addActionListener(new RecognizesActionListener());
        jButtonGetInfo.addActionListener(new GetInfoActionListener());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBackground = new BackgroundPanel();
        jLabelSystem = new javax.swing.JLabel();
        jLabelSchool = new javax.swing.JLabel();
        jLabelTeam = new javax.swing.JLabel();
        jPanelCenterFace = new javax.swing.JPanel();
        jPanelLeftFace = new javax.swing.JPanel();
        jPanelShowInfo = new javax.swing.JPanel();
        jLabelScreen = new javax.swing.JLabel();
        jLabelInfo = new javax.swing.JLabel();
        jLabelJava = new javax.swing.JLabel();
        jLabelMatlab = new javax.swing.JLabel();
        jLabelWindows = new javax.swing.JLabel();
        jPanelRightFace = new javax.swing.JPanel();
        jPanelRightShow = new javax.swing.JPanel();
        jButtonGetInfo = new javax.swing.JButton();
        jButtonRecognize = new javax.swing.JButton();
        jButtonReset = new javax.swing.JButton();
        jLabelcamera = new javax.swing.JLabel();
        jToggleButtonOnOff = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelSystem.setBackground(new java.awt.Color(255, 255, 255));
        jLabelSystem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ImageIcon iconSystem = new javax.swing.ImageIcon(getClass().getResource("/View/system.png"));
        iconSystem.setImage(iconSystem.getImage().getScaledInstance(360, 118, 1));
        jLabelSystem.setIcon(iconSystem);

        jLabelSchool.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ImageIcon iconSchool = new javax.swing.ImageIcon(getClass().getResource("/View/school.png"));
        iconSchool.setImage(iconSchool.getImage().getScaledInstance(280, 75, 1));
        jLabelSchool.setIcon(iconSchool);

        jLabelTeam.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ImageIcon iconTeam = new javax.swing.ImageIcon(getClass().getResource("/View/team.png"));
        iconTeam.setImage(iconTeam.getImage().getScaledInstance(240, 143, 1));
        jLabelTeam.setIcon(iconTeam);

        jPanelCenterFace.setBackground(new java.awt.Color(0, 0, 0));
        jPanelCenterFace.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanelCenterFaceLayout = new javax.swing.GroupLayout(jPanelCenterFace);
        jPanelCenterFace.setLayout(jPanelCenterFaceLayout);
        jPanelCenterFaceLayout.setHorizontalGroup(
            jPanelCenterFaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 399, Short.MAX_VALUE)
        );
        jPanelCenterFaceLayout.setVerticalGroup(
            jPanelCenterFaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 311, Short.MAX_VALUE)
        );

        jPanelLeftFace.setBackground(new java.awt.Color(0, 0, 0));
        jPanelLeftFace.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanelLeftFaceLayout = new javax.swing.GroupLayout(jPanelLeftFace);
        jPanelLeftFace.setLayout(jPanelLeftFaceLayout);
        jPanelLeftFaceLayout.setHorizontalGroup(
            jPanelLeftFaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 221, Short.MAX_VALUE)
        );
        jPanelLeftFaceLayout.setVerticalGroup(
            jPanelLeftFaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanelShowInfo.setBackground(new java.awt.Color(17, 17, 17));

        jLabelScreen.setBackground(new java.awt.Color(37, 35, 35));
        ImageIcon iconcreenInfo = new javax.swing.ImageIcon(getClass().getResource("/View/screen.png"));
        iconcreenInfo.setImage(iconcreenInfo.getImage().getScaledInstance(140, 40, 1));
        jLabelScreen.setIcon(iconcreenInfo);
        jLabelScreen.setOpaque(true);

        jLabelInfo.setBackground(new java.awt.Color(23, 22, 22));
        jLabelInfo.setFont(new java.awt.Font("宋体", 0, 26)); // NOI18N
        jLabelInfo.setForeground(new java.awt.Color(251, 248, 248));
        jLabelInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelInfo.setText("认证成功！！");
        jLabelInfo.setOpaque(true);

        javax.swing.GroupLayout jPanelShowInfoLayout = new javax.swing.GroupLayout(jPanelShowInfo);
        jPanelShowInfo.setLayout(jPanelShowInfoLayout);
        jPanelShowInfoLayout.setHorizontalGroup(
            jPanelShowInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelShowInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelShowInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelShowInfoLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabelInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabelScreen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanelShowInfoLayout.setVerticalGroup(
            jPanelShowInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelShowInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelScreen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabelJava.setBackground(new java.awt.Color(0, 0, 0));
        jLabelJava.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ImageIcon iconJava = new javax.swing.ImageIcon(getClass().getResource("/View/java.png"));
        iconJava.setImage(iconJava.getImage().getScaledInstance(53, 53, 1));
        jLabelJava.setIcon(iconJava);

        jLabelMatlab.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ImageIcon iconMatlab = new javax.swing.ImageIcon(getClass().getResource("/View/matlab.png"));
        iconMatlab.setImage(iconMatlab.getImage().getScaledInstance(60, 60, 1));
        jLabelMatlab.setIcon(iconMatlab);

        jLabelWindows.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ImageIcon iconWindows = new javax.swing.ImageIcon(getClass().getResource("/View/windows.png"));
        iconWindows.setImage(iconWindows.getImage().getScaledInstance(60, 60, 1));
        jLabelWindows.setIcon(iconWindows);

        jPanelRightFace.setBackground(new java.awt.Color(0, 0, 0));
        jPanelRightFace.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanelRightFaceLayout = new javax.swing.GroupLayout(jPanelRightFace);
        jPanelRightFace.setLayout(jPanelRightFaceLayout);
        jPanelRightFaceLayout.setHorizontalGroup(
            jPanelRightFaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 221, Short.MAX_VALUE)
        );
        jPanelRightFaceLayout.setVerticalGroup(
            jPanelRightFaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanelRightShow.setBackground(new java.awt.Color(0, 0, 0));
        jPanelRightShow.setLayout(new javax.swing.BoxLayout(jPanelRightShow, javax.swing.BoxLayout.LINE_AXIS));

        ImageIcon iconGetInfoButton = new javax.swing.ImageIcon(getClass().getResource("/View/getInfo.png"));
        iconGetInfoButton.setImage(iconGetInfoButton.getImage().getScaledInstance(150, 46 , 1));
        jButtonGetInfo.setIcon(iconGetInfoButton);

        ImageIcon iconRecognizedButton = new javax.swing.ImageIcon(getClass().getResource("/View/recognize.png"));
        iconRecognizedButton.setImage(iconRecognizedButton.getImage().getScaledInstance(150, 46, 1));
        jButtonRecognize.setIcon(iconRecognizedButton);

        ImageIcon iconResetButton = new javax.swing.ImageIcon(getClass().getResource("/View/reset.png"));
        iconResetButton.setImage(iconResetButton.getImage().getScaledInstance(150, 46, 1));
        jButtonReset.setIcon(iconResetButton);

        ImageIcon iconCamera = new javax.swing.ImageIcon(getClass().getResource("/View/camera.png"));
        iconCamera.setImage(iconCamera.getImage().getScaledInstance(53, 53, 1));
        jLabelcamera.setIcon(iconCamera);

        ImageIcon iconOff = new javax.swing.ImageIcon(getClass().getResource("/View/off.png"));
        iconOff.setImage(iconOff.getImage().getScaledInstance(102, 45 , 1));
        jToggleButtonOnOff.setIcon(iconOff);

        javax.swing.GroupLayout jPanelBackgroundLayout = new javax.swing.GroupLayout(jPanelBackground);
        jPanelBackground.setLayout(jPanelBackgroundLayout);
        jPanelBackgroundLayout.setHorizontalGroup(
            jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBackgroundLayout.createSequentialGroup()
                .addGroup(jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelBackgroundLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabelSchool, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(jLabelSystem, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelTeam, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelBackgroundLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelBackgroundLayout.createSequentialGroup()
                                .addComponent(jPanelCenterFace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelBackgroundLayout.createSequentialGroup()
                                        .addComponent(jLabelJava, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelMatlab, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabelWindows, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelBackgroundLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jButtonGetInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanelBackgroundLayout.createSequentialGroup()
                                                .addComponent(jLabelcamera, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jToggleButtonOnOff, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jButtonRecognize, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButtonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addComponent(jPanelRightShow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanelBackgroundLayout.createSequentialGroup()
                                .addComponent(jPanelLeftFace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanelRightFace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanelShowInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(32, 32, 32))
        );
        jPanelBackgroundLayout.setVerticalGroup(
            jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBackgroundLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTeam, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelSystem, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelSchool, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelBackgroundLayout.createSequentialGroup()
                        .addGroup(jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelWindows, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelMatlab, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelJava, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelBackgroundLayout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jToggleButtonOnOff, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBackgroundLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelcamera, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jButtonGetInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonRecognize, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanelCenterFace, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelRightShow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelRightFace, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelLeftFace, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelShowInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    class ONOFFActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            AbstractButton abstractButton = (AbstractButton) e.getSource();
            boolean selected = abstractButton.getModel().isSelected();
            if (selected) {
                systemOn();
            } else {
                systemOFF();
            }
        }
    }

    class ResetActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (systemIsOn) {
                systemOFF();
                systemOn();
                countJ = 1;
                CopyTool.copy(backUpFilePath, workingFilePath);
            }
        }
    }

    class GetInfoActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (systemIsOn) {
                CopyTool.copy(workingFilePath, backUpFilePath);
                userName = JOptionPane.showInputDialog(null, "请输入姓名信息：", "录入信息", JOptionPane.INFORMATION_MESSAGE);
                if (userName != null && userName != "") {
                    getInfoThread = new GetInfoThread();
                    getInfoThread.start();
                    jLabelInfo.setText("正在录入！");

                    jButtonGetInfo.setEnabled(false);
                    jButtonRecognize.setEnabled(false);

                    //********录入信息的代码放这里*************************
                    countI = controlProperties.readProperties("i");
                    countI++;
                    //controlProperties.writeData("i", countI + "");
                    /*boolean getInfoSuccess = true;
                    
                     int n = JOptionPane.showConfirmDialog(null, userName + ":我们将对您的面部采集五次信息，是否继续？", "录入人脸信息", JOptionPane.YES_NO_OPTION);//返回的是按钮的index  i=0或者1
                     if (n == 0) {
                     for (int j = 1; j < 6; j++) {
                     int temp = JOptionPane.showConfirmDialog(null, userName + "请保证面部位于合适位置并开始第" + j + "次采集！", "第" + j + "次采集", JOptionPane.YES_NO_OPTION);
                     //JOptionPane.showMessageDialog(null, "请保证面部位于合适位置并开始第"+j+"次采集！", "第"+j+"次采集", JOptionPane.WARNING_MESSAGE); 
                     if (temp == 1) {
                     getInfoSuccess = false;
                     break;
                     }
                     cameraTool = new TakePhotos();
                     cameraTool.takePhotos(grabbedImageCenter, grabbedImageLeft, grabbedImageRight);
                     try {
                     System.out.println("start----------------------------------------------");
                     getInfoResult = sampleTest.mainSample(1, countI, j, userName);
                     } catch (MWException ex) {
                     // Logger.getLogger(FaceRecognizeFrame.class.getName()).log(Level.SEVERE, null, ex);
                     } catch (UndeclaredThrowableException e2) {
                     //e2.printStackTrace();
                     }
                     if (getInfoResult[0].toString().equals("0")) {
                     j--;
                     JOptionPane.showMessageDialog(null, "第" + j + "次采集失败！请目视前方不要晃动，并重新开始", "采集失败", JOptionPane.WARNING_MESSAGE);
                     }
                     }
                     if (getInfoSuccess == true) {
                     jLabelInfo.setText("录入成功！！");
                     } else {
                     countI--;
                     controlProperties.writeData("i", countI + "");
                     jLabelInfo.setText("请选择操作 ！！");
                     }
                     } else {
                     jLabelInfo.setText("请选择操作 ！！");
                     }
                     jButtonGetInfo.setEnabled(true);
                     jButtonRecognize.setEnabled(true);
                     jButtonReset.setEnabled(true);*/

                    //启动线程监控执行的以前的做法：
                    int n = JOptionPane.showConfirmDialog(null, userName + ":我们将对您的面部采集五次信息，是否继续？", "录入人脸信息", JOptionPane.YES_NO_OPTION);//返回的是按钮的index  i=0或者1
                    if (n == 0) {
                        cameraTool = new TakePhotos();
                        cameraTool.takePhotos(grabbedImageCenter, grabbedImageLeft, grabbedImageRight);
                        getinfoToFileThread = new GetInfo();
                        moniterGetInfoThread = new MoniterGetInfo();
                        getinfoToFileThread.start();
                        moniterGetInfoThread.start();
                    } else {
                        getInfoThread.stop();
                        jLabelInfo.setText("请选择操作！！");
                        jButtonGetInfo.setEnabled(true);
                        jButtonRecognize.setEnabled(true);
                    }
                }
                if (userName == "") {
                    jLabelInfo.setText("请输入有效的信息！！！");
                    jButtonGetInfo.setEnabled(true);
                    jButtonRecognize.setEnabled(true);
                }
            }
        }
    }

    class RecognizesActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (systemIsOn) {
                CopyTool.copy(workingFilePath, backUpFilePath);
                infoThread = new InfoThread();
                infoThread.start();

                jButtonGetInfo.setEnabled(false);
                jButtonRecognize.setEnabled(false);
                //识别人脸程序s：*****************************************************
                //*******识别人脸的程序添加在这里：*************************

                recgnize = new Recgnize();
                moniter = new Moniter();
                recgnize.start();
                moniter.start();
            }
        }
    }

    //正面：
    class CameraThreadCenter extends Thread {

        @Override
        public void run() {
            super.run();
            try {
                grabberCenter.start();
                grabbedImageCenter = grabberCenter.grab();
                while ((grabbedImageCenter = grabberCenter.grab()) != null) {
                    myCanvasCenter.setImg(grabbedImageCenter.getBufferedImage());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //左侧面的画面：
    class CameraThreadLeft extends Thread {

        @Override
        public void run() {
            super.run();
            try {
                grabberLeft.start();
                grabbedImageLeft = grabberLeft.grab();
                while ((grabbedImageLeft = grabberLeft.grab()) != null) {
                    myCanvasLeft.setImg(grabbedImageLeft.getBufferedImage());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //右侧面的画面：
    class CameraThreadRight extends Thread {

        @Override
        public void run() {
            super.run();
            try {
                grabberRight.start();
                grabbedImageRight = grabberRight.grab();
                while ((grabbedImageRight = grabberRight.grab()) != null) {
                    myCanvasRight.setImg(grabbedImageRight.getBufferedImage());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //------------录入信息文字提示效果-------------------------------------------------------
    class GetInfoThread extends Thread {

        @Override
        public void run() {
            super.run();
            while (true) {
                jLabelInfo.setText(userName + ":" + "\n" + getInfoText[getInfoTextNum]);
                getInfoTextNum++;
                if (getInfoTextNum > 3) {
                    getInfoTextNum = 0;
                }
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //------------识别文字提示信息效果----------------------------------------------------------
    class InfoThread extends Thread {

        @Override
        public void run() {
            super.run();
            while (true) {
                jLabelInfo.setText(recognizeText[recognizeTextNum]);
                recognizeTextNum++;
                if (recognizeTextNum > 3) {
                    recognizeTextNum = 0;
                }
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //监控识别人脸的线程：
    class Moniter extends Thread {

        @Override
        public void run() {
            super.run();
            while (true) {
                if (recgnize.isAlive()) {
                } else {
                    infoThread.stop();
                    if ((Integer.parseInt("" + recoginizeResult[1])) == 1) {
                        if (recognizeName.equals(recoginizeResult[0].toString())) {
                            jLabelInfo.setText(recoginizeResult[0].toString() + ",认证成功！");
                        } else {
                            jLabelInfo.setText("输入姓名与识别信息不符!!");
                        }
                    } else {
                        jLabelInfo.setText("认证失败!!");
                    }
                    jButtonGetInfo.setEnabled(true);
                    jButtonRecognize.setEnabled(true);
                    break;
                }
            }
        }
    }

    //监控录入的线程：
    class MoniterGetInfo extends Thread {

        @Override
        public void run() {
            while (true) {
                if (getinfoToFileThread.isAlive()) {
                } else {
                    countJ++;
                    if (getInfoResult[0].toString().equals("0")) {
                        countJ--;
                        JOptionPane.showMessageDialog(null, "第" + countJ + "次采集失败！请目视前方不要晃动，并重新开始", "采集失败", JOptionPane.WARNING_MESSAGE);
                    }
                    if (countJ == 6) {
                        getInfoThread.stop();
                        countJ = 1;
                        jLabelInfo.setText("录入成功！！");
                        jButtonGetInfo.setEnabled(true);
                        jButtonRecognize.setEnabled(true);
                        moniterGetInfoThread.stop();
                        break;
                    } else {
                        cameraTool = new TakePhotos();
                        cameraTool.takePhotos(grabbedImageCenter, grabbedImageLeft, grabbedImageRight);
                        getinfoToFileThread = new GetInfo();
                        getinfoToFileThread.start();
                    }
                }
            }
        }

    }

    //录入的线程：
    class GetInfo extends Thread {

        @Override
        public void run() {
            try {
                int temp = JOptionPane.showConfirmDialog(null, userName + "请保证面部位于合适位置并开始第" + countJ + "次采集！", "第" + countJ + "次采集", JOptionPane.YES_NO_OPTION);
                //JOptionPane.showMessageDialog(null, "请保证面部位于合适位置并开始第"+j+"次采集！", "第"+j+"次采集", JOptionPane.WARNING_MESSAGE); 
                if (temp == 1) {
                    //getInfoSuccess = false;
                    //取消了
                    moniterGetInfoThread.stop();
                    getInfoThread.stop();
                    sampleTest.Abandon(countJ);
                    countJ = 1;
                    countI--;
                    controlProperties.writeData("i", countI + "");
                    jLabelInfo.setText("请选择操作 ！！");
                    jButtonGetInfo.setEnabled(true);
                    jButtonRecognize.setEnabled(true);
                } else {
                    initImage(filePathGetInfo);
                    timer.start();
                    getInfoResult = sampleTest.mainSample(1, countI, countJ, userName);
                }
            } catch (MWException ex) {
                //Logger.getLogger(FaceRecognizeFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UndeclaredThrowableException e2) {
                //e2.printStackTrace();
            }
        }

    }

    //识别人脸的线程：
    class Recgnize extends Thread {

        @Override
        public void run() {
            recognizeName = JOptionPane.showInputDialog(null, "输入姓名后请保证面部位置正确并开始识别，请输入姓名信息：", "录入信息", JOptionPane.INFORMATION_MESSAGE);
            //recognizeName = "'"+recognizeName+"'";
            if (recognizeName != null) {
                cameraTool = new TakePhotos();
                cameraTool.takePhotos(grabbedImageCenter, grabbedImageLeft, grabbedImageRight);
                initImage(filePathGetInfo);
                timer.start();
                try {
                    recoginizeResult = sampleTest.test(2);
                } catch (MWException e) {
                    //e.printStackTrace();
                } catch (UndeclaredThrowableException e2) {
                    //e2.printStackTrace();
                }
            } else {
                infoThread.stop();
                jLabelInfo.setText("请选择操作！");
                jButtonGetInfo.setEnabled(true);
                jButtonRecognize.setEnabled(true);
            }
        }
    }

    private void initImage(String filePath) {
        File file = new File(filePath);
        File[] files = file.listFiles();
        numImage = files.length;
        allImageIcon = new ImageIcon[numImage];
        for (int i = 0; i < files.length; i++) {
            File file1 = files[i];
            //System.out.println(file1.getName());   //根据后缀判断
            ImageIcon icon = new ImageIcon(filePath + "\\" + file1.getName());
            allImageIcon[i] = icon;
        }
    }

    private void systemOn() {
        systemIsOn = true;
        CopyTool.copy(workingFilePath, backUpFilePath);
        ImageIcon iconOff = new javax.swing.ImageIcon(getClass().getResource("/View/on.png"));
        iconOff.setImage(iconOff.getImage().getScaledInstance(102, 45, 1));
        jToggleButtonOnOff.setIcon(iconOff);
        caremaThreadCenter = new CameraThreadCenter();
        caremaThreadLeft = new CameraThreadLeft();
        caremaThreadRight = new CameraThreadRight();
        caremaThreadCenter.start();
        caremaThreadLeft.start();
        caremaThreadRight.start();
        jLabelInfo.setText("请选择操作 ！！");
    }

    private void systemOFF() {
        systemIsOn = false;
        ImageIcon iconOff = new javax.swing.ImageIcon(getClass().getResource("/View/off.png"));
        iconOff.setImage(iconOff.getImage().getScaledInstance(102, 45, 1));
        jToggleButtonOnOff.setIcon(iconOff);

        jlabelRightShow.setIcon(null);

        jButtonGetInfo.setEnabled(true);
        jButtonRecognize.setEnabled(true);

        if (infoThread != null && infoThread.isAlive()) {
            infoThread.stop();
        }

        if (getInfoThread != null && getInfoThread.isAlive()) {
            getInfoThread.stop();
        }

        if (getinfoToFileThread != null && getinfoToFileThread.isAlive()) {
            getinfoToFileThread.stop();
        }

        if (moniterGetInfoThread != null && moniterGetInfoThread.isAlive()) {
            moniterGetInfoThread.stop();
        }

        if (recgnize != null && recgnize.isAlive()) {
            recgnize.stop();
        }

        if (moniter != null && moniter.isAlive()) {
            moniter.stop();
        }

        try {
            caremaThreadCenter.stop();
            grabberCenter.stop();
            myCanvasCenter.finish();

            caremaThreadLeft.stop();
            grabberLeft.stop();
            myCanvasLeft.finish();

            caremaThreadRight.stop();
            grabberRight.stop();
            myCanvasRight.finish();

        } catch (FrameGrabber.Exception ex) {
            Logger.getLogger(FaceRecognizeFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        jLabelInfo.setText("请开启系统 ！！");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonGetInfo;
    private javax.swing.JButton jButtonRecognize;
    private javax.swing.JButton jButtonReset;
    private javax.swing.JLabel jLabelInfo;
    private javax.swing.JLabel jLabelJava;
    private javax.swing.JLabel jLabelMatlab;
    private javax.swing.JLabel jLabelSchool;
    private javax.swing.JLabel jLabelScreen;
    private javax.swing.JLabel jLabelSystem;
    private javax.swing.JLabel jLabelTeam;
    private javax.swing.JLabel jLabelWindows;
    private javax.swing.JLabel jLabelcamera;
    private javax.swing.JPanel jPanelBackground;
    private javax.swing.JPanel jPanelCenterFace;
    private javax.swing.JPanel jPanelLeftFace;
    private javax.swing.JPanel jPanelRightFace;
    private javax.swing.JPanel jPanelRightShow;
    private javax.swing.JPanel jPanelShowInfo;
    private javax.swing.JToggleButton jToggleButtonOnOff;
    // End of variables declaration//GEN-END:variables
    private FrameGrabber grabberCenter;
    private FrameGrabber grabberLeft;
    private FrameGrabber grabberRight;
    private ImageCanvas myCanvasCenter;
    private ImageCanvas myCanvasLeft;
    private ImageCanvas myCanvasRight;
    private Image imageCenterpicture;
    private Image imageLeftpicture;
    private Image imageRightpicture;
    private CameraThreadCenter caremaThreadCenter = null;
    private CameraThreadLeft caremaThreadLeft = null;
    private CameraThreadRight caremaThreadRight = null;
    private volatile ControlProperties controlProperties = null;
    private boolean systemIsOn = false;
    private IplImage grabbedImageCenter = null;
    private IplImage grabbedImageLeft = null;
    private IplImage grabbedImageRight = null;
    private TakePhotos cameraTool;
    private int recognizeTextNum = 0;
    private int getInfoTextNum = 0;
    private String[] recognizeText = {"正在识别", "正在识别 .", "正在识别 . .", "正在识别 . . ."};
    private String[] getInfoText = {"我们正在录入", "我们正在录入 .", "我们正在录入 . .", "我们正在录入 . . ."};
    private InfoThread infoThread = null;
    private GetInfoThread getInfoThread = null;
    private String userName;
    private SampleTest sampleTest;
    private Object[] recoginizeResult = null;
    private Object[] getInfoResult = null;
    private Recgnize recgnize = null;
    private Moniter moniter = null;
    private GetInfo getinfoToFileThread = null;
    private MoniterGetInfo moniterGetInfoThread = null;
    private int countJ = 1;
    private int countI = 0;
    private JLabel jlabelRightShow;
    private int changeTime = 1000;
    private int indexNow = 0;
    private int numImage = 3;
    private ImageIcon[] allImageIcon;
    private String filePathTest = "D:\\database\\picturesTest";
    private String filePathGetInfo = "D:\\database\\picturesGet";
    private String workingFilePath = "D:\\database\\data";
    private String backUpFilePath = "D:\\database\\backUp";
    private Timer timer;
    private String recognizeName;
}
