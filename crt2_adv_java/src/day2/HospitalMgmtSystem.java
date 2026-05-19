package day2;

import java.util.ArrayList;

// ABSTRACT CLASS
abstract class Staff {
    protected int id;
    protected String name;
    protected String department;

    public Staff(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    abstract void showDetails();
}

// INHERITANCE
class Doctor extends Staff {

    String specialization;

    public Doctor(int id, String name, String department, String specialization) {
        super(id, name, department);
        this.specialization = specialization;
    }

    // METHOD OVERRIDING
    @Override
    void showDetails() {
        System.out.println("Doctor ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Specialization: " + specialization);
    }

    void presMed(String medicine) {
        System.out.println("Medicine Prescribed: " + medicine);
    }
}

class Intern extends Doctor {
    int duration;
    public Intern(int id, String name, String department,
                  String specialization, int duration) {

        super(id, name, department, specialization);
        this.duration = duration;
    }

    @Override
    void showDetails() {
        System.out.println("Intern Doctor");
        super.showDetails();
        System.out.println("Internship Duration: " + duration + " months");
    }
}

class Patient {

    int patientId;
    String patientName;
    int age;
    ArrayList<String> diseases = new ArrayList<>();

    Doctor assignedDoctor;
    String assignedNurse;
    String ward;
    int bedNo;

    public Patient(int patientId, String patientName, int age) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.age = age;
    }

    void admission() {
        System.out.println(patientName + " admitted successfully.");
    }

    void discharge() {
        System.out.println(patientName + " discharged successfully.");
    }

    void addDisease(String disease) {
        diseases.add(disease);
        System.out.println("Disease Added: " + disease);
    }

    void assignDoc(Doctor doc) {
        assignedDoctor = doc;
        System.out.println("Doctor Assigned: " + doc.name);
    }

    void assignNurse(String nurseName) {
        assignedNurse = nurseName;
        System.out.println("Nurse Assigned: " + nurseName);
    }

    void assignWard(String ward) {
        this.ward = ward;
        System.out.println("Ward Assigned: " + ward);
    }

    void assignBed(int bedNo) {
        this.bedNo = bedNo;
        System.out.println("Bed Assigned: " + bedNo);
    }

    // METHOD OVERLOADING
    void calcBill(int roomCharge) {
        System.out.println("Total Bill: " + roomCharge);
    }

    void calcBill(int roomCharge, int medicineCharge) {
        int total = roomCharge + medicineCharge;
        System.out.println("Total Bill: " + total);
    }

    void showPatient() {
        System.out.println("\nPatient Details");
        System.out.println("ID: " + patientId);
        System.out.println("Name: " + patientName);
        System.out.println("Age: " + age);
        System.out.println("Diseases: " + diseases);
    }
}

class Case {

    int caseId;
    String status;

    public Case(int caseId) {
        this.caseId = caseId;
        status = "Open";
    }

    void optCase() {
        status = "Operational";
        System.out.println("Case is now Operational.");
    }

    void closeCase() {
        status = "Closed";
        System.out.println("Case Closed.");
    }

    void showCase() {
        System.out.println("Case ID: " + caseId);
        System.out.println("Status: " + status);
    }
}

// MAIN CLASS
public class HospitalMgmtSystem {

    public static void main(String[] args) {

        // ARRAYLIST
        ArrayList<Patient> patientList = new ArrayList<>();

        Doctor d1 = new Doctor(101, "Dr. Sharma", "Cardiology", "Heart Specialist");
        Intern i1 = new Intern(102, "Rahul", "General", "Junior Doctor", 6);
        Patient p1 = new Patient(1, "Aman", 22);

        patientList.add(p1);

        p1.admission();

        p1.addDisease("Fever");
        p1.addDisease("Cold");

        p1.assignDoc(d1);
        p1.assignNurse("Sister Mary");
        p1.assignWard("Ward-A");
        p1.assignBed(12);

        d1.presMed("Paracetamol");

        p1.calcBill(5000);
        p1.calcBill(5000, 1500);

        p1.showPatient();
        d1.showDetails();
        i1.showDetails();

        Case c1 = new Case(501);
        c1.optCase();
        c1.showCase();
        c1.closeCase();
        p1.discharge();
    }
}

