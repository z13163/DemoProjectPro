package com.kq.controller;


import com.kq.service.AnalyseService;
import com.kq.utils.result.ResponseBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/html")
public class AnalyseController {

    private AnalyseService analyseService;

    @Autowired
    public AnalyseController(AnalyseService analyseService) {
        this.analyseService = analyseService;
    }

    @RequestMapping(value = "/queryAllSum")
    @ResponseBody
    public ResponseBo queryAllSum(){
        return analyseService.queryAllSum();
    }

    @RequestMapping(value = "/queryAllTeacherSum")
    @ResponseBody
    public ResponseBo queryAllTeacher(){
        return analyseService.queryAllTeacher();
    }
}
