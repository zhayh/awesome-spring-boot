package com.spring.security.jwt.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * @author : zhayh
 * @date : 2020-4-21 16:11
 * @description : token的校验
 */
public class JwtFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        // 从请求头获取token
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String jwtToken = request.getHeader("authorization");

        // 解析token
        Jws<Claims> jws = Jwts.parser()
                .setSigningKey("MyJwtSecret")
                .parseClaimsJws(jwtToken.replace("Bearer", ""));
        Claims claims = jws.getBody();
        String username = claims.getSubject();

        List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(
                (String) claims.get("authorities"));
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(username, null, authorities);

        SecurityContextHolder.getContext().setAuthentication(token);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
