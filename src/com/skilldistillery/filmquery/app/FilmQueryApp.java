package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) throws SQLException {
		FilmQueryApp app = new FilmQueryApp();
//		app.test();
		app.launch();
	}

//	private void test() throws SQLException {
//		Film film = db.findFilmById(1);
//		System.out.println(film);
//	}

	private void launch() {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);
		
		System.out.println("Goodbye.");

		input.close();
	}

	private void startUserInterface(Scanner input) {
		System.out.println("Welcome to the SDVid film database.");
		System.out.println("Choose one of three options: ");
		boolean keepGoing = true;
		while (keepGoing) {
//			System.out.println("1) Search for an Actor by ID Number");
//			System.out.println("2) Search for a Film by ID Number");
//			System.out.println("3) Search for all Films with an Actor in the cast");
//			System.out.println("4) Search for all Actors within a Film cast");
//			System.out.println("5) Exit program");
//			<<<<<<<< User Story 1 >>>>>>>
//			The user is presented with a menu in which they can choose to:
//				Look up a film by its id.
//				Look up a film by a search keyword.
//				Exit the application.
			System.out.println("1) Search for a Film by ID Number");
			System.out.println("2) Search for a Film by Keyword");
			System.out.println("3) Exit program");
			try {
				int choice = input.nextInt();
				input.nextLine();
				keepGoing = handleChoice(choice, input);

			} catch (Exception e) {
//				startUserInterface(input);
				System.err.println(e);
			} 

		}

	}

	public boolean handleChoice(int choice, Scanner input) {
		if (choice == 3) {
			return false;
		} else if (choice >0 && choice < 3) {
			switch (choice) {
//			case 1:
//				getActor(input);
//				return true;
//			case 2:
//				getFilm(input);
//				return true;
//			case 3:
//				getFilmsByActor(input);
//				return true;
//			case 4:
//				getActorsByFilm(input);
//				return true;
			case 1:
				getFilm(input);
				return true;
			case 2:
				getFilmsByKeyword(input);
				return true;
			}
		}
		return true;
	}

	public void getActor(Scanner input) {
		System.out.println("Enter an Actor ID: ");
		try {
			int id = input.nextInt();
			input.nextLine();
			DatabaseAccessorObject dao = new DatabaseAccessorObject();
			System.out.println(dao.findActorById(id));
		} catch (Exception e) {
//			startUserInterface(input);
			System.err.println(e);
		}
	}

	public void getFilm(Scanner input) {
		System.out.println("Enter a Film ID: ");
		try {
			int id = input.nextInt();
			input.nextLine();
			DatabaseAccessorObject dao = new DatabaseAccessorObject();
			;
			if (dao.findFilmById(id) == null) {
				System.out.println("No titles for that Film ID.");
				System.out.println();
			} else {
//				System.out.println(dao.findFilmById(id).toString());
				Film film = dao.findFilmById(id);
				System.out.println(film.getTitle() + " | " + film.getReleaseYear() + " | " + film.getRating() + " | \"" + film.getDescription() + "\"");
			}
		} catch (Exception e) {
//			startUserInterface(input);
			System.err.println(e);
		}
	}
	
	public void getFilmsByKeyword(Scanner input) {
		try {
			System.out.println("Enter a search string for a Film: ");
			String keyword = input.nextLine();
			DatabaseAccessorObject dao = new DatabaseAccessorObject();
			if (dao.findFilmsByKeyword(keyword).isEmpty()) {
				System.out.println("No titles or descriptions for that string.");
				System.out.println();
			} else {
				List<Film> films = new ArrayList<>();
				films = dao.findFilmsByKeyword(keyword);
				for (Film film : films) {
					System.out.println(film.getTitle() + " | " + film.getReleaseYear() + " | " + film.getRating() + " | \"" + film.getDescription() + "\"");
				}
			}
		} catch (Exception e) {
//			startUserInterface(input);
			System.err.println(e);
		}
	}
	
	public void getFilmsByActor(Scanner input) {
		System.out.println("Enter an Actor ID: ");
		try {
			int id = input.nextInt();
			input.nextLine();
			DatabaseAccessorObject dao = new DatabaseAccessorObject();
			for (Film film : dao.findFilmsByActorId(id)) {
				System.out.println(film.getTitle());
			}
		} catch (Exception e) {
//			startUserInterface(input);
			System.err.println(e);
		}
	}

	public void getActorsByFilm(Scanner input) {
		System.out.println("Enter a Film ID: ");
		try {
			int id = input.nextInt();
			input.nextLine();
			DatabaseAccessorObject dao = new DatabaseAccessorObject();
			for (Actor actor : dao.findActorsByFilmId(id)) {
				System.out.println(actor.getFirstName().toString() + " " + actor.getLastName().toString());
			}
		} catch (Exception e) {
//			startUserInterface(input);
			System.err.println(e);
		}
	}

}
