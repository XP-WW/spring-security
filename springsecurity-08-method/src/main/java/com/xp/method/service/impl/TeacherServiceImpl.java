package com.xp.method.service.impl;

import com.xp.method.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

/**
 * @author 苏禾
 * @version 1.0
 * @Description <TODO description class purpose>
 * @createDate 2023/8/20 11:34
 * @since 1.0
 **/
@Slf4j
@Service
public class TeacherServiceImpl implements TeacherService {
    @Override
    @PreAuthorize("hasAuthority('teacher:add')")
    public String add() {
        log.info("添加教师成功");
        return "添加教师成功";
    }

    @Override
    @PreAuthorize("hasAuthority('teacher:update')")
    public String update() {
        log.info("修改教师成功");
        return "修改教师成功";
    }

    @Override
    @PreAuthorize("hasAuthority('teacher:delete')")
    public String delete() {
        log.info("删除教师成功");
        return "删除教师成功";
    }

    @Override
    @PreAuthorize("hasAuthority('teacher:query')")
    public String query() {
        log.info("查询教师成功");
        return "查询教师成功";
    }
}
