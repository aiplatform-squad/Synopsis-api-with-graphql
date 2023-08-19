package com.skb.ft.synopsisservice;

import com.skb.ft.synopsisservice.api.Controller;
import com.skb.ft.synopsisservice.domain.euxp.dto.EuxpRequestParamDto;
import com.skb.ft.synopsisservice.domain.scs.dto.ScsDirectviewRequestDto;
import com.skb.ft.synopsisservice.domain.smd.dto.SmdRequestParamDto;
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
        assertThat(controller.euxpSynopsisQuery(EuxpRequestParamDto.builder().build()).getResult())
                .isEqualTo("9999");
    }
    @Test
    void ScsApiConnectionTest(){
        assertThat(controller.scsDirectviewQuery(ScsDirectviewRequestDto.builder().build()).getResult())
                .containsPattern("02[0-9][0-9]");
    }
    @Test
    void SmdApiConnectionTest(){
        assertThat(controller.smdLikeHateQuery(SmdRequestParamDto.builder().m("getLikeHate").build()).getResult())
                .isEqualTo("MP-30030");
    }
}
