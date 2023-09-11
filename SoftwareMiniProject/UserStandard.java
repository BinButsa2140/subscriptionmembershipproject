import java.time.LocalDate;

public class UserStandard implements UserFunction {//ยังไม่ได้ใช้
    private String username, email, password;
    private int amoutDate = 1;
    String packag;
    public UserStandard(String username, String email, String password, String packag){
        this.username = username;
        this.email = email;
        this.password = password;
        this.packag = packag;
        System.out.println(username);
        System.out.println(email);
        System.out.println(packag);

    }
    @Override
    public String CheckStatus(boolean status) {
        throw new UnsupportedOperationException("Unimplemented method 'CheckStatus'");
    }

    @Override
    public Boolean CountDown(LocalDate date, LocalDate expire) {

        throw new UnsupportedOperationException("Unimplemented method 'CountDown'");
    }
    
}
