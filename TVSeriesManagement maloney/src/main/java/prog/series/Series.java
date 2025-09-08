package prog.series;

import java.util.*;

public class Series {
    private final List<SeriesModel> seriesList = new ArrayList<>();

    public void addSeriesForTest(SeriesModel model) { seriesList.add(model); }

    public boolean captureSeries(String id, String name, String ageStr, String episodesStr) {
        if (!isNumeric(ageStr) || !isNumeric(episodesStr)) return false;
        int age = Integer.parseInt(ageStr);
        int episodes = Integer.parseInt(episodesStr);
        if (!isAgeValid(age)) return false;
        seriesList.add(new SeriesModel(id, name, age, episodes));
        return true;
    }

    public Optional<SeriesModel> searchSeries(String id) {
        return seriesList.stream().filter(s -> s.getSeriesId().equalsIgnoreCase(id)).findFirst();
    }

    public boolean updateSeries(String id, String newName, String newAge, String newEpisodes) {
        Optional<SeriesModel> opt = searchSeries(id);
        if (opt.isEmpty()) return false;
        SeriesModel found = opt.get();
        if (newName != null && !newName.isBlank()) found.setSeriesName(newName);
        if (newAge != null && isNumeric(newAge) && isAgeValid(Integer.parseInt(newAge)))
            found.setSeriesAge(Integer.parseInt(newAge));
        if (newEpisodes != null && isNumeric(newEpisodes))
            found.setSeriesNumberOfEpisodes(Integer.parseInt(newEpisodes));
        return true;
    }

    public boolean deleteSeries(String id) {
        return searchSeries(id).map(seriesList::remove).orElse(false);
    }

    public String seriesReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("---- TV Series Report ----\n");
        sb.append(String.format("%-10s | %-20s | %-5s | %-8s%n", "ID", "Name", "Age", "Episodes"));
        sb.append("-----------------------------------------------\n");
        if (seriesList.isEmpty()) sb.append("No series available.\n");
        for (SeriesModel s : seriesList) {
            sb.append(String.format("%-10s | %-20s | %-5d | %-8d%n",
                    s.getSeriesId(), s.getSeriesName(), s.getSeriesAge(), s.getSeriesNumberOfEpisodes()));
        }
        return sb.toString();
    }

    public void exitSeriesApplication() {
        System.out.println("Exiting... Goodbye.");
    }

    public static boolean isNumeric(String s) { return s.matches("\\d+"); }
    public static boolean isAgeValid(int age) { return age >= 2 && age <= 18; }

    public List<SeriesModel> getSeriesList() { return seriesList; }
}
