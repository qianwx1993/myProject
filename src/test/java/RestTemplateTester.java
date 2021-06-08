import com.qwx.myProject.MyProjectApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

/**
 * @author Qian
 * @Version 1.0
 * @Since JDK1.6
 * @Company Bangsun
 * @Date 2021/2/28 23:13
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyProjectApplication.class)
public class RestTemplateTester {
    @Autowired
    RestTemplate restTemplate;
    @Test
    public void testRest(){
        restTemplate.getForObject("http://www.baidu.com",String.class);
    }
}
