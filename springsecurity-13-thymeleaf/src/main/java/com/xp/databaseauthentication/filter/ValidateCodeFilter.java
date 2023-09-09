package com.xp.databaseauthentication.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * @author 苏禾
 * @version 1.0
 * @Description <TODO description class purpose>
 * @createDate 2023/8/20 20:49
 * @since 1.0
 **/
@Component
@Slf4j
public class ValidateCodeFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        log.info("请求的URI为：{}", requestURI);
        if (!requestURI.equals("/login/doLogin")) {
            doFilter(request, response, filterChain);
        } else {
            validateCode(request, response,filterChain);
        }
    }

    private void validateCode(HttpServletRequest request, HttpServletResponse response,FilterChain filterChain) throws IOException, ServletException {
        String enterCaptchaCode = request.getParameter("code");
        HttpSession session = request.getSession();
        String captchaCodeInSession = (String) session.getAttribute("LOGIN_CAPTCHA_CODE");
        log.info("用户输入的验证码为：{},session中的验证码为：{}",enterCaptchaCode,captchaCodeInSession);
        //移除错误信息
        session.removeAttribute("captchaCodeErrorMsg");
        if (!StringUtils.hasText(captchaCodeInSession)) {
            session.removeAttribute("LOGIN_CAPTCHA_CODE");
        }
        if (!StringUtils.hasText(enterCaptchaCode) || !StringUtils.hasText(captchaCodeInSession) || !enterCaptchaCode.equalsIgnoreCase(captchaCodeInSession)) {
            //说明验证码不正确，返回登陆页面
            session.setAttribute("captchaCodeErrorMsg", "验证码不正确");
//重定向
            response.sendRedirect("/login/toLogin");
        }else{
            filterChain.doFilter(request,response);
        }
    }
}
