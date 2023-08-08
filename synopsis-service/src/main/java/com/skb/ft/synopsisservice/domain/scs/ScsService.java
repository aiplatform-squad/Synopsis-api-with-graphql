package com.skb.ft.synopsisservice.domain.scs;

import com.skb.ft.synopsisservice.domain.euxp.client.EuxpRequestParam;
import com.skb.ft.synopsisservice.domain.euxp.vo.EuxpSynopsisResponseDto;
import com.skb.ft.synopsisservice.domain.scs.client.ScsRequestParam;
import com.skb.ft.synopsisservice.domain.scs.vo.ScsResponseDto;
import org.springframework.stereotype.Service;
@Service
public interface ScsService {
    ScsResponseDto callScsResponse(ScsRequestParam scsRequestParam);
}
