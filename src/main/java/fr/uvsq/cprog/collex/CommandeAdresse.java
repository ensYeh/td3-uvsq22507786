package fr.uvsq.cprog.mvnjunit;

public class CommandeAdresse implements Commande {
    private Dns dns;
    private String nom;

    public CommandeAdresse(Dns dns, String nom) {
        this.dns = dns;
        this.nom = nom;
    }

    @Override
    public String execute() {
        DnsItem item = dns.getItem(new NomMachine(nom));
        return (item != null) ? item.getAdresseIP().toString() : "Nom machine inconnu";
    }
}
