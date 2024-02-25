package com.example.WebDev.Configurations;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.WebDev.Entity.Role;
import com.example.WebDev.Enums.Roles;
import com.example.WebDev.Repository.RoleRepository;

@Configuration
public class RoleConfig {
  @Bean
  public CommandLineRunner commandLineRunner(RoleRepository roleRepository) {
    return args -> {
      roleRepository.saveAll(List.of(
          new Role(Roles.USER, "USER"),
          new Role(Roles.ADMIN, "ADMIN")));
    };
  }
}