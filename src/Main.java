public class Main {
    public static void main(String[] args) {
        AudioFile af1 = new AudioFile("main1.mp3", "Drake", "God's plan", 243, 2023);
        AudioFile af2 = new AudioFile("main2.mp3", "Kanye West", "Jesus Lord", 243, 2021);

        Playlist pl = new Playlist("Крутой рэп из Америки", af1, af2);
        pl.PrintTrackList();

        // обработка строк
        if (af1.GetArtistName().equals("Drake")) {
            System.out.println("Первый артист - всеми любимый Drake");
        }
        int index = af2.GetArtistName().indexOf("West");
        System.out.println("Индекс подстроки 'West' - " + index);

        String artistName = af2.GetArtistName();
        String newArtistName = artistName.replace("West", "East");
        System.out.println("Новое имя исполнителя - " + newArtistName);
        // конец обработки строк

        // возврат целого числа из метода вспомогательного класса
        AuditionsNumber an = new AuditionsNumber();
        System.out.println("Количество прослушиваний: " + an.getCount());
        an.addCount(2);
        System.out.println("Количество прослушиваний: " + an.getCount());

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

        System.out.println("Общее количество созданных треков: " + AudioFile.getTotalAudioFiles());
    }
}