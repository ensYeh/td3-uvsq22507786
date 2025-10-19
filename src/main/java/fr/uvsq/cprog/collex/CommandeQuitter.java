package fr.uvsq.cprog.mvnjunit;

public class CommandeQuitter implements Commande {
    @Override
    public String execute() {
        return "Exited";
    }
}
