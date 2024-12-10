/*
 * This should be your main class where all your objects will be created
 */
package org.example;

public class App {
    public String getGreeting() {
        return "Hello World!h ";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
    }
}
