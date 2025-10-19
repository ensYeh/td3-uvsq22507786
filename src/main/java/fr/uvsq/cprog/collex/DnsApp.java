package fr.uvsq.cprog.mvnjunit;

public class DnsApp {
    public static void main(String[] args) {
        Dns dns = new Dns();
        DnsTUI tui = new DnsTUI(dns);

        while (true) {
            Commande cmd = tui.nextCommande();
            if (cmd == null) {
                tui.affiche("Commande invalide");
                continue;
            }

            String result = cmd.execute();
            tui.affiche(result);

            if (cmd instanceof CommandeQuitter) break;
        }
    }
}
