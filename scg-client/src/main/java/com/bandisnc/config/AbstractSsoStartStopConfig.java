package com.bandisnc.config;

import com.bandisnc.config.sso.SsoClientProps;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public abstract class AbstractSsoStartStopConfig implements InitializingBean, DisposableBean {

    private final SsoClientProps ssoClientProps;

    protected AbstractSsoStartStopConfig(SsoClientProps ssoClientProps) {
        this.ssoClientProps = ssoClientProps;
    }

    @Override
    public void afterPropertiesSet() {
        // SsoClientApiManager clientApiManager = SsoClientApiManager.getInstance();
        // clientApiManager.init(ssoClientProps.toMap());
    }

    @Override
    public void destroy() {
        //SsoClientApiManager.getInstance().destory();
    }

}
