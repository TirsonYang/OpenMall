package ytx.openmall.server.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import ytx.openmall.server.interceptor.JwtSellerInterceptor;


@Configuration
@Slf4j
public class WebMvcConfiguration extends WebMvcConfigurationSupport {

    @Autowired
    private JwtSellerInterceptor jwtSellerInterceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        log.info("添加拦截器——————————————");
        registry.addInterceptor(jwtSellerInterceptor)
                .addPathPatterns("/upload")
                .addPathPatterns("/seller/**")
                .addPathPatterns("/product/**")
                .excludePathPatterns("/seller/login")
                .excludePathPatterns("/seller/register");
    }



}
