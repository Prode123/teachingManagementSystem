package com.hafu.edu.teachingmanagementsystem.controller;

import com.hafu.edu.teachingmanagementsystem.Utils.R;
import com.hafu.edu.teachingmanagementsystem.service.DocumentService;
import com.hafu.edu.teachingmanagementsystem.service.PrizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.hafu.edu.teachingmanagementsystem.Utils.R;
import com.hafu.edu.teachingmanagementsystem.entity.Document;
import com.hafu.edu.teachingmanagementsystem.entity.Prize;
import com.hafu.edu.teachingmanagementsystem.service.DocumentService;
import com.hafu.edu.teachingmanagementsystem.service.PrizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @author 程世玉
 * @create 2022/2/6 20:02
 * @PROJECT_NAME Teaching-Management-System
 * @Description 审核类：
 *                 1、审核文件不通过          failedDocument
 *                 2、审核文件通过            successDocument
 *                 3、审核奖项通过            successPrize
 *                 4、审核奖项不通过          failedPrize
 *
 */
@CrossOrigin
@RestController
public class VerifyFileController {

    @Autowired
    private PrizeService prizeService;
    @Autowired
    private DocumentService documentService;

    /**
     * 管理员审核奖项不通过
     * @author lt
     * 2022/2/12
     */
    @PutMapping("/verify/failedPrize")
    public R failedPrize(Prize prize){
        return prizeService.failedPrize(prize);
    }


    /**
     * 管理员审核文件不通过
     * @author lt
     * 2022/2/12
     */
    @PutMapping("/verify/failedDocument")
    public R failedDocument(Document document){
      return documentService.failedDocument(document);
    }


    /**
     * @Description: 审核奖项通过
     * @Param:
     * @return: json
     * @Author: 程世玉
     * @Date: 2022/2/12
     */
    @PutMapping("/verify/successPrize")
    public R successPrize(@RequestParam("pizIdList")ArrayList<Integer> pizIdList,
                          @RequestParam("auditId") Long authId){
       R r = prizeService.updatePrizeByPizId(pizIdList,authId);
       return r;
    }



    /**
     * @Description: 审核文件通过
     * @Param:
     * @return: json
     * @Author: 程世玉
     * @Date: 2022/2/12
     */
    @PutMapping("/vereify/successDocument")
    public R successDocument(@RequestParam("didList") ArrayList<Long> didList,
                             @RequestParam("auditId") Integer auditId){
       R r = documentService.updateDocumentByDidList(didList,auditId);

       return r;
    }
}

