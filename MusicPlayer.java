package musicPlayer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class MusicPlayer {
	
	private static ArrayList<Album> albums = new ArrayList<>();
	
	public static void main(String[] args) {
		
		
		Album album = new Album("Love Yourself", "BTS");
		
		album.addSong("Singlularity", 3.16);
		album.addSong("Fake Love", 4.02);
		album.addSong("Paradise", 3.31);
		album.addSong("Magic Shop", 4.35);
		album.addSong("So What", 4.41);
		albums.add(album);
		
		album = new Album ("BE", "BTS");
		
		album.addSong("Life Goes On", 3.27);
		album.addSong("Stay", 3.24);
		album.addSong("Dynamite", 3.19);
		albums.add(album);
		
		LinkedList<Song> playList_1 = new LinkedList<>();
		
		albums.get(0).addToPlayList("Singularity", playList_1);
		albums.get(1).addToPlayList("Life Goes On", playList_1);
		albums.get(0).addToPlayList("So What", playList_1);
		albums.get(1).addToPlayList("Stay", playList_1);
		albums.get(1).addToPlayList("Daynamite", playList_1);
		albums.get(0).addToPlayList("Magic Shop", playList_1);
		
		play(playList_1);
		
		
	}
	
	private static void play(LinkedList<Song> playList) {
		Scanner sc = new Scanner(System.in);
		boolean quit = false;
		boolean forward = true;
		ListIterator<Song> listIterator = playList.listIterator();
		
		if(playList.size() == 0 ) {
			System.out.println("There are no songs in this playlist.");
		}else {
			System.out.println("Now play " + listIterator.next().toString());
			printMenu();
		}
		
		while(!quit) {
			int action = sc.nextInt();
			sc.nextLine();
			
			switch (action) {
			case 0: 
				System.out.println("Playlist is ;complete");
				quit = true;
				break;
			case 1:
				if(!forward) {
					if(listIterator.hasNext()) {
						listIterator.next();
						
					}
					forward = true;
				}
				if(listIterator.hasNext()) {
					System.out.println("Now playing "+listIterator.next().toString());
				}else {
					System.out.println("No Song available. You have reached the end of the list");
					forward = false;
				}
				break;
			case 2: 
				if(forward) {
					if (listIterator.hasPrevious()) {
						listIterator.previous();
					}
					forward = false;
				}
				if(listIterator.hasPrevious()) {
					System.out.println("Now Playing :"+listIterator.previous().toString());
				}else {
					System.out.println("No song available for this.");
					forward = false;
				}
				break;
			case 3: 
				if(forward) {
					if(listIterator.hasPrevious()) {
						System.out.println("Now Playing: "+listIterator.previous().toString());
						forward = false;
					}else {
						System.out.println("This is the start of the playlist.");
					}
				}else {
					if(listIterator.hasNext()) {
						System.out.println("Now Playing: "+listIterator.next().toString());
						forward = true;
					}else {
						System.out.println("This is the end of the playlist");
					}
				}
				break;
				
			case 4: 
				printList(playList);
				break;
			case 5: 
				printMenu();
				break;
			case 6: 
				if (playList.size() > 0) {
					listIterator.remove();
					if(listIterator.hasNext()) {
						System.out.println("Now Playing: "+listIterator.next().toString());
					}
					else {
						if(listIterator.hasPrevious())
						System.out.println("Now Play: "+listIterator.previous().toString());
					}
				}
			}
		}
	}
	
	private static void printMenu() {
		System.out.println("Available options\n Press");
		System.out.println("0 - To Quit\n"+
				"1 - To play next song\n"+
				"2 - To play previous song\n"+
				"3 - To replay the current song\n"+
				"4 - List of all songs \n"+
				"5 - Print all available options \n"+
				"6 - Remove current song ");
	}
	
	private static void printList(LinkedList<Song> playList){
		Iterator<Song> iterator = playList.iterator();
		System.out.println("-------------------");
		
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		System.out.println("-------------------");
	}
}
