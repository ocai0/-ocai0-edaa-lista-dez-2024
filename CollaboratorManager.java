import java.util.ArrayList;
import java.util.Random;

class CollaboratorManager {
    private ArrayList<Collaborator> workers = new ArrayList<Collaborator>();
    private ArrayList<Collaborator> busyWorkers = new ArrayList<Collaborator>();
    private Random rand = new Random();

    public void add(Collaborator c) {
        this.workers.add(c);
    }

    public Collaborator attend() {
        if (this.workers.size() == 1)
            this.releaseCollaborator();
        int index = rand.nextInt(this.workers.size() - 1);
        Collaborator result = this.workers.get(index);
        busyWorkers.add(result);
        this.workers.remove(index);
        return result;
    }

    public void releaseCollaborator() {
        int index = this.rand.nextInt(this.busyWorkers.size() - 1);
        Collaborator c = this.busyWorkers.get(index);
        this.busyWorkers.remove(index);
        this.workers.add(c);
    }
}