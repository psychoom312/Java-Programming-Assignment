class University {
    private String uniName = "Global Tech University";

    class Department {
        void display() {
            System.out.println("Member Inner Class: Dept of " + uniName);
        }
    }

    void createExam() {
        class Schedule {
            void print() {
                System.out.println("Local Inner Class: Exam scheduled for Monday.");
            }
        }
        Schedule s = new Schedule();
        s.print();
    }
}

interface Notification {
    void send();
}

public class InnerClassDemo {
    public static void main(String[] args) {
        University myUni = new University();
        University.Department dept = myUni.new Department();
        dept.display();

        myUni.createExam();

        Notification note = new Notification() {
            @Override
            public void send() {
                System.out.println("Anonymous Inner Class: Notification Sent!");
            }
        };
        note.send();
    }
}
