package krawczyk;

import java.util.Scanner;

public class WspolnotaMieszkaniowa {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Administrator admin = new Administrator("Jan", "Kowalski", "admin", "admin123");
        admin.dodajMieszkanca(new Mieszkaniec("Anna", "Nowak", "anna", "haslo1", 500.0));
        admin.dodajMieszkanca(new Mieszkaniec("Piotr", "Kowalski", "piotr", "haslo2", 600.0));
        admin.dodajMieszkanca(new Mieszkaniec("Katarzyna", "Wiśniewska", "katarzyna", "haslo3", 550.0));
        admin.dodajMieszkanca(new Mieszkaniec("Tomasz", "Lewandowski", "tomasz", "haslo4", 700.0));
        admin.dodajMieszkanca(new Mieszkaniec("Zofia", "Kamińska", "zofia", "haslo5", 480.0));
        admin.dodajMieszkanca(new Mieszkaniec("Michał", "Wójcik", "michal", "haslo6", 620.0));
        admin.dodajMieszkanca(new Mieszkaniec("Agnieszka", "Kowalczyk", "agnieszka", "haslo7", 530.0));
        admin.dodajMieszkanca(new Mieszkaniec("Łukasz", "Zieliński", "lukasz", "haslo8", 560.0));
        admin.dodajMieszkanca(new Mieszkaniec("Monika", "Szymańska", "monika", "haslo9", 590.0));
        admin.dodajMieszkanca(new Mieszkaniec("Paweł", "Nowicki", "pawel", "haslo10", 610.0));

        while (true) {
            System.out.println("Witaj w systemie wspólnoty mieszkaniowej!");
            System.out.println("1. Zaloguj jako administrator");
            System.out.println("2. Zaloguj jako mieszkaniec");
            System.out.println("3. Wyjdź");
            System.out.print("Wybierz opcję: ");

            int wybor = scanner.nextInt();
            scanner.nextLine();

            switch (wybor) {
                case 1:
                    zalogujAdministratora(admin);
                    break;
                case 2:
                    zalogujMieszkanca(admin);
                    break;
                case 3:
                    System.out.println("Do widzenia!");
                    return;
                default:
                    System.out.println("Nieprawidłowy wybór.");
            }
        }
    }

    private static void zalogujAdministratora(Administrator admin) {
        System.out.print("Podaj login: ");
        String login = scanner.nextLine();
        System.out.print("Podaj hasło: ");
        String haslo = scanner.nextLine();

        if (admin.zaloguj(login, haslo)) {
            System.out.println("Zalogowano jako administrator.");
            menuAdministratora(admin);
        } else {
            System.out.println("Nieprawidłowy login lub hasło.");
        }
    }

    private static void zalogujMieszkanca(Administrator admin) {
        System.out.print("Podaj login: ");
        String login = scanner.nextLine();
        System.out.print("Podaj hasło: ");
        String haslo = scanner.nextLine();

        for (Mieszkaniec mieszkaniec : admin.mieszkancy) {
            if (mieszkaniec.zaloguj(login, haslo)) {
                System.out.println("Zalogowano jako mieszkaniec.");
                menuMieszkanca(mieszkaniec);
                return;
            }
        }

        System.out.println("Nieprawidłowy login lub hasło.");
    }

    private static void menuAdministratora(Administrator admin) {
        while (true) {
            admin.wyswietlMenu();
            System.out.print("Wybierz opcję: ");

            int wybor = scanner.nextInt();
            scanner.nextLine();

            switch (wybor) {
                case 1:
                    admin.wyswietlListeMieszkancow();
                    break;
                case 2:
                    dodajMieszkanca(admin);
                    break;
                case 3:
                    usunMieszkanca(admin);
                    break;
                case 4:
                    admin.zarzadzajBudzetem();
                    break;
                case 5:
                    System.out.println("Wylogowano.");
                    return;
                default:
                    System.out.println("Nieprawidłowy wybór.");
            }

            System.out.println("---------------------------------");
        }
    }

    private static void menuMieszkanca(Mieszkaniec mieszkaniec) {
        while (true) {
            mieszkaniec.wyswietlMenu();
            System.out.print("Wybierz opcję: ");

            int wybor = scanner.nextInt();
            scanner.nextLine();

            switch (wybor) {
                case 1:
                    mieszkaniec.wyswietlInformacje();
                    break;
                case 2:
                    mieszkaniec.wyswietlPlatnosci();
                    break;
                case 3:
                    System.out.print("Podaj opis usterki: ");
                    String opis = scanner.nextLine();
                    mieszkaniec.zglosUsterke(opis);
                    break;
                case 4:
                    System.out.println("Wylogowano.");
                    return;
                default:
                    System.out.println("Nieprawidłowy wybór.");
            }

            System.out.println("---------------------------------");
        }
    }

    private static void dodajMieszkanca(Administrator admin) {
        System.out.print("Podaj imię: ");
        String imie = scanner.nextLine();
        System.out.print("Podaj nazwisko: ");
        String nazwisko = scanner.nextLine();
        System.out.print("Podaj login: ");
        String login = scanner.nextLine();
        System.out.print("Podaj hasło: ");
        String haslo = scanner.nextLine();
        System.out.print("Podaj opłatę miesięczną: ");
        double oplata = scanner.nextDouble();

        admin.dodajMieszkanca(new Mieszkaniec(imie, nazwisko, login, haslo, oplata));
        System.out.println("Dodano mieszkańca.");
    }

    private static void usunMieszkanca(Administrator admin) {
        System.out.print("Podaj login mieszkańca do usunięcia: ");
        String login = scanner.nextLine();
        try {
            admin.usunMieszkanca(login);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
