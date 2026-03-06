package com.example;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.util.logging.Logger;

public class UserRepository implements InitializingBean , DisposableBean {

    private static final  Logger logger = Logger.getLogger(UserRepository.class.getName());
    public UserRepository()
    {
        logger.info("constructor:UserRepository Created");
    }
    public void save(User user){
        logger.info("save user:"+user.getName());
    }
    @PostConstruct
    public void postConstruct()
    {
        logger.info("postConstruct:UserRepository Initialized");
    }
    @Override
    public void afterPropertiesSet() {
        logger.info("InitializingBean.afterPropertiesSet:UserRepository ready");
    }
    @PreDestroy
    public void preDestroy()
    {
        logger.info("preDestroy:UserRepository about to Destroyed");
    }
    @Override
    public void destroy() {
        logger.info("destroy:UserRepository Destroyed");
    }
}
