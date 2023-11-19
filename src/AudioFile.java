import java.util.ArrayList;

public class AudioFile {
	private String fileName;
	private String artistName;
	private String trackName;
	private int duration;
	private int releaseYear;

	// конструктор
	public AudioFile(String fileName, String artistName, String trackName, int duration, int releaseYear) {
		this.fileName = fileName;
		this.artistName = artistName;
		this.trackName = trackName;
		this.duration = duration;
		this.releaseYear = releaseYear;
	}

	// сеттеры
	public void SetFileName(String fileName) {
		this.fileName = fileName;
	}

	public void SetArtistName(String artistName) {
		this.artistName = artistName;
	}

	public void SetTrackName(String trackName) {
		this.trackName = trackName;
	}

	public void SetDuration(int duration) {
		this.duration = duration;
	}

	public void SetReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	// геттеры
	public String GetFileName() {
		return fileName;
	}
	
	public String GetArtistName() {
		return artistName;
	}

	public String GetTrackName() {
		return trackName;
	}

	public int GetDuration() {
		return duration;
	}

	public int GetReleaseYear() {
		return releaseYear;
	}

	// методы
	public void PrintInfo() {
		PrintInfoLong();
	}

	public void PrintInfo(boolean isLong) {
		if (isLong) PrintInfoLong();
		else PrintInfoShort();
	}

	public void PrintInfoLong() {
		System.out.println("Название файла: " + fileName);
		System.out.println("Имя артиста: " + artistName);
		System.out.println("Название трека: " + trackName);
		System.out.println("Длительность: " + duration + "с");
		System.out.println("Год выхода: " + releaseYear);
	}

	public void PrintInfoShort() {
		System.out.println(artistName + " - " + trackName + ", " + duration + "с, " + releaseYear + " - " + fileName);
	}

	public static void PrintArray(ArrayList<AudioFile> tracks, boolean numbered) {
		System.out.println("Список треков: ");
		for (int i = 0; i < tracks.size(); i++) {
			AudioFile track = tracks.get(i);

			if (numbered) System.out.print((i + 1) + ". ");
			track.PrintInfoShort();
		}
	}
}