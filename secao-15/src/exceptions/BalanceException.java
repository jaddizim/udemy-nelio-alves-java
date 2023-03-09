package exceptions;

public class BalanceException extends Exception {
    @Override
    public String getMessage() {
        return "Withdraw error: Not enough balance";
    }
}