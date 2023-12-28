package com.educandoweb.course.config;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

/**
 * Classe de configuração utilizada para inicialização de dados de teste no perfil "test".
 *
 * Esta classe é anotada com @Configuration para indicar que contém configurações específicas do Spring.
 * Além disso, é anotada com @Profile("test") para especificar que essas configurações são aplicáveis apenas ao perfil "test".
 * Implementa a interface CommandLineRunner para executar a lógica de inicialização ao iniciar a aplicação.
 *
 * @see org.springframework.context.annotation.Configuration
 * @see org.springframework.context.annotation.Profile
 * @see org.springframework.boot.CommandLineRunner
 */
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        userRepository.saveAll(Arrays.asList(u1, u2));
    }
}
