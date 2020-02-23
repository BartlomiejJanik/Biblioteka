public class FixNumeru {
    public static String fix(String nr){
        if (nr.length()==3){
            return "0"+nr;
        }
        if (nr.length()==2){
            return "00"+nr;
        }
        if (nr.length()==1){
            return "000"+nr;
        }
        return nr;
    }
}
