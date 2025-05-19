

package com.example.stickherogame;

import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

import java.util.Random;

public class Platform {
    private double platformWidth;
    private double stickHeroPosition;

    private final int platformHeight = 200;
    private final double screenMargin = 50; // Distance from the screen end

    public Platform(double width, double position) {
        this.platformWidth = width;
        this.stickHeroPosition = position;
    }

    public double getPlatformWidth() {
        return platformWidth;
    }

    public double getStickHeroPosition() {
        return stickHeroPosition;
    }

    public double getPlatform_Width() {
        return platformWidth;
    }


    public double getPlatform_Height() {
        return platformHeight;
    }

//    public void generatePlatforms() {
//        // Get screen dimensions
//        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
//        double screenWidth = primaryScreenBounds.getWidth();
//
//        // Generate the first platform with fixed height and width
//        Platform firstPlatform = new Platform(200, screenMargin);
//        System.out.println("First Platform - Width: " + firstPlatform.getPlatformWidth() +
//                ", Position: " + firstPlatform.getStickHeroPosition());
//
//        // Generate the second platform with fixed height and variable length
//        double secondPlatformWidth = generateRandomLength(screenWidth - screenMargin - firstPlatform.getPlatformWidth());
//        Platform secondPlatform = new Platform(secondPlatformWidth, screenWidth - secondPlatformWidth - screenMargin);
//        System.out.println("Second Platform - Width: " + secondPlatform.getPlatformWidth() +
//                ", Position: " + secondPlatform.getStickHeroPosition());
//    }
//
//    private double generateRandomLength(double maxWidth) {
//        // Generate a random length for the second platform within a certain range
//        Random random = new Random();
//        return random.nextDouble() * maxWidth;
//    }
}
