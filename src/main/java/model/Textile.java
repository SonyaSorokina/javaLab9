package model;

public class Textile {
    private String name;
    private String compound;
    private String color;
    private String country;
    private String pattern;

    public Textile(String name, String compound, String color, String country, String pattern)
    {
        this.name = name;
        this.compound = compound;
        this.color = color;
        this.country = country;
        this.pattern = pattern;
    }

    public String getName()
    {
        return name;
    }

    public String getCompound()
    {
        return compound;
    }

    public String getColor()
    {
        return color;
    }

    public String getCountry()
    {
        return country;
    }

    public String getPattern()
    {
        return pattern;
    }

}
