package com.hafu.edu.teachingmanagementsystem.controller;

import com.alibaba.excel.util.FileUtils;
import com.hafu.edu.teachingmanagementsystem.Utils.R;
import com.hafu.edu.teachingmanagementsystem.Utils.ZipUtils;
import com.hafu.edu.teachingmanagementsystem.entity.Document;
import com.hafu.edu.teachingmanagementsystem.entity.FilePrize;
import com.hafu.edu.teachingmanagementsystem.entity.Prize;
import com.hafu.edu.teachingmanagementsystem.entity.User;
import com.hafu.edu.teachingmanagementsystem.service.DocumentService;
import com.hafu.edu.teachingmanagementsystem.service.PrizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 程世玉
 * @create 2022/2/6 19:34
 * @PROJECT_NAME Teaching-Management-System
 * @Description 文件操作类，关于文件的一些操作
 *                  1、查询多个文件               getAllFiles
 *                  2、下载资源                 downloadFile
 *                  3、重新上传奖项              restartUpload
 *                  4、查询单个文件              getOneFile
 *                  5、上传文件                 uploadFile
 *                  6、删除单个或多个文件（课程大纲、教学进度计划表、人才培育方案）  deleteFile
 *                  7、学生端人才培养方案查询    getStudentFile
 *
 *
 */
@RestController
@CrossOrigin
public class FilesOperateController {

    @Autowired
    private DocumentService documentService;

    @Autowired
    private PrizeService prizeService;


    /**
     * 管理员和个人查询多个文件 可以是奖项 也可以是其他文件
     * 参数描述 必传参数 pageNum pageSize uid(管理员为0 学生为具体uid)
     *
     * @author lt
     */
    @GetMapping("/fileOperate/getAllFiles")
    public R  getAllFiles(FilePrize filePrize){
        /**
         * 首先判断是管理员还是个人
         *  如果uid大于0是用户  如果uid为0是管理员 否则重新输入
         */
        if(filePrize.getUid()==0){
//            说明为管理员
//            判断管理员操作的奖项还是文件
//            condition为1说明是文件
            if(filePrize.getCondition()==1){
//                调用管理员查询文件的service
                return documentService.selectAllFile(filePrize);
            }else
            if(filePrize.getCondition()==2) {
//                调用管理员查询奖项的service
                return documentService.selectAllPrize(filePrize);

            }
            else return R.exp(201,"condition填写错误，无法判断文件还是奖项,请检查！");
        }
        /**
         *    如果是学生查询文件 学生可以查询各种文件
         *    如果是学生查询奖项  调用查询奖项service(个人奖项或者学院奖项)
         *    如果是老师查询文件 老师可以查询各种文件
         *    如果是老师查询奖项 调用查询奖项service(个人奖项或者学院奖项)
         *    学生和老师都有查询所有文件的权利 这里不再做区分
         */
//               uid大于0说明是用户
           if(filePrize.getUid()>0){
//             condition为1说明是文件
               if(filePrize.getCondition()==1){
//                调用用户查询文件的service
                   return  documentService.userSelectAllFile(filePrize);
               }else
               if(filePrize.getCondition()==2) {
//                调用用户查询奖项的service
                   return documentService.userSelectAllPrize(filePrize);
               }
               else return R.exp(201,"condition填写错误，无法判断文件还是奖项,请检查！");
        }
     return R.exp(201,"无法判断用户信息,请检查！");
    }



    /**
     * 获取单个文件
     * @param did 文件的id
     * @return json
     */
    @GetMapping("/fileOperate/getOneFile")
    public R getOneFile(@RequestParam("did") Long did){
        Document document = documentService.queryById(did);
        if (document == null){
            return R.exp(201,"操作错误，无法获取文件详情，请重新点击");
        }
        return R.ok().setData(document);
    }


   /**
    * @Description: 获取学生人才培养方案
    * @Param:
    * @return: 
    * @Author: 程世玉
    * @Date: 2022/2/11
    */
    @GetMapping("/fileOperate/getStudentFile")
    public R getStudentFile(Document d){

        R r =  documentService.queryStudentTrainResouce(d);

        return r;
    }


    /**
     * 上传文件
     * 2022/2/11
     * @author lt
     */
     @PostMapping("/fileOperate/uploadFile")
    public R uploadFile(@RequestParam("file") MultipartFile file, Document document){
       return documentService.uploadFile(file,document);
     }

    /**
     * 重新上传奖项
     * 原有的思路：将旧的奖项改为待删除状态 将新的奖项上传成功 成功后才把原有的奖项删除
     * 我的想法： 直接将旧奖项做更新 更新成功就是重新上传成功 更新失败就是重新上传失败
     * 2022/2/12
     * @author lt
     */
//    @PostMapping("/fileOperate/restartUpload")
//    public R restartUpload1(@RequestParam("files") MultipartFile[] files,Prize prize){
//        return prizeService.restartUpload( files, prize);
//    }
    /**
     * 重新上传奖项
     * 因为涉及多奖项上传 无法对多奖项同时进行update操作
     * 所以该接口重新规划 思路是将原有的奖项全部删除 然后上传新的奖项（同样是数据库增加多条记录）
     * 2022/2/20
     * @author lt
     */
    @PostMapping("/fileOperate/restartUpload")
    public R restartUpload(@RequestParam("files") MultipartFile[] files,Prize prize,int judge){
        //        judge为0说明是学生上传奖项
        if(judge==0){
            int i = prizeService.deleteByPathFront(prize);
            if (i<1){
                return R.fail().setData("删除原奖项失败，请重试!");
            }
            return prizeService.uploadFile(files,prize);
        }
//      judge为1说明是老师上传奖项
        if (judge==1){
            int i = prizeService.deleteByPathFront(prize);
            if (i<1){
                return R.fail().setData("删除原奖项失败，请重试!");
            }
            return prizeService.teacherUploadFile(files,prize);
        }
        return R.fail().setData("无法判断是老师还是学生上传奖项");
    }

    /**
     * 测试文件下载
     * @author lt
     * 2022/2/14
     * @param response
     * @param fileName
     * @return
     */
    @RequestMapping("/fileOperate/testdownloadFile")
    public String testfileDownLoad(HttpServletResponse response, @RequestParam("fileName") String fileName){
//        File file = new File("D://file//diffcident" +'/'+ fileName);
        File file = new File("D:\\file\\diffident" +File.separator+ fileName);
//        System.out.println(fileName);
        if(!file.exists()){
            return "下载文件不存在";
        }
        response.reset();
        response.setContentType("application/octet-stream");
        response.setCharacterEncoding("utf-8");
        response.setContentLength((int) file.length());
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName );

        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));) {
            byte[] buff = new byte[1024];
            OutputStream os  = response.getOutputStream();
            int i = 0;
            while ((i = bis.read(buff)) != -1) {
                os.write(buff, 0, i);
                os.flush();
            }
        } catch (IOException e) {
//            log.error("{}",e);
            return "下载失败";
        }
        return "下载成功";
    }

    /**
     * 下载单个文件
     * @author lt
     * 2022/2/14
     */
    @RequestMapping("/fileOperate/oneFileDownLoad")
    public String oneFileDownLoad(HttpServletResponse response, Document document){
//        File file = new File("D:\\file\\diffident" +File.separator+ fileName);
        File file = new File( "C:\\file\\diffident"+File.separator+ document.getFileName());
        if(!file.exists()){
            return "下载文件不存在";
        }
        response.reset();
        response.setContentType("application/octet-stream");
        response.setCharacterEncoding("utf-8");
        response.setContentLength((int) file.length());
//        设置文件名
        String name="";
        switch (document.getFileType()){
            case 10:name="课程介绍";
            break;
            case 11:name="理论教学大纲";
                break;
            case 12:name="考试大纲";
                break;
            case 13:name="实验教学大纲";
                break;
            case 20:name="教学进度计划表";
                break;
            case 30:name="人才培养方案";
                break;
        }
//        最终文件名 如：18级C语言教学进度计划表
        String fileName=document.getGrade()+document.getCourse()+name;
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName );
        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));) {
            byte[] buff = new byte[1024];
            OutputStream os  = response.getOutputStream();
            int i = 0;
            while ((i = bis.read(buff)) != -1) {
                os.write(buff, 0, i);
                os.flush();
            }
        } catch (IOException e) {
            return "下载失败";
        }
        return "下载成功";
    }

    /**
     * 下载单个奖项
     * @author lt
     * 2022/2/14
     */
    @RequestMapping("/fileOperate/onePrizeDownLoad")
    public String onePrizeDownLoad(HttpServletResponse response, Prize prize){
//        获取文件名
//        prize.getPathFront().split();
        File file = new File("D:\\file\\diffident"+prize.getPathFront().substring(prize.getPathFront().indexOf("/")));
        if(!file.exists()){
            return "下载文件不存在";
        }
        response.reset();
        response.setContentType("application/octet-stream");
        response.setCharacterEncoding("utf-8");
        response.setContentLength((int) file.length());
//        设置文件名
        response.setHeader("Content-Disposition", "attachment;filename=" + prize.getPname() );
        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));) {
            byte[] buff = new byte[1024];
            OutputStream os  = response.getOutputStream();
            int i = 0;
            while ((i = bis.read(buff)) != -1) {
                os.write(buff, 0, i);
                os.flush();
            }
        } catch (IOException e) {
            return "下载失败";
        }
        return "下载成功";
    }



     /**
      * @Description: 删除单个或多个文件（课程大纲、教学进度计划表、人才培育方案）
      * @Param:
      * @return: json
      * @Author: 程世玉
      * @Date: 2022/2/12
      */
     @DeleteMapping("/fileOperate/deleteFile")
     @PreAuthorize("hasRole('ROLE_1')")  // 有教师的权限和管理员的权限才可以访问
    public R deleteFile(@RequestParam("uid") Integer uid,
                        @RequestParam("did")ArrayList<Long> didList){

       R r = documentService.deleteByIdList(didList);

       return r;
     }


}
