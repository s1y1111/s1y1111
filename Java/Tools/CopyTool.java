package Tools;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 *
 * @author JiTuo
 */
public class CopyTool {

    public static void copy(String originDirectory, String targetDirectory) {

        File origindirectory = new File(originDirectory); // 源路径File实例
        File targetdirectory = new File(targetDirectory); // 目标路径File实例
        if (!origindirectory.isDirectory() || !targetdirectory.isDirectory()) { // 判断是不是正确的路径
            System.out.println("不是正确的目录！");
            return;
        }
        File[] fileList = origindirectory.listFiles(); // 目录中的所有文件
        for (File file : fileList) {
            byte[] buffer = new byte[1];
            if (!file.isFile()) // 判断是不是文件
            {
                continue;
            }
            try {
                FileInputStream fin = new FileInputStream(file);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(fin);
                PrintStream pout = new PrintStream(targetdirectory.getAbsolutePath() + "/" + file.getName());
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(pout);

                while (bufferedInputStream.read(buffer) != -1) {
                    bufferedOutputStream.write(buffer);
                }
                bufferedOutputStream.flush();

                bufferedOutputStream.close();
                pout.close();
                bufferedInputStream.close();
                fin.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("End");
    }
}
