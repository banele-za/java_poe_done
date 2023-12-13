
import javax.swing.JOptionPane;




public class ShowReport {
    int pos=0;
    int devPos=0;
    String[] afterDeleteTN = new String[Login.noOfTasks];
    String[] afterDeleteTS = new String[Login.noOfTasks];
    String[] afterDeleteDN = new String[Login.noOfTasks];
    int[] afterDeleteTD = new int[Login.noOfTasks];
    String[] afterDeleteTID = new String[Login.noOfTasks];
    
    
    
    public void delete(String toDelete) {
        
        int z;
        int x=0;
        for (z=0; z<Login.arrNameOfTasks.length ; z++) {
            if (!toDelete.equalsIgnoreCase(Login.arrNameOfTasks[z])) {
                afterDeleteTN[x] = Login.arrNameOfTasks[z];
                afterDeleteTS[x] = Login.arrTaskStatus[z];
                afterDeleteDN[x] = Login.arrDevName[z];
                afterDeleteTD[x] = Login.arrTotalHours[z];
                afterDeleteTID[x] = Login.arrTaskID[z];
                x++;
            }
        }
        
    }
    
    public void statusOfDone() {
        int d=0;
        for (int e = 0; e<Login.arrTaskStatus.length; e++) {
            if (Login.arrTaskStatus[e].equals("Done")) {
                Login.newArrDoneStatus[d] = Login.arrNameOfTasks[e];
                Login.newArrDoneDev[d] = Login.arrDevName[e];
                Login.newArrDoneDuration[d] = Login.arrTotalHours[e];
                d++;
            }
        }
    }
    
    public int longestDuration() {
        int longest=0;
        for (int g=0; g<Login.arrTotalHours.length; g++) {
            if (Login.arrTotalHours[g] > longest) {
                longest = Login.arrTotalHours[g];   
            }
        }
        return longest;
    }
    
    public int searchTaskName() {
        
        for (int p=0; p<Login.arrNameOfTasks.length; p++) {
            if (Login.searchTName.equalsIgnoreCase(Login.arrNameOfTasks[p])) {
                pos = p;
            }
        }
        return pos;
    }
    
    public int searchDeveloper() {
     
        for (int ds=0; ds<Login.arrDevName.length; ds++ ) {
            if (Login.searchDevName.equalsIgnoreCase(Login.arrDevName[ds])) {
                devPos = ds;
            }
        }
        return devPos;
    }
    
    public void fullReport() {
     
        for(int r=0; r<afterDeleteTN.length; r++) {
            if (Login.arrNameOfTasks[r] != null && Login.arrDevName[r] != null && Login.arrTotalHours[r] != 0 && Login.arrTaskID[r] != null) {
            JOptionPane.showMessageDialog(null, "Full Report of all tasks:\n Task Name: "+Login.arrNameOfTasks[r]+"\n Developer Name: "+Login.arrDevName[r]+"\n Task Duration: "+Login.arrTotalHours[r]+"\n Task ID: "+Login.arrTaskID[r]);
            }
        }
    }

}
