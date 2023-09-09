package com.xp.databaseauthentication.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 苏禾
 * @version 1.0
 * @Description <TODO description class purpose>
 * @createDate 2023/8/20 15:44
 * @since 1.0
 **/
@Controller
@Slf4j
@RequestMapping("/student")
public class StudentController {
    @GetMapping("/query")
    @PreAuthorize("hasAuthority('student:query')")
    public String queryInfo(){
        return "user/query";
    }
    @GetMapping("/add")
    @PreAuthorize("hasAuthority('student:add')")
    public String addInfo(){
        return "user/add";
    }
    @GetMapping("/update")
    @PreAuthorize("hasAuthority('student:update')")
    public String updateInfo(){
        return "user/update";
    }
    @GetMapping("/delete")
    @PreAuthorize("hasAuthority('student:delete')")
    public String deleteInfo(){
        return "user/delete";
    }
    @GetMapping("/export")
    @PreAuthorize("hasAuthority('student:export')")
    public String exportInfo(){
        return "/user/export";
    }
}
