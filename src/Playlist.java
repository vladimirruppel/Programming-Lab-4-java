import java.util.ArrayList;

class Playlist {
	private String playlistName = "Новый плейлист";
	private ArrayList<AudioFile> trackList = new ArrayList<>();

	// конструкторы
	public Playlist(String playlistName) {
		this.playlistName = playlistName;
	}

	public Playlist(String playlistName, ArrayList<AudioFile> trackList) {
		this.playlistName = playlistName;
		this.trackList = trackList;
	}

	public Playlist(String playlistName, AudioFile... tracks) {
		this.playlistName = playlistName;
		for (AudioFile track : tracks) {
			trackList.add(track);
		}
	}

	// сеттеры
	public void SetPlaylistName(String playlistName) {
		this.playlistName = playlistName;
	}

	public void SetTrackList(ArrayList<AudioFile> trackList) {
		this.trackList = trackList;
	}

	public void SetTrackList(AudioFile... tracks) {
		for (AudioFile track : tracks) {
			trackList.add(track);
		}
	}

	// геттеры
	public String GetPlaylistName() {
		return playlistName;
	}

	public ArrayList<AudioFile> GetTrackList() {
		return trackList;
	}

	public int GetSize() {
		return trackList.size();
	}

	public AudioFile GetTrackByIndex(int index) {
		return trackList.get(index);
	}

	// методы
	public void PrintInfo() {
		System.out.println("Название плейлиста: " + playlistName + ", количество треков: " + trackList.size());
	}

	public void PrintTrackList() {
		System.out.println("Плейлист: " + playlistName + " (" + trackList.size() + " треков)");
		for (AudioFile track : trackList) {
			track.PrintInfoShort();
		}
	}

	public void AddTrack(AudioFile track) {
		trackList.add(track);
	}

	public void RemoveTrackByIndex(int index) {
		trackList.remove(index);
	}

	public static void PrintArray(ArrayList<Playlist> playlists) {
		System.out.println("Список плейлистов: ");
		for (Playlist playlist : playlists) {
			playlist.PrintInfo();
		}
	}

	public boolean Contains(AudioFile track) {
		return trackList.contains(track);
	}
}