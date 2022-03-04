package com.hafu.edu.teachingmanagementsystem.service;

import com.hafu.edu.teachingmanagementsystem.Utils.R;
import com.hafu.edu.teachingmanagementsystem.entity.Document;
import com.hafu.edu.teachingmanagementsystem.entity.Prize;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

/**
 * (Prize)表服务接口
 *
 * @author makejava
 * @since 2022-02-06 17:46:38
 */

public interface PrizeService {

    /**
     * 通过ID查询单条数据
     *
     * @param pizId 主键
     * @return 实例对象
     */
    Prize queryById(Long pizId);

    /**
     * 分页查询
     *
     * @param prize       筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Prize> queryByPage(Prize prize, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param prize 实例对象
     * @return 实例对象
     */
    Prize insert(Prize prize);

    /**
     * 修改数据
     *
     * @param prize 实例对象
     * @return 实例对象
     */
    Prize update(Prize prize);

    /**
     * 通过主键删除数据
     *
     * @param pizId 主键
     * @return 是否成功
     */
    boolean deleteById(Long pizId);

    R deleteByListId(ArrayList<Integer> pizIdList);

    /**
     * 上传奖项
     * @author lt
     * 2022/2/11
     */
    R uploadFile(@RequestParam("files") MultipartFile[] files, Prize prize);
    /**
     * 老师上传奖项
     * @author lt
     * 2022/2/11
     */
    R teacherUploadFile(@RequestParam("files") MultipartFile[] files, Prize prize);


    /**
     * 管理员审核奖项不通过
     * @author lt
     * 2022/2/12
     */
    R failedPrize(Prize prize);

    /**
     * 重新上传奖项
     * @author lt
     * 2022/2/12
     */
    R restartUpload(@RequestParam("files") MultipartFile[] files,Prize prize);

    /**
     * @Description: 审核奖项通过
     * @Param:
     * @return: json
     * @Author: 程世玉
     * @Date: 2022/2/12
     */
    R updatePrizeByPizId(ArrayList<Integer> pizIdList, Long authId);

    /**
     * 通过pathFront删除奖项
     * @author lt
     */
    int deleteByPathFront(Prize prize);
}
