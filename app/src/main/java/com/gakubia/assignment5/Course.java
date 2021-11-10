package com.gakubia.assignment5;

public class Course {
     String IDno, Course1, Course2, Course3, Course4, Course5,Course6, Course7;

    public Course() {
    }

    public Course(String IDno, String course1, String course2, String course3, String course4, String course5, String course6, String course7) {
        this.IDno = IDno;
        this.Course1 = course1;
        this.Course2 = course2;
        this.Course3 = course3;
        this.Course4 = course4;
        this.Course5 = course5;
        this.Course6= course6;
        this.Course7= course7;
    }

    public String getIDno() {
        return IDno;
    }

    public void setIDno(String IDno) {
        this.IDno = IDno;
    }

    public String getCourse1() {
        return Course1;
    }

    public void setCourse1(String course1) {
        Course1 = course1;
    }

    public String getCourse2() {
        return Course2;
    }

    public void setCourse2(String course2) {
        Course2 = course2;
    }

    public String getCourse3() {
        return Course3;
    }

    public void setCourse3(String course3) {
        Course3 = course3;
    }

    public String getCourse4() {
        return Course4;
    }

    public void setCourse4(String course4) {
        Course4 = course4;
    }

    public String getCourse5() {
        return Course5;
    }

    public void setCourse5(String course5) {
        Course5 = course5;
    }

    public String getCourse6() {
        return Course6;
    }

    public void setCourse6(String course6) {
        Course6 = course6;
    }

    public String getCourse7() {
        return Course7;
    }

    public void setCourse7(String course7) {
        Course5 = course7;
    }
}
