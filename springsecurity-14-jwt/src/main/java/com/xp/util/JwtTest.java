package com.xp.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 苏禾
 * @version 1.0
 * @Description <TODO description class purpose>
 * @createDate 2023/9/10 11:08
 * @since 1.0
 **/
public class JwtTest {
    public static void main(String[] args) throws InterruptedException {
        List<String> authList = new ArrayList<>();
        authList.add("student:query");
        authList.add("student:add");
        authList.add("student:update");

        String obama = JwtUtils.createJwt(19, "obama", authList);
        System.out.println(obama);
        Thread.sleep(3000*10);
        JwtUtils.verifyToken(obama);
    }



}
