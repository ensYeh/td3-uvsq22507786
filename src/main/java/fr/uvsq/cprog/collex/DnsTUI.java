package fr.uvsq.cprog.mvnjunit;

import java.util.Scanner;

public class DnsTUI {
    private Dns dns;
    private Scanner scanner;

    public DnsTUI(Dns dns) {
        this.dns = dns;
        this.scanner = new Scanner(System.in);
    }

    public Commande nextCommande() {
        System.out.print("> ");
        String input = scanner.nextLine().trim();

        if (input.equals("exit") || input.equals("quit")) {
            return new CommandeQuitter();
        }
        else if (input.startsWith("add ")) {
            String[] parts = input.split("\\s+");
            if (parts.length == 3) {
                return new CommandeAjout(dns, parts[1], parts[2]);
            }
        }
        else if (input.startsWith("ls ")) {
            boolean triParAdresse = input.contains("-a");
            String[] parts = input.replace("-a", "").trim().split("\\s+");
            if (parts.length == 2) {
                return new CommandeListe(dns, parts[1], triParAdresse);
            }
        }
        else if (input.matches("\\d+\\.\\d+\\.\\d+\\.\\d+")) {
            return new CommandeNom(dns, input);
        }
        else if (input.contains(".")) {
            return new CommandeAdresse(dns, input);
        }

        return null;
    }

    public void affiche(String resultat) {
        System.out.println(resultat);
    }
}
