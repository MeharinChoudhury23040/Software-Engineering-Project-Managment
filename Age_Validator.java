package validation;

public class AgeValidator {
    public static void validate(int age) throws InvalidAgeException {
        if (age < 18 || age > 60) {
            throw new InvalidAgeException("Age must be between 18 and 60.");
        }
    }
}