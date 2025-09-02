package Test.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InputStreamTest {
    public static void main(String[] args) throws FileNotFoundException {
        String filePath = "F:\\Java-project\\javaPractice\\src\\main\\java\\com\\st\\File\\file.txt";
//        NoBufferFileInputStreamTest(filePath);
        BufferFileInputStreamTest(filePath);
    }

    private static void NoBufferFileInputStreamTest(String filePath) {
        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            int byteData;
            //一个字节一个字节的读取
            //FileInputStream.read()方法
            while((byteData = fileInputStream.read())!=-1){//返回的是单个字节的值
                System.out.println((char)byteData);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static void BufferFileInputStreamTest(String filePath) throws FileNotFoundException {
        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            byte[] buffer = new byte[1024];
            int byteData;
            while((byteData = fileInputStream.read(buffer))!= -1 ){
                String content = new String(buffer, 0, byteData);//返回的是读取的字节的数量，值存在了buffer中
                System.out.println(content);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
