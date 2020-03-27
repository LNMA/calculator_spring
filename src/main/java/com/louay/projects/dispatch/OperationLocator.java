package com.louay.projects.dispatch;

import com.louay.projects.factory.BeanFactory;
import com.louay.projects.operation.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class OperationLocator {
    private static Map<String, Operation> operationMap = new HashMap<>();
    private static ApplicationContext ac = new AnnotationConfigApplicationContext(BeanFactory.class);

    static {
        operationMap.put("+", ac.getBean(Addition.class));
        operationMap.put("-", ac.getBean(Subtraction.class));
        operationMap.put("*", ac.getBean(Multiplication.class));
        operationMap.put("/", ac.getBean(Division.class));
        operationMap.put("%", ac.getBean(Modulo.class));
        operationMap.put("^", ac.getBean(Power.class));
    }

    public static Operation getOperation(String operation) {
        return operationMap.get(operation);
    }

}
