package com.nechaev.loftcoin;

import android.app.Application;
import android.content.Context;
import android.net.TrafficStats;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class AppModule {
    @Singleton
    @Provides
    static Context context(Application app) {
        return app.getApplicationContext();
    }

    @Provides
    @Singleton
    static ExecutorService ioExecutor() {
        int poolSize = Runtime.getRuntime().availableProcessors() * 2 + 1;
        final AtomicInteger threadIds = new AtomicInteger();
        return Executors.newFixedThreadPool(poolSize, r -> {
            final Thread thread = new Thread(r);
            final int threadId = threadIds.incrementAndGet();
            TrafficStats.setThreadStatsTag(threadId);
            thread.setName("io-" + threadId);
            thread.setPriority(Thread.MIN_PRIORITY);
            return thread;
        });
    }
}
