package ourbusinessproject;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Bootstrap {

    @Autowired
    private InitializationService initializationService;

    public Bootstrap(InitializationService initializationService) {
        this.initializationService= initializationService;
    }

    @PostConstruct
    public void init() {
        try {
            this.initializationService.initProjects();
            this.initializationService.initPartnerships();
        } catch (RuntimeException e) {
            e.getStackTrace();
        }
    }

    /**
     * return initializationService
     * @return
     */
    public InitializationService getInitializationService() {
        return initializationService;
    }
}
