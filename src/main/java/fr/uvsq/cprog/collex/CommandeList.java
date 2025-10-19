package fr.uvsq.cprog.mvnjunit;

import java.util.List;

public class CommandeListe implements Commande {
    private Dns dns;
    private String domaine;
    private boolean triParAdresse;

    public CommandeListe(Dns dns, String domaine, boolean triParAdresse) {
        this.dns = dns;
        this.domaine = domaine;
        this.triParAdresse = triParAdresse;
    }

    @Override
    public String execute() {
        List<DnsItem> items = dns.getItems(domaine);
        if (items.isEmpty()) return "Aucune machine pour ce domaine.";

        items.sort((a, b) -> triParAdresse
                ? a.getAdresseIP().toString().compareTo(b.getAdresseIP().toString())
                : a.getNomMachine().toString().compareTo(b.getNomMachine().toString()));

        StringBuilder sb = new StringBuilder();
        for (DnsItem item : items) {
            sb.append(item.getAdresseIP()).append(" ").append(item.getNomMachine()).append("\n");
        }
        return sb.toString();
    }
}
