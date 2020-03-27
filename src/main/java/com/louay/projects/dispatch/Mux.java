package com.louay.projects.dispatch;

import com.louay.projects.factory.BeanFactory;
import com.louay.projects.operation.*;
import com.louay.projects.operation.impl.OperationImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import java.util.Stack;

public class Mux {
    private ApplicationContext ac = new AnnotationConfigApplicationContext(BeanFactory.class);
    private OperationNumbers operationNumbers = null;
    private Stack<String> operator = new Stack<>();
    private Stack<String> operand = new Stack<>();


    private String splitBlanks(String equation) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < equation.length(); i++) {
            char current = equation.charAt(i);
            if (current == '(' || current == ')' || current == '+' || current == '-' || current == '*' || current == '/' || current == '%' || current == '^') {
                result.append(" ");
                result.append(current);
                result.append(" ");
            } else {
                result.append(current);
            }
        }
        return result.toString();
    }

    public void dispatcher(String line) {
        if (line != null) {
            String splitLine = splitBlanks(line);
            String[] command = splitLine.split(" ");

            for (int i = 0; i < command.length; i++) {

                if ("(".equals(command[i])) {
                    i += 2;
                    while (!")".equals(command[i])) {
                        OperationNumbers operation = buildNumbers(isExponential(command[i-1]), isExponential(command[i+1]), command[i]);
                        command[i + 1] = makeAnOperation().toString();
                        operation.printResult();
                        i += 2;
                    }
                    operand.push(command[i - 1]);

                } else {

                    if (command[i].equals("+") || command[i].equals("-") || command[i].equals("*") || command[i].equals("%") ||
                            command[i].equals("/") || command[i].equals("^")) {
                        operator.push(command[i]);

                    } else {

                        if ((command[i].matches("[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?"))) {
                                operand.push(command[i]);
                        }else {

                            if (command[i].matches("[eE]")){
                                operand.push(isExponential(command[i]));
                            }
                        }
                    }
                }
            }
            System.out.println(calculateStack());
        }
    }

    public String isExponential(String number) {
        return number.matches("[eE]") ? String.valueOf(Math.E) : number;
    }


    private String calculateStack() {
        if (!operator.empty()) {
            OperationNumbers operation = buildNumbers(operand.pop(), operand.pop(), operator.pop());
            operand.push(makeAnOperation().toString());
            operation.printResult();
            calculateStack();
        }
        return operand.peek();
    }


    private OperationNumbers buildNumbers(String num1, String num2, String operation) {
        this.operationNumbers = ac.getBean(OperationNumbers.class);
        Number number1 = Double.valueOf(num1);
        Number number2 = Double.valueOf(num2);
        this.operationNumbers.setNumber1(number1);
        this.operationNumbers.setNumber2(number2);
        this.operationNumbers.setOperation(OperationLocator.getOperation(operation));
        return operationNumbers;
    }


    private Number makeAnOperation() {
        Number result = 0;
        Operation operation = this.operationNumbers.getOperation();
        ((OperationImpl) operation).setNumber1(this.operationNumbers.getNumber1());
        ((OperationImpl) operation).setNumber2(this.operationNumbers.getNumber2());
        if (operation instanceof Addition) {
            result = ((Addition) operation).additionOperation(this.operationNumbers.getNumber1(), this.operationNumbers.getNumber2());
        } else {
            if (operation instanceof Subtraction) {
                result = ((Subtraction) operation).subtractionOperation(this.operationNumbers.getNumber1(), this.operationNumbers.getNumber2());
            } else {
                if (operation instanceof Division) {
                    result = ((Division) operation).divisionOperation(this.operationNumbers.getNumber1(), this.operationNumbers.getNumber2());
                } else {
                    if (operation instanceof Multiplication) {
                        result = ((Multiplication) operation).multiplicationOperation(this.operationNumbers.getNumber1(), this.operationNumbers.getNumber2());
                    } else {
                        if (operation instanceof Power) {
                            result = ((Power) operation).powerOperation(this.operationNumbers.getNumber1(), this.operationNumbers.getNumber2());
                        } else {
                            if (operation instanceof Modulo) {
                                result = ((Modulo) operation).moduloOperation(this.operationNumbers.getNumber1(), this.operationNumbers.getNumber2());
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
