package validation;

public class DeptValidator {
    public static void validate(String dept) throws InvalidDeptException {
        String[] validDepts = {"CSE", "EEE", "BBA", "ME", "ICT"};
        boolean isValid = false;

        for (String d : validDepts) {
            if (d.equalsIgnoreCase(dept)) {
                isValid = true;
                break;
            }
        }

        if (!isValid) {
            throw new InvalidDeptException("Department must be one of: CSE, EEE, BBA, ME, ICT.");
        }
    }
}