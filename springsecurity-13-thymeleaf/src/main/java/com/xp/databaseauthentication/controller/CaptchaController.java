package com.xp.databaseauthentication.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.imageio.ImageIO;
import java.io.IOException;

/**
 * @author 苏禾
 * @version 1.0
 * @Description <TODO description class purpose>
 * @createDate 2023/8/20 19:52
 * @since 1.0
 **/
@Controller
@Slf4j
public class CaptchaController {
    @GetMapping("/code/image")
    public void getCaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //创建一个验证码
        CircleCaptcha circleCaptcha = CaptchaUtil.createCircleCaptcha(100, 50, 4, 20);
        //放到session中
        // 为什么要重构？重构的快捷键是啥？
        String captchaCode=circleCaptcha.getCode();
        log.info("生成的验证码为：{}",captchaCode);
        request.getSession().setAttribute("LOGIN_CAPTCHA_CODE",captchaCode);
        circleCaptcha.write(response.getOutputStream());
    }
}
