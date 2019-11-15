package cn.com.agree.main;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class MockWebTestClient {
    @Autowired
    WebTestClient testClient;
    @Test
    public void testTestClient(){
        this.testClient.post().uri("/test").exchange().expectStatus().isOk().expectBody(String.class).isEqualTo("hello");
    }

}
