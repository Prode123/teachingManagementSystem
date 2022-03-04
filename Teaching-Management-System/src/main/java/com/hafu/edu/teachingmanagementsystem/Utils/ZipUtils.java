package com.hafu.edu.teachingmanagementsystem.Utils;

import com.hafu.edu.teachingmanagementsystem.Exception.ErrorCodeEnum;
import com.hafu.edu.teachingmanagementsystem.Exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author 程世玉
 * @create 2022/2/20 10:39
 * @PROJECT_NAME Teaching-Management-System
 * @Description
 */
public class ZipUtils {
    private static final Logger logger = LoggerFactory.getLogger(ZipUtils.class);

    /**
     * 获取当前系统的临时目录
     */
    private static final String FILE_PATH = System.getProperty("java.io.tmpdir") + File.separator;

    private static final int ZIP_BUFFER_SIZE = 8192;

    /**
     * zip打包下载
     * @author 程世玉
     */
    public static void zipDownload(HttpServletResponse response, String zipFileName, List<File> fileList) {
        // zip文件路径
        String zipPath = FILE_PATH + zipFileName;
        try {
            //创建zip输出流
            try (ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipPath))) {
                //声明文件集合用于存放文件
                byte[] buffer = new byte[1024];
                //将文件放入zip压缩包
                for (int i = 0; i < fileList.size(); i++) {
                    File file = fileList.get(i);
                    try (FileInputStream fis = new FileInputStream(file)) {
                        out.putNextEntry(new ZipEntry(file.getName()));
                        int len;
                        // 读入需要下载的文件的内容，打包到zip文件
                        while ((len = fis.read(buffer)) > 0) {
                            out.write(buffer, 0, len);
                        }
                        out.closeEntry();
                    }
                }
            }
            //下载zip文件
            downFile(response, zipFileName);
        } catch (Exception e) {
            throw new ServiceException(ErrorCodeEnum.DOWNLOAD_ERROR);
        } finally {
            // zip文件删除
            List<File> list = new ArrayList<>();
            list.add(new File(zipPath));
            deleteFile(list);
        }
    }

    /**
     * 文件下载
     * @author 程世玉
     */
    private static void downFile(HttpServletResponse response, String zipFileName) {
        try {
            String path = FILE_PATH + zipFileName;
            File file = new File(path);
            if (file.exists()) {
                try (InputStream ins = new FileInputStream(path);
                     BufferedInputStream bins = new BufferedInputStream(ins);
                     OutputStream outs = response.getOutputStream();
                     BufferedOutputStream bouts = new BufferedOutputStream(outs)) {
                    response.setContentType("application/x-download");
                    response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(zipFileName, "UTF-8"));
                    int bytesRead = 0;
                    byte[] buffer = new byte[ZIP_BUFFER_SIZE];
                    while ((bytesRead = bins.read(buffer, 0, ZIP_BUFFER_SIZE)) != -1) {
                        bouts.write(buffer, 0, bytesRead);
                    }
                    bouts.flush();
                }
            }
        } catch (Exception e) {
            logger.error("文件下载出错", e);
        }
    }

    /**
     * 删除文件
     * @author 程世玉
     */
    public static void deleteFile(List<File> fileList) {
        for (File file : fileList) {
            if (file.exists()) {
                file.delete();
            }
        }
    }
}
