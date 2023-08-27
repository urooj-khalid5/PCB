import java.util.Scanner;

public class ReadyQueue {

    public static Node front = null;
    public static Node rear = null;

    public void Enqueue(int totalInstruction, int arrivalTime) {
        Node newNode = new Node(totalInstruction, arrivalTime);
        Get_Instructions(newNode);
        if (front == null)
            front = newNode;
        else
            rear.Next = newNode;
        rear = newNode;
        rear.Next = front;
    }

  public Node Remove(Node curr, Node todelete) {
    if (curr == todelete) {
      Node temp = curr;
      if (front == rear) {
        rear = null;
        front = null;
        curr = null;
      } else if (curr == rear) {
        curr = curr.Next;
        rear = curr;
      } else if (front != rear) {
        curr = curr.Next;
        if (temp == front) {
          front = curr;
          rear.Next = front;
        }
      }
      return curr;
    } else
      curr.Next = Remove(curr.Next, todelete);
    return curr;
  }

  void Get_Instructions(Node Curr) {
    System.out.println("\n\t\t==================================");
    Scanner my = new Scanner(System.in);
    System.out.println("\n\t\tGive Process NO " + Curr.ProgramId + " Instructions One by One\n");
    for (int i = 0; i <= (Curr.totalInstruction - 1); i++) {
      System.out.print("\t\t    Give Value of Instruction " + (i + 1) + ": ");
      Curr.Process[i] = my.nextInt();
    }
    System.out.println("\n\t\t==================================");
  }
}