package com.myapp.recipeapp.model;

import org.junit.Before;
import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.*;

public class CategoryTest {

    Category category;
    List<Category> categoryList;
    @Before
    public void setUp() throws Exception {
        category=new Category("American",null);
        categoryList=List.of(category,new Category("Italian",null),new Category("Turkey",null));
    }

    @Test
    public void monoTest() throws InterruptedException {
        CountDownLatch countDownLatch=new CountDownLatch(1);
        Mono<Category> categoryMono=Mono.just(category);
        categoryMono.delayElement(Duration.ofSeconds(3)).doOnTerminate(countDownLatch::countDown).subscribe(p-> System.out.println(p));

        //Category category=categoryMono.block();
        //Thread.currentThread().join();
        //System.out.println(category.getDescription());
    }

    @Test
    public void fluxTest() throws InterruptedException {
        CountDownLatch countDownLatch=new CountDownLatch(1);
        Flux<List<Category>> flux=Flux.just(categoryList);
        flux.delayElements(Duration.ofSeconds(3)).doOnComplete(countDownLatch::countDown)
                .subscribe(System.out::println);
        countDownLatch.await();
    }

    @Test
    public void getId() {
        Long idValue=4L;

        category.setId(4L);

        assertEquals(idValue,category.getId());
    }

    @Test
    public void getDescription() {
    }

    @Test
    public void getRecipes() {
    }
}