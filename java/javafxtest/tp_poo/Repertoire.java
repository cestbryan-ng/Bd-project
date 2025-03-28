package javafxtest.tp_poo;

import java.util.List;

public class Repertoire {
    public List<Contact> liste_de_contact;

    public Repertoire() {}

    public Repertoire(List<Contact> liste_de_contact) {
        this.liste_de_contact = liste_de_contact;
    }

    public void setListe_de_contact(List<Contact> liste_de_contact) {
        this.liste_de_contact = liste_de_contact;
    }

    public List<Contact> getListe_de_contact() {
        return this.liste_de_contact;
    }

    public void ajouterContact(Contact contact_a_ajouter) {
        liste_de_contact.add(contact_a_ajouter);
    }

    public void supprimerContact(Contact contact_a_supprimer) {
        if (rechercherContact(contact_a_supprimer)) {
            liste_de_contact.remove(contact_a_supprimer);
        } else {
            System.out.println("Contact non présent dans la liste");
        }
    }

    public void modifierContact(Contact contact_de_la_liste, Contact nouveau_contact) {
        if (rechercherContact(contact_de_la_liste)) {
            liste_de_contact.set(liste_de_contact.indexOf(contact_de_la_liste), nouveau_contact);
        } else {
            System.out.println("Impossible de modifier car l'élément n'est pas présent");
        }
    }

    public boolean rechercherContact(Contact contact_a_rechercher) {
        if (liste_de_contact.contains(contact_a_rechercher)) {
            return true;
        }
        else {
            return false;
        }
    }

}
