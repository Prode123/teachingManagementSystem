package com.hafu.edu.teachingmanagementsystem.controller;

import com.hafu.edu.teachingmanagementsystem.Utils.ExcelUtils;
import com.hafu.edu.teachingmanagementsystem.Utils.R;
import com.hafu.edu.teachingmanagementsystem.Utils.ZipUtils;
import com.hafu.edu.teachingmanagementsystem.Utils.splitUtils;
import com.hafu.edu.teachingmanagementsystem.dao.PrizeDao;
import com.hafu.edu.teachingmanagementsystem.entity.*;
import com.hafu.edu.teachingmanagementsystem.service.PrizeService;
import com.hafu.edu.teachingmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 程世玉
 * @create 2022/2/8 12:50
 * @PROJECT_NAME Teaching-Management-System
 * @Description 奖项类，奖项的一些操作
 * 1、查询单个奖项              getOnePrize
 * 2、上传奖项                 uploadPrize
 * 3、删除单个和多个奖项         deletePrize
 * 4、查询获奖人名字             getPrizeWinner
 * 5、批量下载奖项照片          zipDownload
 */
@RestController
public class PrizeUserOperateController {

    @Autowired
    private PrizeService prizeService;

    @Autowired
    private UserService userService;

    @Resource
    private PrizeDao prizeDao;

    /**
     * @Description: 通过奖项id查询一个奖项
     * @Param: 奖项id
     * @return: R
     * @Author: 程世玉
     * @Date: 2022/2/11
     */
    @GetMapping("/prize/getOnePrize")
    public R getOnePrize(@RequestParam("pizId") Long pizId) {
        Prize prize = prizeService.queryById(pizId);
        if (prize == null) {
            return R.exp(201, "奖项查询错误，该奖项不存在");
        }

        return R.ok().setData(prize);
    }

    /**
     * @Description: 删除单个和多个奖项
     * @Param:
     * @return: json
     * @Author: 程世玉
     * @Date: 2022/2/9
     * 管理员才能够删除奖项，所以这里开始判断，比如有管理权限才可以访问
     */
    @DeleteMapping("/prize/deletePrize")
    public R deletePrize(@RequestParam("pizIdList") ArrayList<Integer> pizIdList) {

        R flag = prizeService.deleteByListId(pizIdList);

        return flag;
    }


    /**
     * @Description: 查询获奖人名字
     * @Param:
     * @return: R
     * @Author: 程世玉
     * @Date: 2022/2/11
     */
    @GetMapping("/prize/getPrizeWinner")
    public R getPrizeWinner(@RequestParam("usernameList") List<String> usernameList) {
        System.out.println(usernameList.get(0));
        R r = userService.queryUserByUserNameList(usernameList);

        return r;
    }


    /**
     * 上传奖项
     * 2022/2/11
     *
     * @author lt
     */
//    @PostMapping("/fileOperate/uploadPrize")
//    public R uploadFile(@RequestParam("file") MultipartFile file, Prize prize){
//        return prizeService.uploadFile(file,prize);
//    }

    /**
     * 上传奖项
     * 2022/2/20
     * @author lt
     */
    @PostMapping("/fileOperate/uploadPrize")
    public R uploadFile(@RequestParam("files") MultipartFile[] files, Prize prize,int judge){
//        judge为0说明是学生上传奖项
        if(judge==0){
            System.out.println(prize);
            return prizeService.uploadFile(files,prize);
        }
//      judge为1说明是老师上传奖项
        if (judge==1){
            return prizeService.teacherUploadFile(files,prize);
         }
        return R.fail().setData("无法判断是老师还是学生上传奖项");
    }


    /**
     * 多奖项下载到Excel文件
     *
     * @author lt
     * 2022/2/15
     */
    @GetMapping("/testExcel")
    public void testExcel(HttpServletResponse response) throws IOException {
        List<PrizeDo> list = new ArrayList<>();
        list.add(new PrizeDo("优秀奖", "001"));
        list.add(new PrizeDo("参与奖", "002"));
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename=" + "test.xlsx");//或者文件名后缀为xlsx
//        ExcelUtils.writeExcel(response,list);
    }


    /**
     * @Description: 批量下载奖项照片
     * @Param:
     * @return: json
     * @Author: 程世玉
     * @Date: 2022/2/20
     */
    @GetMapping("/fileOperate/downloadAttachMent")
    public void  zipDownload(@RequestParam("pathFront") ArrayList<String> prizeFrontList,
                               HttpServletRequest request,
                               HttpServletResponse response){
        ArrayList<File> files = new ArrayList<File>();

        System.out.println(prizeFrontList.size());

        for (String prizeFront : prizeFrontList) {
            List<String> splitString = splitUtils.splitString(prizeFront, "/");
            String fileStaticPath = "C:/file/user_images/" + splitString.get(splitString.size() - 1);
            File file = new File(fileStaticPath);
            files.add(file);
        }


        ZipUtils.zipDownload(response,"奖项照片.zip",files);
    }

    /**
     * 多奖项下载到Excel文件
     * 因为管理员只能看到本学院的奖项
     * 只按照学年划分
     * 1某学年的所有奖项
     * 2某学年所有老师的奖项（指导老师字段为0）
     * 3某学年所有学生的奖项（指导老师字段不为0）
     * 只按照学院划分
     * 1某学院的所有奖项
     * 2某学院的所有老师的获奖情况
     * 3某学院所有学生的获奖情况
     * @author lt
     * 2022/2/15
     */
    @GetMapping("/downloadExcel")
    public void downloadExcel(HttpServletResponse response, Prize prize) throws IOException {
//        下载该学院所有的奖项 下载所有学生的奖项
        List<PrizeExcel> list = new ArrayList<>();
        if (prize.getTid() == null) {
            List<Prize> prizes = prizeDao.adminFindAllPrize(prize);
            for (Prize prize1 : prizes) {
//            将每一条数据添加到list里面
                list.add(new PrizeExcel(prize1.getPname(), prize1.getLevel(), prize1.getPlevel(), prize1.getPsponsor(),
                        prize1.getPtime().toString(), prize1.getIsDelete().toString(), prize1.getTname(),
                        prize1.getCategory().toString(), prize1.getTitle(),
                        prize1.getNumber(), prize1.getFaculty(), prize1.getGrade()));
            }
        }
//         下载所有老师的奖项
        if (prize.getTid().equals("0")) {
            List<Prize> prizes = prizeDao.adminFindAllTeacherPrize(prize);
            for (Prize prize1 : prizes) {
//            将每一条数据添加到list里面
                list.add(new PrizeExcel(prize1.getPname(), prize1.getLevel(), prize1.getPlevel(), prize1.getPsponsor(),
                        prize1.getPtime().toString(), prize1.getIsDelete().toString(), prize1.getTname(),
                        prize1.getCategory().toString(), prize1.getTitle(),
                        prize1.getNumber(), prize1.getFaculty(), prize1.getGrade()));
            }
        }
        if (!prize.getTid().equals("0")) {
            List<Prize> prizes = prizeDao.adminFindAllStudentPrize(prize);
            for (Prize prize1 : prizes) {
//            将每一条数据添加到list里面
                list.add(new PrizeExcel(prize1.getPname(), prize1.getLevel(), prize1.getPlevel(), prize1.getPsponsor(),
                        prize1.getPtime().toString(), prize1.getIsDelete().toString(), prize1.getTname(),
                        prize1.getCategory().toString(), prize1.getTitle(),
                        prize1.getNumber(), prize1.getFaculty(), prize1.getGrade()));
            }
        }
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + prize.getGrade() + "prize.xlsx");
        ExcelUtils.writeExcel(response, list);
    }
}
