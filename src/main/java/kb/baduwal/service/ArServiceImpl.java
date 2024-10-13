package kb.baduwal.service;

import kb.baduwal.bindings.App;
import kb.baduwal.constants.AppConstants;
import kb.baduwal.entities.AppEntity;
import kb.baduwal.entities.UserEntity;
import kb.baduwal.exception.SsaWebException;
import kb.baduwal.repositories.AppRepo;
import kb.baduwal.repositories.UserRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArServiceImpl implements ArService {

    @Autowired
    private AppRepo appRepo;

    @Autowired
    private UserRepo userRepo;

    private static final String SSA_WEB_API_URL="";

    @Override
    public String createApplication(App app) {

        try {
            WebClient webClient = WebClient.create();
            String stateName = webClient.get()
                    .uri(SSA_WEB_API_URL,app.getSsn())
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            if(AppConstants.RI.equals(stateName)){

                UserEntity userEntity = userRepo.findById(app.getUserId()).get();

                //Valid citizen app
                AppEntity appEntity = new AppEntity();
                BeanUtils.copyProperties(app,appEntity);

                appEntity.setUser(userEntity);

                appEntity = appRepo.save(appEntity);

                return "App created with case Num: " + appEntity.getCasNum();
            }

        }catch (Exception e){
            throw new SsaWebException(e.getMessage());
        }

        return AppConstants.INVALID_SSN;
    }

    @Override
    public List<App> fetchApps(Integer userId) {

        UserEntity userEntity = userRepo.findById(userId).get();
        Integer roleId = userEntity.getRoleId();

        List<AppEntity> appsEntities = null;

        //Role id =1 means Admin, so we have to ge the all user application
        if(1== roleId){
            appsEntities = appRepo.fetchUserApps();
        }else { //If not admin case worker(cw)
            appsEntities = appRepo.fetchCwApps(userId);
        }

        List<App> apps = new ArrayList<>();

        for(AppEntity entity: appsEntities){
            App app = new App();
            BeanUtils.copyProperties(entity,apps);
            apps.add(app);
        }

        return apps;
    }
}
