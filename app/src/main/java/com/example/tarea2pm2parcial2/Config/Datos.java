package com.example.tarea2pm2parcial2.Config;

public class Datos {
    private String id;
    private String subId;
    private String title;
    private String body;

    public Datos() {
    }

    public Datos(String id, String subId, String title, String body) {
        this.id = id;
        this.subId = subId;
        this.title = title;
        this.body = body;
    }

    public Datos(String id, String subId) {
        this.id = id;
        this.subId = subId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubId() {
        return subId;
    }

    public void setSubId(String subId) {
        this.subId = subId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
