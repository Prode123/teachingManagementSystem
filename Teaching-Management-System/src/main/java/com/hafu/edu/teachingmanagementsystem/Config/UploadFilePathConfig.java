package com.hafu.edu.teachingmanagementsystem.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author 程世玉
 * @create 2022/2/11 16:55
 * @PROJECT_NAME Teaching-Management-System
 * @Description 本类用来配置上传下载虚拟路径
 */
@Configuration
public class UploadFilePathConfig extends WebMvcConfigurerAdapter{

    @Value("${file.staticImgAccessPath}")
    private String staticImgAccessPath;

    /*照片路径*/
    @Value("${file.uploadImgFolder}")
    private String uploadImgFolder;

    /*文件路径*/
    @Value("${file.uploadfileFolder}")
    private String uploadfileFolder;

    /**/
    @Value("${file.uploadPrizeFolder}")
    private String uploadPrizeFolder;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(staticImgAccessPath).
                addResourceLocations("file:" + uploadImgFolder,
                        "file:" + uploadfileFolder , "file:" + uploadPrizeFolder);
    }
}
