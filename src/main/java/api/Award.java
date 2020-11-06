package api;

public class Award
{
    private String category;
    private String name;
    private boolean winner;

    public Award(String category, String name, boolean winner)
    {
        this.category = category;
        this.name = name;
        this.winner = winner;
    }

    @Override
    public String toString()
    {
        return "Award{" +
                "category='" + category + '\'' +
                ", name='" + name + '\'' +
                ", winner=" + winner +
                '}';
    }
}
