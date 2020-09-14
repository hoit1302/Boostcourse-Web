package org.edwith.webbe.calculatorcli;
 
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
 
 
 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
public class MyServiceTest {
   @Autowired
   MyService myService;
 
   @Test
   public void execute() throws Exception{
       // given
       int value1 = 5;
       int value2 = 10;
 
       // when
       int result = myService.execute(value1, value2);
 
       // then
       Assert.assertEquals(30, result);
   }
}
