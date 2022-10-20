package com.example.fragment.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Clase modelo que contiene el dato del usuario y el mensaje que manda
 * Al ser user un objeto se debe implementar la interfaz Serializable y Parcelable en el objeto User
 */
public class Message implements Parcelable {
    public static final String KEY="message";
    private String text;
    private int size;

    protected Message(Parcel in) {
        text = in.readString();
        size = in.readInt();
    }

    public static final Creator<Message> CREATOR = new Creator<Message>() {
        @Override
        public Message createFromParcel(Parcel in) {
            return new Message(in);
        }

        @Override
        public Message[] newArray(int size) {
            return new Message[size];
        }
    };

    public Message(String text, int size) {
        this.text = text;
        this.size = size;
    }
    public Message() { }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(text);
        parcel.writeInt(size);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
