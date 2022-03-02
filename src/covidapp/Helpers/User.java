/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package covidapp;


class User {
    private String cne, prenom,nom, departement,filiere, vac, type_vac,nbr_dose;
    
    public User(String cne,String prenom, String nom,String departement,String filiere, String vac, String type_vac, String nbr_dose){
        this.cne=cne;
        this.prenom=prenom;
        this.nom=nom;
        this.filiere=filiere;
        this.departement=departement;
        this.vac=vac;
        this.type_vac=type_vac;
        this.nbr_dose=nbr_dose;
    }
    
    public String getcne(){
        return cne;
    }
    
    public String getprenom(){
        return prenom;
    }
    
    public String getnom(){
        return nom;
    }
    
    public String getfiliere(){
        return filiere;
    }
    
public String getdepart(){
        return departement;
    }

public String getvac(){
        return vac;
    }

public String gettype_vac(){
        return type_vac;
    }

public String getnbr(){
        return nbr_dose;
    }
}







