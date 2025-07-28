package dev.luanfernandes.demos.automation;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Scanner;

import static java.awt.event.InputEvent.BUTTON1_DOWN_MASK;

public class AutoClicker {
    
    public static void main(String[] args) throws AWTException {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the duration in minutes: ");
            long durationInMinutes = scanner.nextLong();
            System.out.print("Enter the interval in seconds: ");
            int intervalInSeconds = scanner.nextInt();
            Robot robot = new Robot();
            long totalInteractions = (durationInMinutes * 60) / intervalInSeconds;
            System.out.println("======= Initializing AutoClicker =======");
            for (int i = 0; i < totalInteractions; i++) {
                long remainingTime = (totalInteractions - i) * intervalInSeconds;
                System.out.println("Interaction: " + (i + 1) + "/" + totalInteractions);
                System.out.println("Time remaining: " + remainingTime + " seconds");
                robot.mouseMove(20, 200);
                robot.mousePress(BUTTON1_DOWN_MASK);
                robot.mouseRelease(BUTTON1_DOWN_MASK);
                System.out.println("Button clicked!");
                robot.delay(intervalInSeconds * 1000);
            }
        }
    }
}