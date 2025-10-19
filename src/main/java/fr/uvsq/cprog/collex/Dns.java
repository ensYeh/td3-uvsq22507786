package fr.uvsq.cprog.mvnjunit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dns {
    private final List<DnsItem> items;

    public Dns() {
        items = new ArrayList<>();
        items.add(new DnsItem(new AdresseIP("193.51.31.90"), new NomMachine("www.uvsq.fr")));
        items.add(new DnsItem(new AdresseIP("193.51.31.154"), new NomMachine("poste.uvsq.fr")));
        items.add(new DnsItem(new AdresseIP("193.51.25.12"), new NomMachine("ecampus.uvsq.fr")));
    }

    public DnsItem getItem(AdresseIP ip) {
        for (DnsItem item : items) {
            if (item.getAdresseIP().equals(ip)) {
                return item;
            }
        }
        return null;
    }

    public DnsItem getItem(NomMachine nom) {
        for (DnsItem item : items) {
            if (item.getNomMachine().equals(nom)) {
                return item;
            }
        }
        return null;
    }

    public List<DnsItem> getItems(String domaine) {
        List<DnsItem> result = new ArrayList<>();
        for (DnsItem item : items) {
            if (item.getNomMachine().getNomDomaine().equals(domaine)) {
                result.add(item);
            }
        }
        return result;
    }

    public void addItem(AdresseIP ip, NomMachine nom) throws IllegalArgumentException {
        if (getItem(ip) != null) {
            throw new IllegalArgumentException("adresse IP existant deja !");
        }
        if (getItem(nom) != null) {
            throw new IllegalArgumentException("Nom de machine existante deja !");
        }
        items.add(new DnsItem(ip, nom));
    }

}
