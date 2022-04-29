package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;

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

		input.close();
	}

	private void startUserInterface(Scanner input) {
		System.out.println("Welcome to the SDVid film database.");
		System.out.println("Choose one of three options: ");
		System.out.println("1) Search for an Actor by ID Number");
		System.out.println("2) Search for a Film by ID Number");
		System.out.println("3) Exit program");
		try {
			int choice = input.nextInt();
			input.nextLine();
			if (choice < 1 || choice > 3) {
				startUserInterface(input);
			}
			while (choice != 3) {
				switch (choice) {
				case 1:
					getActor(input);
					break;
				case 2:
					getFilm(input);
					break;
				case 3:
					break;
				}
			}
			
		} catch (Exception e) {
			startUserInterface(input);
		} finally {
			System.out.println("Goodbye.");
		}

	}

	public void getActor(Scanner input) {
		System.out.println("Enter an Actor ID: ");
		try {
			int id = input.nextInt();
			input.nextLine();
			DatabaseAccessorObject dao = new DatabaseAccessorObject();
			System.out.println(dao.findActorById(id));
		} catch (Exception e) {
			startUserInterface(input);
		}
	}
	
	public void getFilm(Scanner input) {
		System.out.println("Enter a Film ID: ");
		try {
			int id = input.nextInt();
			input.nextLine();
			DatabaseAccessorObject dao = new DatabaseAccessorObject();
			System.out.println(dao.findFilmById(id));
		} catch (Exception e) {
			startUserInterface(input);
		}
	}


}
