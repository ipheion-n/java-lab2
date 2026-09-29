public class JournalEntry {
    private final String lastName;
    private final String firstName;
    private final String birthDate;
    private final String phone;
    private final String address;

    public JournalEntry(String lastName, String firstName, String birthDate, String phone, String address) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.phone = phone;
        this.address = address;
    }

    public String getLastName() { return lastName; }
    public String getFirstName() { return firstName; }
    public String getBirthDate() { return birthDate; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }

    @Override
    public String toString() {
        return String.format(
            "Студент: %s %s | Дата народж.: %s | Тел: %s | Адреса: %s",
            lastName, firstName, birthDate, phone, address
        );
    }
}