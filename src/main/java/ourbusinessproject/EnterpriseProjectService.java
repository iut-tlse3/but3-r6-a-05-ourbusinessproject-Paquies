package ourbusinessproject;

import jakarta.persistence.TypedQuery;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterpriseProjectService {

    @PersistenceContext
    private final EntityManager entityManager;

    /**
     *
     * @param entityManager
     */
    public EnterpriseProjectService(EntityManager entityManager) {
        this.entityManager= entityManager;
    }

    /**
     * Create a new project
     *
     * @param aTitle
     * @param aDescription
     * @param enterprise
     * @return
     */
    public Project newProject(String aTitle, String aDescription, Enterprise enterprise) {
        Project project = new Project();
        project.setTitle(aTitle);
        project.setDescription(aDescription);
        project.setEnterprise(enterprise);
        entityManager.persist(project);
        entityManager.flush();
        enterprise.addProject(project);
        return project;
    }

    /**
     * Return a project by Id
     * @param id
     * @return
     */
    public Project findProjectById(Long id) {
        return entityManager.find(Project.class, id);
    }

    /**
     * Create a new enterprise
     * @param aName
     * @param aDescription
     * @param aContactName
     * @param aContactEmail
     * @return
     */
    public Enterprise newEnterprise(String aName, String aDescription, String aContactName, String aContactEmail) {
        Enterprise enterprise = new Enterprise();
        enterprise.setName(aName);
        enterprise.setDescription(aDescription);
        enterprise.setContactEmail(aContactEmail);
        enterprise.setContactName(aContactName);
        entityManager.persist(enterprise);
        entityManager.flush();
        return enterprise;
    }

    /**
     * Return the enterprise by Id
     * @param id
     * @return
     */
    public Enterprise findEnterpriseById(Object id) {
        return entityManager.find(Enterprise.class,id);
    }

    /**
     * Return the entityManager
     * @return
     */
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    /**
     * return all the projects from the DB
     * @return
     */
    public List<Project> findAllProjects() {
        String query = "SELECT pr FROM Project pr JOIN FETCH pr.enterprise ORDER By pr.title";
        TypedQuery<Project> queryObj = entityManager.createQuery(query,Project.class);
        return queryObj.getResultList();
    }
}
