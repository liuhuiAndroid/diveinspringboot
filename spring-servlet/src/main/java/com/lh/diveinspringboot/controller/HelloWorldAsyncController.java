package com.lh.diveinspringboot.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Random;
import java.util.concurrent.*;

@RestController
public class HelloWorldAsyncController {

    private final BlockingQueue<DeferredResult<String>> queue = new ArrayBlockingQueue<>(5);

    // 超时随机数
    private final Random random = new Random();

    // 这个注解在容器启动时便会生效,5秒执行一次任务
    @Scheduled(fixedRate = 5000)
    public void process() throws InterruptedException { // 定时操作
        DeferredResult<String> result = null;
        do {
            result = queue.take();
            // 随机超时时间
            long timeout = random.nextInt(100);
            // 模拟等待时间，RPC 或者 DB 查询
            Thread.sleep(timeout);
            // 计算结果
            result.setResult("Hello,World");
            println("执行计算结果，消耗：" + timeout + " ms.");
        } while (result != null);
    }

    @GetMapping("/hello-world")
    public DeferredResult<String> helloWorld() {
        DeferredResult<String> result = new DeferredResult<>(50L);
        // 将指定元素插入此队列中
        queue.offer(result);
        println("Hello,World");
        result.onCompletion(() -> println("执行结束"));
        result.onTimeout(() -> println("执行超时"));
        return result;
    }

    @GetMapping("/callable-hello-world")
    public Callable<String> callableHelloWorld() {
        final long startTime = System.currentTimeMillis();
        println("Hello,World");
        return () -> {
            long costTime = System.currentTimeMillis() - startTime;
            println("执行计算结果，消耗：" + costTime + " ms.");
            return "Hello,World";
        };
    }

    @GetMapping("/completion-stage")
    public CompletionStage<String> completionStage(){
        final long startTime = System.currentTimeMillis();
        println("Hello,World");
        return CompletableFuture.supplyAsync(()->{
            long costTime = System.currentTimeMillis() - startTime;
            println("执行计算结果，消耗：" + costTime + " ms.");
            return "Hello,World"; // 异步执行结果
        });
    }

    private static void println(Object object) {
        String threadName = Thread.currentThread().getName();
        System.out.println("HelloWorldAsyncController[" + threadName + "]: " + object);
    }

}