package com.skb.ft.synopsisservice;

import com.skb.ft.synopsisservice.api.Controller;
import com.skb.ft.synopsisservice.domain.euxp.client.EuxpRequestParam;
import com.skb.ft.synopsisservice.domain.synopsis.dto.SynopsisPageRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest
public class SynopsisApiTest {
    @Autowired
    private Controller controller;
    @Test void SynopsisEuxpDataValid(){
        assertThat(controller.synopsisPageViewQuery(SynopsisPageRequestDto.builder().smd_m("getLikeHate")
                .build()).getEuxpSynopsis().getResult()).isEqualTo("9999");
    }
    @Test void SynopsisScsDataValid(){
        assertThat(controller.synopsisPageViewQuery(SynopsisPageRequestDto.builder().smd_m("getLikeHate")
                .build()).getScsDirectview().getResult()).containsPattern("02[0-9][0-9]");
    }
@Test void SynopsisSmdDataValid(){
    assertThat(controller.synopsisPageViewQuery(SynopsisPageRequestDto.builder().smd_m("getLikeHate")
            .build()).getSmdLikeHate().getResult()).containsPattern("MP-30030");
}

}
