import java.util.Scanner;
import validation.AgeValidator;
import validation.DeptValidator;
import validation.InvalidAgeException;
import validation.InvalidDeptException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter your age: ");
            int age = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter your department: ");
            String dept = scanner.nextLine();

            AgeValidator.validate(age);
            DeptValidator.validate(dept);

            System.out.println("✅ Validation successful!");

        } catch (InvalidAgeException e) {
            System.out.println("❌ Age Error: " + e.getMessage());
        } catch (InvalidDeptException e) {
            System.out.println("❌ Department Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid input: Age must be a number.");
        } finally {
            scanner.close();
        }
    }
}