import java.time.LocalDate;

public class UserPre implements UserFunction {//ยังไม่ได้ใช้
    private String username, email, password;
    private int amoutDate = 12;

    @Override
    public String CheckStatus(boolean status) {
        throw new UnsupportedOperationException("Unimplemented method 'CheckStatus'");
    }

    @Override
    public Boolean CountDown(LocalDate date, LocalDate expire) {
        throw new UnsupportedOperationException("Unimplemented method 'CountDown'");
    }    
}
