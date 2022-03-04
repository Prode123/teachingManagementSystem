package com.hafu.edu.teachingmanagementsystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hafu.edu.teachingmanagementsystem.Exception.ErrorCodeEnum;
import com.hafu.edu.teachingmanagementsystem.Exception.ServiceException;
import com.hafu.edu.teachingmanagementsystem.Utils.R;
import com.hafu.edu.teachingmanagementsystem.dao.PrizeDao;
import com.hafu.edu.teachingmanagementsystem.entity.*;
import com.hafu.edu.teachingmanagementsystem.dao.DocumentDao;
import com.hafu.edu.teachingmanagementsystem.service.DocumentService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * (Document)表服务实现类
 *
 * @author makejava
 * @since 2022-02-06 17:45:55
 */
@Service("documentService")
@Transactional
public class DocumentServiceImpl implements DocumentService {
    @Resource
    private DocumentDao documentDao;

    @Resource
    private PrizeDao prizeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param did 主键
     * @return 实例对象
     */
    @Override
    public Document queryById(Long did) {
        return this.documentDao.queryById(did);
    }

    /**
     * 分页查询
     *
     * @param document    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Document> queryByPage(Document document, PageRequest pageRequest) {
        long total = this.documentDao.count(document);
        return new PageImpl<>(this.documentDao.queryAllByLimit(document, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param document 实例对象
     * @return 实例对象
     */
    @Override
    public Document insert(Document document) {
        this.documentDao.insert(document);
        return document;
    }

    /**
     * 修改数据
     *
     * @param document 实例对象
     * @return 实例对象
     */
    @Override
    public Document update(Document document) {
        this.documentDao.update(document);
        return this.queryById(document.getDid());
    }

    /**
     * 通过主键删除数据
     *
     * @param did 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long did) {
        return this.documentDao.deleteById(did) > 0;
    }



    /**
     * @Description: 查询学生人才培养方案
     * @Param:
     * @return: Document
     * @Author: 程世玉
     * @Date: 2022/2/9
     */
    @Override
    public R queryStudentTrainResouce(Document d) {
        List<Document> document = documentDao.getStudentTrainResouce(d);
        if (document == null || document.size() == 0){
            return  R.exp(201,"您专业的学生培养方案暂时没有上传，请联系专业相关负责人");
        }
        return R.ok().setData(document.get(0));
    }




    /**
     * 管理员查询所有的文件或所有的奖项
     * 用户查询所有的个人奖项或文件
     * @author lt
     */
    @Override
    public R selectAllFilePrize(FilePrize filePrize){
        PageHelper.startPage(filePrize.getPageNum(), filePrize.getPageSize());
//        判断是管理员还是个人 如果有用户id就是管理员 没有用户id就是个人
//        用户id大于0说明是个人
        if(filePrize.getUid()>0){
//            判断是查询奖项还是文件
//            condition为1说明是文件
            if(filePrize.getCondition()==1){
                System.out.println(filePrize.getCondition());
//             用户通过条件查询文件 (模糊查询)
                Document document=new Document();
                document.setCourse(filePrize.getFileName());
                document.setUid(filePrize.getUid());
                document.setMajor(filePrize.getMajor());
                document.setSemester(filePrize.getSemester());
                document.setFileType(filePrize.getFileType());
                List<Document> documents = documentDao.mohuSelect(document);
                for (Document document1 : documents) {
                    System.out.println(document1.getMajor());
                }
                PageInfo<Document> page=new PageInfo<>(documents);
                return R.ok().setData(page);
            }
//                condition为2说明是奖项
            else if(filePrize.getCondition()==2){
                System.out.println(filePrize.getCondition());
//             通过用户id查询个人的所有奖项
                Prize prize=new Prize();
                prize.setUid((long)filePrize.getUid());
                System.out.println(prize.getUid());

                List<Prize> prizes = prizeDao.selectAllPrize(prize);
                for (Prize prize1 : prizes) {
                    System.out.println(prize1);
                }
                PageInfo<Prize> page=new PageInfo<>(prizes);
                return R.ok().setData(page);
            }
            else return R.exp(201,"condition填写错误，请检查！");
        }
//        else为管理员的情况
        else {
//            判断是查询奖项还是文件
//            condition为1说明是文件
            if(filePrize.getCondition()==1){
//                管理员通过条件查询文件
                Document document=new Document();
                document.setStatus(filePrize.getStatus());
                List<Document> documents = documentDao.selectAllDocument(document);
                PageInfo<Document> page=new PageInfo<>(documents);
                return R.ok().setData(page);
            }
//                condition为2说明是奖项
            else if(filePrize.getCondition()==2){
                Prize prize=new Prize();
                prize.setStatus(filePrize.getStatus());
                List<Prize> allPrize = prizeDao.findAllPrize(prize);
                PageInfo<Prize> page=new PageInfo<>(allPrize);
                return R.ok().setData(page);

            }
            else return R.exp(201,"condition填写错误，请检查！");
        }

    }

    /**
     * 管理员查询所有文件
     * @author lt
     * 2022/2/11
     */
    @Override
    public R selectAllFile(FilePrize filePrize){
        PageHelper.startPage(filePrize.getPageNum(), filePrize.getPageSize());
        Document document=new Document();
        document.setStatus(filePrize.getStatus());
        List<Document> documents = documentDao.selectAllDocument(document);
        PageInfo<Document> page=new PageInfo<>(documents);
        return R.ok().setData(page);
    }
    /**
     * 管理员查询所有奖项
     * @author lt
     * 2022/2/11
     */
    @Override
    public R selectAllPrize(FilePrize filePrize){
        PageHelper.startPage(filePrize.getPageNum(), filePrize.getPageSize());
        Prize prize=new Prize();
        prize.setStatus(filePrize.getStatus());
        List<Prize> allPrize = prizeDao.findAllPrize(prize);
        PageInfo<Prize> page=new PageInfo<>(allPrize);
        return R.ok().setData(page);
    }

    /**
     * 用户查询所有文件
     * @author lt
     * 2022/2/11
     */
    @Override
    public R userSelectAllFile(FilePrize filePrize){
        PageHelper.startPage(filePrize.getPageNum(), filePrize.getPageSize());
        Document document=new Document();
        document.setCourse(filePrize.getFileName());
        document.setUid(filePrize.getUid());
        document.setMajor(filePrize.getMajor());
        document.setSemester(filePrize.getSemester());
        document.setFileType(filePrize.getFileType());

        List<Document> documents = documentDao.mohuSelect(document);
        PageInfo<Document> page=new PageInfo<>(documents);
        return R.ok().setData(page);
    }

    /**
     * 用户查询所有奖项
     * @author lt
     * 2022/2/11
     */
    @Override
    public R userSelectAllPrize(FilePrize filePrize){
        PageHelper.startPage(filePrize.getPageNum(), filePrize.getPageSize());
        Prize prize=new Prize();
        prize.setUid((long)filePrize.getUid());
        List<Prize> prizes = prizeDao.selectAllPrize(prize);
        PageInfo<Prize> page=new PageInfo<>(prizes);
        return R.ok().setData(page);
    }


    /**
     * 上传文件
     * @author lt
     * 2022/2/11
     */
    @Override
   public R uploadFile(@RequestParam("file") MultipartFile file, Document document){
        if(file.isEmpty()){
            return R.exp(201,"上传文件为空");
        }
//       获取文件名
//        String fileName1 = DateTime.Now.ToString("yyyyMMddHHmmss");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Random random = new Random();
        String unique = random.nextInt(89999 + 10000) + simpleDateFormat.format(new Date());
        String originalFilename = file.getOriginalFilename();
//            //获取最后一个.的位置
        int lastIndexOf = originalFilename.lastIndexOf(".");
//            //获取文件的后缀名 .jpg
        String suffix = originalFilename.substring(lastIndexOf);

//        生成唯一文件名
        String fileName = unique+suffix;
//        定义文件存储路径
        String path1 = "C://file//diffcident" ;
        File path = new File(path1 + File.separator + fileName);
        if(!path.getParentFile().exists()){ //判断文件父目录是否存在
            path.getParentFile().mkdirs();
        }
        try {
            file.transferTo(path); //保存文件
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
//            e.printStackTrace();
            throw new ServiceException(ErrorCodeEnum.INTERNAL_SERVER_ERROR);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new ServiceException(ErrorCodeEnum.INTERNAL_SERVER_ERROR);
        }

//        设置文件路径
        document.setPath("/manangmentSystem/file" + File.separator + fileName);
//        设置文件大小
        document.setSize(file.getSize());
//        设置文件名
        document.setFileName(fileName);
//        设置创建时间
        document.setCreateTime(new Date());
//        设置设置审核状态
        document.setStatus(0);
//        操作数据库 将上传的文件信息插入数据库

        int i = documentDao.insert(document);

        if(i>0){
            return R.ok().setData(document);
        }
        else {
            return R.exp(201,"上传失败");
        }

    }


    /**
     * 管理员审核文件不通过
     * @author lt
     * 2022/2/12
     */
    @Override
    public R failedDocument(Document document) {
        document.setStatus(2);
        document.setModifiedTime(new Date());
        int i = documentDao.update(document);
        if (i > 0) {
            return R.ok().setData(document);
        } else {
            return R.exp(201, "操作失败");
        }
    }

    /**
     * @Description: 删除单个或多个文件（课程大纲、教学进度计划表、人才培育方案）
     * @Param:
     * @return: json
     * @Author: 程世玉
     * @Date: 2022/2/12
     */
    @Override
    public R deleteByIdList(ArrayList<Long> didList) {

        for (int i = 0; i < didList.size(); i++) {
            int flag = documentDao.deleteById(didList.get(i));
            if (flag == 0){
                throw new ServiceException(ErrorCodeEnum.BATCH_DELETION_FAILED,"第" + (i+1) + "条数据删除失败   ");
            }
        }
        return R.ok();
    }

    /**
     * @Description: 审核文件通过
     * @Param:
     * @return: json
     * @Author: 程世玉
     * @Date: 2022/2/12
     */
    @Override
    public R updateDocumentByDidList(ArrayList<Long> didList, Integer auditId) {
        // 创建document对象，用来存放要修改的信息
        Document document = new Document();
        document.setAuditId(auditId);
        document.setStatus(1);

        for (int i = 0; i < didList.size(); i++) {

            document.setDid(didList.get(i));

            int flag = documentDao.update(document);

            if (flag == 0){
                return R.exp(201,"在第"+ (i+1) +"条审核失败，共审核通过0条");
            }
        }

        return R.ok();
    }
}
