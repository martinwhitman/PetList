package view;

import java.util.List;
import java.util.Scanner;

import controller.ListDogsHelper;
import model.ListDogs;


public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static ListDogsHelper ldh = new ListDogsHelper();

		private static void addADog() {
			
			System.out.print("Enter a type: ");
			String type = in.nextLine();
			System.out.print("Enter a name: ");
			String name = in.nextLine();
			System.out.print("Enter an owner: ");
			String owner = in.nextLine();
			ListDogs toAdd = new ListDogs(type,name,owner);
			ldh.insertDog(toAdd);
		}

		private static void deleteADog() {
			// TODO Auto-generated method stub
			System.out.print("Enter the type to delete: ");
			String type = in.nextLine();
			System.out.print("Enter the name to delete: ");
			String name = in.nextLine();
			System.out.print("Enter the owner to delete: ");
			String owner = in.nextLine();
			ListDogs toDelete = new ListDogs(type,name,owner);
			ldh.deleteDog(toDelete);

		}

		private static void editADog() {
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Type");
			System.out.println("2 : Search by Name");
			System.out.println("3 : Search by Owner");
			int searchBy = in.nextInt();
			in.nextLine();
			List<ListDogs> foundDogs;
			if (searchBy == 1) {
				System.out.print("Enter the type: ");
				String typeName = in.nextLine();
				foundDogs = ldh.searchForDogsByType(typeName);
				
			} else if (searchBy==2){
				System.out.print("Enter the name: ");
				String nameName = in.nextLine();
				foundDogs = ldh.searchForItemByName(nameName);

			}
			else {
				System.out.println("Enter the owner");
				String ownerName = in.nextLine();
				foundDogs = ldh.searchForItemByOwner(ownerName);
			}

			if (!foundDogs.isEmpty()) {
				System.out.println("Found Results.");
				for (ListDogs l : foundDogs) {
					System.out.println(l.toString());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				ListDogs toEdit = ldh.searchForItemById(idToEdit);
				System.out.println("Retrieved " + toEdit.getType()+" "+ toEdit.getName()+" owned by "+toEdit.getOwner());
				System.out.println("1 : Update Type");
				System.out.println("2 : Update Name");
				System.out.println("3 : Update Owner");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Type: ");
					String newType = in.nextLine();
					toEdit.setType(newType);
				} else if (update == 2) {
					System.out.print("New Name: ");
					String newName = in.nextLine();
					toEdit.setName(newName);
				} else if (update == 3) {
					System.out.print("New owner: ");
					String newOwner = in.nextLine();
					toEdit.setOwner(newOwner);
				}
				

				ldh.updateDog(toEdit);

			} else {
				System.out.println("---- No results found");
			}

		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to our champion dog list! ---");
			while (goAgain) {
				System.out.println("*  Select an item:");
				System.out.println("*  1 -- Add a dog to the list");
				System.out.println("*  2 -- Edit a dog's info");
				System.out.println("*  3 -- Delete a dog from the list");
				System.out.println("*  4 -- View the list");
				System.out.println("*  5 -- Exit the champion program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addADog();
				} else if (selection == 2) {
					editADog();
				} else if (selection == 3) {
					deleteADog();
				} else if (selection == 4) {
					viewTheList();
				} else {
					ldh.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			List<ListDogs> allDogs = ldh.showAllDogs();
			for(ListDogs l : allDogs){
				System.out.println(l.returnDogDetails());
			

		}

	}
}