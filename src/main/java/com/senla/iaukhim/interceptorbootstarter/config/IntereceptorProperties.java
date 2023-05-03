package com.senla.iaukhim.interceptorbootstarter.config;

import com.senla.iaukhim.interceptorbootstarter.exceptions.InterceptorPropertiesException;
import jakarta.annotation.PostConstruct;
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

    @PostConstruct
    public void checkProperties(){
        if(Objects.isNull(uri)){
            composeUri();
        }
    }

    private void composeUri() {
        StringBuilder uriBuilder = new StringBuilder();
        try{
            uriBuilder.append("mongodb://");
            uriBuilder.append(this.getUserName() + ":");
            uriBuilder.append(this.getPassword() + "@");
            uriBuilder.append(this.getHost() + ":");
            uriBuilder.append(this.getPort() + "/");
            uriBuilder.append(this.getDataBase());
        }
        catch (NullPointerException e){
            throw new InterceptorPropertiesException();
        }
    }

    public String getUri() {
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
