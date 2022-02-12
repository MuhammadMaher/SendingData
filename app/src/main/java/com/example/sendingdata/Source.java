
package com.example.sendingdata;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Source {

    @SerializedName("id")
    @Expose
    // لان جميع قيم id تساوي null
    private Object id;
    @SerializedName("name")
    @Expose
    private String name;

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "\nSource{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
