package kb.baduwal.service;

import kb.baduwal.bindings.App;

import java.util.List;

public interface ArService {

    public String createApplication(App app);

    public List<App> fetchApps(Integer userId);

}
