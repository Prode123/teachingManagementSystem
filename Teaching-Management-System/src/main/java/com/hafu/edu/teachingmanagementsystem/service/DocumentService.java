package com.hafu.edu.teachingmanagementsystem.service;

import com.hafu.edu.teachingmanagementsystem.Utils.R;
import com.hafu.edu.teachingmanagementsystem.entity.Document;
import com.hafu.edu.teachingmanagementsystem.entity.FilePrize;
import com.hafu.edu.teachingmanagementsystem.entity.Prize;
import com.hafu.edu.teachingmanagementsystem.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

/**
 * (Document)表服务接口
 *
 * @author makejava
 * @since 2022-02-06 17:45:55
 */

public interface DocumentService {

    /**
     * 通过ID查询单条数据
     *
     * @param did 主键
     * @return 实例对象
     */
    Document queryById(Long did);

    /**
     * 分页查询
     *
     * @param document    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Document> queryByPage(Document document, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param document 实例对象
     * @return 实例对象
     */
    Document insert(Document document);

    /**
     * 修改数据
     *
     * @param document 实例对象
     * @return 实例对象
     */
    Document update(Document document);

    /**
     * 通过主键删除数据
     *
     * @param did 主键
     * @return 是否成功
     */
    boolean deleteById(Long did);

    /**
     * @Description: 查询学生人才培养方案
     * @Param:
     * @return: Document
     * @Author: 程世玉
     * @Date: 2022/2/9
     */
    R queryStudentTrainResouce(Document d);



    /**
     * 管理员查询所有的文件或所有的奖项
     * 用户查询所有的个人奖项或文件
     * @author lt
     */
    R selectAllFilePrize(FilePrize filePrize);


    /**
     * 管理员查询所有文件
     * @author lt
     * 2022/2/11
     */
     R selectAllFile(FilePrize filePrize);

    /**
     * 管理员查询所有奖项
     * @author lt
     * 2022/2/11
     */
     R selectAllPrize(FilePrize filePrize);

    /**
     * 用户查询所有文件
     * @author lt
     * 2022/2/11
     */
    R userSelectAllFile(FilePrize filePrize);

    /**
     * 用户查询所有文件
     * @author lt
     * 2022/2/11
     */
    R userSelectAllPrize(FilePrize filePrize);

    /**
     * 上传文件
     * @author lt
     * 2022/2/11
     */
    R uploadFile(@RequestParam("file") MultipartFile file, Document document);

    /**
     * @Description: 删除单个或多个文件（课程大纲、教学进度计划表、人才培育方案）
     * @Param:
     * @return: json
     * @Author: 程世玉
     * @Date: 2022/2/12
     */
    R deleteByIdList(ArrayList<Long> didList);

    /**
     * @Description: 审核文件通过
     * @Param:
     * @return: json
     * @Author: 程世玉
     * @Date: 2022/2/12
     */
    R updateDocumentByDidList(ArrayList<Long> didList, Integer auditId);

    /**
     * 管理员审核文件不通过
     * @author lt
     * 2022/2/12
     */
    R failedDocument(Document document);
}
