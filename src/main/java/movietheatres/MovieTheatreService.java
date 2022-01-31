package movietheatres;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.*;

public class MovieTheatreService{
    private Map<String, List<Movie>> Shows = new LinkedHashMap<>();

    public Map<String, List<Movie>> getShows() {
        return this.Shows;
    }

    public void readFromFile(Path path) {
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            while (reader.ready()) {
                loader(reader.readLine());
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
    }

    private void loader(String line) {
        String[] temp = line.split("-");
        String theater = temp[0];
        temp = temp[1].split(";");
        String title = temp[0];
        LocalTime startTime = LocalTime.parse(temp[1]);
        Shows.putIfAbsent(theater, new ArrayList<>());
        List<Movie> movies = Shows.get(theater);
        movies.add(new Movie(title, startTime));
        movies.sort(Comparator.comparing(Movie::getStartTime));
    }


    public List<String> findMovie(String title) {
        return Shows.entrySet().stream()
                .filter(entry -> entry.getValue().stream().anyMatch(movie -> movie.getTitle().equals(title)))
                .map(Map.Entry::getKey)
                .toList();
    }

    public LocalTime findLatestShow(String title) {
        return Shows.values().stream()
                .flatMap(List::stream)
                .filter(movie -> movie.getTitle().equals(title))
                .max(Comparator.comparing(Movie::getStartTime))
                .orElseThrow(() -> new IllegalArgumentException("Movie not found"))
                .getStartTime();
    }
}
