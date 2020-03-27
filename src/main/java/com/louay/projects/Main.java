package com.louay.projects;

import com.louay.projects.dispatch.Mux;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Mux mux = new Mux();
        System.out.println("Please input your equation  e.g.: 1+2+(6-3)");
        mux.dispatcher(input.nextLine());
    }
}
