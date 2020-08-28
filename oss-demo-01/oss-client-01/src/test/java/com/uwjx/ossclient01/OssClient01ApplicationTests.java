package com.uwjx.ossclient01;

import com.uwjx.ossclient01.net.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
class OssClient01ApplicationTests {

    @Test
    public void t(){
        String url = "http://localhost:8090/oauth/authorize?client_id=client01&client_secret=12345&response_type=code&redirect_uri=http://localhost:8081/account/callback";
        String resp = HttpUtil.get(url);
        log.warn("resp : {}" , resp);
    }

}
