package cn.com.agree.basis;

import cn.com.agree.basis.unitTest.AService;
import cn.com.agree.basis.unitTest.BService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AService.class)
public class ServiceTest {
    @Autowired
    AService aService;

    @Test
    public void testService(){
        System.err.println(aService.getAServiceName());
    }

    @Test
    public void testFound(){
        String name = aService.getAServiceName();
        name.contains("A");
    }
}
