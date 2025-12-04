package com.eduard.librarymanagementproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class LibraryManagementProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryManagementProjectApplication.class, args);
    }

}
