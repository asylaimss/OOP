import java.util.Calendar;
import java.util.Date;

public class TimeDepositAccount {
    private double balance;
    private Date maturityDate;

    public TimeDepositAccount(double balance, DepositLength duration) {
        this.balance = balance;
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, duration.getDays());
        this.maturityDate = cal.getTime();
    }

    public Date getMaturityDate() {
        return maturityDate;
    }
}