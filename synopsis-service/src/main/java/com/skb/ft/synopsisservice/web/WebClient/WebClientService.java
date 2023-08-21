package com.skb.ft.synopsisservice.web.WebClient;

import com.skb.ft.synopsisservice.domain.euxp.dto.EuxpSynopsisResponseDto;
import com.skb.ft.synopsisservice.domain.scs.dto.ScsDirectviewRequestDto;
import com.skb.ft.synopsisservice.domain.scs.dto.ScsDirectviewResponseDto;
import com.skb.ft.synopsisservice.domain.smd.dto.SmdLikeHateResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class WebClientService {
    @Value("${env.AUTH_VAL}")
    String authVal;
    @Value("${env.CLIENT_ID}")
    String clientId;
    @Value("${env.TIMESTAMP}")
    String timestamp;
    @Value("${env.UUID}")
    String uuid;
    @Value("${env.TRACE}")
    String trace;
    @Value("${env.API_KEY}")
    String apiKey;
    @Value("${env.EUXP_URL_PARAM}")
    String euxpUrlParam;
    @Value(("${env.SMD_URL_PARAM}"))
    String smdUrlParam;

    public EuxpSynopsisResponseDto requestEuxpWebclient(){

        WebClient webClient=WebClient.builder()
                .baseUrl(euxpUrlParam)
                .build();

        return webClient.get().header("Client_ID",clientId)
                .header("Auth_Val",authVal)
                .header("TimeStamp",timestamp)
                .header("UUID",uuid)
                .header("Timestamp",timestamp)
                .header("Api_Key",apiKey).retrieve().bodyToMono(EuxpSynopsisResponseDto.class).block();
    }

    public SmdLikeHateResponseDto requestSmdWebclient(){
        WebClient webClient=WebClient.builder()
                .baseUrl(smdUrlParam)
                .build();

        return webClient.get()                .header("Client_ID",clientId)
                .header("Auth_Val",authVal)
                .header("TimeStamp",timestamp)
                .header("UUID",uuid)
                .header("Timestamp",timestamp)
                .header("Api_Key",apiKey).retrieve().bodyToMono(SmdLikeHateResponseDto.class).block();
    }

    public ScsDirectviewResponseDto requestScsWebclient(ScsDirectviewRequestDto scsDirectviewRequestDto){
        WebClient webClient=WebClient.builder()
                .baseUrl("http://payperview.scs.svc.skb-doj-stg01.btvpaas.com/v5")
                .build();

        return webClient.post().uri("/directview").body(Mono.just(scsDirectviewRequestDto),ScsDirectviewRequestDto.class).retrieve().bodyToMono(ScsDirectviewResponseDto.class).block();
    }
}
