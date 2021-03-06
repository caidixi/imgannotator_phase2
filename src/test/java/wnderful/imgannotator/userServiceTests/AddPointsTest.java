package wnderful.imgannotator.userServiceTests;

import com.alibaba.fastjson.JSON;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import wnderful.imgannotator.blserviceImpl.BaseServiceImpl;
import wnderful.imgannotator.blserviceImpl.UserServiceImpl;
import wnderful.imgannotator.dataServiceImpl.NormalDataServiceImpl;
import wnderful.imgannotator.publicData.reponseCode.userResponseCode.AddPointsRepCode;
import wnderful.imgannotator.publicData.response.userResponse.AddPointsRep;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class AddPointsTest {
    private UserServiceImpl userService = new UserServiceImpl();

    @BeforeClass
    public static void prepare(){
        NormalDataServiceImpl normalDataService = new NormalDataServiceImpl();
        normalDataService.deleteAll();
        BaseServiceImpl baseService = new BaseServiceImpl();
        baseService.signUp("caidixi","123456","caidixi@163.com","worker");
        baseService.signUp("caizhe","654321","caizhe@163.com","requester");
    }

    @Test
    public void test1(){
        String rep = JSON.toJSONString(userService.addPoints("caidixi",1234));
        String hopeRep = JSON.toJSONString(new AddPointsRep(AddPointsRepCode.SUCCESS));
        assertEquals(hopeRep,rep);
    }

    @Test
    public void test2(){
        String rep = JSON.toJSONString(userService.addPoints("caizhe",4321));
        String hopeRep = JSON.toJSONString(new AddPointsRep(AddPointsRepCode.SUCCESS));
        assertEquals(hopeRep,rep);
    }

    @Test
    public void test3(){
        String rep = JSON.toJSONString(userService.addPoints("cai",1234));
        String hopeRep = JSON.toJSONString(new AddPointsRep(AddPointsRepCode.NOTFOUND));
        assertEquals(hopeRep,rep);
    }

    @Test
    public void test4(){
        String rep = JSON.toJSONString(userService.addPoints("caizhe",-4321));
        String hopeRep = JSON.toJSONString(new AddPointsRep(AddPointsRepCode.UNPROPER));
        assertEquals(hopeRep,rep);
    }


}
