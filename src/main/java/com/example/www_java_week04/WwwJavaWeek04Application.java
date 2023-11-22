package com.example.www_java_week04;
import com.example.www_java_week04.model.Address;
import com.example.www_java_week04.model.Candidate;
import com.example.www_java_week04.repositories.AddressRepository;
import com.example.www_java_week04.repositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class WwwJavaWeek04Application {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private CandidateRepository candidateRepository;
    public static void main(String[] args) {
        SpringApplication.run(WwwJavaWeek04Application.class, args);
    }

    @Bean
    CommandLineRunner test() {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
//              boolean rs = addressRepository.delete(2);
//              System.out.println(rs);
              Optional<Address> op = addressRepository.findById(1);
                System.out.println(op);
            }
        };
    }
}
