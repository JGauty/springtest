package com.demos.springtest.service;

import com.demos.springtest.dao.EmployeeRepository;
import com.demos.springtest.entity.Employee;
import oracle.ucp.proxy.annotation.Pre;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

import static org.junit.Assert.*;
import static org.powermock.api.mockito.PowerMockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(EmployeeService.class)
public class EmployeeServiceTest {

//    @InjectMocks
//    EmployeeService employeeService;

    @Mock
    EmployeeRepository employeeRepository;

    @Captor
    ArgumentCaptor<ExecutorService> keyCaptor;

    @Test
    public void testSuccess(){
        Employee employee = new Employee();
        Mockito.when(employeeRepository.findAll()).thenReturn(Arrays.asList(employee));
        ExecutorService executorService = new ThreadPoolExecutor(10, 100, 5L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
        mockStatic(Executors.class);
        when(Executors.newFixedThreadPool(2)).thenReturn(executorService);

        EmployeeService employeeService = spy(new EmployeeService(employeeRepository));
        employeeService.findAllEmployees();
        Mockito.verify(employeeService, Mockito.times(1)).justCheck(keyCaptor.capture());
        Mockito.verify(employeeRepository, Mockito.times(1)).findAll();
        List<ExecutorService> list = keyCaptor.getAllValues();
        System.out.println(keyCaptor.getAllValues());
    }
}