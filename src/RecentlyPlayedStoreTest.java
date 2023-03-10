import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class RecentlyPlayedStoreTest {

    @Test
    public void testAddSong() {
        SongDeque store = new SongDeque(3, 0);
        store.addSong(1, "S1");
        store.addSong(1, "S2");
        store.addSong(1, "S3");
        assertEquals(Arrays.asList("S3", "S2", "S1"), store.getRecentlyPlayed(1));
        store.addSong(1, "S4");
        assertEquals(Arrays.asList("S4", "S3", "S2"), store.getRecentlyPlayed(1));
        store.addSong(1, "S2");
        assertEquals(Arrays.asList("S2", "S4", "S3"), store.getRecentlyPlayed(1));
        store.addSong(1, "S1");
        assertEquals(Arrays.asList("S1", "S2", "S4"), store.getRecentlyPlayed(1));
    }

    @Test
    public void testGetRecentlyPlayed() {
        SongDeque store = new SongDeque(3, 0);
        store.addSong(1, "S1");
        store.addSong(1, "S2");
        store.addSong(1, "S3");
        assertEquals(Arrays.asList("S3", "S2", "S1"), store.getRecentlyPlayed(1));
        assertEquals(Collections.emptyList(), store.getRecentlyPlayed(2));
    }

}
