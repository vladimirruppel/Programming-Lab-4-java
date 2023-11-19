class AudioPlayer {
	private boolean isPlaylistAssigned = false;
	private boolean isPlaying = false;
	private Playlist currentPlaylist = null;
	private int trackIndexInPlaylist = 0;

	// конструкторы 
	public AudioPlayer(Playlist currentPlaylist) {
		this.currentPlaylist = currentPlaylist;
		this.isPlaylistAssigned = true;
	}

	public AudioPlayer(Playlist currentPlaylist, int trackIndexInPlaylist) {
		this.currentPlaylist = currentPlaylist;
		this.trackIndexInPlaylist = trackIndexInPlaylist;
		this.isPlaylistAssigned = true;
	} 

	// сеттеры
	public void SetCurrentPlaylist(Playlist currentPlaylist) {
		this.currentPlaylist = currentPlaylist;
		this.isPlaylistAssigned = true;
	}

	public void SetCurrentPlaylist(Playlist currentPlaylist, int trackIndexInPlaylist) {
		this.currentPlaylist = currentPlaylist;
		this.trackIndexInPlaylist = trackIndexInPlaylist;
		this.isPlaylistAssigned = true;
	}

	// геттеры
	public boolean GetIsPlaying() {
		return isPlaying;
	}

	public boolean GetIsPlaylistAssigned() {
		return isPlaylistAssigned;
	}

	public Playlist GetCurrentPlaylist() {
		return currentPlaylist;
	}

	public AudioFile GetCurrentTrack() {
		boolean isCurrentPlaylistEmpty = currentPlaylist.GetSize() == 0;
		return isCurrentPlaylistEmpty ? null : currentPlaylist.GetTrackByIndex(trackIndexInPlaylist);
	}

	// методы
	public void PrintInfo() {
		System.out.println("Статус: " + (isPlaying ? "играет" : "не играет"));
		System.out.println("Плейлист: " + (isPlaylistAssigned ? currentPlaylist.GetPlaylistName() : "не определен"));
		System.out.println("Трек: " + (isPlaylistAssigned ? (GetCurrentTrack().GetArtistName() + " - " + GetCurrentTrack().GetTrackName()) : "не определен"));
	}

	public void Play() {
		isPlaying = true;	
	}

	public void Pause() {
		isPlaying = false;
	}

	public void Toggle() {
		isPlaying = !isPlaying;
	}

	public void Next() {
		if (trackIndexInPlaylist + 1 < currentPlaylist.GetSize())
			trackIndexInPlaylist++;
	}

	public void Previous() {
		if (trackIndexInPlaylist > 0)
			trackIndexInPlaylist--;
	}
}