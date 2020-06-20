package com.recipes.config;

import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

/**
 * Created by Yurii_Suprun
 */
@Profile(value = "local")
@Configuration
@Import(EmbeddedMongoAutoConfiguration.class)
public class DataConfig {


}
