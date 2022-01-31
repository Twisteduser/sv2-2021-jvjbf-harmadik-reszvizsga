package streams;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SongService {
    private List<Song> songService = new ArrayList<>();

    public List<Song> getSongService() {
        return new ArrayList<>(songService);
    }

    public void addSong(Song song){
        songService.add(song);
    }

    public Optional<Song> shortestSong(){
        return songService.stream()
                .min(Comparator.comparing(Song::getLength));

    }

    public List<Song> findSongByTitle(String title){
        return songService.stream()
                .filter(song -> song.getTitle().equals(title))
                .collect(Collectors.toList());
    }

    public boolean isPerformerInSong(Song song, String performer){
        return song.getPerformers()
                .stream()
                .anyMatch(performers->performers.contains(performer));

    }

    public List<String> titlesBeforeDate(LocalDate date){
        return songService.stream()
                .filter(song -> song.getRelease().isBefore(date))
                .map(Song::getTitle)
                .collect(Collectors.toList());
    }
}
