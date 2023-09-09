package com.xp.method.controller;

import com.xp.method.service.TeacherService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 苏禾
 * @version 1.0
 * @Description <TODO description class purpose>
 * @createDate 2023/8/20 11:35
 * @since 1.0
 **/
@RestController
@RequestMapping("/teacher")
@Slf4j
public class TeacherController {
    @Resource
    private TeacherService teacherService;

    @GetMapping("/query")
    public String queryInfo() {
        return teacherService.query();
    }

    @GetMapping("/add")
    public String addInfo() {
        return teacherService.add();
    }

    @GetMapping("/update")
    public String updateInfo() {
        log.info("进入更新教师Controller");
        return teacherService.update();
    }

    @GetMapping("/delete")
    public String deleteInfo() {
        return teacherService.delete();
    }
}
