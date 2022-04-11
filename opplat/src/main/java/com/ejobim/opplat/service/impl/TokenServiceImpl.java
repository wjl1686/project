package com.ejobim.opplat.service.impl;

import com.ejobim.opplat.common.Constant;
import com.ejobim.opplat.config.RedisService;
import com.ejobim.opplat.exception.BusinessException;
import com.ejobim.opplat.service.TokenService;
import com.ejobim.opplat.util.UUIDUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private RedisService redisService;
    


    /**
     * 创建token
     *
     * @return
     */
    @Override
    public String createToken() {
        String str = UUIDUtils.getUUID32();
        StringBuffer token = new StringBuffer();
        try {
            token.append(Constant.Redis_TOKEN_PREFIX).append(str);
            redisService.setEx(token.toString(), token.toString(),10000L);
            boolean notEmpty = StringUtils.isNotEmpty(token.toString());
            if (notEmpty) {
                return token.toString();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }


    /**
     * 检验token
     *
     * @param request
     * @return
     */
    @Override
    public boolean checkToken(HttpServletRequest request) throws Exception {
        String token = request.getHeader(Constant.TOKEN_NAME);
        if (StringUtils.isBlank(token)) {// header中不存在token
            token = request.getParameter(Constant.TOKEN_NAME);
            if (StringUtils.isBlank(token)) {// parameter中也不存在token
                throw new BusinessException(100,"参数非法");
            }
        }
        if (!redisService.exists(token)) {
            throw new BusinessException(200,"重复操作");
        }

        boolean remove = redisService.remove(token);
        if (!remove) {
            throw new BusinessException(200,"重复操作");
        }
        return true;
    }
}