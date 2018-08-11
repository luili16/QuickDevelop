package com.llx.basemodel.model.entity;

import com.google.gson.annotations.SerializedName;

public class Key {

    @SerializedName("public_key")
    private String publicKey;

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    @Override
    public String toString() {
        return "Key{" +
                "publicKey='" + publicKey + '\'' +
                '}';
    }

}
