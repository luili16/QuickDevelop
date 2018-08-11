package com.llx.basemodel.model.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "user", primaryKeys = "uid")
public class User {

    private String uid;

    private String email;

    @ColumnInfo(name = "nick_name")
    @SerializedName("nick_name")
    private String nickName;

    @ColumnInfo(name = "user_head")
    @SerializedName("user_head")
    private String userHead;

    @ColumnInfo(name = "session_id")
    @SerializedName("session_id")
    private String sessionId;

    @SerializedName("token")
    private String token;

    public @NonNull
    String getUid() {
        return uid;
    }

    public void setUid(@NonNull String uid) {
        this.uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserHead() {
        return userHead;
    }

    public void setUserHead(String userHead) {
        this.userHead = userHead;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", email='" + email + '\'' +
                ", nickName='" + nickName + '\'' +
                ", userHead='" + userHead + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", token='" + token + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!uid.equals(user.uid)) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (nickName != null ? !nickName.equals(user.nickName) : user.nickName != null)
            return false;
        if (userHead != null ? !userHead.equals(user.userHead) : user.userHead != null)
            return false;
        if (sessionId != null ? !sessionId.equals(user.sessionId) : user.sessionId != null)
            return false;
        return token != null ? token.equals(user.token) : user.token == null;
    }

    @Override
    public int hashCode() {
        int result = uid.hashCode();
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (nickName != null ? nickName.hashCode() : 0);
        result = 31 * result + (userHead != null ? userHead.hashCode() : 0);
        result = 31 * result + (sessionId != null ? sessionId.hashCode() : 0);
        result = 31 * result + (token != null ? token.hashCode() : 0);
        return result;
    }
}
