package com.xp.databaseauthentication.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 苏禾
 * @version 1.0
 * @Description <TODO description class purpose>
 * @createDate 2023/8/20 15:44
 * @since 1.0
 **/
@RestController
@Slf4j
@RequestMapping("/teacher")
public class TeacherController {
    @GetMapping("/query")
    @PreAuthorize("hasAuthority('teacher:query')")
    public String queryInfo(){
        return "I am a teacher!";
    }
}
