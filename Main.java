import java.util.Scanner;

class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        StudentDAO dao = new StudentDAO();
        MarksDAO marksDao = new MarksDAO();

        while(true)
        {
            System.out.println("\n================================");
            System.out.println("          EDUTRACK");
            System.out.println("   Student Management System");
            System.out.println("================================");

            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
           System.out.println("6. Add Marks");
System.out.println("7. View Result");
System.out.println("8. Update Marks");
System.out.println("9. Delete Marks");
System.out.println("10. Exit");

            System.out.print("\nEnter your choice: ");

            int choice = sc.nextInt();

            if(choice == 1)
            {
                System.out.println("\n--- Add Student ---");

                System.out.print("Enter ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Email: ");
                String email = sc.nextLine();

                System.out.print("Enter Phone: ");
                String phone = sc.nextLine();

                System.out.print("Enter Course: ");
                String course = sc.nextLine();

                System.out.print("Enter Year: ");
                int year = sc.nextInt();

                Student s = new Student(
                    id, name, email, phone, course, year
                );

                dao.addStudent(s);
            }

            else if(choice == 2)
            {
                System.out.println("\n--- Student List ---");

                dao.viewStudents();
            }

            else if(choice == 3)
            {
                System.out.println("\n--- Search Student ---");

                System.out.print("Enter Student ID: ");
                int id = sc.nextInt();

                dao.searchStudent(id);
            }

            else if(choice == 4)
            {
                System.out.println("\n--- Update Student ---");

                System.out.print("Enter Student ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter New Name: ");
                String name = sc.nextLine();

                System.out.print("Enter New Email: ");
                String email = sc.nextLine();

                System.out.print("Enter New Phone: ");
                String phone = sc.nextLine();

                System.out.print("Enter New Course: ");
                String course = sc.nextLine();

                System.out.print("Enter New Year: ");
                int year = sc.nextInt();

                Student s = new Student(
                    id, name, email, phone, course, year
                );

                dao.updateStudent(s);
            }

            else if(choice == 5)
            {
                System.out.println("\n--- Delete Student ---");

                System.out.print("Enter Student ID: ");
                int id = sc.nextInt();

                dao.deleteStudent(id);
            }
           
else if(choice == 6)
{
    System.out.println("\n--- Add Marks ---");

    System.out.print("Enter Student ID: ");
    int studentId = sc.nextInt();
    sc.nextLine();

    System.out.print("Enter Subject: ");
    String subject = sc.nextLine();

   System.out.print("Enter Marks: ");
int marks = sc.nextInt();

if(marks < 0 || marks > 100)
{
    System.out.println("Invalid marks! Please enter marks between 0 and 100.");
}
else
{
    Marks m = new Marks(studentId, subject, marks);

    marksDao.addMarks(m);
}
}

else if(choice == 7)
{
    System.out.println("\n--- View Result ---");

    System.out.print("Enter Student ID: ");
    int studentId = sc.nextInt();

    marksDao.viewResult(studentId);
}
else if(choice == 8)
{
    System.out.println("\n--- Update Marks ---");

    System.out.print("Enter Student ID: ");
    int studentId = sc.nextInt();
    sc.nextLine();

    System.out.print("Enter Subject: ");
    String subject = sc.nextLine();

    System.out.print("Enter New Marks: ");
    int newMarks = sc.nextInt();

    if(newMarks < 0 || newMarks > 100)
    {
        System.out.println(
            "Invalid marks! Please enter marks between 0 and 100."
        );
    }
    else
    {
        marksDao.updateMarks(studentId, subject, newMarks);
    }
}
else if(choice == 9)
{
    System.out.println("\n--- Delete Marks ---");

    System.out.print("Enter Student ID: ");
    int studentId = sc.nextInt();
    sc.nextLine();

    System.out.print("Enter Subject: ");
    String subject = sc.nextLine();

    marksDao.deleteMarks(studentId, subject);
}
            else if(choice == 10)
            {
                System.out.println("\nThank you for using EduTrack!");
                break;
            }

            else
            {
                System.out.println("\nInvalid choice!");
            }
        }

        sc.close();
    }
}