package rest;

public class ExchangeResult {
    private final String from;
    private final String to;
    private final double rate;
    private boolean error;
    private final String errorMsg;

    public ExchangeResult(String from, String to, double rate){
        this.from = from;
        this.to = to;
        this.rate = rate;
        this.error = false;
        this.errorMsg = "";
    }

    public ExchangeResult(String from, String to, double rate, boolean error, String errorMsg){
        this.from = from;
        this.to = to;
        this.rate = rate;
        this.error = error;
        this.errorMsg = errorMsg;
    }

    public String getFrom() {
        return this.from;
    }
    public String getTo() {
        return this.to;
    }
    public double getRate() {
        return this.rate;
    }
    public boolean getError() {
        return this.error;
    }
    public String getErrorMsg() {
        return this.errorMsg;
    }
}
