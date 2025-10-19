package fr.uvsq.cprog.mvnjunit;

public class CommandeNom implements Commande {
    private Dns dns;
    private String ip;

    public CommandeNom(Dns dns, String ip) {
        this.dns = dns;
        this.ip = ip;
    }

    @Override
    public String execute() {
        DnsItem item = dns.getItem(new AdresseIP(ip));
        return (item != null) ? item.getNomMachine().toString() : "Adresse inconnue";
    }
}
