package com.ejobim.opplat.common.interceptors;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * Created by wujianlong on 2019/01/25.
 */
public class SignatureInterceptor extends HandlerInterceptorAdapter {

    private Log log = LogFactory.getLog(SignatureInterceptor.class);

    /*@Autowired
    private ITerminalAccountService terminalAccountService;*/

    //@Value("${signatrue.timeout}")
    private Long signatureTimeout =22222L;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String verificateCode = request.getHeader("verificateCode");
        String timestamp = request.getHeader("timestamp");
        String nonce = request.getHeader("nonce");
        Enumeration<String> names = request.getParameterNames();
        StringBuffer sb = new StringBuffer();
        while (names.hasMoreElements()){
            String name = names.nextElement();
            sb.append(name).append(request.getParameter(name));
        }

        long time = Long.parseLong(timestamp);
        if(System.currentTimeMillis()-time>signatureTimeout){
            //如果时间超过1分钟，认证失败
            log.info("签名时间超时，可能存在不安全访问");
            return false;
        }


        //验证签名
       /* String appid = request.getParameter("appid");
        TerminalAccount terminalAccount = new TerminalAccount();
        terminalAccount.setAppid(appid);
        List<TerminalAccount> terminals = terminalAccountService.queryListByEntity(terminalAccount);

        long count = terminals.stream().filter(t-> SignUtil.checkSignature(verificateCode, timestamp, nonce, t.getToken())).count();
        if(count==0){
            log.info("签名验证失败");
            return false;
        }
        log.info("签名验证通过");
*/
        return super.preHandle(request, response, handler);
    }
}