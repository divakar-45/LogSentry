package mitre;

public class MitreMapper {

    public static String getTechniqueId(String ruleName) {

        switch (ruleName) {

            case "Brute Force Attack":
                return "T1110";

            case "Password Spraying":
                return "T1110.003";

            case "Midnight Login":
                return "Behavioral Detection";

            default:
                return "Unknown";

        }

    }

}