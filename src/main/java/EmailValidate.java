public class EmailValidate {
    public static boolean vaild(String s) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\D]+[\\D]$";
        return s.matches(regex);
    }
}
