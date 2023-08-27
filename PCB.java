import java.util.Scanner;

public class PCB {

    public static void main(String[] args) {
        Scanner myInput = new Scanner(System.in);

        System.out.print("Enter number of processes you want to execute: ");
        int totalProcess = myInput.nextInt();

        System.out.print("Enter your Quantum from 1 till 3: ");
        int Quantum = myInput.nextInt();

        ReadyQueue Queue = new ReadyQueue();
        for (int i = 1; i <= totalProcess; i++) {
            System.out.print("\n\t\tEnter arrival time of Process " + i + ": ");
            int arrivalTime = myInput.nextInt();
            if (i == 1) {
                while (arrivalTime != 0) {
                    System.out.print("\n\t\tFirst process must have arrival time 0. Enter again: ");
                    arrivalTime = myInput.nextInt();
                }
            }

            System.out.print("\n\t\tEnter total instructions of Process " + i + ": ");
            int totalInstruction = myInput.nextInt();

            if (totalInstruction > 10 || totalInstruction < 1) {
                i = i - 1;
                System.out.println("\n\t\tOops, max instruction count can be 10. Please try again.");
                continue;
            }
            Queue.Enqueue(totalInstruction, arrivalTime);
        }

        Processor P = new Processor();
        P.Execution(Quantum, Queue.front, 0, 0);
    }
}