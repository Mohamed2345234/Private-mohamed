import java.util.ArrayList;
import java.util.Scanner;

interface Notificatie{
    void sendNotification(String messege);
}
abstract class Account implements Notificatie{
    String voorNaam;
    String achterNaam;
    int leeftijd;

    public String getVoorNaam() {
        return voorNaam;
    }

    public String getAchterNaam() {
        return achterNaam;
    }

    public int getLeeftijd() {
        return leeftijd;
    }

    public Account(String voorNaam, String achterNaam, int leeftijd){
        this.voorNaam = voorNaam;
        this.achterNaam = achterNaam;
        this.leeftijd = leeftijd;

    }
}
class Ouder extends Account{
    public Ouder(String voorNaam, String achterNaam, int leeftijd) {
        super(voorNaam, achterNaam, leeftijd);
    }

    @Override
    public void sendNotification(String messege) {

    }
    public String getVoorNaam() {
        return voorNaam;
    }

    public String getAchterNaam() {
        return achterNaam;
    }
    public int getLeeftijd() {
        return leeftijd;
    }
    public void accepteerOfWeigerRedenVanKind(boolean isRedenRelevant, boolean gaatOverSchool, boolean gaatOverBijbaan, boolean redenGeaccepteerd){
        if (redenGeaccepteerd){
            if (isRedenRelevant && (gaatOverBijbaan || gaatOverSchool)){
                System.out.println("Reden is relevant en gaat om school of bijbaan of beide");
            }
        }else {
            System.out.println("De reden is niet geaccepteerd");
        }
    }
}
class Kind extends Account{
    public Kind(String voorNaam, String achterNaam, int leeftijd){
        super(voorNaam,achterNaam,leeftijd);
    }

    @Override
    public void sendNotification(String messege) {

    }
    public String getVoorNaam() {
        return voorNaam;
    }

    public String getAchterNaam() {
        return achterNaam;
    }
    public int getLeeftijd() {
        return leeftijd;
    }
}

class Taak{
    String naam;
    String beschrijving;
    String instructie;
    Account account;
    public Taak(String naam, String beschrijving, String instructie ){
        this.naam = naam;
        this.beschrijving = beschrijving;
        this.instructie = instructie;
    }
    public void takenUitdelen(ArrayList<Account> accounts){
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < accounts.size();){
            System.out.println(i + ". " + accounts.get(i).voorNaam);
            i++;
        }
        System.out.println("Voer in de naam van het Kind die uw een taak wilt geven");
        String naam= scanner.nextLine();
        Account assignedAccount = null;
        for(Account account : accounts){
            if (account.voorNaam.equalsIgnoreCase(naam)){
                assignedAccount = account;
                break;
            }
        }
        if(assignedAccount != null){
            System.out.println("Voer de naam in");
            String taak = scanner.nextLine();
            System.out.println("De taak: " + taak + " is verwezen naar: " + assignedAccount.voorNaam + ".");
        }else {
            System.out.println("Accoutn niet gevonden");
        }
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public void setInstructie(String instructie) {
        this.instructie = instructie;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getNaam() {
        return naam;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public String getInstructie() {
        return instructie;
    }

    public Account getAccount() {
        return account;
    }
}

class Main {
    public static void main(String [] args) {
        ArrayList<Taak> taken = new ArrayList<>();
        ArrayList<Account> accounts = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welkom in Task Divider");
        System.out.println("Kies de volgende opties hier onder");
        System.out.println();

        Ouder moeder = new Ouder("Hanan", "Mahamud", 47);
        Kind mohamed = new Kind("Mohamed", "Nabil", 22);
        Kind fathiya = new Kind("Fathiya", "Nabil", 20);
        Kind ahmed = new Kind("Ahmed", "Nabil", 17);
        Kind maaida = new Kind("Maaida", "Nabil", 15);
        Kind mustafa = new Kind("Mustafa", "Nabil", 11);
        accounts.add(mohamed);
        accounts.add(fathiya);
        accounts.add(ahmed);
        accounts.add(maaida);
        accounts.add(mustafa);

        Taak taak1 = new Taak("Stofzuigen", "De woonkamer Stofzuigen", "Zorg ook dat je de achter de bank stofzuigd");
        Taak taak2 = new Taak("toiletten schoonmaken", "De boven toilte schoonmaken", "Vergeet niet de douche ook schoon te maken");
        Taak taak3 = new Taak("Afwassen", "De borden die in het gootsteen", "Er liggen ook borden boven vergeet die ook niet");
        Taak taak4 = new Taak("De trap", "De trappen stofzuigen", "niet leuningen vergeten af te vegen");
        Taak taak5 = new Taak("dweilen", "De boven kamer dweilen", "Zorg dat je niet te veel middelen gebruikt en gebruik warm water");
        taken.add(taak1);
        taken.add(taak2);
        taken.add(taak3);
        taken.add(taak4);
        taken.add(taak5);

        System.out.println("Kies 1: voor weergaven van accounts");
        System.out.println("Kies 2: voor weergaven van taken");
        System.out.println("Kies 3: voor beide lijsten" );
        String optie = scanner.nextLine();
        if (optie.equalsIgnoreCase("1")) {
            for (Account account : accounts) {
                System.out.println("Voornaam: " + account.getVoorNaam());
                System.out.println("Achternaam: " + account.getAchterNaam());
                System.out.println("Leeftijd: " + account.getLeeftijd());
                System.out.println();
            }
        } else if (optie.equalsIgnoreCase("2")) {
            for (Taak taak : taken) {
                System.out.println("Taak: " + taak.getNaam());
                System.out.println("beschrijving: " + taak.getBeschrijving());
                System.out.println("Instructies: " + taak.getInstructie());
                System.out.println();
            }
        } else if (optie.equalsIgnoreCase("3")) {
            System.out.println("Account");
            for (Account account : accounts) {
                System.out.println("Voornaam: " + account.getVoorNaam());
                System.out.println("Achternaam: " + account.getAchterNaam());
                System.out.println("Leeftijd: " + account.getLeeftijd());
                System.out.println();
            }
            System.out.println("Taken");
            for (Taak taak : taken) {
                System.out.println("Taak: " + taak.getNaam());
                System.out.println("beschrijving: " + taak.getBeschrijving());
                System.out.println("Instructies: " + taak.getInstructie());
                System.out.println();
            }
        } else {
            System.out.println("ongeldige optie");
            System.out.println("Kies 1: voor lijst van account");
            System.out.println("Kies 2: voor lijst van taken");
            System.out.println("Kies 3: voor beide lijsten");
            while (optie != "1" + "2" + "3"){
                optie = scanner.nextLine();


            }
        }
        moeder.accepteerOfWeigerRedenVanKind(true, true, true , true);
        moeder.accepteerOfWeigerRedenVanKind(true, true, true , false);
        moeder.accepteerOfWeigerRedenVanKind(true, true, false , true);
        moeder.accepteerOfWeigerRedenVanKind(false, false, true , true);
        moeder.accepteerOfWeigerRedenVanKind(false, false, false , true);
        moeder.accepteerOfWeigerRedenVanKind(false, false, false , false);
    }
}