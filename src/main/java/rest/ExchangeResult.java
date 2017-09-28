package rest;

public class ExchangeResult {
    private final String from;
    private final String to;
    private final double rate;
    private boolean error;
    private final String errorMsg;
    private final String source;

    public ExchangeResult(String from, String to, double rate, String source){
        this.from = from;
        this.to = to;
        this.rate = rate;
        this.error = false;
        this.errorMsg = "";
        this.source = source;

    }

    public ExchangeResult(String from, String to, double rate, boolean error, String errorMsg){
        this.from = from;
        this.to = to;
        this.rate = rate;
        this.error = error;
        this.errorMsg = errorMsg;
        this.source ="none";
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
    public String getSource() {
        return this.source;
    }
}
