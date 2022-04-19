package com.bandisnc.config.sso;

import com.bandisnc.sso.constant.SsoPropConsts;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Data
@Component
@ConfigurationProperties(prefix = "bandisnc.sso")
public class SsoClientProps {

    private String serverUrl;
    private String clientId;
    private String clientSecret;
    private String secretIv;
    private String connectionTimeout;

    public Map<String, String> toMap() {
        Map<String, String> propsMap = new ConcurrentHashMap<>();
        propsMap.put(SsoPropConsts.SERVER_URL, getServerUrl());
        propsMap.put(SsoPropConsts.CLIENT_ID, getClientId());
        propsMap.put(SsoPropConsts.CLIENT_SECRET, getClientSecret());
        propsMap.put(SsoPropConsts.CLIENT_SN_BDSKISV, getSecretIv());
        propsMap.put(SsoPropConsts.CONN_TIME_OUT, getConnectionTimeout());

        return propsMap;
    }
}
