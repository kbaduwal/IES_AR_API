package kb.baduwal.repositories;

import kb.baduwal.entities.AppEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AppRepo extends JpaRepository<AppEntity, Long> {

    //For admin
    public List<AppEntity> fetchUserApps();

    //Return the Application created by particular case worker(CW)
    @Query(value = "from AppEntity where userId=:userId")
    public List<AppEntity> fetchCwApps(Integer userId);
}
