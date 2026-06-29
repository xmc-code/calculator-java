package org.example;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args){
        // 读取两个数字和一个运算符
        Scanner scanner = new Scanner(System.in );
        double num1,num2;
        char op;

        try {
            // 尝试读取第一个数字
            System.out.println("输入第一个数字: ");

            num1 = scanner.nextDouble();
            System.out.println("输入运算符 (+, -, *, /): ");

            op = scanner.next().charAt(0);
            System.out.println("输入第二个数字: ");

            num2 = scanner.nextDouble();
        } catch (java.util.InputMismatchException e) {
            // 如果用户输入的不是数字，就进入这个异常处理
            System.out.println("【异常捕获】错误：您必须输入合法的数字！程序终止。");
            return; // 出现异常，直接结束程序
        }

        // 根据运算符计算结果
        double result;
        boolean validOp = true;
        switch (op) {
            case '+':
                result = num1 + num2;
                System.out.println("运算类型：加法");
                break;
            case '-':
                result = num1 - num2;
                System.out.println("运算类型：减法");
                break;
            case '*':
                result = num1 * num2;
                System.out.println("运算类型：乘法");
                break;
            case '/':
                if (num2 != 0){
                    result = num1 / num2;
                    System.out.println("运算类型：除法");
                } else {
                    System.out.println("错误：除数不能为零。");
                    scanner.close();
                    return;
                }
                break;
            default:
                System.out.println("错误：无效运算符‘"+op+"',仅支持 +，-，*，/");
                scanner.close();
                return;
        }
        System.out.printf("计算结果：%.2f\n",result);
        scanner.close();
    }
}
