
public class Task {
    static String finaltaskID;
    static int totalHours;
    
    public boolean checkTaskDescription() {
        
        boolean descriptionLength = false;
        if (Login.taskDescription.length() <= 70) {
            descriptionLength = true;
        }
        
        return descriptionLength;
    }

    public String createTaskID() {
        StringBuilder taskIDsb = new StringBuilder();
        taskIDsb.append(Login.firstTwoTaskName);
        taskIDsb.append(":");
        taskIDsb.append(Login.taskNumber);
        taskIDsb.append(":");
        taskIDsb.append(Login.lastThreeDev);
        String taskID = taskIDsb.toString();
        finaltaskID = taskID.toUpperCase();
        
        return finaltaskID;
        
    }
    
    public String printTaskDetails() {
        
        String taskDetails = ("Task Details\nTask Status:   "+Login.taskStatus+"\nDeveloper Details:   "+Login.devName+" "+Login.devLastName+"\nTask Number:   "+Login.taskNumber+"\nTask Name:   "+Login.nameOfTasks+"\nTask Description:   "+Login.taskDescription+"\nTask ID:   "+finaltaskID+"\nTask Duration:   "+Login.addTaskDuration+" hours\nTotal Duration of Tasks:   "+totalHours+" hours");
        
        return taskDetails;
    }
    
    public int returnTotalHours() {
        
        totalHours = Login.taskDuration + Login.addTaskDuration;
        
        return totalHours;
    }
    
    
    
}

    
