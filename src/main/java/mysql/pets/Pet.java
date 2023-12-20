package mysql.pets;

import java.io.Serializable;

public class Pet implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String petKid;
    private String petName;
    private int petAge;
    private String petColor;
    private String petOwner;

    public Pet() {
    }

    public Pet(String petKid, String petName, int petAge, String petColor, String petOwner) {
        this.petKid = petKid;
        this.petName = petName;
        this.petAge = petAge;
        this.petColor = petColor;
        this.petOwner = petOwner;
    }

    public Pet(int id, String petKid, String petName, int petAge, String petColor, String petOwner) {
        this.id = id;
        this.petKid = petKid;
        this.petName = petName;
        this.petAge = petAge;
        this.petColor = petColor;
        this.petOwner = petOwner;
    }

    public int getId() {
        return id;
    }

    public String getPetKid() {
        return petKid;
    }

    public String getPetName() {
        return petName;
    }

    public int getPetAge() {
        return petAge;
    }

    public String getPetColor() {
        return petColor;
    }

    public String getPetOwner() {
        return petOwner;
    }

}
