package fr.uvsq.cprog.collex;

public class AdresseIP {
    private final String adresse;

    public AdresseIP(String adresse) {
        if (!adresse.matches("\\d+\\.\\d+\\.\\d+\\.\\d+")) {
            throw new IllegalArgumentException("format adresse invalide " + adresse);
        }
        this.adresse = adresse;
    }

    public String getAdresse() {
        return adresse;
    }

    @Override
    public String toString() {
        return adresse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AdresseIP)) return false;
        return adresse.equals(((AdresseIP) o).adresse);
    }
}
