import java.util.ArrayList;
import java.util.Scanner;

class MusicLibrary {
	private ArrayList<AudioFile> tracks = new ArrayList<AudioFile>();
	private ArrayList<Playlist> playlists = new ArrayList<Playlist>();
	Scanner scanner = new Scanner(System.in);

	// вспомогательная функция
	private ArrayList<AudioFile> GetTracksFromPlaylists(ArrayList<Playlist> playlists) {
		ArrayList<AudioFile> tracks = new ArrayList<AudioFile>();

		for (Playlist playlist : playlists) {
			for (AudioFile track : playlist.GetTrackList()) {
				tracks.add(track);
			}
		}

		return tracks;
	}

	// конструкторы
	public MusicLibrary(ArrayList<AudioFile> tracks) {
		this.tracks = tracks;
	}

	public MusicLibrary(ArrayList<AudioFile> tracks, ArrayList<Playlist> playlists) {
		this.tracks = tracks;
		this.playlists = playlists;
	}

	public MusicLibrary(AudioFile... tracks) {
		for (AudioFile track : tracks) {
			this.tracks.add(track);
		}
	}

	public MusicLibrary(Playlist... playlists) {
		for (Playlist playlist : playlists) {
			this.playlists.add(playlist);
		}
		this.tracks = GetTracksFromPlaylists(this.playlists);
	}

	// сеттеры
	public void SetTracks(AudioFile... tracks) {
		this.tracks = new ArrayList<AudioFile>(); // очистить массив
		for (AudioFile track : tracks) {
			this.tracks.add(track);
		}
	}

	public void SetTracks(ArrayList<AudioFile> tracks) {
		this.tracks = tracks;
	}

	public void SetPlaylists(Playlist... playlists) {
		this.playlists = new ArrayList<Playlist>();
		for (Playlist playlist : playlists) {
			this.playlists.add(playlist);
		}
	}

	public void SetPlaylists(ArrayList<Playlist> playlists) {
		this.playlists = playlists;
	}

	// геттеры
	public int GetTracksCount() {
		return tracks.size();
	}

	public int GetPlaylistsCount() {
		return playlists.size();
	}

	public AudioFile GetTrackByIndex(int index) {
		return tracks.get(index);
	}

	public Playlist GetPlaylistByIndex(int index) {
		return playlists.get(index);
	}

	// методы
	public void AddTrack(AudioFile track) {
		tracks.add(track);
	}

	public void AddPlaylist(Playlist playlist) {
		playlists.add(playlist);
	}

	public AudioFile CreateTrack() {
		System.out.println("Создание трека");
		System.out.print("Введите наименование файла: ");
		String fileName = scanner.nextLine();

		System.out.print("Введите имя артиста: ");
		String artistName = scanner.nextLine();

		System.out.print("Введите название трека: ");
		String trackName = scanner.nextLine();

		System.out.print("Введите длительность трека: ");
		int duration = scanner.nextInt();

		System.out.print("Введите год выхода трека: ");
		int releaseYear = scanner.nextInt();
		scanner.nextLine();

		AudioFile track = new AudioFile(fileName, artistName, trackName, duration, releaseYear);
		AddTrack(track);
		System.out.println("Трек создан");

		return track;
	}

	public Playlist CreatePlaylist() {
		System.out.print("Введите название плейлиста: ");
		String playlistName = scanner.nextLine();

		ArrayList<AudioFile> tracks = new ArrayList<AudioFile>();
		boolean toContinue = true;
		do {
			// TODO: Проверка на существование в массиве одного и того же трека

			System.out.println("Откуда взять трек: ");
			System.out.println("1. Из библиотеки");
			System.out.println("2. Создать новый");

			int answer;
			do {
				System.out.print("Ваш выбор: ");
				answer = scanner.nextInt();
			} while (answer < 1 || answer > 2);

			if (answer == 1) { // из библиотеки
				if (GetTracksCount() == 0) {
					System.out.println("Нет треков в библиотеке");
				} 
				else {
					PrintTracks();

					int trackNumber;
					do {
						System.out.print("Выберите номер трека для добавления в плейлист: ");
						trackNumber = scanner.nextInt();
					} while (trackNumber < 1 || trackNumber > this.tracks.size());

					AudioFile chosenTrack = this.tracks.get(trackNumber - 1);

					if (tracks.contains(chosenTrack)) {
						System.out.println("Выбранный трек уже добавлен в плейлист");
					}
					else {
						tracks.add(chosenTrack);
					}
				}
			}
			else if (answer == 2) { // создать новый
				tracks.add(CreateTrack());
			}

			do {
				System.out.println("Продолжить добавление треков?");
				System.out.println("1. Да");
				System.out.println("0. Нет");

				answer = scanner.nextInt();
			} while (answer < 0 || answer > 1);

			toContinue = answer > 0; // int >> boolean
		} while (toContinue);

		Playlist playlist = new Playlist(playlistName, tracks);
		playlists.add(playlist);
		System.out.println("Плейлист создан");		

		return playlist;
	} 

	public void PrintTracks() {
		AudioFile.PrintArray(tracks, true);
	}

	public void PrintPlaylists() {
		Playlist.PrintArray(playlists);
	}

	public void CloseScanner() {
		scanner.close();
	}
}