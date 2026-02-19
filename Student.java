public class Student {

    private int studentID;
    private String firstName;
    private String middleName;
    private String lastName;
    private int age;
    private int yearLevel;
    private String program;
    private String contactNo;
    private String barangay;
    private String email;

    private Student(Builder builder) {
        this.studentID = builder.studentID;
        this.firstName = builder.firstName;
        this.middleName = builder.middleName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.yearLevel = builder.yearLevel;
        this.program = builder.program;
        this.contactNo = builder.contactNo;
        this.barangay = builder.barangay;
        this.email = builder.email;
    }

    // GETTERS ONLY
    public int getStudentID() { return studentID; }
    public String getFirstName() { return firstName; }
    public String getMiddleName() { return middleName; }
    public String getLastName() { return lastName; }
    public int getAge() { return age; }
    public int getYearLevel() { return yearLevel; }
    public String getProgram() { return program; }
    public String getContactNo() { return contactNo; }
    public String getBarangay() { return barangay; }
    public String getEmail() { return email; }

    public static class Builder {
        private int studentID;
        private String firstName;
        private String middleName;
        private String lastName;
        private int age;
        private int yearLevel;
        private String program;
        private String contactNo;
        private String barangay;
        private String email;

        public Builder setStudentID(int id) {
            this.studentID = id; return this;
        }
        public Builder setFirstName(String f) {
            this.firstName = f; return this;
        }
        public Builder setMiddleName(String m) {
            this.middleName = m; return this;
        }
        public Builder setLastName(String l) {
            this.lastName = l; return this;
        }
        public Builder setAge(int a) {
            this.age = a; return this;
        }
        public Builder setYearLevel(int y) {
            this.yearLevel = y; return this;
        }
        public Builder setProgram(String p) {
            this.program = p; return this;
        }
        public Builder setContactNo(String c) {
            this.contactNo = c; return this;
        }
        public Builder setBarangay(String b) {
            this.barangay = b; return this;
        }
        public Builder setEmail(String e) {
            this.email = e; return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}
