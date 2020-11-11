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

    /**
     * Get the Award's category
     *
     * @return category as String
     */
    public String getCategory()
    {
        return category;
    }

    /**
     * Get the Award's name
     *
     * @return name as String
     */
    public String getName()
    {
        return name;
    }

    /**
     * Get the Award's win status
     *
     * @return winner as boolean
     */
    public boolean isWinner()
    {
        return winner;
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
