/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model_class;

/**
 *
 * @author farzana
 */
public class Registration_info {
        private String studentName;
        private String studentId;
        private String department;
        private String section;
        private String batch;
        private String email;
        private String userName;
        private String password;
        private String position;
        
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

        public String getStudentName() {
        return studentName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
        
    public void setDepartment(String department){
    this.department=department;
    }
    public String getDepartment(){
    return department;
    }    
    
    
}
