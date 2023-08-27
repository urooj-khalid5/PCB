public class Processor {

    ReadyQueue Queue = new ReadyQueue();
    Screen screen = new Screen();
    int IR;
    Node PC;
    int Quantum;
    int currentTime = 0; // Track the current time

    public void Execution(int Q, Node PC, int instruction, int flag) {
        IR = instruction;
        Node curr = PC;


        boolean isFirstQuantum = true; // Flag to track the first quantum
        int remainingInstructions = curr.totalInstruction - curr.totalExecuted;
        for (int i = 1; i <= Q; i++) {
            if (Check_Deletion(curr) == 1) {
                flag = 1;
                break;
            } else {
                if (isFirstQuantum) {
                    // Set start time when the process starts executing
                    curr.setStartTime(currentTime);
                    isFirstQuantum = false;
                }

                curr.totalExecuted = IR;
                IR = IR + 1;
                
            }
        }
        
        curr.setIR_Val(curr.Process[IR - 1]); // Set IR_Val using the setter method


        int quantumUsed = Math.min(Q, remainingInstructions - 1);

        curr.setEndTime(curr.startTime + quantumUsed);
        int turnaroundTime = curr.endTime - curr.arrivalTime;
        curr.setTurnaroundTime(turnaroundTime);
        int waitingTime = curr.turnaroundTime - curr.totalInstruction; // Waiting time calculation corrected
        curr.setWaitingTime(waitingTime);
        // Calculate Response Time
        int responseTime = curr.totalInstruction - curr.startTime;
        curr.setResponseTime(responseTime);

        // Calculate Utilization
        double utilization = (double) curr.totalExecuted / curr.totalInstruction;
        curr.setUtilization(utilization);

        if (Check_Deletion(curr) == 1) {
            flag = 1;
        }

        currentTime = curr.endTime; // Update current time

        PC = ProcessSwitch(curr);
        String state = Check_Deletion(curr) == 1 ? "Completed" : "Running"; // Determine State
        if (state == "Running") {
            int resumeInstructionValue = curr.Process[IR]; // Get the actual instruction value at IR+1
            curr.setResumeInstruction(resumeInstructionValue); // Set resume instruction
        } else {
            curr.setResumeInstruction(0);
        }
        Node nextProcess = ProcessSwitch(curr);
        int nextInstructionIndex = 0; // Default value when nextProcess is null
        int nextInstructionValue = -1; // Default value when nextProcess is null
        if (nextProcess != null) {
            nextInstructionIndex = (nextProcess.totalExecuted + 1) % nextProcess.totalInstruction;
            nextInstructionValue = nextProcess.Process[nextInstructionIndex];
        }
        screen.Display(curr, Q, IR, PC, state,nextInstructionIndex, nextInstructionValue);
        
        
        
        
        Set_IR(PC);
        if (flag == 1) {
            Queue.Remove(ReadyQueue.front, curr);

        }

        if (PC != null) {
            currentTime = curr.endTime; // Set current time to the end time of the current process
            Execution(Q, PC, IR, 0);
        } else {
            return;
        }
    }

    int Check_Deletion(Node curr) {
        if (curr.totalInstruction - 1 == curr.totalExecuted) {
            return 1;
        } else {
            return 0;
        }
    }

    Node ProcessSwitch(Node curr) {
        if (ReadyQueue.front == ReadyQueue.rear
                && ReadyQueue.front.totalExecuted == ReadyQueue.front.totalInstruction - 1) {
            return null;
        } else if (curr == ReadyQueue.rear) {
            return ReadyQueue.front;}
        else {
            return curr.Next;
        }
    }

    void Set_IR(Node curr) {
        if (curr == null) {
            IR = Queue.front.totalExecuted - 1;
        } else {
            IR = curr.totalExecuted + 1;
        }
    }
}