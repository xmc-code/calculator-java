package org.example;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            double num1, num2 = 0, result;
            char op;

            try {
                System.out.print("请输入运算符 (+, -, *, /, ^, s=sin, c=cos, q=退出): ");
                op = scanner.next().charAt(0);

                if (op == 'q') {
                    System.out.println("计算器已关闭，再见！");
                    return;
                }

                if (op == 's' || op == 'c') {
                    System.out.print("输入角度（度）: ");
                    num1 = scanner.nextDouble();
                } else {
                    System.out.print("输入第一个数字: ");
                    num1 = scanner.nextDouble();
                    System.out.print("输入第二个数字: ");
                    num2 = scanner.nextDouble();
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("【异常捕获】错误：您必须输入合法的数字！请重新输入。");
                scanner.nextLine(); // 清空输入缓冲区
                continue;
            }

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
                    if (num2 != 0) {
                        result = num1 / num2;
                        System.out.println("运算类型：除法");
                    } else {
                        System.out.println("错误：除数不能为零。");
                        continue;
                    }
                    break;
                case '^':
                    result = Math.pow(num1, num2);
                    System.out.println("运算类型：幂运算");
                    break;
                case 's':
                    result = Math.sin(Math.toRadians(num1));
                    System.out.println("运算类型：正弦函数");
                    break;
                case 'c':
                    result = Math.cos(Math.toRadians(num1));
                    System.out.println("运算类型：余弦函数");
                    break;
                default:
                    System.out.println("错误：无效运算符 '" + op + "', 仅支持 +, -, *, /, ^, s, c, q");
                    continue;
            }

            System.out.printf("计算结果：%.2f\n", result);

            System.out.print("是否继续？(y/n): ");
            String choice = scanner.next();
            if (choice.equalsIgnoreCase("n")) {
                System.out.println("计算器已关闭，再见！");
                return;
            }
        }
    }
}