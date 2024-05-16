import java.time.LocalTime;

class Client implements Comparable<Client> {
    private String name;
    private LocalTime createdAt;

    public LocalTime getTime() {
        return createdAt;
    }

    public String getName() {
        return name;
    }

    public Client(String n, LocalTime createdAt) {
        this.name = n;
        this.createdAt = createdAt;
    }

    @Override
    public int compareTo(Client o) {
        return this.createdAt.compareTo(o.getTime());
    }
}