public class screen {

    void Display_Instructions(Node Curr) {
        System.out.println("\t\t=================================");
        System.out.println("\n\t\tThe Values Of Instructions Executed ");
        for (int i = 0; i <= Curr.totalExecuted; i++) {
            System.out.println("\t\t\t" + Curr.Process[i]);
        }
        System.out.println("\n\t\t=================================");
    }

    void Display(Node curr, int Q, int Ir, Node Pc, String state,int nextInstructionIndex,int nextInstructionValue) {
        System.out.println("\n*************************************");
        System.out.println("\n\t\tPCB OF PROCESS: " + (curr.ProgramId));
        System.out.println("\t\t---------------");
        System.out.println("\n\t\tProcess ID: " + "P"+(curr.ProgramId));
        System.out.println("\t\tExecution Time: " + (curr.totalInstruction));
        System.out.println("\t\tArrival Time: " + curr.arrivalTime);
        System.out.println("\t\tTotal Instruction: " + curr.totalInstruction);
        System.out.println("\t\tQuantum: " + Q);
        System.out.println("\t\tAlgorithm: \"Round-Robin\"");
        System.out.println("\t\tState: " + state); // Display State
        if (curr.resumeInstruction != 0) {
            System.out.println("\t\tResume Instruction: " + curr.resumeInstruction);
        } else {
            System.out.println("\t\tResume Instruction: None");
        }
        if (curr.startTime != -1) {
            System.out.println("\t\tStart Time: " + curr.startTime);
        }
        if (curr.endTime != -1) {
            System.out.println("\t\tEnd Time: " + curr.endTime);
        }
        if (curr.turnaroundTime != -1) {
            System.out.println("\t\tTurnaround Time: " + curr.turnaroundTime);
        }
        if (curr.waitingTime != -1) {
            System.out.println("\t\tWaiting Time: " + curr.waitingTime);
        }
        if (curr.responseTime != -1) {
            System.out.println("\t\tResponse Time: " + curr.responseTime);
        }
        if (curr.utilization != -1.0) {
            System.out.println("\t\tUtilization: " + curr.utilization);
        }
        Display_Instructions(curr);
        if (Pc == null) {
            System.out.println("\t\tIR: Index = " + Ir + ", Instruction Value = " + curr.getIR_Val());
            System.out.println("\t\tPC: none");
             
        } else if (Ir != -1 && Pc != null) {
            System.out.println("\t\tIR: Index = " + Ir + ", Instruction Value = " + curr.getIR_Val());
            System.out.println("\t\tPC: " + Pc.ProgramId + ", Next Instruction Index = " + nextInstructionIndex + ", Next Instruction Value = " + nextInstructionValue);
            
        }
    }
}