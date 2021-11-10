package com.kq.service;


import com.kq.dao.Analyse;
import com.kq.pojo.Sum;
import com.kq.utils.result.ResponseBo;
import com.kq.utils.result.ResultUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class AnalyseService {
    @Resource
    private Analyse analyse;

    public ResponseBo queryAllSum(){
        List<Sum> sums = analyse.queryAllSum();
        return ResultUtils.success("查询成功",sums);
    }

    public ResponseBo queryAllTeacher(){
        List<Sum> sums = analyse.queryAllTeacher();
        return ResultUtils.success("查询成功",sums);
    }
}
