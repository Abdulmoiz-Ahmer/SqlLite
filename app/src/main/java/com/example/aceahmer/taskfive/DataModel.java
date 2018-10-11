package com.example.aceahmer.taskfive;

import android.os.Parcel;
import android.os.Parcelable;

public class DataModel implements Parcelable {

    int id=-1;
    int age=-1;
    String Aboutme;
    String firstName;
    String secondName;
    String Occupation;

    public DataModel() {
    }

    public DataModel(int id, String firstName ,String secondName, String occupation,int age, String aboutme) {
        this.id = id;
        this.age = age;
        Aboutme = aboutme;
        this.firstName = firstName;
        this.secondName = secondName;
        Occupation = occupation;
    }

    protected DataModel(Parcel in) {
        id = in.readInt();
        age = in.readInt();
        Aboutme = in.readString();
        firstName = in.readString();
        secondName = in.readString();
        Occupation = in.readString();
    }

    public static final Creator<DataModel> CREATOR = new Creator<DataModel>() {
        @Override
        public DataModel createFromParcel(Parcel in) {
            return new DataModel(in);
        }

        @Override
        public DataModel[] newArray(int size) {
            return new DataModel[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAboutme() {
        return Aboutme;
    }

    public void setAboutme(String aboutme) {
        Aboutme = aboutme;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getOccupation() {
        return Occupation;
    }

    public void setOccupation(String occupation) {
        Occupation = occupation;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeInt(age);
        parcel.writeString(Aboutme);
        parcel.writeString(firstName);
        parcel.writeString(secondName);
        parcel.writeString(Occupation);
    }
}
