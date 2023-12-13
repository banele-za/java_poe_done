
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author BANELE
 */
public class Login {
    
    static StringBuilder taskDescription = new StringBuilder("");
    static StringBuilder nameOfTasks = new StringBuilder("");
    static String nameOfTaskStr;
    static int noOfTasks;
    static String devName;
    static String firstTwoTaskName;
    static String devLastName;
    static int taskDuration;
    static int addTaskDuration;
    static String lastThreeDev;
    static String taskStatus;
    static int taskNumber;
    static String searchTName;
    static String searchDevName;
    static String toDelete;
    
    static String[] arrNameOfTasks;
    static String[] arrTaskID;
    static String[] arrTaskStatus;
    static int[] arrTotalHours;
    static String[] arrDevName;
    
    
    static String[] newArrDoneStatus;
    static String[] newArrDoneDev;
    static int[] newArrDoneDuration;
    
    
     

    
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your first name");
        String firstName=sc.nextLine();
        System.out.println("Enter your last name");
        String lastName=sc.nextLine();
        System.out.println("Enter a username");
        String userName =sc.nextLine();
        while (checkUserName(userName) == false) {
            System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters long");
            userName =sc.nextLine();
            }
        if (checkUserName(userName) == true) {
            System.out.println("Username captured");
        }
        System.out.println("Enter a password");
        String password = sc.nextLine();
        while (checkPasswordComplexity(password) == false) {
            System.out.println("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character");
            password =sc.nextLine();
            }
        if (checkPasswordComplexity(password) == true) {
            System.out.println("Password successfully captured");    
        }
        registerUser(userName, password);
        System.out.println("Enter your created username");
        String realUserName = sc.nextLine();
        System.out.println("Enter your created password");
        String realPass = sc.nextLine();
        while (loginUser(userName, password, realPass, realUserName) == false) {
             System.out.println("You have entered invalid login credentials");
             System.out.println("Enter your created username");
             realUserName = sc.nextLine();
             System.out.println("Enter your created password");
             realPass = sc.nextLine();
            }
        returnLoginStatus(userName, password, firstName, lastName, realPass, realUserName);
        
        
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");
        int choice = Integer.parseInt(JOptionPane.showInputDialog(null, "Select an option\n 1) Add tasks\n 2) Show report\n 3) Quit"));
        while (choice != 3) {
        
        if (choice == 1) {
            Task t = new Task();
            
            noOfTasks = Integer.parseInt(JOptionPane.showInputDialog(null,"How many tasks do you want to add?" ));
            arrNameOfTasks = new String[noOfTasks];
            arrTaskID = new String[noOfTasks];
            arrTaskStatus = new String[noOfTasks];
            arrTotalHours = new int[noOfTasks];
            arrDevName = new String [noOfTasks];
    
            newArrDoneStatus = new String[noOfTasks];
            newArrDoneDev = new String[noOfTasks];
            newArrDoneDuration = new int[noOfTasks];
            
            for (int i = 0; i < noOfTasks; i++ ) {
                
                nameOfTaskStr = (JOptionPane.showInputDialog(null, "Enter the name of the task"));
                arrNameOfTasks[i] = nameOfTaskStr;
                // names of tasks
                
                nameOfTasks.append(nameOfTaskStr);
                firstTwoTaskName = nameOfTaskStr.substring(0 , 2);
                String tDescr = JOptionPane.showInputDialog(null, "Enter a description for the task");
                while (t.checkTaskDescription() == false) {
                    tDescr = JOptionPane.showInputDialog(null, "Enter a description for the task");
                }
                devName = JOptionPane.showInputDialog("Enter your name");
                
                arrDevName[i] = devName;  
                // developer names
                
                devLastName = JOptionPane.showInputDialog("Enter your last name");
                lastThreeDev = devName.substring(devName.length() - 3);
                taskNumber = taskNumber + 1;
                taskDescription.append(tDescr);
                
                addTaskDuration = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the duration of the task in hours"));
                t.returnTotalHours();
                
                arrTotalHours[i] = addTaskDuration;
                //total hours
                
                taskDuration = taskDuration + addTaskDuration;
                int statusChoice = Integer.parseInt(JOptionPane.showInputDialog(null, "Select the status of the task\n 1) To Do\n 2) Doing\n 3) Done"));
                if (statusChoice == 1) {
                   taskStatus = "To Do"; 
                }
                if (statusChoice == 2) {
                    taskStatus = "Doing";
                }
                if (statusChoice == 3) {
                    taskStatus = "Done";
                }
                
                arrTaskStatus[i] = taskStatus;
                //task statuses
                
                t.createTaskID(); // calling the method here because i now have all the information to display
                
                arrTaskID[i] = Task.finaltaskID;
                // task ids
                
                JOptionPane.showMessageDialog(null, t.printTaskDetails());
                nameOfTasks.setLength(0); // emptying the nameOfTasks StringBuilder
                taskDescription.setLength(0); // emptying the taskDescription StringBuilder
            }
            choice = Integer.parseInt(JOptionPane.showInputDialog(null, "Select an option\n 1) Add tasks\n 2) Show report\n 3) Quit"));
               
        }
        if (choice == 2) {
            
            ShowReport s = new ShowReport();
          
            int rChoice = Integer.parseInt(JOptionPane.showInputDialog(null, "Select an option.\n 1) View all tasks with the status of done.\n 2) View the developer and duration of the tasks with the longest duration.\n 3) Search for a task using a task name.\n 4) Search for tasks using a delevoper's name.\n 5) Delete a task.\n 6) View all captured tasks.\n 0) Go back"));
            while (rChoice != 0) {
            if (rChoice == 1) {
                
                s.statusOfDone();
                for (int sd = 0; sd<newArrDoneStatus.length; sd++) {
                    if (newArrDoneDev[sd] != null && newArrDoneStatus[sd] != null && newArrDoneDuration[sd] != 0) {
                    JOptionPane.showMessageDialog(null, "The tasks with the status of done are as follows :\n Task Name: "+newArrDoneStatus[sd]+"\n Developer Name: "+newArrDoneDev[sd]+"\n Task Duration: "+newArrDoneDuration[sd]);
                }
            }
                rChoice = Integer.parseInt(JOptionPane.showInputDialog(null, "Select an option.\n 1) View all tasks with the status of done.\n 2) View the developer and duration of the tasks with the longest duration.\n 3) Search for a task using a task name.\n 4) Search for tasks using a delevoper's name.\n 5) Delete a task.\n 6) View all captured tasks.\n 0) Go back"));
                
            }
            
            
            if (rChoice == 2) {
           
                s.longestDuration();
                for (int ld = 0; ld<arrTotalHours.length; ld++) {
                    if (arrTotalHours[ld] == s.longestDuration()) {
                        JOptionPane.showMessageDialog(null, "The task with the longest duration is\n Task Name: "+arrNameOfTasks[ld]+"\n Developer Name: "+arrDevName[ld]+"\n Task Duration: "+arrTotalHours[ld]);
                    }
                }
                rChoice = Integer.parseInt(JOptionPane.showInputDialog(null, "Select an option.\n 1) View all tasks with the status of done.\n 2) View the developer and duration of the tasks with the longest duration.\n 3) Search for a task using a task name.\n 4) Search for tasks using a delevoper's name.\n 5) Delete a task.\n 6) View all captured tasks.\n 0) Go back"));  
            }
            
            if (rChoice == 3) {
                
                searchTName = JOptionPane.showInputDialog(null, "Enter the name of the task you want");
                s.searchTaskName();
                JOptionPane.showMessageDialog(null, "Your results are as follows\n Task Name: "+arrNameOfTasks[s.pos]+"\n Developer Name: "+arrDevName[s.pos]+"\n Task Duration: "+arrTotalHours[s.pos]);
                rChoice = Integer.parseInt(JOptionPane.showInputDialog(null, "Select an option.\n 1) View all tasks with the status of done.\n 2) View the developer and duration of the tasks with the longest duration.\n 3) Search for a task using a task name.\n 4) Search for tasks using a delevoper's name.\n 5) Delete a task.\n 6) View all captured tasks.\n 0) Go back"));
            }
            
            if (rChoice == 4) {
                
                searchDevName = JOptionPane.showInputDialog(null, "Enter the name of the developer");
                s.searchDeveloper();
                JOptionPane.showMessageDialog(null, "Your results are as follows\n Task Name: "+arrNameOfTasks[s.devPos]+"\n Developer Name: "+arrDevName[s.devPos]+"\n Task Duration: "+arrTotalHours[s.devPos]);
                rChoice = Integer.parseInt(JOptionPane.showInputDialog(null, "Select an option.\n 1) View all tasks with the status of done.\n 2) View the developer and duration of the tasks with the longest duration.\n 3) Search for a task using a task name.\n 4) Search for tasks using a delevoper's name.\n 5) Delete a task.\n 6) View all captured tasks.\n 0) Go back"));
            }
           
            if (rChoice == 5) {
                
                toDelete = JOptionPane.showInputDialog(null, "Enter the name of the task you want to delete");
                s.delete(toDelete);
                arrNameOfTasks = s.afterDeleteTN;
                arrTaskStatus = s.afterDeleteTS;
                arrDevName = s.afterDeleteDN;
                arrTotalHours = s.afterDeleteTD;
                arrTaskID = s.afterDeleteTID;
                JOptionPane.showMessageDialog(null, "Task has been deleted");
                rChoice = Integer.parseInt(JOptionPane.showInputDialog(null, "Select an option.\n 1) View all tasks with the status of done.\n 2) View the developer and duration of the tasks with the longest duration.\n 3) Search for a task using a task name.\n 4) Search for tasks using a delevoper's name.\n 5) Delete a task.\n 6) View all captured tasks.\n 0) Go back"));
            }
            
            if (rChoice == 6) {
                s.fullReport();
                rChoice = Integer.parseInt(JOptionPane.showInputDialog(null, "Select an option.\n 1) View all tasks with the status of done.\n 2) View the developer and duration of the tasks with the longest duration.\n 3) Search for a task using a task name.\n 4) Search for tasks using a delevoper's name.\n 5) Delete a task.\n 6) View all captured tasks.\n 0) Go back"));
            }
            
        }
        choice = Integer.parseInt(JOptionPane.showInputDialog(null, "Select an option\n 1) Add tasks\n 2) Show report\n 3) Quit"));
        }
        }
        
        }
    
    public static boolean checkUserName(String userName) {
        
        boolean underScore=false;
        boolean userNameLength=false;
        boolean userNameCompl = false;
       
        for (int i=0; i<userName.length(); i++) {
        if (userName.length()<=5) {
            userNameLength=true;
           }
        }
        for (int a=0; a<userName.length(); a++) {
            if (userName.charAt(a) == 95) {
                underScore=true;
            }
        }
        if (underScore == true && userNameLength == true) {
            userNameCompl=true;
        }
        while (userNameCompl == false) {
            return false;
            
        }
        if (userNameCompl == true) {
            return true;
        }
        return userNameCompl;
           
    }
    
    public static boolean checkPasswordComplexity(String password) {
        
        boolean capl = false;
        boolean number = false;
        boolean special = false;
        boolean passCombination = false;
        
        
        int passLength = password.length();
                
        for (int c=0; c<password.length(); c++) {
            if (password.charAt(c) >= 65 && password.charAt(c) <= 90){
                        capl=true;
                        }
                    }
        for (int n=0; n<password.length(); n++) {
            if (password.charAt(n)>=48 && password.charAt(n)<=57) {
                         number=true;
                    }
                }
        for (int s=0; s<password.length(); s++) {
            if (password.charAt(s)>=33 && password.charAt(s)<=47 || password.charAt(s)>=58 && password.charAt(s)<=64 || password.charAt(s)>=91 && password.charAt(s)<=96) {
                    special=true;
                    }
                }
                if(capl==true && number==true && special==true && passLength>=8) {
                    passCombination=true;
                }
        while (passCombination == false) {
            return false;
                }
        if (passCombination == true) {
            return true;
                }
        return passCombination;
    }
    
    public static String registerUser(String userName, String password){
        
        String regStatus = null;
        if (checkUserName(userName) == false) {
            regStatus = "Username is incorrectly formatted";
            }
        if (checkPasswordComplexity(password) == false) {
            regStatus = "The password does not meet the complexity requirements";
            }
        if (checkUserName(userName)==true && checkPasswordComplexity(password)==true) {
            regStatus = "Username is correctly formatted, password meets the complexity requirements and user has been successfully registered";
        }
        System.out.println(regStatus);
        return regStatus;
        }
     public static boolean loginUser(String userName,String password, String realPass, String realUserName) {
        
        boolean allMatch = false;
        boolean passMatch = false;
        boolean userMatch = false;
        
        if (realPass.equals(password)) {
            passMatch = true;
            }
        if (realUserName.equals(userName)) {
            userMatch = true;
            }
        if (passMatch == true && userMatch == true) {
            allMatch = true;
        }
        if (allMatch == true) {
            return true;
        }
        if (allMatch == false) {
            return false;
            }
        return allMatch;
    }
    
    public static String returnLoginStatus(String userName, String password, String firstName, String lastName, String realPass, String realUserName) {
        
        String loginStatus;
        if (loginUser(userName, password, realPass, realUserName) == true) {
            loginStatus = "User " + firstName + " " + lastName + " has successfully logged in ";
        }
        else {
            loginStatus = "Your login has failed";
        }
        System.out.println(loginStatus);
        return loginStatus;
        }
    
    
}
