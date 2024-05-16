import java.time.LocalTime;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class App {
    private static Random rand = new Random();

    public static void main(String[] args) {
        Queue<Client> filaEspera = App.getWaitQueue();
        System.out.println("");
        CollaboratorManager collaboratorManager = new CollaboratorManager();
        collaboratorManager.add(new Collaborator("Renan Garcia"));
        collaboratorManager.add(new Collaborator("Carlos Neto"));
        collaboratorManager.add(new Collaborator("Rodolfo Souza"));
        collaboratorManager.add(new Collaborator("Edilaine Pereira"));
        Client client = filaEspera.poll();
        do {
            System.out.println("Atendendo " + client.getName() + "...");
            LocalTime endTime = App.getEndTime(client.getTime());
            LocalTime timeSpent = endTime.minusHours(client.getTime().getHour())
                    .minusMinutes(client.getTime().getMinute());
            System.out.println(client.getName() + " atendido pelo " + collaboratorManager.attend().getName()
                    + ", com o tempo de " + timeSpent.getMinute() + " minutos de espera\n");
            if (App.rand.nextInt(1) == 1)
                collaboratorManager.releaseCollaborator();

        } while ((client = filaEspera.poll()) != null);
    }

    public static LocalTime getEndTime(LocalTime t) {
        return t.plusMinutes(App.rand.nextInt(59));
    }

    public static Queue<Client> getWaitQueue() {
        Queue<Client> result = new PriorityQueue<Client>();
        String[] clientNames = { "Rafael Lima", "Pedro Dutra", "Ramos Garcia", "Augusto Duarte", "Matheus Tadeu",
                "Vinicius Amaral", "Sandro Santos", "Marconi Luz" };
        int[] mockedHours = { 13, 14, 13, 12, 16, 17, 13, 12 };
        int[] mockedMinutes = { 14, 35, 45, 46, 12, 00, 34, 53 };
        for (int index = 0; index < clientNames.length; index++) {
            LocalTime enteredTime = LocalTime.of(mockedHours[index], mockedMinutes[index]);
            Client client = new Client(clientNames[index], enteredTime);
            result.add(client);
            System.out.println(client.getName() + " entrou na fila de espera.");
        }
        return result;
    }
}