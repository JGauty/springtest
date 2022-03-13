package com.demos.springtest.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.concurrent.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.powermock.api.mockito.PowerMockito.*;


@RunWith(PowerMockRunner.class)
@PrepareForTest(Executors.class)
public class PowerMockitoExample {


    @Test
    public void testExecutorService() throws Exception {
//        ThreadPoolExecutor service= new ThreadPoolExecutor(3, 3,
//                11L, TimeUnit.MILLISECONDS,
//                new LinkedBlockingQueue<Runnable>());
        ExecutorService executorService = new ThreadPoolExecutor(10, 100, 5L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
        mockStatic(Executors.class);
        when(Executors.newFixedThreadPool(2)).thenReturn(executorService);

        ExecutorService service1 = Executors.newFixedThreadPool(2);
        System.out.println(service1);

    }
}
