package com.example;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.awt.peer.DialogPeer;
import java.util.logging.Logger;

public class UserService implements InitializingBean, DisposableBean {
    private static final Logger logger = Logger.getLogger(UserService.class.getName());
    private UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        logger.info("UserService: Created");
    }
    public void register(User user) {
        userRepository.save(user);
    }
    @PostConstruct
    public void postConstruct() {
        logger.info("UserService: PostConstruct Intialized");
    }
    @Override
    public void afterPropertiesSet() {
        logger.info(" InitializingBean UserService: afterPropertiesSet");
    }
    @PreDestroy
    public void preDestroy() {
        logger.info("PreDestroy:UserService about to destroy" );
    }
    @Override
    public void destroy() {
        logger.info("DisposableBean.destroy: UserService Destroyed");
    }

}
