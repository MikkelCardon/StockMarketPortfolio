package Gui.models;

import java.util.ArrayList;

public class Person {
    int person_id;
    String name;
    ArrayList<Portfolio> portfolioArrayList = new ArrayList<>();

    public Person(int person_id, String name) {
        this.person_id = person_id;
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void addPortfolio(Portfolio portfolio){
        portfolioArrayList.add(portfolio);
    }

    public ArrayList<Portfolio> getPortfolioArrayList() {
        return portfolioArrayList;
    }
}
