package com.spring.security.jwt.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.security.jwt.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author : zhayh
 * @date : 2020-4-21 15:37
 * @description : 验证用户名密码正确后，生成一个token，并将 token返回给客户端
 *
 *  * 该类继承自 AbstractAuthenticationProcessingFilter，重写了其中的 3个方法
 *  * attemptAuthentication： 接收并解析用户凭证
 *  * successfulAuthentication： 用户成功登录，这个方法会被调用，在这个方法里生成 token
 *  * unsuccessfulAuthentication： 用户登录失败，这个方法会被调用，返回错误信息
 */
public class JwtLoginFilter extends AbstractAuthenticationProcessingFilter {

    public JwtLoginFilter(String defaultFilterProcessesUrl, AuthenticationManager authenticationManager) {
        super(new AntPathRequestMatcher(defaultFilterProcessesUrl));
        setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException {
        User user = new ObjectMapper().readValue(request.getInputStream(), User.class);
        return getAuthenticationManager().authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain, Authentication authResult)
            throws IOException, ServletException {
        // 获取登录用户的角色
        Collection<? extends GrantedAuthority> authorities = authResult.getAuthorities();
        String AuthorityStr = authorities.stream().map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));
        String token = Jwts.builder()
                .claim("authorities", AuthorityStr)
                .setSubject(authResult.getName())
                .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 1000))
                .signWith(SignatureAlgorithm.HS512, "MyJwtSecret")
                .compact();
        // token放在报文中
        Map<String, String> map = new HashMap<>();
        map.put("token", token);
        map.put("msg", "登录成功");
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.write(new ObjectMapper().writeValueAsString(map));
        out.flush();
        out.close();

        // token也可以放在响应头
//        response.addHeader("Authorization", "Bearer " + token);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request,
                                              HttpServletResponse response,
                                              AuthenticationException failed)
            throws IOException, ServletException {
        Map<String, String> map = new HashMap<>();
        map.put("msg", "登录失败");
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.write(new ObjectMapper().writeValueAsString(map));
        out.flush();
        out.close();
    }
}
