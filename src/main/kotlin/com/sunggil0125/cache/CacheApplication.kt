package com.sunggil0125.cache

import com.sunggil0125.cache.configuration.RedisProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan(
    basePackageClasses = [
        RedisProperties::class,
    ]
)
@SpringBootApplication
class CacheApplication

fun main(args: Array<String>) {
    runApplication<CacheApplication>(*args)
}
