package Model;

public class User {
    private  String Name,Password,StaffNo,IsStaff;

    public User(String name, String password) {
        Name = name;
        Password = password;
    }

    public User() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getStaffNo() {
        return StaffNo;
    }

    public void setStaffNo(String staffNo) {
        StaffNo = staffNo;
    }

    public String getIsStaff() {
        return IsStaff;
    }

    public void setIsStaff(String isStaff) {
        IsStaff = isStaff;
    }
}
