package com.platform.admin.common.util;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileUtils {
    /**
     * 嵌套删除多级目录
     *
     * @param[in]oPath目录
     */
    private static void deleteFolder(final File oPath) {
        final File[] dirs = oPath.listFiles();
        if (dirs != null) {
            for (final File oSubPath : dirs) {
                if (oSubPath.isDirectory()) {
                    deleteFolder(oSubPath);
                }
            }
        }
        oPath.delete();
    }

    /**
     * 删除单级目录
     *
     * @param[in]sPath目录
     */
    public static void deleteFolder(final String sPath) {
        final File oPath = new File(sPath);
        if (!oPath.exists() || !oPath.isDirectory()) {
            return;
        }

        deleteFolder(oPath);
    }

    public static void deleteDir(File dir) {
        if (dir == null || !dir.exists() || !dir.isDirectory())
            return; // 检查参数
        for (File file : dir.listFiles()) {
            if (file.isFile())
                file.delete(); // 删除所有文件
            else if (file.isDirectory())
                deleteDir(file); // 递规的方式删除文件夹
        }
        dir.delete();// 删除目录本身
    }


    /**
     * 创建多级目录
     *
     * @param[in]sPath目录
     * @return是否创建成功
     */
    public static boolean createFolder(final String sPath) {
        try {
            final File oPath = new File(sPath);
            if (!oPath.exists()) {
                oPath.mkdirs();
            }
            return true;
        } catch (final Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 复制文件
     *
     * @throws IOException
     * @param[in] sFile1
     * @param[in] sFile2
     */
    public static void copyFile(final String sFile1, final String sFile2)
            throws IOException {
        final File oFile1 = new File(sFile1);
        if (oFile1.exists()) {
            final String sPath = sFile2.substring(0, sFile2.lastIndexOf('\\'));
            createFolder(sPath); // 确保目标目录存在

            final File oFile2 = new File(sFile2);
            final RandomAccessFile inData = new RandomAccessFile(oFile1, "r");
            final RandomAccessFile opData = new RandomAccessFile(oFile2, "rw");
            final FileChannel inChannel = inData.getChannel();
            final FileChannel opChannel = opData.getChannel();
            inChannel.transferTo(0, inChannel.size(), opChannel);
            inChannel.close();
            inData.close();
            opChannel.close();
            opData.close();
        }
    }


    /**
     * 复制文件
     *
     * @throws IOException
     * @param[in] oFile1
     * @param[in] sFile2
     */
    public static void copyFile(final File oFile1, final String sFile2)
            throws IOException {
        if (oFile1.exists()) {
            final String sPath = sFile2.substring(0, sFile2.lastIndexOf('\\'));
            createFolder(sPath); // 确保目标目录存在

            final File oFile2 = new File(sFile2);
            final RandomAccessFile inData = new RandomAccessFile(oFile1, "r");
            final RandomAccessFile opData = new RandomAccessFile(oFile2, "rw");
            final FileChannel inChannel = inData.getChannel();
            final FileChannel opChannel = opData.getChannel();
            inChannel.transferTo(0, inChannel.size(), opChannel);
            inChannel.close();
            inData.close();
            opChannel.close();
            opData.close();
        }
    }


    /**
     * 获取目下的图片文件列表
     * @param path
     * @return
     */
    public static List<Map<String,String>> getPicFileList(String path){
        List<Map<String,String>> list = new ArrayList<Map<String,String>>();

        try{
            File dir = new File(path);

            String[] children = dir.list();
            if (children == null) {
                // 不存在或者不是目录
            } else {
                for (int i = 0; i < children.length; i++) {
                    //是图片
                    if(isPicture(children[i])){
                        // 文件名
                        Map<String,String> map = new HashMap<String, String>();
                        map.put("icon",children[i]);
                        list.add(map);
                    }
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }



    /**
     * 判断文件是否为图片
     * @param fileName
     * @return
     * @throws Exception
     */
    public static boolean isPicture(String fileName){
        if(fileName.lastIndexOf(".")==-1)
            return false;

        // 获得文件后缀名
        String tmpName = fileName.substring(fileName.lastIndexOf(".") + 1,fileName.length());
        // 声明图片后缀名数组
        String imgeArray [][] = {
                {"bmp", 	"0"}
                , {"dib", 	"1"}
                , {"gif", 	"2"}
                , {"jfif", 	"3"}
                , {"jpe", 	"4"}
                , {"jpeg", 	"5"}
                , {"jpg", 	"6"}
                , {"png", 	"7"}
                , {"tif", 	"8"}
                , {"tiff", 	"9"}
                , {"ico", 	"10"}
        };
        // 遍历名称数组
        for(int i = 0; i<imgeArray.length;i++){
            // 判断单个类型文件的场合
            if (imgeArray[i][0].equals(tmpName.toLowerCase())) {
                return true;
            }
        }
        return false;
    }


    public static boolean isEmpty(String str){
        if(str==null || "".equalsIgnoreCase(str))return true;
        return false;
    }
}
