import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AudioFile af1 = new AudioFile("main1.mp3", "Drake", "God's plan", 243, 2023);
        AudioFile af2 = new AudioFile("main2.mp3", "Kanye West", "Jesus Lord", 243, 2021);

        Playlist pl = new Playlist("Крутой рэп из Америки", af1, af2);
        pl.PrintTrackList();

        AudioPlayer player = new AudioPlayer(pl);
        player.PrintInfo();
        player.Play();
        player.Next();
        player.PrintInfo();

        AudioCollection ac = new AudioCollection(af1, af2);
        ac.PrintStats();
        ac.SearchAndPrintByArtistName("Kanye West");

        MusicLibrary lib = new MusicLibrary(pl);
        lib.PrintTracks();
        lib.CreateTrack();
        lib.CreatePlaylist();
        lib.PrintPlaylists();
        lib.CloseScanner();
    }
}