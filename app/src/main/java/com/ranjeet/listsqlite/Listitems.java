package com.ranjeet.listsqlite;

/**
 * Created by admin on 1/3/2018.
 */

public class Listitems {
  private   String name;
   private String dept;
   private String mobileno;
   private byte [] image;

    public Listitems(String name, String dept, String mobileno, byte[] image) {
        this.name = name;
        this.dept = dept;
        this.mobileno = mobileno;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
