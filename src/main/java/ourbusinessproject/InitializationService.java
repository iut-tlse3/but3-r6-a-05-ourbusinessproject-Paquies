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

    private Partnership p1E1WithE2;
    private Partnership p1E2WithE1;
    private Partnership p2E1WithE2;

    @Autowired
    private EnterpriseProjectService enterpriseProjectService;

    @Autowired
    private PartnershipService partnershipService;

    @Transactional
    public void initProjects() {
        // Since this method is Transactional, all statements inside are run in a single transaction.
        this.e1 = this.enterpriseProjectService.newEnterprise("e1","enterprise e1","enterprise1", "e1@gmail.com");
        this.e2 = this.enterpriseProjectService.newEnterprise("e2","enterprise e2", "enterprise2", "e2@gmail.com");
        this.project1E1 = this.enterpriseProjectService.newProject("p1e1", "project p1e1", this.e1);
        this.project1E2 = this.enterpriseProjectService.newProject("p1e2","project p1e2", this.e2);
        this.project2E1 = this.enterpriseProjectService.newProject("p2e1","project p2e1", this.e1);
    }

    @Transactional
    public void initPartnerships() {
        this.p1E1WithE2 = this.partnershipService.newPartnership(this.project1E1,this.e2);
        this.p1E2WithE1 = this.partnershipService.newPartnership(this.project1E2, this.e1);
        this.p2E1WithE2 = this.partnershipService.newPartnership(this.project2E1, e2);
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



    public Partnership getPartnershipP1E1WithE2() {
        return this.p1E1WithE2;
    }

    public Partnership getPartnershipP1E2WithE1() {
        return this.p1E2WithE1;
    }

    public Partnership getPartnershipP2E1WithE2() {
        return this.p2E1WithE2;
    }
}
