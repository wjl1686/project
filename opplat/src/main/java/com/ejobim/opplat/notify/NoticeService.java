package com.ejobim.opplat.notify;

import org.springframework.stereotype.Service;

/**
 *
 * @author zch
 */
@Service
public class NoticeService {




   /* @Value("${notify-service-url}")
    private String notifyServiceUrl;

    public void post(PostParams params) throws Exception {
        JSONObject postData = (JSONObject) JSONObject.toJSON(params);
        JSONObject result = HttpClientUtils.httpPost(notifyServiceUrl + "/notice/post", postData);
        if (!result.getBoolean("success")) {
            throw new Exception(result.getString("errorMessage"));
        }
    }

    public List<Notice> fetch(FetchParams params) throws Exception {
        String url = notifyServiceUrl + String.format("/notice/fetch?target=%s", params.target);
        if(params.afterId != null) {
            url += String.format("&afterId=%d", params.afterId);
        }
        if(params.count != null) {
            url += String.format("&count=%d", params.count);            
        }
        JSONObject result = HttpClientUtils.httpGet(url);
        if (!result.getBoolean("success")) {
            throw new Exception(result.getString("errorMessage"));
        }
        return result.getJSONArray("root").toJavaList(Notice.class);
    }
    
    public void bindToken(BindParams params) throws Exception {
        JSONObject postData = (JSONObject) JSONObject.toJSON(params);
        JSONObject result = HttpClientUtils.httpPost(notifyServiceUrl + "/token/bind", postData);
        if (!result.getBoolean("success")) {
            throw new Exception(result.getString("errorMessage"));
        }
    }
    
    public void unbindToken(UnbindParams params) throws Exception {
        JSONObject postData = (JSONObject) JSONObject.toJSON(params);
        JSONObject result = HttpClientUtils.httpPost(notifyServiceUrl + "/token/remove", postData);
        if (!result.getBoolean("success")) {
            throw new Exception(result.getString("errorMessage"));
        }
    }

    public static class PostParams {

        @ApiModelProperty(value = "通知目标", required = true)
        public String[] targets;

        @ApiModelProperty(value = "标题", required = true)
        public String title;

        @ApiModelProperty(value = "通知内容")
        public String body;

        @ApiModelProperty(value = "扩展参数")
        public Map<String, Object> extParameters;
        
        @ApiModelProperty(value = "指定通知时间，否则立即通知")
        public Date notifyTime;

        @ApiModelProperty(value = "过期时间（秒）")
        public Integer expireSeconds;

        @ApiModelProperty(value = "是否App推送")
        public boolean appPush;

    }

    public static class FetchParams {

        @ApiModelProperty(value = "通知目标")
        public String target;

        @ApiModelProperty(value = "起始ID（大于）")
        public Long afterId;

        @ApiModelProperty(value = "获取总数")
        public Integer count;

    }

    public static class Notice {

        @ApiModelProperty("消息ID")
        public Long id;

        @ApiModelProperty("标题")
        public String title;

        @ApiModelProperty("内容")
        public String body;

        @ApiModelProperty("发布时间")
        public Date postTime;

        @ApiModelProperty("过期时间")
        public Date expireTime;

        @ApiModelProperty("扩展参数")
        public Map<String, Object> extParameters;

    }
    
    public static class BindParams {
        
        @ApiModelProperty("平台Token")
        public String token;
        
        @ApiModelProperty("通知目标")
        public String target;
        
        @ApiModelProperty("过期时间（秒）")
        public Integer expireSeconds;
        
    }
    
    public static class UnbindParams {
        
        @ApiModelProperty("平台Token")
        public String token;
        
    }
   */

}
