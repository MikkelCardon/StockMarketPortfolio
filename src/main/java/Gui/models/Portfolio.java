package Gui.models;

public class Portfolio {
    private int portfolio_id;
    private String navn;

    public Portfolio(int portfolio_id, String navn) {
        this.portfolio_id = portfolio_id;
        this.navn = navn;
    }

    @Override
    public String toString(){
        return navn +  " " + portfolio_id;
    }
}
