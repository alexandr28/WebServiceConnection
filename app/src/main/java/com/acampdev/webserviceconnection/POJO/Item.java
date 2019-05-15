package com.acampdev.webserviceconnection.POJO;

public class Item {

    private String id;
    private String name;
    private String socialNetwork;
    private String image;

    public  Item(){}

    public Item(String id, String name, String socialNetwork, String image) {
        this.id = id;
        this.name = name;
        this.socialNetwork = socialNetwork;
        this.image=image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSocialNetwork() {
        return socialNetwork;
    }

    public void setSocialNetwork(String socialNetwork) {
        this.socialNetwork = socialNetwork;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
