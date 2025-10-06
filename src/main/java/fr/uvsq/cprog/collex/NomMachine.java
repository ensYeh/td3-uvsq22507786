package fr.uvsq.cprog.collex;

public class NomMachine {
    private final String nom;

    public NomMachine(String nom) {
        if (!nom.matches("[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            throw new IllegalArgumentException("Nom machine invalide "+ nom);
        }
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NomMachine)) return false;
        return nom.equals(((NomMachine) o).nom);
    }
}