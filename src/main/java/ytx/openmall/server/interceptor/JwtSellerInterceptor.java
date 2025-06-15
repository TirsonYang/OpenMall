package ytx.openmall.server.interceptor;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import ytx.openmall.common.context.BaseContext;
import ytx.openmall.common.properties.JwtProperty;
import ytx.openmall.common.util.JWTUtils;

import java.lang.invoke.MethodHandle;


@Slf4j
@Component
public class JwtSellerInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtProperty jwtProperty;



    //
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)){
            return true;
        }

        try {
            log.info("注册拦截器—————");
            String token = request.getHeader(jwtProperty.getSellerTokenName());
            log.info("jwt校验:{}",token);
            Claims claims = JWTUtils.parseJWT(jwtProperty.getSellerSecretKey(), token);
            Long sellerID=Long.valueOf(claims.get("sellerID").toString());
            log.info("sellerID:{}",sellerID);
            BaseContext.setThreadLocal(sellerID);
            return true;

        } catch (Exception e) {
            response.setStatus(401);     //返回异常状态码
            return false;
        }


    }


}
