package Rest.API.demo.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends GenericFilterBean {

    private final JwtProvider jwtProvider; // JWT 토큰을 생성 및 검증 모듈 클래스

    // request로 들어오는 Jwt의 유효성을 검증 - JwtProvider.validationToken() 을 필터로서 FilterChain에 추가
    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException {
        String token = jwtProvider.resolveToken((HttpServletRequest) request);
        // resolveToken : Request의 Header에서 token 파싱
        if (token != null && jwtProvider.validationToken(token)) {
        // validateToken : Jwt 토큰의 유효성 + 만료일자 확인
            Authentication authentication = jwtProvider.getAuthentication(token);
        // getAuthentication : Jwt 토큰으로 인증 정보 조회
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
    }
}
