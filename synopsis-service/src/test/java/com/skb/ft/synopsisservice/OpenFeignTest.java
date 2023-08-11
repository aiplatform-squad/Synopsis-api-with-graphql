package com.skb.ft.synopsisservice;

import com.skb.ft.synopsisservice.api.Controller;
import com.skb.ft.synopsisservice.domain.euxp.client.EuxpRequestParam;
import com.skb.ft.synopsisservice.domain.scs.dto.ScsDirectviewRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest
public class OpenFeignTest {
    @Autowired
    private Controller controller;
    @Test
    void EuxpApiConnectionTest(){
        assertThat(controller.euxpQuery(EuxpRequestParam.builder().build()).getResult())
                .isEqualTo("9999");
    }
}
