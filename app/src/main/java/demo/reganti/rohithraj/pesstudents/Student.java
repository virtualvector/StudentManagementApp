package demo.reganti.rohithraj.pesstudents;

import java.io.Serializable;

/**
 * Created by vector on 25/8/17.
 */


//NAME,USN,MAT,CHEM,PCD,CAD,ELN,PLAB,CLAB,SGPA
public class Student implements Serializable {


    private String name;
    private String usn;
    private double mat;
    private double chem;
    private double pcd, cad,eln,plab,clab,sgpa;

    public void setName(String name) {
        this.name = name;
    }

    public void setUsn(String usn) {
        this.usn = usn;
    }

    public void setMat(double mat) {
        this.mat = mat;
    }

    public void setChem(double chem) {
        this.chem = chem;
    }

    public void setPcd(double pcd) {
        this.pcd = pcd;
    }

    public void setCad(double cad) {
        this.cad = cad;
    }

    public void setEln(double eln) {
        this.eln = eln;
    }

    public void setPlab(double plab) {
        this.plab = plab;
    }

    public void setClab(double clab) {
        this.clab = clab;
    }

    public void setSgpa(double sgpa) {
        this.sgpa = sgpa;
    }

    public String getName() {
        return name;
    }

    public String getUsn() {
        return usn;
    }

    public double getMat() {
        return mat;
    }

    public double getChem() {
        return chem;
    }

    public double getPcd() {
        return pcd;
    }

    public double getCad() {
        return cad;
    }

    public double getEln() {
        return eln;
    }

    public double getPlab() {
        return plab;
    }

    public double getClab() {
        return clab;
    }

    public double getSgpa() {
        return sgpa;
    }
}
