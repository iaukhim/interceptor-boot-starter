package com.senla.iaukhim.interceptorbootstarter.config;

import com.senla.iaukhim.interceptorbootstarter.exceptions.InterceptorPropertiesException;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Objects;

@ConfigurationProperties(prefix = "iaukhim.interceptor")
@Component
public class IntereceptorProperties {

    private String uri;

    private String host;

    private String port;

    private String dataBase;

    private String userName;

    private String password;

    public String getUri() {
        if(Objects.isNull(uri)){
            throw new InterceptorPropertiesException();
        }
        return uri;

    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getDataBase() {
        return dataBase;
    }

    public void setDataBase(String dataBase) {
        this.dataBase = dataBase;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
