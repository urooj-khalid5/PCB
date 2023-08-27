public class Node {

    static int programCounter = 0;
    int ProgramId = 0;
    int totalInstruction;
    int totalExecuted = -1;
    int arrivalTime = -1; // Initialize with default value
    Node Next;
    int[] Process;
    int startTime = -1; // Initialize with default value
    int endTime = -1;   // Initialize with default value
    int turnaroundTime = -1; // Initialize with default value
    int waitingTime = -1; // Initialize with default value
    int responseTime = -1; // Initialize with default value
    double utilization = -1.0; // Initialize with default value
    int resumeInstruction = 0; // Initialize with default value
    int IR_Val = -1; // Initialize with default value
    

    
    

    public Node(int totalInstructions, int arrivalTime) {
        programCounter++;
        this.totalInstruction = totalInstructions;
        this.arrivalTime = arrivalTime;
        this.ProgramId = programCounter;
        this.Process = new int[totalInstruction];
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public void setTurnaroundTime(int turnaroundTime) {
        this.turnaroundTime = turnaroundTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public void setResponseTime(int responseTime) {
        this.responseTime = responseTime;
    }

    public void setUtilization(double utilization) {
        this.utilization = utilization;
    }

    public void setResumeInstruction(int resumeInstruction) {
        this.resumeInstruction = resumeInstruction;
    }

    public void setIR_Val(int irVal) {
        IR_Val = irVal;
    }


    public int getIR_Val() {
        return IR_Val;
    }
    
  


}
