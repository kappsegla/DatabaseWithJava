package org.example;

public class Country {
    private String name;
    private String capital;
    private int population;
    private String code;

    public Country(String name, String capital, int population, String code) {
        this.name = name;
        this.capital = capital;
        this.population = population;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
