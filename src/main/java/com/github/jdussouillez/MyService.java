package com.github.jdussouillez;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class MyService {

    @ConfigProperty(name = "myapp.key.value")
    protected byte[] key;
}
