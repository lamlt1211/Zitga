package com.bkap.securities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Project-SemIV
 *
 * @author Tung lam
 * @created_at 22/07/2020 - 17:56
 * @created_by Tung lam
 * @since 22/07/2020
 */
@Component
public class RequestFilter extends OncePerRequestFilter {
    @Autowired
    private UserDetailServiceImpl jwtUserDetailService = new UserDetailServiceImpl();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        final int status = response.getStatus();
        if (status == 401) {
        }
        chain.doFilter(request, response);
    }
}
