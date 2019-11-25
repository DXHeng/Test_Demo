package com.xio.study.stream;

import org.junit.Test;

import java.io.*;

/**
 * @author: polarbear
 * @Date: 2019/6/21 14:29
 * @Description: Test_Demo
 */
public class StreamTest {


    @Test
    public void copyFile(){
        try {
            File inFile = new File("D:\\英雄时刻\\11437696\\1.gif");
            String name = inFile.getName();
            System.out.println(name);
            File outFile = new File("E:\\testfile\\1.gif");
            //下面的判断也可以注释掉
            //因为如果写入文件不存在，系统会自动创建一个文件，而不会报错。
            if(!outFile.exists()){
                outFile.createNewFile();
            }
            FileInputStream finS = new FileInputStream(inFile);
            FileOutputStream foutS = new FileOutputStream(outFile);
            int c;
            while ((c = finS.read()) != -1) {
                foutS.write(c);
            }
            finS.close();
            foutS.close();
            System.out.println("操作完成！");
        } catch (IOException e) {
            System.err.println("FileStreamsTest: " + e);
        }
    }



    @Test
    public void fileToStream() {

        byte[] buffer = null;



        File file = new File("D:\\英雄时刻\\11437696\\1.gif");

        try {

            boolean newFile = file.createNewFile();

            FileInputStream fis = null;


            fis = new FileInputStream(file);

            ByteArrayOutputStream baos = new ByteArrayOutputStream(fis.available());

            byte[] bytes = new byte[fis.available()];

            int temp;

            while ((temp = fis.read(bytes)) != -1) {
                baos.write(bytes, 0, temp);
            }

            fis.close();

            baos.close();

            buffer = baos.toByteArray();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void fileToStream2() {

        try {
            FileInputStream rf = new FileInputStream(new File("D:\\英雄时刻\\11437696\\1.gif"));
            int n = 512;
            byte buffer[] = new byte[n];
            while ((rf.read(buffer, 0, n) != -1) && (n > 0)) {
                System.out.println(buffer);
            }
            rf.close();
        } catch (IOException IOe) {
            System.out.println(IOe.toString());
        }
    }


//
//    public void fileToStream2 (){
//
//        try {
//
//            InputStream is = request.getInputStream();
//            File filedir = new File("服务器绝对路径文件夹常量");
//            if (!filedir.exists())
//                filedir.mkdirs();
//            File file = new File(filedir, "文件名.后缀名");
//            OutputStream os = new FileOutputStream(file);
//
//            byte[] byteStr = new byte[1024];
//            int len = 0;
//            while ((len = is.read(byteStr)) > 0) {
//                os.write(byteStr,0,len);
//            }
//            is.close();
//
//            os.flush();
//            os.close();
//        } catch (FileNotFoundException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }


}
