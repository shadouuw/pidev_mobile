/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author asus
 */
public class Scores {
    int id,id_jeux,score,rank;
    String id_user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_jeux() {
        return id_jeux;
    }

    public void setId_jeux(int id_jeux) {
        this.id_jeux = id_jeux;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    
    
    
    public Scores() {
    }

    public Scores(int id,int id_jeux, String id_user, int score) {
this.id=id;
        this.id_jeux = id_jeux;
        this.id_user = id_user;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Scores{" + "id=" + id + ", id_jeux=" + id_jeux + ", id_user=" + id_user + ", score=" + score + '}';
    }
    
}
