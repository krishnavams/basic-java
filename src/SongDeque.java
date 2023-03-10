    import java.util.*;

    public class SongDeque {
        private final int capacity;
        private final Map<Integer, LinkedList<String>> playlists;

        public SongDeque(int capacity, int initialCapacity) {
            this.capacity = capacity;
            this.playlists = new HashMap<>();
        }

        public void addSong(int userId, String songId) {
            LinkedList<String> playlist = playlists.computeIfAbsent(userId, k -> new LinkedList<>());

            if (playlist.contains(songId)) {
                playlist.remove(songId);
            }

            playlist.addFirst(songId);

            if (playlist.size() > capacity) {
                playlist.removeLast();
            }
        }

        public List<String> getRecentlyPlayed(int userId) {
            LinkedList<String> playlist = playlists.get(userId);

            if (playlist == null) {
                return Collections.emptyList();
            }

            return new ArrayList<>(playlist);
        }

        public static void main(String[] args) {
            SongDeque store = new SongDeque(3, 0);
            store.addSong(1, "S1");
            store.addSong(1, "S2");
            store.addSong(1, "S3");
            assert store.getRecentlyPlayed(1).equals(Arrays.asList("S3", "S2", "S1"));
            store.addSong(1, "S4");
            assert store.getRecentlyPlayed(1).equals(Arrays.asList("S4", "S3", "S2"));
            store.addSong(1, "S2");
            assert store.getRecentlyPlayed(1).equals(Arrays.asList("S2", "S4", "S3"));
            store.addSong(1, "S1");
            assert store.getRecentlyPlayed(1).equals(Arrays.asList("S1", "S2", "S4"));
        }
    }


