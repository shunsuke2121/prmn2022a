package RocketleagueApi;
import java.util.List;

public class RepositoryData {
    private String id;
    private String name;
    private List<String> stats;

    public String getName() {
        return name;
    }

    public List<String> getStats() {
        return stats;
    }

    public String getid(){
        return id;
    }
}
