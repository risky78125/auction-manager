package com.wuqi.auction;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wuqi.auction.repository")
public class AuctionManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuctionManagerApplication.class, args);
    }

}
