package com.github.jdussouillez;

import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import java.nio.charset.StandardCharsets;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class MyService {

    @ConfigProperty(name = "myapp.key.value")
    protected byte[] key;

    public void onStart(@Observes final StartupEvent event) {
        System.out.println("Key = " + new String(key, StandardCharsets.UTF_8));
    }
}
