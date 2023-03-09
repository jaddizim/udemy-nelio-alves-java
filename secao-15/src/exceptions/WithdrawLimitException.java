package exceptions;

public class WithdrawLimitException extends Exception {
    @Override
    public String getMessage() {
        return "Withdraw error: The amount exceeds withdraw limit";
    }
}