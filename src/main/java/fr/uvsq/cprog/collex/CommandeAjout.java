package fr.uvsq.cprog.mvnjunit;

public class CommandeAjout implements Commande {
    private Dns dns;
    private String ip;
    private String nom;

    public CommandeAjout(Dns dns, String ip, String nom) {
        this.dns = dns;
        this.ip = ip;
        this.nom = nom;
    }

    @Override
    public String execute() {
        try {
            dns.addItem(new AdresseIP(ip), new NomMachine(nom));
            return "Ajout fait";
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }
}
