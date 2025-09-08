package prog.series;

public class SeriesModel {
    private String seriesId;
    private String seriesName;
    private int seriesAge;
    private int seriesNumberOfEpisodes;

    public SeriesModel(String seriesId, String seriesName, int seriesAge, int seriesNumberOfEpisodes) {
        this.seriesId = seriesId;
        this.seriesName = seriesName;
        this.seriesAge = seriesAge;
        this.seriesNumberOfEpisodes = seriesNumberOfEpisodes;
    }

    public String getSeriesId() { return seriesId; }
    public void setSeriesId(String seriesId) { this.seriesId = seriesId; }

    public String getSeriesName() { return seriesName; }
    public void setSeriesName(String seriesName) { this.seriesName = seriesName; }

    public int getSeriesAge() { return seriesAge; }
    public void setSeriesAge(int seriesAge) { this.seriesAge = seriesAge; }

    public int getSeriesNumberOfEpisodes() { return seriesNumberOfEpisodes; }
    public void setSeriesNumberOfEpisodes(int seriesNumberOfEpisodes) { this.seriesNumberOfEpisodes = seriesNumberOfEpisodes; }

    @Override
    public String toString() {
        return String.format("Series ID: %s%nSeries Name: %s%nAge Restriction: %d%nEpisodes: %d",
                seriesId, seriesName, seriesAge, seriesNumberOfEpisodes);
    }
}
