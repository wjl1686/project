package com.ejobim.opplat.common;


import com.ejobim.opplat.common.interceptors.AuthenticatInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by wujianlong on 2019/01/25.
 */
@Configuration
public class AppConfig implements WebMvcConfigurer  {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 设置允许跨域的路径
        registry.addMapping("/**")
                // 设置允许跨域请求的域名
                .allowedOrigins("*")
                // 是否允许证书 不再默认开启
                .allowCredentials(true)
                // 设置允许的方法
                .allowedMethods("*")
                // 跨域允许时间
                .maxAge(3600);
    }

//    @Bean
//    public SignatureInterceptor signatureInterceptor(){
//        return new SignatureInterceptor();
//    }
//
    @Bean
    public AuthenticatInterceptor authenticatInterceptor(){
        return new AuthenticatInterceptor();
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
//
//
//    @Bean
//    public DeprecatedInterceptor deprecatedInterceptor(){
//        return new DeprecatedInterceptor();
//    }
//
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(authenticatInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/login/**", "/static/**","/sys/checkUer","/calc/**","/equip/getEquipviewQR","/factory/downloadModel",
                        "/equip/downloadModel", "/equip/downloadModelHigh","/equip/export","/factory/export","/bewg/createSocket","/scheduling/getGroupCalendarData","/equip/getTbEquipInfo","/swagger-ui.html","/webjars/**", "/swagger-resources/**", "/v2/**", 
                        "/swagger**/**","/scheduling/exportTbSchedulingPlan","/routing/getRoutingLocationViewQR","/routing/downloadModel","/maintainFactor/downloadModel","/overhaul/downloadModel","/doc.html","/routing/downloadModelParam","/report/getReportModelExtendDetailDate",
                        "/equipOrder/exportGongYiOrder","/home/getTaskStaticInfo");
    }


}
