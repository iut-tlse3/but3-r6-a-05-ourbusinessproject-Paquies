package ourbusinessproject;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InitializationService {

    private Project project1E1;
    private Project project1E2;
    private Project project2E1;

    private Enterprise e1;
    private Enterprise e2;

    @Autowired
    private EnterpriseProjectService enterpriseProjectService;

    @Transactional
    public void initProjects() {
        this.e1 = this.enterpriseProjectService.newEnterprise("e1","enterprise e1","enterprise1", "e1@gmail.com");
        this.e2 = this.enterpriseProjectService.newEnterprise("e2","enterprise e2", "enterprise2", "e2@gmail.com");
        this.project1E1 = this.enterpriseProjectService.newProject("p1e1", "project p1e1", this.e1);
        this.project1E2 = this.enterpriseProjectService.newProject("p1e2","project p1e2", this.e2);
        this.project2E1 = this.enterpriseProjectService.newProject("p2e1","project p2e1", this.e1);
    }

    /**
     * return Project1E1
     * @return
     */
    public Project getProject1E1() {
        return this.project1E1;
    }

    /**
     * return Project1E2
     * @return
     */
    public Project getProject1E2() {
        return this.project1E2;
    }

    /**
     * Return Project2E1
     * @return
     */
    public Project getProject2E1() {
        return this.project2E1;
    }

    /**
     * Return Enterprise1
     * @return
     */
    public Enterprise getEnterprise1() {
        return this.e1;
    }

    /**
     * Return Enterprise2
     * @return
     */
    public Enterprise getEnterprise2() {
        return this.e2;
    }
}
