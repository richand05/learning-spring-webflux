package com.richand.example4;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        Mono<String> mono = Mono.just("Richard").delayElement(Duration.ofSeconds(2));
        Mono<String> mono1 = Mono.just("Andree").delayElement(Duration.ofSeconds(3));

        Flux<String> flux = Flux.merge(mono,mono1);
        flux.subscribe(System.out::println);

        try {
            Thread.sleep(10000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
