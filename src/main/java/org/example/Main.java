package org.example;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Задача 1 ===");
        Task1.solve(new String[]{
                "5",
                "10 30 40 20 50"
        });
        System.out.println();

        System.out.println("=== Задача 2 ===");
        Task2.solve(new String[]{
                "4 10",
                "5 10",
                "4 40",
                "6 30",
                "3 50"
        });
        System.out.println();

        System.out.println("=== Задача 3 ===");
        Task3.solve(new String[]{
                "abcde",
                "ace"
        });
        System.out.println();

        System.out.println("=== Задача 4 ===");
        Task4.solve(new String[]{
                "2 10",
                "3 5",
                "5 8"
        });
        System.out.println();

        System.out.println("=== Задача 5 ===");
        Task5.solve(new String[]{
                "5",
                "1 3 5 4 7"
        });
        System.out.println();

        System.out.println("=== Задача 6 ===");
        Task6.solve(new String[]{
                "ab",
                "ba"
        });
    }
}