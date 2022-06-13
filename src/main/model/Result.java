package main.model;

public class Result  {
    private Polinom result;

    public Result(Polinom result) {
        super();
        this.result = result;
    }
    public Result() {
        super();
    }

    public Polinom getResult() {
        return result;
    }

    public void setResult(Polinom result) {
        this.result = result;
    }



}