package com.example.signuplogin;

public class Bagrut {
    private String id;
    private String moed;
    private String semester;
    private String bagrutFileUrl;
    private String solutionFileUrl;

    public Bagrut() {
        // Firestore needs no-args constructor
    }

    public Bagrut(String moed, String semester, String bagrutFileUrl, String solutionFileUrl) {
        this.moed = moed;
        this.semester = semester;
        this.bagrutFileUrl = bagrutFileUrl;
        this.solutionFileUrl = solutionFileUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Getters and setters
    public String getMoed() { return moed; }
    public String getSemester() { return semester; }
    public String getBagrutFileUrl() { return bagrutFileUrl; }
    public String getSolutionFileUrl() { return solutionFileUrl; }

    public void setMoed(String moed) { this.moed = moed; }
    public void setSemester(String semester) { this.semester = semester; }
    public void setBagrutFileUrl(String bagrutFileUrl) { this.bagrutFileUrl = bagrutFileUrl; }
    public void setSolutionFileUrl(String solutionFileUrl) { this.solutionFileUrl = solutionFileUrl;}
}
