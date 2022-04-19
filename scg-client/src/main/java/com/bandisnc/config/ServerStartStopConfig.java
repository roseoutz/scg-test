package com.bandisnc.config;

import com.bandisnc.config.sso.SsoClientProps;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServerStartStopConfig extends AbstractSsoStartStopConfig {

    public ServerStartStopConfig(SsoClientProps ssoClientProps) {
        super(ssoClientProps);
    }
}
