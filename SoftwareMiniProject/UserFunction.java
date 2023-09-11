import java.time.LocalDate;

interface UserFunction {// ยังไม่ได้ใช้
    public abstract String CheckStatus(boolean status);
    public abstract Boolean CountDown(LocalDate date, LocalDate expire);
}
