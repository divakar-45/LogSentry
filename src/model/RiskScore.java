package model;

public class RiskScore {

    public static int calculate(Alert alert) {

        switch (alert.getRuleName()) {

            case "Password Spraying":
                return 90;

            case "Brute Force Attack":
                return 80;

            case "Midnight Login":
                return 40;

            default:
                return 20;

        }

    }

}