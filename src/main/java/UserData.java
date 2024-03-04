import java.text.ParseException;
import java.text.SimpleDateFormat;

class UserData {
    private String lastName;
    private String firstName;
    private String middleName;
    private String birthDate;
    private long phoneNumber;
    private char gender;

    public UserData(String lastName,
                    String firstName,
                    String middleName,
                    String birthDate,
                    long phoneNumber,
                    char gender) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthDate = validateDate(birthDate);
        this.phoneNumber = validatePhoneNumber(phoneNumber);
        this.gender = validateGender(gender);
    }

    private String validateDate(String date) {
        try {
            // Проверка формата даты
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            dateFormat.setLenient(false);
            dateFormat.parse(date);
            return date;
        } catch (ParseException e) {
            throw new IllegalArgumentException("Неверный формат даты");
        }
    }

    private long validatePhoneNumber(long phoneNumber) {
        // Проверка формата номера телефона
        if (String.valueOf(phoneNumber).matches("\\d{10}")) {
            return phoneNumber;
        } else {
            throw new IllegalArgumentException("Неверный формат номера телефона");
        }
    }

    private char validateGender(char gender) {
        if (gender == 'f' || gender == 'm') {
            return gender;
        } else {
            throw new IllegalArgumentException("Неверный формат пола");
        }
    }

    public String getLastName() {
        return lastName;
    }

    public String toString() {
        return String.format("%s %s %s %s %d %c",
                lastName,
                firstName,
                middleName,
                birthDate,
                phoneNumber,
                gender);
    }
}