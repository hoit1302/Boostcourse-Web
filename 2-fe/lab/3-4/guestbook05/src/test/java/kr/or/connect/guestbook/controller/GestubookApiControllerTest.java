package kr.or.connect.guestbook.controller;

import kr.or.connect.guestbook.config.ApplicationConfig;
import kr.or.connect.guestbook.config.WebMvcContextConfiguration;
import kr.or.connect.guestbook.dto.Guestbook;
import kr.or.connect.guestbook.service.GuestbookService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebMvcContextConfiguration.class, ApplicationConfig.class })
public class GestubookApiControllerTest {
    @InjectMocks
    public GuestbookApiController guestbookApiController;
//    @InjectMocks어노테이션이 붙여서 선언된 guestbookApiController는 목객체인 GuestbookService를 사용하게 됩니다.
//    스프링에 위해 주입된 객체를 사용하는 것이 아닌 Mockito 프레임워크에 위해 생성된 목객체가 주입되어 객체가 생성됩니다.

    @Mock //@Mock어노테이션을 붙여서 선언된 guestbookService는 mockito에 위해 목객체로 생성됩니다. 말그대로 가짜 객체가 됩니다.
    GuestbookService guestbookService;

    private MockMvc mockMvc;

    @Before //테스트 메소드가 실행되기 전에 @Before어노테이션이 붙은 메소드가 실행됩니다.
    public void createController() {
        MockitoAnnotations.initMocks(this); //현재 객체에서 @Mock이 붙은 필드를 목객체로 초기화시킵니다.
        mockMvc = MockMvcBuilders.standaloneSetup(guestbookApiController).build();
//        MockMVC타입의 변수 mockMvc를 초기화 합니다. guestbookApiController를 테스트 하기 위한
//        MockMvc객체를 생성합니다.
    }

    @Test
    public void getGuestbooks() throws Exception {
        Guestbook guestbook1 = new Guestbook();
        guestbook1.setId(1L);
        guestbook1.setRegdate(new Date());
        guestbook1.setContent("hello");
        guestbook1.setName("kim");

        List<Guestbook> list = Arrays.asList(guestbook1);
        when(guestbookService.getGuestbooks(0)).thenReturn(list);
//        List<Guestbook>타입의 변수 list를 초기화하고 해당 list에 방명록 한 건을 저장합니다.
//        when(guestbookService.getGuestbooks(0)).thenReturn(list);
//        위의 문장은 아래와 같이 동작합니다.
//        when( 목객체.목객체메소드호출() ).threnReturn(목객체 메소드가 리턴 할 값)
//        guestbookService.getGuestbook(0) 이 호출되면 위에서 선언된 list객체가 리턴 되도록 설정합니다.
        
        
        RequestBuilder reqBuilder = MockMvcRequestBuilders.get("/guestbooks").contentType(MediaType.APPLICATION_JSON);
//        MockMvcRequestBuilders를 이용해 MockMvc에게 호출할 URL을 생성합니다.
//        get(“/guestbooks”)
//        GET 방식으로 /guestbooks 경로를 호출하라는 의미입니다.
//        contentType(MediaType.APPLICATION_JSON);
//        application/json 형식으로 api를 호출합니다.
//        즉 2가지가 합치면 application/json형식으로 /guestbooks를 GET방식으로 호출한다는 것을 뜻합니다. 
//        이러한 URL정보를 가진 reqBuilder를 생성합니다
        
        mockMvc.perform(reqBuilder).andExpect(status().isOk()).andDo(print());
//        mockMvc.perform(reqBuilder) 는 reqBuilder에 해당하는 URL에 대한 요청을 보냈다는 것을 의미합니다.
//        andExpect(status().isOk()) 는 mockMvc에 위해 URL이 실행되고 상태코드값이 200이 나와야 한다는 것을 의미합니다.
//        andDo(print())는 처리 내용을 출력하게 됩니다.
//        여기까지 실행되면 화면에 다음과 같은 결과가 출력되면서 테스트가 성공하게 됩니다.

        verify(guestbookService).getGuestbooks(0);
        // Guestbook 목객체의 getGuestbooks(0)메소드가 호출했다면 검증은 성공하게 됩니다.
    }

//    아래의 코드는 방명록을 삭제하는 web api를 테스트하고 있습니다.
    @Test
    public void deleteGuestbook() throws Exception {
        Long id = 1L;

        when(guestbookService.deleteGuestbook(id, "127.0.0.1")).thenReturn(1);

        RequestBuilder reqBuilder = MockMvcRequestBuilders.delete("/guestbooks/" + id).contentType(MediaType.APPLICATION_JSON);
//        “/guestbooks/” + id 경로를 DELETE방식으로 호출하기 위한 경로 정보를 가지고 있는 reqBuilder객체를 생성합니다.
        mockMvc.perform(reqBuilder).andExpect(status().isOk()).andDo(print());
//        reqBuilder에 해당하는 URL을 호출한 후, 상태 코드가 200일 경우 성공합니다. 그리고 결과를 출력하게 됩니다.


        verify(guestbookService).deleteGuestbook(id, "127.0.0.1");
//        guestbookService 목객체의 deleteGuestbook(id, “127.0.0.1”)메소드가 Web API가 동작하면서 호출되었다면 성공하게 됩니다.
    }
}