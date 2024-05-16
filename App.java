import java.time.LocalTime;
import java.util.PriorityQueue;
import java.util.Queue;

public class App {
    public static void main(String[] args) {
        Queue<Client> filaEspera = App.getWaitQueue();
    }

    public static Queue<Client> getWaitQueue() {
        Queue<Client> result = new PriorityQueue<Client>();
        String[] clientNames = {"Rafael Lima", "Pedro Dutra", "Ramos Garcia", "Augusto Duarte", "Matheus Tadeu", "Vinicius Amaral", "Sandro Santos", "Marconi Luz"};
        int[] mockedHours   = {13, 14, 13, 12, 16, 17, 13, 12};
        int[] mockedMinutes = {14, 35, 45, 46, 12, 00, 34, 53};
        for(int index = 0; index < clientNames.length; index++) {
            LocalTime enteredTime = LocalTime.of(mockedHours[index], mockedMinutes[index]);
            Client client = new Client(clientNames[index], enteredTime);
            result.add(client);
            System.out.println(client.getName() + " entrou na fila de espera.");
        }
        return result;
    }
}