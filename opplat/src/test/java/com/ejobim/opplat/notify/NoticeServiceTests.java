package com.ejobim.opplat.notify;

import com.ejobim.opplat.notify.NoticeService.BindParams;
import com.ejobim.opplat.notify.NoticeService.FetchParams;
import com.ejobim.opplat.notify.NoticeService.PostParams;
import com.ejobim.opplat.notify.NoticeService.UnbindParams;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author zch
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class NoticeServiceTests {

    @Autowired
    private NoticeService noticeService;

    @Test
    public void test() throws Exception {
        {
            BindParams params = new BindParams();
            params.token = "token1";
            params.target = "user1";
            params.expireSeconds = 24 * 3600;
            this.noticeService.bindToken(params);
        }
        {
            PostParams params = new PostParams();
            params.targets = new String[]{"user1", "user2"};
            params.title = "title1";
            params.body = "body1";
            params.expireSeconds = 12 * 3600;
            this.noticeService.post(params);
        }
        {
            FetchParams params = new FetchParams();
            params.target = "user1";
            params.afterId = 0L;
            params.count = 100;
            this.noticeService.fetch(params);
        }
        {
            UnbindParams params = new UnbindParams();
            params.token = "token1";
            this.noticeService.unbindToken(params);
        }
    }
}
